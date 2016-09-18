package ru.szhernovoy.map;

import java.util.Calendar;

/**
 * Created by Sergey on 17.09.2016.
 */
public class UserWithoutOverride extends User  {


    public UserWithoutOverride(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }
}
