package ru.szhernovoy.control;

import ru.szhernovoy.model.Player;

import java.util.Random;

/**
 * Created by admin on 21.08.2016.
 */
public class Computer implements Player{

    private int []boardSize = {1,2,3};
    private final Random rn;

    /**
     * Constructor.
     */
    public Computer() {
        this.rn = new Random(System.currentTimeMillis());
    }

    /**
     * Enter position for set "X" or "O"
     * @param question
     * @return
     */
    @Override
    public int[] select(String question) {
        int[] answer = new int[2];
        answer[0] = rn.nextInt(boardSize[boardSize.length-1]);
        answer[1] = rn.nextInt(boardSize[boardSize.length-1]);
        return answer;
    }
    /**
     * Set board size for input method
     */
    @Override
    public void setBoardSize(int[] boardSize) {
        this.boardSize = boardSize;
    }
    /**
     * Return type player
     * @return
     */
    @Override
    public String whoAreYou() {
        return "Computer";
    }
    /**
     * Ask for first step.
     * @param question
     * @return
     */
    @Override
    public boolean firstStep(String question) {
        return false;
    }
}
