package ru.szhernovoy.spring.carstore.persistence;/**
 * Created by Admin on 01.02.2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.szhernovoy.spring.carstore.domain.User;

@Component
public class UserStorage {

    private StorageFactory<User> storageFactory;

    @Autowired
    public UserStorage(StorageFactory storageFactory){
        this.storageFactory = storageFactory;
    }

    public User add(User user) {
        return null;
    }


    public User get(int id) {
        return null;
    }
}
