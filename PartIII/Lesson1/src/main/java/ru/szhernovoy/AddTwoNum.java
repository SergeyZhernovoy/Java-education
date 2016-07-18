package ru.szhernovoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by admin on 17.07.2016.
 */
public class AddTwoNum {
    public static void main(String[] args) throws IOException {

        AddTwoNum obj = new AddTwoNum();

        int count =0;

        int  summa = 0;
        int  changeNum = 0;
        do{
            System.out.print("\nPlease , enter numeric: ");
            changeNum = obj.mainFlow(new InputStreamReader(System.in));
            summa = obj.addNumeric(summa,changeNum);
            count++;

        }while(count != 2);
        System.out.println(String.format("Summa equal %d",summa));
    }

    public int mainFlow(Reader in) throws IOException {
        BufferedReader br = new BufferedReader(in);
        int num =0;
        try{
            num = Integer.parseInt(br.readLine());

        }
        catch(NumberFormatException iexc){
            System.out.println("Wrong numeric");
        }
        return num;
    }

    public int addNumeric(int first,int second){
        return (first+second);
    }


}
