package ru.szhernovoy.products;

import java.util.GregorianCalendar;

/**
 * Class inheritor food.
 * Created by Sergey on 06.08.2016.
 */
public class Potatos extends Food {
    /**
     * Constructor.
     * @param name
     * @param expireDate
     * @param createDate
     * @param price
     * @param disscount
     */
    public Potatos(String name, GregorianCalendar expireDate, GregorianCalendar createDate, int price, int disscount) {
        super(name, expireDate, createDate, price, disscount);
    }
}
