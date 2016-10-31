package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public class Cell {

    private AbstractCharacter character;

    public synchronized AbstractCharacter getCharacter() {
        return character;
    }

    public synchronized void setCharacter(AbstractCharacter character) {
        this.character = character;
    }



}
