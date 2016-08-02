package ru.szhernovoy.calculator.model;

/**
 * Created by admin on 02.08.2016.
 */
public interface Input {

    String ask(String question);

    int ask(String question, int[] range);

}
