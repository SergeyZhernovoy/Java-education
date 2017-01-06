package ru.szhernovoy.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.factory.DAOFactory;
import ru.szhernovoy.dao.interfaces.UserDAO;
import ru.szhernovoy.dao.value.User;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by dort on 25.12.16.
 */
public class UserDAOImplementation implements UserDAO {
    private final static Logger log = LoggerFactory.getLogger(UserDAOImplementation.class);
    private DAOFactory factory;

    public UserDAOImplementation(final DAOFactory factory) {
        this.factory  = factory;
    }

    @Override
    public int createUser(User user) {

        int result = -1;
        ResultSet rs = null;
        PreparedStatement st = null;
        try(Connection conn = this.factory.getConnection()) {
            st = conn.prepareStatement("INSERT INTO users(name,role,address,musictype) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1,user.getName());
            st.setInt(2,user.getRoleId());
            st.setInt(3,user.getAdressId());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()){
                result = rs.getInt("id");
                user.setId(result);
                this.setMusicType(user);
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
        try(Connection conn = this.factory.getConnection()) {
            st = conn.prepareStatement("SELECT * FROM users");
            rs = st.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAdressId(rs.getInt("address"));
                user.setRoleId(rs.getInt("role"));
                fillMusicType(user);
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
        try(Connection conn = this.factory.getConnection()) {
            st = conn.prepareStatement("SELECT * FROM users WHERE id = ?");
            st.setInt(1,id);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new User();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setAdressId(rs.getInt("address"));
                result.setRoleId(rs.getInt("role"));
                fillMusicType(result);
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
        try(Connection conn = this.factory.getConnection()) {
            st = conn.prepareStatement("UPDATE users SET name = ?,address = ?,role = ?  WHERE id = ?");
            st.setString(1,user.getName());
            st.setInt(3,user.getRoleId());
            st.setInt(2,user.getAdressId());
            st.setInt(4,id);
            st.executeUpdate();
            user.setId(id);
            this.setMusicType(user);
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
         try(Connection conn = this.factory.getConnection();PreparedStatement st =  conn.prepareStatement("DELETE FROM users WHERE id = ?");PreparedStatement stM =  conn.prepareStatement("DELETE FROM users_musictype where user = ?")) {
            st.setInt(1,id);
            st.executeUpdate();
            result = true;

            stM.setInt(1,id);
            stM.executeUpdate();

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return result;
    }

    @Override
    public User findUserByName(String name) {
        User result =null;
        ResultSet rs = null;

        try(Connection conn = this.factory.getConnection();PreparedStatement st = conn.prepareStatement("SELECT * FROM users WHERE name = ?")) {
            st.setString(1,name);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new User();
                result.setId(rs.getInt("id"));
                result.setName(rs.getString("name"));
                result.setAdressId(rs.getInt("address"));
                result.setRoleId(rs.getInt("role"));
                fillMusicType(result);
            }

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        finally {
            try{
                rs.close();
            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }

        return result;
    }

    private void fillMusicType(User user){
        ResultSet rs = null;
        try(Connection conn = this.factory.getConnection();PreparedStatement st = conn.prepareStatement("SELECT * FROM users_musictype WHERE user = ?")){
            st.setInt(1,user.getId());
            rs = st.executeQuery();
            rs = st.executeQuery();
            while (rs.next()){
                user.setMusicTypeId(rs.getInt("musictype"));
            }
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        finally {
            try{
                rs.close();
            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
    }

    private void setMusicType(User user){
        ResultSet rs = null;
        PreparedStatement st = null;
        try(Connection conn = this.factory.getConnection()){

            Set<Integer> mType = user.getMusicTypeId();
            st = conn.prepareStatement("DELETE FROM users_musictype where user = ?");
            st.setInt(1,user.getId());
            st.executeUpdate();
            for(int numberType : mType){
                st = conn.prepareStatement("INSERT INTO users_musictype(musictype,user) VALUES (?,?)");
                st.setInt(1,numberType);
                st.setInt(2,user.getId());
                st.executeUpdate();
            }
        }catch (Exception e) {
            log.error(e.getMessage(), e);
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
    }




}
