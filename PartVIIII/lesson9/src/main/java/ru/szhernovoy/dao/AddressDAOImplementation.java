package ru.szhernovoy.dao;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.value.Address;
import ru.szhernovoy.dao.interfaces.AddressDAO;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public class AddressDAOImplementation implements AddressDAO {
    private final static Logger log = LoggerFactory.getLogger(AddressDAOImplementation.class);

    @Override
    public int createAddress(String name) {
        return 0;
    }

    @Override
    public Collection getAll() {
        return null;
    }

    @Override
    public Address findAddress(int id) {
        return null;
    }

    @Override
    public boolean updateAddress(int id, String name) {
        return false;
    }

    @Override
    public boolean deleteAddress(int id) {
        return false;
    }
}
