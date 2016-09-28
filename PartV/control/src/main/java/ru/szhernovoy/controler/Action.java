package ru.szhernovoy.controler;

/**
 * Created by admin on 27.09.2016.
 */
public interface Action {
    boolean execute(String name,String operation, float price, int volume, int id);
}
