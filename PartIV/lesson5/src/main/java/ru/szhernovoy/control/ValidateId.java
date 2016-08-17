package ru.szhernovoy.control;

import ru.szhernovoy.model.User;


/**
 * Created by admin on 16.08.2016.
 */
public class ValidateId implements Validate {
    /**
     * check setting conditions for compliance.
     * @param users
     * @param user
     * @return
     */
    @Override
    public boolean checkParamter(User[] users, User user) {
        boolean result = false;
        for(int index = 0; index < users.length; index++){
            if (users[index]!= null && users[index].getId().equals(user.getId())){
                result = true;
                break;
            }
        }

        return result;
    }
}
