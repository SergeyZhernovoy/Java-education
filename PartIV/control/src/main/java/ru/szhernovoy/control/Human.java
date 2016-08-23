package ru.szhernovoy.control;

import ru.szhernovoy.model.IO;
import ru.szhernovoy.model.Player;

/**
 * Created by admin on 21.08.2016.
 */
public class Human implements Player {

    private int []boardSize = {1,2,3};
    private final IO io;

    public Human(final IO io){
        this.io = io;
    }

    @Override
    public int[] select(String question) {
        return new int[0];
    }

    @Override
    public String firstStep(String question) {
        return null;
    }

    @Override
    public void setBoardSize(int[] boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public boolean isHuman() {
        return true;
    }
}
