package ru.szhernovoy.springbeans;/**
 * Created by szhernovoy on 27.01.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class JdbcStorageImpl implements Storage {

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcStorageImpl.class);

    @Override
    public void add(User user) {
        System.out.println("Add user across jdbc");
    }
}
