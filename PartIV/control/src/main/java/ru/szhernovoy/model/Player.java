package ru.szhernovoy.model;

/**
 * Created by szhernovoy on 20.08.2016.
 */
public interface Player {
    /**
     * Ask for first step.
     * @param question
     * @return
     * @throws ErrorInput
     */
    boolean firstStep(String question) throws ErrorInput;

    /**
     * Enter position for set "X" or "O"
     * @param question
     * @return
     * @throws ErrorInput
     */
    int[] select(String question) throws ErrorInput;

    /**
     * Set board size for input method
     * @param range
     */
    void setBoardSize(int[] range);

    /**
     * Return type player
     * @return
     */
    String whoAreYou();
}
