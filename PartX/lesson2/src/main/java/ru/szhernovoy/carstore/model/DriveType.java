package ru.szhernovoy.carstore.model;


/**
 * type engine : privod ; backoff front full
 * Created by admin on 05.01.2017.
 */
public class DriveType {
    private int id;
    private String name;

    public DriveType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
