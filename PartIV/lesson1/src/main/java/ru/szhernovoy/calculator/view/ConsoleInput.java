package ru.szhernovoy.calculator.view;

import ru.szhernovoy.calculator.model.MenuOfException;


import java.util.Scanner;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class ConsoleInput implements IO {

    private Scanner sc = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
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

        String key = this.ask(question);
        boolean exist = false;

        for (String value : range) {
            if (value.equals(key)) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOfException("out of menu range");
        }
    }

    @Override
    public String ask(String question, boolean numeric) {
        return null;
    }

    @Override
    public void println(Object value) {
        System.out.println(value);
    }

    @Override
    public void print(Object value) {
        System.out.print(value);
    }
}
