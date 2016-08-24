package ru.szhernovoy.control;

import ru.szhernovoy.model.ErrorInput;

import java.util.InputMismatchException;

/**
 * Created by admin on 20.08.2016.
 */
public class ValidateIO extends ConsoleIO {

    /**
     * simple ask
     * @param question
     * @return
     * @throws ErrorInput
     */
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

    /**
     * Ask on range value
     * @param question
     * @param range
     * @return
     * @throws ErrorInput
     */
    public int ask(String question, int[] range) {

        boolean correctInput = false;
        int result = 0;
        do{
            try {
                result =  super.ask(question,range)-1;
                correctInput = true;
            } catch (ErrorInput  | NumberFormatException exc) {
                System.out.println("Uncorrect input - try again...");
            }catch (InputMismatchException  exc){
                System.out.println("Uncorrect input - try again...");
            }

        }while(!correctInput);
        return result;

    }
}
