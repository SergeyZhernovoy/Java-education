package ru.szhernovoy.model;

/**
 * Created by szhernovoy on 20.08.2016.
 */
public interface IO {

    String ask(String question);

    int ask(String question, int[] range);

    boolean ask(String question, String[] range);

    void print(Object value);

}
