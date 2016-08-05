package ru.szhernovoy.calculator.view;

import ru.szhernovoy.calculator.model.MenuOfException;


import java.util.Scanner;

/**Console input user
 * Created by szhernovoy on 03.08.2016.
 */
public class ConsoleInput implements IO {

    /**object read user input in console */
    private Scanner sc = new Scanner(System.in);
    /**
     * base method. Read data from console.
     * @param question String parametr
     * @return
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return sc.nextLine();
    }

    /**
     * method check input value in any range and get it if all right.
     * @param question
     * @param range range key's menu
     * @return
     */
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
    /**
     * method check input value in convert to double and get it if all right.
     * @param question
     * @param numeric
     * @return
     */
    @Override
    public String ask(String question, boolean numeric) {
        return null;
    }

    /**
     * Print value with change line.
     * @param value
     */
    @Override
    public void println(Object value) {
        System.out.println(value);
    }

    /**
     * Print value.
     * @param value
     */
    @Override
    public void print(Object value) {
        System.out.print(value);
    }
}
