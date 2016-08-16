package ru.szhernovoy.model;

import ru.szhernovoy.control.Validate;

import java.util.Random;

/**
 * Created by szhernovoy on 15.08.2016.
 */
public class UserStorage {

    private User[] users;
    private int position = 0;
    private final Random RN = new Random();


    public UserStorage(int size) {
        this.users = new User[size];
    }

    public UserStorage(User[] users) {
        this.users = users;
    }

    public boolean addUser(Validate[] valid, User user){

        boolean result = checkParam(valid,user);

        if(result){
            user.setId(generateId());
            users[position++] = user;
        }

        return result;
    }

    public boolean checkParam(Validate[] valid, User user){
        boolean result = true;

        for (Validate currentTest : valid){
            if(!currentTest.checkParamter(this.users, user)){
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean updateUser(Validate[] valid, User user){

        boolean result = checkParam(valid,user);
        System.out.println("111 " + result);
        if(result){
            for (int index = 0; index < this.users.length; index++){
                if(this.users[index].getId().equals(user.getId())){
                    this.users[index] = user;
                    break;
                }
            }
        }

        return result;

    }

    public boolean deleteUser(Validate[] valid, User user){
        boolean result = checkParam(valid,user);

        if(result){
            for (int index = 0; index < this.users.length; index++){
                if(this.users[index].getId().equals(user.getId())){
                    this.users[index] = null;
                    result = true;
                    break;
                }
                else{
                    result = false;
                }
            }
        }
        return result;
    }

    String generateId(){
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

}
