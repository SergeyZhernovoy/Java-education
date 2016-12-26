package ru.szhernovoy.dao.factory;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.interfaces.RoleDAO;
import ru.szhernovoy.dao.interfaces.AddressDAO;
import ru.szhernovoy.dao.interfaces.MusicTypeDAO;
import ru.szhernovoy.dao.interfaces.UserDAO;

import java.sql.Connection;

/**
 * Created by dort on 25.12.16.
 */
public class MySQLFactory extends DAOFactory {
    private final static Logger log = LoggerFactory.getLogger(MySQLFactory.class);

    @Override
    public MusicTypeDAO getMusicDAO() {
        return null;
    }

    @Override
    public RoleDAO getRoleDAO() {
        return null;
    }

    @Override
    public AddressDAO getAddressDAO() {
        return null;
    }

    @Override
    public UserDAO getUserDAO() {
        return null;
    }

    @Override
    public Connection createConnection() {
        return null;
    }
}
