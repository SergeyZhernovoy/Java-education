package ru.szhernovoy.dao.interfaces;

import ru.szhernovoy.dao.value.Address;

import java.util.Collection;

/**
 * Created by dort on 25.12.16.
 */
public interface AddressDAO {
     int createAddress(String name);
     Collection<Address> getAll();
     Address findAddress(int id);
     boolean updateAddress(int id, String name);
     boolean deleteAddress(int id);
     Address findAddressByName(String name);
    void close();

}
