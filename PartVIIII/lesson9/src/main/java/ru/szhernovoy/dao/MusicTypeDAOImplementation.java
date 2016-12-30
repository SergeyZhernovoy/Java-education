package ru.szhernovoy.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.value.MusicType;
import ru.szhernovoy.dao.interfaces.MusicTypeDAO;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by dort on 25.12.16.
 */
public class MusicTypeDAOImplementation implements MusicTypeDAO {
    private final static Logger log = LoggerFactory.getLogger(MusicTypeDAOImplementation.class);
    Connection conn;

    public MusicTypeDAOImplementation(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int createMusicType(String name) {

        int result = 0;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            st = this.conn.prepareStatement("INSERT INTO musictype(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1,name);
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()){
                result = rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return result;
    }

    @Override
    public Collection getAll() {

        Collection<MusicType> musicTypes = new LinkedList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM musictype");
            rs = st.executeQuery();
            MusicType musicType = null;
            while (rs.next()) {
                musicType = new MusicType();
                musicType.setId(rs.getInt("id"));
                musicType.setName(rs.getString("name"));
                musicTypes.add(musicType);
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
        return musicTypes;
    }

    @Override
    public MusicType findMusicType(int id) {
        MusicType result =null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM musictype WHERE id = ?");
            st.setInt(1,id);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new MusicType();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
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

        return result;
    }

    @Override
    public boolean updateMusicType(int id, String name) {
        boolean result = false;
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE musictype SET name = ?, WHERE id = ?");
            st.setString(1,name);
            st.setInt(4,id);
            st.executeUpdate();
            result = true;
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
        return result;

    }

    @Override
    public boolean deleteMusicType(int id) {

        boolean result = false;
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM musictype WHERE id = ?");
            st.setInt(1,id);
            st.executeUpdate();
            result = true;

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
        return result;
    }

    @Override
    public MusicType findMusicTypeByName(String name) {
        MusicType result =null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM musictype WHERE name = ?");
            st.setString(1,name);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new MusicType();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
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

        return result;
    }

    @Override
    public void close(){
        try {
            if(this.conn != null){
                this.conn.close();
            }
        } catch (SQLException e) {
            log.error(e.getMessage(),e);
        }
    }


}
