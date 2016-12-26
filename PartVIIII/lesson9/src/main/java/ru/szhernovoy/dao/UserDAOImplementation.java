package ru.szhernovoy.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.value.Address;
import ru.szhernovoy.dao.interfaces.UserDAO;
import ru.szhernovoy.dao.value.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
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

        int result = 0;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            st = this.conn.prepareStatement("INSERT INTO user(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
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
                this.conn.close();
            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return result;
    }

    @Override
    public Collection getAll() {

        Collection<Role> roles = new ConcurrentSkipListSet<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM role");
            rs = st.executeQuery();
            Role role = null;
            while (rs.next()) {
                role = new Role();
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                roles.add(role);
            }

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        finally {
            try{
                rs.close();
                st.close();
                this.conn.close();
            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return roles;
    }

    @Override
    public User findUser(int id) {
        Role result =null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM role WHERE id = ?");
            st.setInt(1,id);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new Role();
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
                this.conn.close();
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
            st = conn.prepareStatement("UPDATE role SET name = ?, WHERE id = ?");
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
                this.conn.close();
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
            st = conn.prepareStatement("DELETE FROM role WHERE id = ?");
            st.setInt(1,id);
            st.executeUpdate();
            result = true;

        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        finally {
            try{
                st.close();
                this.conn.close();
            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return result;
    }

}
