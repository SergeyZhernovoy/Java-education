package ru.szhernovoy.model;

import java.util.Scanner;

/**
 * Created by admin on 14.08.2016.
 */
public class ConsoleInput implements Input {
    /**this value need for interactive work application with user  */
    private Scanner sc = new Scanner(System.in);

    /**
     * Print question and get input data from user
     * @param question
     * @return
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return sc.nextLine();
    }

}
