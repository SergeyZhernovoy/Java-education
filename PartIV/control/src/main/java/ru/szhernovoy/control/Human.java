package ru.szhernovoy.control;

import ru.szhernovoy.model.Player;

/**
 * Created by admin on 21.08.2016.
 */
public class Human implements Player {
    @Override
    public String[] select(int x, int y) {
        return new String[0];
    }
}
