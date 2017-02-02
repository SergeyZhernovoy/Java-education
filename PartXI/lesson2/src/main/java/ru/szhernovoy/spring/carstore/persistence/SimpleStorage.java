package ru.szhernovoy.spring.carstore.persistence;

import org.springframework.stereotype.Component;
import ru.szhernovoy.spring.carstore.domain.User;

import java.util.ArrayList;

/**
 * Created by Admin on 01.02.2017.
 */

@Component
public class SimpleStorage implements StorageFactory<User>  {

    private ArrayList<User> users = new ArrayList<>();

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public User get(int id) {
        return null;
    }
}
