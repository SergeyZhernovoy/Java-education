package ru.szhernovoy;

/**
 * Created by admin on 19.07.2016.
 */
public class StringLengthException extends Exception {
    private String myString;
    public StringLengthException(String msg){
        this.myString = msg;
    }

    @Override
    public String toString(){
        return String.format("this string %s have length not 5",myString);
    }
}
