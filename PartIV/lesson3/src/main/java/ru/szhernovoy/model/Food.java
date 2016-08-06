package ru.szhernovoy.model;

import java.util.Random;

/**
 * Created by Sergey on 06.08.2016.
 */
public abstract class Food {
    protected String name;
    protected long expireDate;
    protected int price = 0;
    protected int disscount = 0;
    private Random rn = new Random();

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
