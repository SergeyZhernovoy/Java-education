package ru.szhernovoy.model;

/**
 * Created by szhernovoy on 17.12.2016.
 */
public interface CrudOperation extends CrudRoleInterface<Role>, CrudUserInterface<User> {
    void matcherRoot();
}
