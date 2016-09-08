package ru.szhernovoy.store;

import java.util.Random;

/**
 * Created by admin on 07.09.2016.
 */
public abstract class Base {

    private String id;
    private final Random RN = new Random();

    public Base() {
        setId(generateId());
    }

    public String getId(){
        return this.id;
    }
    public void setId(String id){
       this.id = id;
    }
    public String generateId(){
        return String.valueOf(RN.nextInt(100)+System.currentTimeMillis());
    }

}
