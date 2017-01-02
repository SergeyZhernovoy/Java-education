package ru.szhernovoy.model;


import java.sql.Timestamp;

/**
 * Created by admin on 30.12.2016.
 */
public class Item {

    private int id;
    private String desc;
    private Timestamp create;
    private boolean done;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getCreate() {
        return create;
    }

    public void setCreate(Timestamp create) {
        this.create = create;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
