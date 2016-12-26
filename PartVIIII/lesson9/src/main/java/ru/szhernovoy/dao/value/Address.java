package ru.szhernovoy.dao.value;


import java.io.Serializable;

/**
 * Created by dort on 25.12.16.
 */
public class Address implements Serializable{

    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
