package ru.szhernovoy.model;

/**
 * Created by szhernovoy on 20.08.2016.
 */
public interface Player {
    boolean firstStep(String question) throws ErrorInput;
    int[] select(String question) throws ErrorInput;
    void setBoardSize(int[] range);
    String whoAreYou();
}
