package ru.szhernovoy.dbase;/**
 * Created by szhernovoy on 03.12.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;


public class HtmlTable {
    private static Logger log = LoggerFactory.getLogger(HtmlTable.class);
    private static HtmlTable instance = new HtmlTable();

    private HtmlTable(){
    }

    public static HtmlTable getInstance(){
        return instance;
    }

    public String getUsers(){
        StringBuilder builder = new StringBuilder();
        builder.append("<table>");
        Iterator<User> iter = DBManager.instance().getUsers().iterator();
        while(iter.hasNext()){
              builder.append("<tr><td>"+iter.next()+"</td></tr>");
        }
        builder.append("</table>");
        return builder.toString();
    }

}
