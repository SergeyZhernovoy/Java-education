package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public abstract class AbstractCharacter implements ActionCharacter {
    private String name;
    private int id;

    @Override
    public String toString() {
        return getClass().getName()  +
                "{ name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
