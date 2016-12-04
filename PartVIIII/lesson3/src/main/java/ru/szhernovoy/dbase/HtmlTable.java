package ru.szhernovoy.dbase;/**
 * Created by szhernovoy on 03.12.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;


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
        List<User> users = DBManager.instance().getUsers();
        for (User user:users){
            builder.append(String.format("<tr><td>%s</td></tr>\n",user.toString()));
        }
        builder.append("</table>");
        return builder.toString();
    }

}
