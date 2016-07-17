package ru.szhernovoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 17.07.2016.
 */
public class OddNumeric {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean enough = false;
        String num;
        int  inputNum;
        do{
            System.out.println("Please , enter numeric ");
            try{
                num = br.readLine();
                inputNum = Integer.parseInt(num);
                enough = true;
                if(inputNum%2 ==0){
                    System.out.println(String.format("%s is even", num));
                }
                else {
                    System.out.println(String.format("%s is odd", num));
                }
            }
            catch(NumberFormatException iexc){
                System.out.println("Wrong numeric");
            }
        }while(!enough);
    }
}
