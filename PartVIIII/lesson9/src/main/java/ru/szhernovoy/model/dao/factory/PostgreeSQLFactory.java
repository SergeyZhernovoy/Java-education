package ru.szhernovoy.model.dao.factory;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.model.dao.*;
import ru.szhernovoy.model.dao.interfaces.AddressDAO;
import ru.szhernovoy.model.dao.interfaces.MusicTypeDAO;
import ru.szhernovoy.model.dao.interfaces.RoleDAO;
import ru.szhernovoy.model.dao.interfaces.UserDAO;

import java.sql.Connection;

/**
 * Created by dort on 25.12.16.
 */
public class PostgreeSQLFactory extends DAOFactory {
    private final static Logger log = LoggerFactory.getLogger(PostgreeSQLFactory.class);

    @Override
    public MusicTypeDAO getMusicDAO() {
        return new MusitTypeDAOImplementation();
    }

    @Override
    public RoleDAO getRoleDAO() {
        return new RoleDAOImplementation();
    }

    @Override
    public AddressDAO getAddressDAO() {
        return new AddressDAOImplementation();
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImplementation();
    }

    @Override
    public Connection createConnection() {
        return null;
    }




}
