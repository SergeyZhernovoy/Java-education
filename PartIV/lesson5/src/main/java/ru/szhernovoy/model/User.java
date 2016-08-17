package ru.szhernovoy.model;

/**
 * Created by szhernovoy on 15.08.2016.
 */
public class User {

    /**name's user */
    private String name;
    /**age's user */
    private int age;
    /**unique id's user */
    private String id;

    /**
     * Construtor.
     * @param name
     * @param age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Setter name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter age
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter id
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Setter id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
}
