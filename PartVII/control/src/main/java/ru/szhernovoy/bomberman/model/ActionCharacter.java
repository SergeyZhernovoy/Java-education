package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public interface ActionCharacter {
    Cell move(Direction step, Cell cell);
}
