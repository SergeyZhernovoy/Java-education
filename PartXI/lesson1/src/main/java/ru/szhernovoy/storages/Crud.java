package ru.szhernovoy.storages;

import java.util.Collection;

/**
 * Created by szhernovoy on 27.01.2017.
 */
public interface Crud {
    User add(User user);
    User update(User user);
    boolean delete(User user);
    User get(int id);
    Collection<User> get();
}
