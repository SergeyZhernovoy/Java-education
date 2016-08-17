package ru.szhernovoy.control;

import ru.szhernovoy.model.User;


/**
 * Created by admin on 16.08.2016.
 */
public class ValidateName implements Validate {
    /**
     * check setting conditions for compliance.
     * @param users
     * @param user
     * @return
     */
    @Override
    public boolean checkParamter(User[] users, User user) {
        boolean result = true;
        for(int index = 0; index < users.length; index++){
            if (users[index]!= null && users[index].getName().equals(user.getName())){
                result = false;
                break;
            }
        }
        return result;
    }
}
