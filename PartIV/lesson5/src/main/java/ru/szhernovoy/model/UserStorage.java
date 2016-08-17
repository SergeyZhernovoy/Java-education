package ru.szhernovoy.model;

import ru.szhernovoy.control.Validate;

import java.util.Random;

/**
 * Created by szhernovoy on 15.08.2016.
 */
public class UserStorage {

    /** array user*/
    private User[] users;
    /**current position in array */
    private int position = 0;
    /**help generate unique id */
    private final Random RN = new Random();


    /**
     * Constructor
     * @param size
     */
    public UserStorage(int size) {
        this.users = new User[size];
    }

    /**
     * Constructor
     * @param users
     */
    public UserStorage(User[] users) {
        this.users = users;
        generateNewId();
    }

    /**
     * Generate new id for users in array
     */
    private void generateNewId(){
        for (User user: this.users){
             user.setId(this.generateId());
        }
    }

    /**
     * Add new user in array
     * @param valid
     * @param user
     * @return
     */
    public boolean addUser(Validate[] valid, User user){

        boolean result = checkParam(valid,user); //we don't find user

        if(result){
            user.setId(this.generateId());
            users[position++] = user;
        }

        return result;
    }

    /**
     * Control on array validation methods
     * @param valid
     * @param user
     * @return
     */
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

    /**
     * Edit user in array
     * @param valid
     * @param user
     * @return
     */
    public boolean updateUser(Validate[] valid, User user){

        boolean result = checkParam(valid,user);
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

    /**
     * delete user from array
     * @param valid
     * @param user
     * @return
     */
    public boolean deleteUser(Validate[] valid, User user){
        boolean result = checkParam(valid,user);
        System.out.println(result);
        if(result){
            for (int index = 0; index < this.users.length; index++){

                if(this.users[index].getId().equals(user.getId())){
                    this.users[index] = null;
                    break;
                }
             }
        }
        return result;
    }

    /**
     * Generate one id
     * @return
     */
    String generateId(){
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

}
