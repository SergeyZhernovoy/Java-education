package ru.szhernovoy.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.interfaces.UserDAO;
import ru.szhernovoy.dao.value.User;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by dort on 25.12.16.
 */
public class UserDAOImplementation implements UserDAO {
    private final static Logger log = LoggerFactory.getLogger(UserDAOImplementation.class);
    Connection conn;

    public UserDAOImplementation(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int createUser(User user) {

        int result = -1;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            st = this.conn.prepareStatement("INSERT INTO users(name,role,address,musictype) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1,user.getName());
            st.setInt(2,user.getRoleId());
            st.setInt(3,user.getAdressId());
            st.setInt(4,user.getMusicTypeId());
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

        Collection<User> users = new LinkedList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM users");
            rs = st.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAdressId(rs.getInt("address"));
                user.setMusicTypeId(rs.getInt("musictype"));
                user.setRoleId(rs.getInt("role"));
                users.add(user);
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
        return users;
    }

    @Override
    public User findUser(int id) {
        User result =null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
            st.setInt(1,id);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new User();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setAdressId(rs.getInt("address"));
                result.setMusicTypeId(rs.getInt("musictype"));
                result.setRoleId(rs.getInt("role"));
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
    public boolean updateUser(User user, int id) {
        boolean result = false;
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE users SET name = ?,address = ?,musictype = ?,role = ?  WHERE id = ?");
            st.setString(1,user.getName());
            st.setInt(4,user.getRoleId());
            st.setInt(2,user.getAdressId());
            st.setInt(3,user.getMusicTypeId());
            st.setInt(5,id);
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
    public boolean deleteUser(int id) {

        boolean result = false;
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("DELETE FROM users WHERE id = ?");
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
    public User findUserByName(String name) {
        User result =null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM users WHERE name = ?");
            st.setString(1,name);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new User();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setAdressId(rs.getInt("address"));
                result.setMusicTypeId(rs.getInt("musictype"));
                result.setRoleId(rs.getInt("role"));
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
