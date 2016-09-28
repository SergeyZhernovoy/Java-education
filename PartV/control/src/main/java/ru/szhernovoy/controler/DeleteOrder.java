package ru.szhernovoy.controler;

/**
 * Created by admin on 27.09.2016.
 */
public class DeleteOrder implements Action {

    @Override
    public boolean execute(String name, String operation, float price, int volume, int id) {
        return false;
    }
}
