package ru.szhernovoy.dao.factory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.interfaces.RoleDAO;
import ru.szhernovoy.dao.*;
import ru.szhernovoy.dao.interfaces.AddressDAO;
import ru.szhernovoy.dao.interfaces.MusicTypeDAO;
import ru.szhernovoy.dao.interfaces.UserDAO;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by dort on 25.12.16.
 */
public class PostgreeSQLFactory extends DAOFactory {
    private final static Logger log = LoggerFactory.getLogger(PostgreeSQLFactory.class);
    private static PostgreeSQLFactory postgreeSQLFactory ;
    private ComboPooledDataSource pool;

    private PostgreeSQLFactory(){
        this.pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass(properties.getProperty("driverClass"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        pool.setJdbcUrl(properties.getProperty("jdbcUrl"));
        pool.setUser(properties.getProperty("user"));
        pool.setPassword(properties.getProperty("password"));
        pool.setMaxPoolSize(5);
    }

    public synchronized static PostgreeSQLFactory getInstance(){
        if(postgreeSQLFactory == null){
            postgreeSQLFactory = new PostgreeSQLFactory();
        }
        return postgreeSQLFactory;
    }

    @Override
    public MusicTypeDAO getMusicDAO() {
        return new MusicTypeDAOImplementation(this);
    }

    @Override
    public RoleDAO getRoleDAO() {
        return new RoleDAOImplementation(this);
    }

    @Override
    public AddressDAO getAddressDAO() {
        return new AddressDAOImplementation(this);
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserDAOImplementation(this);
    }

    @Override
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn  = this.pool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
