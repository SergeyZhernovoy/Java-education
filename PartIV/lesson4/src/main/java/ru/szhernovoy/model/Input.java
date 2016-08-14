package ru.szhernovoy.model;

import java.util.Scanner;

/**
 * interface for realization interactive work
 * Created by admin on 11.08.2016.
 */
public interface Input {
    /**
     * Print question and get input data from user
     * @param question
     * @return
     */
    String ask(String question);
}
