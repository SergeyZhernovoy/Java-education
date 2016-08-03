package ru.szhernovoy.calculator.model;

import ru.szhernovoy.calculator.template.MenuOfException;

import java.util.Scanner;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class ConsoleInput implements Input {

    private Scanner sc = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return sc.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;

        for(int value : range){
            if(value == key){
                exist = true;
                break;
            }
        }
        if(exist){
            return key;
        }
        else{
            throw new MenuOfException("out of menu range");
        }
    }

    /**
     * Method get parametr and check it in range
     * @param question question about choice method calculate
     * @param range    array methods for calculate
     * @return
     */
    @Override
    public String ask(String question, String[] range) {
        return null;
    }
}
