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
            this.conn = DriverManager.getConnection(props.getProperty("url"), props);
            result = true;
            log.info("connect to a date base", conn);
        } catch (SQLException e) {
            log.error(e.getMessage(),e);
        }
        return result;
    }

    public Properties getProperties(String fileProperties) {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(fileProperties)) {
            properties.load(fileInputStream);
            log.info("get parametres connection", properties);
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

    public boolean add(Vacancy vacancy){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("INSERT INTO author(linkAuthor,nameAuthor) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
            st.setString(1,vacancy.getUrlAuthor());
            st.setString(2,vacancy.getAuthor());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            int author_id = 0;
            if(rs.next()){
                author_id = rs.getInt("author_id");
            }
            log.info("update date in table author", st);
            st = conn.prepareStatement("INSERT INTO vacancy(vacancy_name,vacancy_link,ask,answer,last_update,author_id) VALUES (?,?,?,?,?,?)");
            st.setString(1,vacancy.getTitle());
            st.setString(2,vacancy.getUrlVacancy());
            st.setInt(3,vacancy.getView());
            st.setInt(4,vacancy.getAnswer());
            st.setTimestamp(5,new Timestamp(vacancy.getUpdateDate()));
            st.setInt(6,author_id);
            st.executeUpdate();
            log.info("update date in table vacancy", st);

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
        return true;
    }

    public boolean printVacancy(int count){
        boolean result = true;

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT v.vacancy_name, v.ask, v.answer, v.last_update, a.nameAuthor FROM vacancy as v LEFT OUTER JOIN author as a ON v.author_id = a.author_id");
            rs = st.executeQuery();
            while (rs.next()) {
                log.info(String.format("vacancy - %s, view - %d, answer - %d, last update - %s, author - %s ",rs.getString("vacancy_name"),rs.getInt("ask"),rs.getInt("answer"),String.valueOf(rs.getTimestamp("last_update").getTime()),rs.getString("nameAuthor")));
            }
        } catch (Exception e) {
            result = false;
            log.error(e.getMessage(),e);
        }
        finally {
            try{
                rs.close();
                st.close();
            }
            catch (Exception e){
                result = false;
                log.error(e.getMessage(),e);
            }
        }

        return result;

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
        PreparedStatement st = null;
        ResultSet rs = null;
        long result = 0;
        try {
            st = conn.prepareStatement("SELECT d.lastDate FROM work as d WHERE time_id =1");
            rs = st.executeQuery();
            if(rs.next()) {
                result = rs.getTimestamp("lastDate").getTime();
                log.info("get time last load");
            }
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        finally {
            try{
                st.close();
                rs.close();
            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return result;
    }

    public long setTimeLoad(long time){
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO work(lastDate) VALUES (?)");
            st.setTimestamp(1,new Timestamp(time));
            st.executeUpdate();
            log.info("update time last vacancies");

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        finally {
            try{
               st.close();
            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return time;
    }

}
