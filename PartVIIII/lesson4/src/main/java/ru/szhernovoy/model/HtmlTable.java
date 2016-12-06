package ru.szhernovoy.model;/**
 * Created by szhernovoy on 03.12.2016.
 */

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HtmlTable {

    private static HtmlTable instance = new HtmlTable();
    private List<User> users = new CopyOnWriteArrayList<>();

    private HtmlTable(){
    }

    public static HtmlTable getInstance(){
        return instance;
    }

    public void loadUsers(){
        for(User user :DBManager.instance().getUsers()){
            this.users.add(user);
        }
    }

    public List<User> getUser(){
        return this.users;
    }

}
