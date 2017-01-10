package ru.szhernovoy.model;


import java.sql.Timestamp;

/**
 * Created by admin on 30.12.2016.
 */
public class Item {

    /**
     * Created by admin on 30.12.2016.
     */
    private int id;
    /**
     * Created by admin on 30.12.2016.
     */
    private String desc;
    /**
     * Created by admin on 30.12.2016.
     */
    private Timestamp create;
    /**
     * Created by admin on 30.12.2016.
     */
    private boolean done;

    /**
     * Created by admin on 30.12.2016.
     */
    public Item() {
    }

    /**
     * Created by admin on 30.12.2016.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Created by admin on 30.12.2016.
     * @param id .
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Created by admin on 30.12.2016.
     * @return String
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Created by admin on 30.12.2016.
     * @param desc .
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Created by admin on 30.12.2016.
     * @return Timestamp
     */
    public Timestamp getCreate() {
        return create;
    }

    /**
     * Created by admin on 30.12.2016.
     * @param create .
     */
    public void setCreate(Timestamp create) {
        this.create = create;
    }

    /**
     * Created by admin on 30.12.2016.
     * @return boolean
     */
    public boolean getDone() {
        return done;
    }

    /**
     * Created by admin on 30.12.2016.
     * @param done .
     */
    public void setDone(boolean done) {
        this.done = done;
    }
}
