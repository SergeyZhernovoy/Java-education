package ru.szhernovoy.model;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Created by dort on 16.12.16.
 */
public class Country {
    private final static Logger log = LoggerFactory.getLogger(Country.class);
    private String id;
    private String name;

    public Country(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
