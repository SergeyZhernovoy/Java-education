package ru.szhernovoy.controler;

/**
 * Created by admin on 27.09.2016.
 */
public class AddOrder implements Action {

    @Override
    public boolean execute(String name, String operation, float price, int volume, int id) {
        //System.out.println(String.format("Book = %s; Operation = %s; Price = %f; Volume = %d; ID = %s ",name,operation,price,volume,id));
        return false;
    }
}
