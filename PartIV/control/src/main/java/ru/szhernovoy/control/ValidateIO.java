package ru.szhernovoy.control;

import ru.szhernovoy.model.ErrorInput;

/**
 * Created by admin on 20.08.2016.
 */
public class ValidateIO extends ConsoleIO {


    public boolean ask(String question)  {

        boolean correctInput = false;
        boolean result = false;
        do{
            try {
                result =  super.ask(question);
                correctInput = true;
            } catch (ErrorInput errorInput) {
                System.out.println("Uncorrect input - try again...");
            }
        }while(!correctInput);
        return result;
    }


    public int ask(String question, int[] range) {

        boolean correctInput = false;
        int result = 0;
        do{
            try {
                result =  super.ask(question,range)-1;
                correctInput = true;
            } catch (ErrorInput | NumberFormatException exc) {
                System.out.println("Uncorrect input - try again...");
            }
        }while(!correctInput);
        return result;

    }
}
