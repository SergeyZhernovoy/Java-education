package ru.szhernovoy.model;

import java.util.List;

/**
 * Created by dort on 17.12.16.
 */
public interface CrudUserInterface<T extends User>  {

   boolean addUser(T  user);

   List<T> getUsers();

   void deleteUser(T user);

   void updateItem(T user);

}
