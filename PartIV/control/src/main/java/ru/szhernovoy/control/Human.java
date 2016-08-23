package ru.szhernovoy.control;

import ru.szhernovoy.model.ErrorInput;
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
    public int[] select(String question) throws ErrorInput {
        int[] answer = new int[2];
        answer[0] = this.io.ask(String.format("%s - x ",question),this.boardSize);
        answer[1] = this.io.ask(String.format("%s - y ",question),this.boardSize);
        return answer;
    }

    @Override
    public boolean firstStep(String question) throws ErrorInput {
           return this.io.ask(question);
    }

    @Override
    public void setBoardSize(int[] boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public String whoAreYou() {
        return "Human";
    }
}
