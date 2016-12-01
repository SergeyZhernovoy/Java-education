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
    /**logger */
    private static Logger log = LoggerFactory.getLogger(DBManager.class);
    /**main connector to base */
    private Connection conn;

    public DBManager(final Properties fileProperties) {
         this.connect(fileProperties);
    }

    /**
     * Try connect to base date
     * @param
     * @return
     */
    public boolean connect(Properties properties)  {
        boolean result = false;

        try {
            this.conn = DriverManager.getConnection(properties.getProperty("url"), properties);
            result = true;
            log.info("connect to a date base", conn);
        } catch (SQLException e) {
            log.error(e.getMessage(),e);
        }
        return result;
    }


    @Override
    protected void finalize() throws Throwable {
        this.close();
    }

    /**
     * add vacancy into date base
     * @param vacancy
     * @return
     */
    public boolean add(Vacancy vacancy){
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            int author_id = 0;

            st = conn.prepareStatement("SELECT a.author_id FROM author as a WHERE a.linkAuthor = ?");
            st.setString(1,vacancy.getUrlAuthor());
            rs = st.executeQuery();
            if(rs.next()) {
                author_id = rs.getInt("author_id");
            }
            else{
                st = conn.prepareStatement("INSERT INTO author(linkAuthor,nameAuthor) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
                st.setString(1,vacancy.getUrlAuthor());
                st.setString(2,vacancy.getAuthor());
                st.executeUpdate();
                rs = st.getGeneratedKeys();
                if(rs.next()){
                    author_id = rs.getInt("author_id");
                }
                log.info("update date in table author", st);
            }
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

    /**
     * print all vacancies
     * @return
     */
    public boolean printVacancy(){
        boolean result = true;

        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT v.vacancy_name, v.ask, v.answer, v.last_update, a.nameAuthor FROM vacancy as v LEFT OUTER JOIN author as a ON v.author_id = a.author_id ORDER BY v.vacancy_id ");

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

    /**
     * close connect to base
     * @return
     */
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

    /**
     * get last download vacancies
     * @return
     */
    public long getLastLoad(){
        PreparedStatement st = null;
        ResultSet rs = null;
        long result = 0;
        try {
            st = conn.prepareStatement("SELECT d.lastDate FROM work as d");
            rs = st.executeQuery();
            if(rs.next()) {
                result = rs.getTimestamp("lastdate").getTime();
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

    /**
     * set last tome download vacancies
     * @param time
     * @return
     */
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
