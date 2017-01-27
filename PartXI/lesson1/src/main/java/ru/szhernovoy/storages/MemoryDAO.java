package ru.szhernovoy.storages;/**
 * Created by szhernovoy on 27.01.2017.
 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MemoryDAO implements Crud {

    private List<User> storage = new ArrayList<>();
    private int id;

    @Override
    public User add(User user) {
        this.storage.add(user);
        user.setId(++id);
        return user;
    }

    @Override
    public boolean update(User user) {
        boolean result = false;
        if(this.storage.contains(user)){
            result = true;
            int index = this.storage.indexOf(user);
            this.storage.set(index,user);
        }
        return result;
    }

    @Override
    public boolean delete(User user) {

        boolean result = false;
        if(this.storage.contains(user)){
            result = true;
            int index = this.storage.indexOf(user);
            this.storage.remove(index);
        }
        return result;

   }

    @Override
    public User get(int idUser) {
        User user = new User();
        user.setId(idUser);
        if(this.storage.contains(user)){
            int index = this.storage.indexOf(user);
            user = this.storage.get(index);
        }
        return user;
    }

    @Override
    public Collection<User> get() {

        return this.storage;

    }
}
