package ru.szhernovoy.model;/**
 * Created by szhernovoy on 17.12.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class DBManager implements CrudOperation {
    private static Logger log = LoggerFactory.getLogger(DBManager.class);
    private static DBManager dbManager = new DBManager();
    private List<User> storage = new CopyOnWriteArrayList<>();

    private DBManager() {

    }

    public static DBManager newInstance(){
        return dbManager;
    }

    @Override
    public boolean addRole(Role role) {
        return false;
    }

    @Override
    public List<Role> getRoles() {
        return null;
    }

    @Override
    public void deleteRole(Role role) {

    }

    @Override
    public void updateRole(Role role) {

    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateItem(User user) {

    }

    @Override
    public void matcherRoot() {

    }
}
