package ru.szhernovoy.dao.factory;


import ru.szhernovoy.dao.interfaces.AddressDAO;
import ru.szhernovoy.dao.interfaces.RoleDAO;
import ru.szhernovoy.dao.interfaces.UserDAO;
import ru.szhernovoy.dao.interfaces.MusicTypeDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by dort on 25.12.16.
 */
public abstract class DAOFactory {

    protected static Properties properties;

    public abstract MusicTypeDAO getMusicDAO();
    public abstract RoleDAO getRoleDAO();
    public abstract AddressDAO getAddressDAO();
    public abstract UserDAO getUserDAO();

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(DAOFactory.class.getClassLoader().getResource("dao.properties").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DAOFactory getFactory(){
        DAOFactory factory;
        switch (Integer.valueOf(properties.getProperty("type_base"))){
            case 1:
                factory = PostgreeSQLFactory.getInstance();
                break;
            case 2:
                factory = new MySQLFactory();
                break;
            default:
                factory = PostgreeSQLFactory.getInstance();

        }
        return  factory;
    }

}
