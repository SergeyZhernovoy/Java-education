package ru.szhernovoy.control;

import ru.szhernovoy.model.IO;

import java.util.Scanner;

/**
 * Created by admin on 20.08.2016.
 */
public class ConsoleIO implements IO{
    private Scanner sc = new Scanner(System.in);
    @Override
    public String ask(String question) {
        return null;
    }

    @Override
    public int ask(String question, int[] range) {
        System.out.println(question);

        return 0;
    }


    @Override
    public boolean ask(String question, String[] range) {
        System.out.print(String.format("%s : ",question));
        String answer = sc.nextLine();
        boolean result;
        if(answer.equals("y"))
            result = true;
        else {
            result = false;
        }
        return result;
    }

    @Override
    public void print(Object value) {

    }
}
