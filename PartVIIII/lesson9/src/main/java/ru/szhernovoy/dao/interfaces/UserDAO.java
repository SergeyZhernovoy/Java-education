package ru.szhernovoy.dao.interfaces;


import ru.szhernovoy.dao.value.User;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface UserDAO {
     int createUser(User user);
     Collection getAll();
     User findUser(int id);
     boolean updateUser(User user, int id);
     boolean deleteUser(int id);
     User findUserByName(String name);

}
