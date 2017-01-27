package ru.szhernovoy.storages;/**
 * Created by Admin on 27.01.2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class User {

    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);

    private int id;

    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
