package ru.szhernovoy.dao.interfaces;


import ru.szhernovoy.dao.value.User;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface UserDAO {
    public int createUser(User user);
    public Collection getAll();
    public User findUser(int id);
    public boolean updateUser(User user, int id);
    public boolean deleteUser(int id);
}
