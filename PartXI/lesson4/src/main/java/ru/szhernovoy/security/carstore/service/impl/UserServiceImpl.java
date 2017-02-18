package ru.szhernovoy.security.carstore.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import ru.szhernovoy.security.carstore.domain.User;
import ru.szhernovoy.security.carstore.repositories.UserCrud;
import ru.szhernovoy.security.carstore.service.UserService;

import java.util.List;

/**
 * Created by admin on 17.02.2017.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserCrud userCrud;

    @Override
    public List<User> get() {
        return Lists.newArrayList(this.userCrud.findAll());
    }

    @Override
    public User get(int id) {
        return this.userCrud.findOne(id);
    }

    @Override
    public User createOrUpdate(User user) {
        return this.userCrud.save(user);
    }
}
