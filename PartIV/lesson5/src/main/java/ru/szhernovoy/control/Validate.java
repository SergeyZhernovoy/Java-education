package ru.szhernovoy.control;

import ru.szhernovoy.model.UserStorage;

/**
 * Created by szhernovoy on 15.08.2016.
 */
public interface Validate {
    boolean checkParamtres(UserStorage[] users, String name, String id, int age);
}
