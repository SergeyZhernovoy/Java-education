package ru.szhernovoy.products;

import java.util.GregorianCalendar;

/**
 * Created by Sergey on 06.08.2016.
 */
public class Beard extends Food {
    public Beard(String name, GregorianCalendar expireDate, GregorianCalendar createDate, int price, int disscount) {
        super(name, expireDate, createDate, price, disscount);
    }
}
