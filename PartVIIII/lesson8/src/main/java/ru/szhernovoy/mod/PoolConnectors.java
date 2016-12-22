package ru.szhernovoy.mod;/**
 * Created by szhernovoy on 15.12.2016.
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class PoolConnectors {
    private static Logger log = LoggerFactory.getLogger(PoolConnectors.class);
    private static ComboPooledDataSource pool;

    private PoolConnectors(){

    }

    static {
        Properties prop = new Properties();
        pool = new ComboPooledDataSource();
        try {
            prop.load(new FileInputStream(PoolConnectors.class.getClassLoader().getResource("db.properties").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pool.setDriverClass(prop.getProperty("driverClass"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        pool.setJdbcUrl(prop.getProperty("jdbcUrl"));
        pool.setUser(prop.getProperty("user"));
        pool.setPassword(prop.getProperty("password"));
        pool.setMaxPoolSize(5);
    }


    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }


}
