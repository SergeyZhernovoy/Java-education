package ru.szhernovoy.map;

import java.util.Calendar;

/**
 * Created by admin on 17.09.2016.
 */
public class User {
    protected String name;
    protected int children;
    protected Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }


}
