package ru.szhernovoy.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.interfaces.RoleDAO;
import ru.szhernovoy.dao.value.Role;

import java.sql.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by dort on 25.12.16.
 */
public class RoleDAOImplementation implements RoleDAO {
    private final static Logger log = LoggerFactory.getLogger(RoleDAOImplementation.class);
    Connection conn;

    public RoleDAOImplementation(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int createRole(String name) {

        int result = 0;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            st = this.conn.prepareStatement("INSERT INTO role(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
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

        Collection<Role> roles = new LinkedList<>();
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

            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return roles;
    }

    @Override
    public Role findRole(int id) {
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

            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }

        return result;
    }

    @Override
    public boolean updateRole(int id, String name) {
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

            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return result;

    }

    @Override
    public boolean deleteRole(int id) {

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

            }
            catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }
        return result;
    }

    @Override
    public Role findRoleByName(String name) {
        Role result =null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM role WHERE name = ?");
            st.setString(1,name);
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
