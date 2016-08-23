package ru.szhernovoy.model;

/**
 * Created by szhernovoy on 20.08.2016.
 */
public interface IO {

    boolean ask(String question) throws ErrorInput;

    int ask(String question, int[] range) throws ErrorInput;

    void print(Object value);

}
