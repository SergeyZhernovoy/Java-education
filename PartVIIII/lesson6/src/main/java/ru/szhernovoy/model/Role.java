package ru.szhernovoy.model;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Created by admin on 11.12.2016.
 */
public class Role {
    private final static Logger log = LoggerFactory.getLogger(Role.class);
    private String name;
    private boolean isRoot = false;
    private int id;

    public Role(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }
}
