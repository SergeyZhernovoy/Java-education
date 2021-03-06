package ru.szhernovoy.carstore.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.FileCleanerCleanup;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileCleaningTracker;
import ru.szhernovoy.carstore.dao.ImageDBManager;
import ru.szhernovoy.carstore.dao.OrderDBManager;
import ru.szhernovoy.carstore.model.Image;
import ru.szhernovoy.carstore.model.Order;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by szhernovoy on 14.01.2017.
 */

public class ImageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        HttpSession session = req.getSession(false);
        Integer userId = (int)session.getAttribute("id_user");
        Integer orderId = (int)session.getAttribute("currentOrder");
        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();

        if(isMultipart && userId != -1 && orderId != -1){
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();

            FileCleaningTracker tracker = FileCleanerCleanup.getFileCleaningTracker(servletContext);
            factory.setFileCleaningTracker(tracker);
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(req);

                for (FileItem imageFile : items){
                    byte[] imageByte = imageFile.get();
                    Order order = new Order();
                    order.setId(orderId);
                    Image image = new Image();
                    image.setDataimage(imageByte);
                    image.setOrder(order);
                    new ImageDBManager().create(image);
                }
                jsonObject.addProperty("success", true);

            } catch (FileUploadException e) {
                jsonObject.addProperty("success", false);
                e.printStackTrace();
            }
        } else {
            jsonObject.addProperty("success", false);
        }

        out.append(jsonObject.toString());
        out.flush();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/jpeg");
        PrintWriter out = resp.getWriter();
        JsonArray jsonObject = new JsonArray();
        int orderId = Integer.valueOf(req.getParameter("order"));
        Collection<Order> orderCollection = new OrderDBManager().get(orderId);
        List<Image> images = new ArrayList<>();
        for(Order order : orderCollection){
            images.addAll(order.getImageCarList());
        }

        for(Image image : images){
            jsonObject.add(String.format("data:image/jpeg;base64,%s",DatatypeConverter.printBase64Binary(image.getDataimage())));
        }
        out.append(jsonObject.toString());
        out.flush();
    }
}
