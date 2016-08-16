package ru.szhernovoy.control;

import ru.szhernovoy.model.User;


/**
 * Created by admin on 16.08.2016.
 */
public class ValidateAge implements Validate {
    @Override
    public boolean checkParamter(User[] users, User user) {
        boolean result = false;

        for(int index = 0; index < users.length; index++){
            if (users[index]!= null && users[index].getAge() == user.getAge()){
                result = true;
                break;
            }
        }
        return result;
    }
}
