package ru.szhernovoy.model.dao.interfaces;

import ru.szhernovoy.model.Address;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface AddressDAO {
    public int createAddress();
    public Collection getAll();
    public Address findAddress(int id);
    public boolean updateAddress();
    public boolean deleteAddress();


}
