package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */

/**
 * Cell of game board
 */
public class Cell {

    /**every cell have or have not character */
    private AbstractCharacter character;

    /**
     * Getter CHaracter from Cell
     * @return
     */
    public synchronized AbstractCharacter getCharacter() {
        return character;
    }

    /**
     * Setter Character into Cell
     * @param character
     */
    public void setCharacter(AbstractCharacter character) {
        this.character = character;
    }

    /**
     * Erase in cell any reference  to character
     */
    public synchronized void erase() {
        this.character = null;
    }

}
