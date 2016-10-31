package ru.szhernovoy.bomberman.model;

import java.util.Random;

/**
 * Created by szhernovoy on 31.10.2016.
 */
public enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN;

    private static Random random = new Random();

    public static Direction getRandomDirection() {
        int position = random.nextInt(values().length);
        return values()[position];
    }


}
