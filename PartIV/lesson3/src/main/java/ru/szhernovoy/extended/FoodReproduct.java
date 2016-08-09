package ru.szhernovoy.extended;

import ru.szhernovoy.products.Food;

import java.util.GregorianCalendar;

/**
 * Created by szhernovoy on 09.08.2016.
 */
public abstract class FoodReproduct extends Food {

    private boolean canReproduct = false;

    /**
     * Contructor.
     *
     * @param name
     * @param createDate
     * @param expireDate
     * @param price
     * @param disscount
     */
    public FoodReproduct(String name, GregorianCalendar createDate, GregorianCalendar expireDate, int price, int disscount, boolean canReproduct) {
        super(name, createDate, expireDate, price, disscount);
        this.canReproduct = canReproduct;
    }

    public boolean isCanReproduct(){
        return this.canReproduct;
    }


}
