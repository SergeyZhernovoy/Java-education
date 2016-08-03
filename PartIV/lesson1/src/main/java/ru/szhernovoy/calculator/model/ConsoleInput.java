package ru.szhernovoy.calculator.model;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class ConsoleInput implements Input {
    @Override
    public String ask(String question) {
        return null;
    }

    @Override
    public int ask(String question, int[] range) {
        return 0;
    }
}
