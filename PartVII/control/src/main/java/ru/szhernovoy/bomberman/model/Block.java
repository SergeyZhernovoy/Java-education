package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public class Block extends AbstractCharacter {

    public Block(String name, int id, boolean isLife,Cell[][] cells, int x, int y) {
        super(name, id, isLife,cells,x,y,Type.BLOCK);
    }

    @Override
    public void  move(Direction step) {

    }
}
