package ru.szhernovoy.repository.value;/**
 * Created by szhernovoy on 27.12.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovoy.dao.value.*;
import ru.szhernovoy.repository.UserRepositoryInterface;


public class UserRepository <T> implements UserRepositoryInterface {
    private static Logger log = LoggerFactory.getLogger(UserRepository.class);





    private static class UserReference{

        User user;
        Role role;
        MusicType musicType;
        Address address;




    }
}
