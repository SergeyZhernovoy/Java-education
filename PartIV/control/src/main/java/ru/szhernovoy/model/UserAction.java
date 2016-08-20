package ru.szhernovoy.model;

/**
 * Created by szhernovoy on 20.08.2016.
 */
public interface UserAction {
    void initGame();
    void select(int x, int y, boolean bomb);
}
