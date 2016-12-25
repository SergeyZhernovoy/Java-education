package ru.szhernovoy.model.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.model.Address;
import ru.szhernovoy.model.dao.interfaces.UserDAO;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public class UserDAOImplementation implements UserDAO {
    private final static Logger log = LoggerFactory.getLogger(UserDAOImplementation.class);

    @Override
    public int createUser() {
        return 0;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public Address findUser(int id) {
        return null;
    }

    @Override
    public boolean updateUser() {
        return false;
    }

    @Override
    public boolean deleteUser() {
        return false;
    }
}
