package ru.szhernovoy.control;

import ru.szhernovoy.model.User;


/**
 * Created by szhernovoy on 15.08.2016.
 */
public interface Validate {
    boolean checkParamter(User[] users, User user);

}
