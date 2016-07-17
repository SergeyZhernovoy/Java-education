package ru.szhernovoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 17.07.2016.
 */
public class MinFromDoubleNumeric {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count =0;
        double[] num = new double[3];

        do{
            System.out.print("\nPlease , enter numeric: ");
            try{
                num[count++] = Math.abs(Double.parseDouble(br.readLine()));
            }
            catch(NumberFormatException iexc){
                System.out.println("Wrong numeric");
            }
        }while(count < 3);
        double min = num[0];
        for(int index =0;index < 3;index++){
            if(num[index] < min){
                min = num[index];
            }
        }
        System.out.println("Minimum is "+min);
    }
}
