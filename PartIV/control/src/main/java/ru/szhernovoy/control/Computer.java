package ru.szhernovoy.control;

import ru.szhernovoy.model.Player;

/**
 * Created by admin on 21.08.2016.
 */
public class Computer implements Player{

    private final Logic ai;

    public Computer(Logic ai) {
        this.ai = new Logic();
    }


    @Override
    public int[] select(String question) {
        return new int[0];
    }

    @Override
    public void setBoardSize(int[] range) {

    }

    @Override
    public boolean isHuman() {
        return false;
    }

    @Override
    public String firstStep(String question) {
        return "n";
    }
}
