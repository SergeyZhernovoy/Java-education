package ru.szhernovoy.products;

import java.util.GregorianCalendar;

/**
 * Created by Sergey on 06.08.2016.
 */
public class Bananas extends Food {
    public Bananas(String name, GregorianCalendar expireDate, GregorianCalendar createDate, int price, int disscount) {
        super(name, expireDate, createDate, price, disscount);
    }
}
