package ru.szhernovoy.model;

/**
 * Created by szhernovoy on 20.08.2016.
 */
public interface IO {

    /**
     * simple ask
     * @param question
     * @return
     * @throws ErrorInput
     */
    boolean ask(String question) throws ErrorInput;

    /**
     * Ask on range value
     * @param question
     * @param range
     * @return
     * @throws ErrorInput
     */
    int ask(String question, int[] range) throws ErrorInput;

}
