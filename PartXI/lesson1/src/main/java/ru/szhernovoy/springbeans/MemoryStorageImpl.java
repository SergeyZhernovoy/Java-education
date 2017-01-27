package ru.szhernovoy.springbeans;/**
 * Created by szhernovoy on 27.01.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class MemoryStorageImpl implements Storage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemoryStorageImpl.class);

    @Override
    public void add(User user) {
        System.out.println("We add user "+ user);
    }
}
