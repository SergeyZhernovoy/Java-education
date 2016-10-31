package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public class Human extends AbstractCharacter {

    public Human(String name, int id, boolean isLife,Cell[][] cells, int x, int y) {
        super(name, id, isLife,cells,x ,y);
    }

    @Override
    public void move(Direction step) {

    }
}
