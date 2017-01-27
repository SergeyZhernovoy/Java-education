package ru.szhernovoy.storages;/**
 * Created by szhernovoy on 27.01.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class JdbcDAO implements Crud {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcDAO.class);

    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public Collection<User> get() {
        return null;
    }
}
