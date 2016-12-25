package ru.szhernovoy.model.dao.factory;


import ru.szhernovoy.model.dao.interfaces.AddressDAO;
import ru.szhernovoy.model.dao.interfaces.MusicTypeDAO;
import ru.szhernovoy.model.dao.interfaces.RoleDAO;
import ru.szhernovoy.model.dao.interfaces.UserDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by dort on 25.12.16.
 */
public abstract class DAOFactory {

    protected Properties properties;

    public abstract MusicTypeDAO getMusicDAO();
    public abstract RoleDAO getRoleDAO();
    public abstract AddressDAO getAddressDAO();
    public abstract UserDAO getUserDAO();
    public abstract Connection createConnection();


    public DAOFactory(){
        this.properties = new Properties();
        try {
            this.properties.load(new FileInputStream(DAOFactory.class.getClassLoader().getResource("dao.properties").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DAOFactory getFactort(){
        DAOFactory factory;
        switch (Integer.valueOf(this.properties.getProperty("type_base"))){
            case 1:
                factory = new PostgreeSQLFactory();
                break;
            case 2:
                factory = new MySQLFactory();
                break;
            default:
                factory = new PostgreeSQLFactory();

        }
        return  factory;
    }

}
