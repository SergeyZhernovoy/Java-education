package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public class Human extends AbstractCharacter {

    public Human(String name, int id, boolean isLife) {
        super(name, id, isLife);
    }

    @Override
    public Cell move(Direction step,Cell cell) {
        return cell;
    }
}
