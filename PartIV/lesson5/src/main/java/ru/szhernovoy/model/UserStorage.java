package ru.szhernovoy.model;

import ru.szhernovoy.control.Validate;

/**
 * Created by szhernovoy on 15.08.2016.
 */
public class UserStorage {

    private User[] users;
    private int position = 0;
    private Validate valid;


    public UserStorage(int size, Validate validate) {
        this.users = new User[size];
        this.valid = validate;
    }

    public User addUser(){
        return new User("1",1);
    }

    public User updateUser(){
        return new User("1",1);
    }

    public boolean deleteUser(){
        return true;
    }

}
