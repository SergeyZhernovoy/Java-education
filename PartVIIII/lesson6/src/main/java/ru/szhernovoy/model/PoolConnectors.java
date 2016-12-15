package ru.szhernovoy.model;/**
 * Created by szhernovoy on 15.12.2016.
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PoolConnectors {
    private static Logger log = LoggerFactory.getLogger(PoolConnectors.class);
    private ComboPooledDataSource pool;

    public void createPoolConnectors(){
        Properties prop = new Properties();
        this.pool = new ComboPooledDataSource();
        try {
            prop.load(new FileInputStream(this.getClass().getClassLoader().getResource("db.properties").getPath()));
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


}
