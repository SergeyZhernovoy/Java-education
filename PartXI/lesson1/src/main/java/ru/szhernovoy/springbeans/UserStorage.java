package ru.szhernovoy.springbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by szhernovoy on 27.01.2017.
 */


@Component
public class UserStorage {

    private final Storage storage;
    @Autowired
    public UserStorage(Storage storage){
        this.storage = storage;
    }

    public void add(User user){
        this.storage.add(user);
    }

}
