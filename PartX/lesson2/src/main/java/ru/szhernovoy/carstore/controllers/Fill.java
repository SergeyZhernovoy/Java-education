package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 13.01.2017.
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.dao.*;
import ru.szhernovoy.carstore.model.*;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;


public class Fill extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Fill.class);

    /**
     * Called by the server (via the <code>service</code> method) to
     * allow a servlet to handle a GET request.
     * <p>
     * <p>Overriding this method to support a GET request also
     * automatically supports an HTTP HEAD request. A HEAD
     * request is a GET request that returns no body in the
     * response, only the request header fields.
     * <p>
     * <p>When overriding this method, read the request data,
     * write the response headers, get the response's writer or
     * output stream object, and finally, write the response data.
     * It's best to include content type and encoding. When using
     * a <code>PrintWriter</code> object to return the response,
     * set the content type before accessing the
     * <code>PrintWriter</code> object.
     * <p>
     * <p>The servlet container must write the headers before
     * committing the response, because in HTTP the headers must be sent
     * before the response body.
     * <p>
     * <p>Where possible, set the Content-Length header (with the
     * {@link ServletResponse#setContentLength} method),
     * to allow the servlet container to use a persistent connection
     * to return its response to the client, improving performance.
     * The content length is automatically set if the entire response fits
     * inside the response buffer.
     * <p>
     * <p>When using HTTP 1.1 chunked encoding (which means that the response
     * has a Transfer-Encoding header), do not set the Content-Length header.
     * <p>
     * <p>The GET method should be safe, that is, without
     * any side effects for which users are held responsible.
     * For example, most form queries have no side effects.
     * If a client request is intended to change stored data,
     * the request should use some other HTTP method.
     * <p>
     * <p>The GET method should also be idempotent, meaning
     * that it can be safely repeated. Sometimes making a
     * method safe also makes it idempotent. For example,
     * repeating queries is both safe and idempotent, but
     * buying a product online or modifying data is neither
     * safe nor idempotent.
     * <p>
     * <p>If the request is incorrectly formatted, <code>doGet</code>
     * returns an HTTP "Bad Request" message.
     *
     * @param req  an {@link HttpServletRequest} object that
     *             contains the request the client has made
     *             of the servlet
     * @param resp an {@link HttpServletResponse} object that
     *             contains the response the servlet sends
     *             to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the GET request
     * @throws ServletException if the request for the GET
     *                          could not be handled
     * @see ServletResponse#setContentType
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/json;charset=Windows-1251");
        resp.setCharacterEncoding("UTF-8");
        int typeReq = Integer.valueOf(req.getParameter("type"));
        PrintWriter out = resp.getWriter();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("item", getJsonArray(typeReq));
        out.append(jsonObject.toString());
        out.flush();

    }

    public String getJsonArray(int type){

        JsonArray jsonArray = null;
        switch (type){
            case 1:
                BodyDBManager bodyDBManager = new BodyDBManager();
                jsonArray = bodyDBManager.convert(bodyDBManager.get());
                break;
            case 2:
                DriveDBManager driveDBManager = new DriveDBManager();
                jsonArray = driveDBManager.convert(driveDBManager.get());
                break;
            case 3:
                EngineDBManager engineDBManager = new EngineDBManager();
                jsonArray = engineDBManager.convert(engineDBManager.get());
                break;
            case 4:
                ModelDBManager modelDBManager = new ModelDBManager();
                jsonArray = modelDBManager.convert(modelDBManager.get());
                break;
            case 5:
                TranssmDBManger transsmDBManger = new TranssmDBManger();
                jsonArray = transsmDBManger.convert(transsmDBManger.get());
                break;
        }

        return jsonArray.toString();

    }

}

