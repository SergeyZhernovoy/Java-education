package ru.szhernovoy.control;

import ru.szhernovoy.model.ErrorInput;
import ru.szhernovoy.model.IO;

import java.util.Scanner;

/**
 * Created by admin on 20.08.2016.
 */
public class ConsoleIO implements IO{
    private Scanner sc = new Scanner(System.in);

    /**
     * simple ask
     * @param question
     * @return
     * @throws ErrorInput
     */
    @Override
    public boolean ask(String question) throws ErrorInput {
        System.out.print(String.format("%s : ",question));
        String result = sc.nextLine();
        if(result.equals("y") || result.equals("n")){
           return result.equals("y") ? true : false;
        }
        else{
            throw  new ErrorInput("Uncorrect input");
        }
    }
    /**
     * Ask on range value
     * @param question
     * @param range
     * @return
     * @throws ErrorInput
     */
    @Override
    public int ask(String question, int[] range) throws ErrorInput {
        System.out.print(String.format("%s : ",question));
        int answer = sc.nextInt();
        boolean result = false;
        for(int index = 0; index < range.length; index++){
            if(range[index] == answer){
                result = true;
                break;
            }
        }
        if(result){
            return answer;
        }
        else{
            throw  new ErrorInput("Uncorrect input");
        }

    }
}
