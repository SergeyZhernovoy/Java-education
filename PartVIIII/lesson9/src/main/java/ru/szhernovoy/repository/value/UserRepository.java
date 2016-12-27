package ru.szhernovoy.repository.value;/**
 * Created by szhernovoy on 27.12.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.value.*;
import ru.szhernovoy.repository.RepositoryInterface;

import java.util.Collection;
import java.util.Objects;


public class UserRepository <T> implements RepositoryInterface {
    private static Logger log = LoggerFactory.getLogger(UserRepository.class);
    private User user;
    private Role role;
    private MusicType musicType;
    private Address address;


    @Override
    public User getModelWithRef() {

    }

    @Override
    public void createModelWithRef() {

    }


}
