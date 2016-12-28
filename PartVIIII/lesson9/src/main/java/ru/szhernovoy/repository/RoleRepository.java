package ru.szhernovoy.repository;/**
 * Created by szhernovoy on 28.12.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.factory.DAOFactory;
import ru.szhernovoy.dao.interfaces.RoleDAO;
import ru.szhernovoy.dao.interfaces.UserDAO;
import ru.szhernovoy.dao.value.Role;
import ru.szhernovoy.dao.value.User;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;


public class RoleRepository {
    private static Logger log = LoggerFactory.getLogger(RoleRepository.class);
    private DAOFactory factory = DAOFactory.getFactory();
    private RoleDAO roleDAO = factory.getRoleDAO();
    private UserDAO userDAO = factory.getUserDAO();

    public Collection<User> getRoleReferences(){
        Collection<User> storage = new CopyOnWriteArrayList<>();
        Collection<Role> roles  = this.roleDAO.getAll();
        Collection<User> users =  this.userDAO.getAll();
        for(Role role : roles) {
            for (User user : users) {
                if (user.getRoleId() == role.getId()) {
                    storage.add(user);
                }
            }
        }
        return storage;
    }
}


