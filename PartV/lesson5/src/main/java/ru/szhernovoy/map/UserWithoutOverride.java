package ru.szhernovoy.map;

import java.util.Calendar;

/**
 * Created by Sergey on 17.09.2016.
 */
public class UserWithoutOverride {
    private String name;
    private int children;
    private Calendar birthday;

    public UserWithoutOverride(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }


}
