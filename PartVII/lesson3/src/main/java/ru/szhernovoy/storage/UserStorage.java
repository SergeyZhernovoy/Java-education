package ru.szhernovoy.storage;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by szhernovoy on 14.10.2016.
 */
public class UserStorage {

    private Map<String,User> storage;
    Object lock = new Object();

    public UserStorage(){
        this.storage = new ConcurrentHashMap<>();
    }

    public UserStorage(final Map<String, User> storage){
        this.storage = storage;
    }



    public boolean add(User user){

            boolean result = false;
            if (user != null) {
                this.storage.put(user.getId(), user);
                result = true;
            }
            return result;

    }

    public boolean update(User user){
        boolean result = false;
        if(user !=null){
            if(this.storage.containsKey(user.getId())){
                this.storage.put(user.getId(),user);
                result = true;
            }
        }
        return result;
    }

    public  boolean delete(String key){
        boolean result = false;
        if(this.storage.containsKey(key)){
            this.storage.remove(key);
            result = true;
        }
        return result;
    }

    public User read(String key){
        if(this.storage.containsKey(key)){
            return this.storage.get(key);
        }
        else{
            throw new NoSuchElementException(String.format("No such User with id %s",key));
        }
    }

    public boolean transfer(int value,User userFrom,User userTo){
        boolean result = false;
        if(userFrom != null && userTo != null&& this.storage.containsKey(userFrom.getId())&& this.storage.containsKey(userTo.getId())){
           synchronized (lock){
                    if(userFrom.getAmount() >= value) {
                        userTo.setAmount(userTo.getAmount() + value);
                        userFrom.setAmount(userFrom.getAmount() - value);
                        result = true;
                    }
            }
        }
        return result;
    }
}
