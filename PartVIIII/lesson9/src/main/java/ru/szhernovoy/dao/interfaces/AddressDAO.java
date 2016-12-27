package ru.szhernovoy.dao.interfaces;

import ru.szhernovoy.dao.value.Address;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface AddressDAO {
    public int createAddress(String name);
    public Collection getAll();
    public Address findAddress(int id);
    public boolean updateAddress(int id, String name);
    public boolean deleteAddress(int id);
    public Address findAddressByName(String name);


}
