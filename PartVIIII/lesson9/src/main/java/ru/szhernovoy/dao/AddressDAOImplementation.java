package ru.szhernovoy.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.value.Address;
import ru.szhernovoy.dao.interfaces.AddressDAO;

import java.sql.*;
import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by dort on 25.12.16.
 */
public class AddressDAOImplementation implements AddressDAO {
    private final static Logger log = LoggerFactory.getLogger(AddressDAOImplementation.class);
    private Connection conn;

    public AddressDAOImplementation(Connection connection){
        this.conn = connection;
    }

    @Override
    public int createAddress(String name) {

        int result = 0;
        ResultSet rs = null;
        PreparedStatement st = null;
        try {
            st = this.conn.prepareStatement("INSERT INTO address(name) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
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

        Collection<Address> addresses = new ConcurrentSkipListSet<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM address");
            rs = st.executeQuery();
            Address address = null;
            while (rs.next()) {
                address = new Address();
                address.setId(rs.getInt("id"));
                address.setName(rs.getString("name"));
                addresses.add(address);
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
        return addresses;
    }

    @Override
    public Address findAddress(int id) {
        Address result =null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM address WHERE id = ?");
            st.setInt(1,id);
            rs = st.executeQuery();
            if (rs.next()) {
                result = new Address();
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
    public boolean updateAddress(int id, String name) {
            boolean result = false;
            PreparedStatement st = null;
            try {
                st = conn.prepareStatement("UPDATE address SET name = ?, WHERE id = ?");
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
    public boolean deleteAddress(int id) {

            boolean result = false;
            PreparedStatement st = null;
            try {
                st = conn.prepareStatement("DELETE FROM address WHERE id = ?");
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
