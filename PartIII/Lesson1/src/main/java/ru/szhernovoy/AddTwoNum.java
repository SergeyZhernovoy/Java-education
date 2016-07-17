package ru.szhernovoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by admin on 17.07.2016.
 */
public class AddTwoNum {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count =0;

        int  summa = 0;
        do{
            System.out.print("\nPlease , enter numeric: ");
            try{
                summa += Integer.parseInt(br.readLine());
                count++;
            }
            catch(NumberFormatException iexc){
                System.out.println("Wrong numeric");
            }
        }while(count != 2);
        System.out.println(String.format("Summa equal %d",summa));
    }
}
