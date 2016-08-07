package ru.szhernovoy.products;

import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Created by Sergey on 06.08.2016.
 */
public abstract class Food {

    protected String name;
    protected final GregorianCalendar expireDate;
    protected final GregorianCalendar createDate;
    protected int price = 0;
    protected int disscount = 0;
    private Random rn = new Random();

    public Food(String name, final GregorianCalendar expireDate,final GregorianCalendar createDate, int price, int disscount) {
        this.name = name;
        this.expireDate = expireDate;
        this.price = price;
        this.disscount = disscount;
        this.createDate = createDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDisscount() {
        return disscount;
    }

    public void setDisscount(int disscount) {
        this.disscount = disscount;
    }


}
