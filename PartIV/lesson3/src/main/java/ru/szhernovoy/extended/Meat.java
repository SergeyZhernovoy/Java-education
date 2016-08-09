package ru.szhernovoy.extended;

import java.util.GregorianCalendar;

/**
 * Created by szhernovoy on 09.08.2016.
 */
public class Meat extends FoodReproduct {
    /**
     * Contructor.
     *
     * @param name
     * @param createDate
     * @param expireDate
     * @param price
     * @param disscount
     * @param canReproduct
     */
    public Meat(String name, GregorianCalendar createDate, GregorianCalendar expireDate, int price, int disscount, boolean canReproduct) {
        super(name, createDate, expireDate, price, disscount, canReproduct);
    }
}
