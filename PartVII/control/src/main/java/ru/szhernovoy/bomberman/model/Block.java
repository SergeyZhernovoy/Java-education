package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public class Block extends AbstractCharacter {

    public Block(String name, int id,Cell[][] cells, int x, int y) {
        super(name, id, cells,x,y);
    }

    @Override
    public void  move(Direction step) {
        /**
         * do nothing
         */
    }
}
