package ru.szhernovoy.model;

/**
 * Created by szhernovoy on 20.08.2016.
 */
public interface Player {
    String firstStep(String question);
    int[] select(String question);
    void setBoardSize(int[] range);
    boolean isHuman();
}
