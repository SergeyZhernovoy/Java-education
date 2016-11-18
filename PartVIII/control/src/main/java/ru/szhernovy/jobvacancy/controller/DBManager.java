package ru.szhernovy.jobvacancy.controller;/**
 * Created by szhernovoy on 14.11.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovy.jobvacancy.model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;



public class DBManager {
    private static Logger log = LoggerFactory.getLogger(DBManager.class);
    private Connection conn;

    public DBManager(final String fileProperties) {
         this.connect(fileProperties);
    }

    public boolean connect(String fileProperties)  {
        boolean result = false;
        Properties props = getProperties(fileProperties);
        try {
            conn = DriverManager.getConnection(props.getProperty("url"), props);
            result = true;
        } catch (SQLException e) {
            log.error(e.getMessage(),e);
        }
        return result;
    }

    public Properties getProperties(String fileProperties) {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(fileProperties)) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage(),e);
        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return properties;
    }

    @Override
    protected void finalize() throws Throwable {
        this.close();
    }

    public Vacancy add(Vacancy vacancy){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("INSERT INTO task(name,description,create_date) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
            st.setString(1,item.getName());
            st.setString(2,item.getDescr());
            st.setTimestamp(3,new Timestamp(item.getCreate()));
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()){
                item.setId(String.valueOf(rs.getInt("task_id")));
            }


        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        finally {
            try{
                rs.close();
                st.close();
            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return item;
    }




    public boolean close(){
        boolean result = false;
        if(conn !=null ){
            try{
                conn.close();
                result = true;
            }
            catch(SQLException e){
                log.error(e.getMessage(),e);
            }
        }
        return result;
    }


    public long getLastLoad(){
        return  0;
    }

    public long setTimeLoad(long time){
        return 0;
    }


}
