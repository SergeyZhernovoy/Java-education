package ru.szhernovoy.security.carstore.service;

import ru.szhernovoy.security.carstore.domain.User;

import java.util.List;

/**
 * Created by admin on 17.02.2017.
 */
public interface UserService <T extends User> {

    List<User> get();
    User get(int id);
    User createOrUpdate(User user);

}
