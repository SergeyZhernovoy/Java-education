package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public abstract class AbstractCharacter implements ActionCharacter {

    protected final String name;
    protected final int id;
    protected boolean isLife;
    protected final Cell[][] cells;

    public AbstractCharacter(String name, int id, boolean isLife,final Cell[][] cells) {
        this.name = name;
        this.id = id;
        this.isLife = isLife;
        this.cells = cells;
    }

    @Override
    public String toString() {
        return getClass().getName()  +
                "{ name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isLife() {
        return isLife;
    }
}
