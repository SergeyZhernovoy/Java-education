package ru.szhernovoy.carstore.controllers;/**
 * Created by szhernovoy on 11.01.2017.
 */

import com.google.gson.JsonObject;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.carstore.dao.UserDBManager;
import ru.szhernovoy.carstore.model.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


public class SignIn extends HttpServlet{

    private static final Logger LOGGER = LoggerFactory.getLogger(SignIn.class);

    /**
     * Called by the server (via the <code>service</code> method)
     * to allow a servlet to handle a POST request.
     * <p>
     * The HTTP POST method allows the client to send
     * data of unlimited length to the Web server a single time
     * and is useful when posting information such as
     * credit card numbers.
     * <p>
     * <p>When overriding this method, read the request data,
     * write the response headers, get the response's writer or output
     * stream object, and finally, write the response data. It's best
     * to include content type and encoding. When using a
     * <code>PrintWriter</code> object to return the response, set the
     * content type before accessing the <code>PrintWriter</code> object.
     * <p>
     * <p>The servlet container must write the headers before committing the
     * response, because in HTTP the headers must be sent before the
     * response body.
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
     * <p>This method does not need to be either safe or idempotent.
     * Operations requested through POST can have side effects for
     * which the user can be held accountable, for example,
     * updating stored data or buying items online.
     * <p>
     * <p>If the HTTP POST request is incorrectly formatted,
     * <code>doPost</code> returns an HTTP "Bad Request" message.
     *
     * @param req  an {@link HttpServletRequest} object that
     *             contains the request the client has made
     *             of the servlet
     * @param resp an {@link HttpServletResponse} object that
     *             contains the response the servlet sends
     *             to the client
     * @throws IOException      if an input or output error is
     *                          detected when the servlet handles
     *                          the request
     * @throws ServletException if the request for the POST
     *                          could not be handled
     * @see ServletOutputStream
     * @see ServletResponse#setContentType
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        boolean addNewUser = Boolean.valueOf(req.getParameter("addUser"));

        HttpSession session = req.getSession();
        session.setAttribute("success",false);
        session.setAttribute("currentOrder",-1);
        JsonObject json = new JsonObject();
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        User matchUser = new User();
        matchUser.setId(-1);
        if(addNewUser){
            User user = new User();
            user.setName(login);
            user.setPassword(password);
            UserDBManager userDBManager = new UserDBManager();
            matchUser = userDBManager.create(user);
            session.setAttribute("success",true);
            json.addProperty("success",true);
        } else{
            if(new UserDBManager().matchUser(login,password,matchUser)){
                session.setAttribute("success",true);
                json.addProperty("success",true);
            } else {
                json.addProperty("success",false);

            }
        }

        session.setAttribute("id_user",matchUser.getId());
        out.append(json.toString());
        out.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        boolean success = (boolean)session.getAttribute("success");
        PrintWriter out = new PrintWriter(resp.getOutputStream());
        JsonObject json = new JsonObject();
        json.addProperty("success",success);
        out.append(json.toString());
        out.flush();
    }
}
