package ru.szhernovoy.extended;

import ru.szhernovoy.products.Food;

import java.util.GregorianCalendar;

/**
 * Created by szhernovoy on 09.08.2016.
 */
public abstract class FoodReproduct extends Food {

    private boolean canReproduct = false;
    private Food food;

    /**
     * Contructor.
     *
     * @param name
     * @param createDate
     * @param expireDate
     * @param price
     * @param disscount
     */
    public FoodReproduct(String name, GregorianCalendar createDate, GregorianCalendar expireDate, int price, int disscount, boolean canReproduct, Food food) {
        super(name, createDate, expireDate, price, disscount);
        this.canReproduct = canReproduct;
        this.food = food;
    }


    public boolean isCanReproduct(){
        return this.canReproduct;
    }

    /**
     * calculate difference between expire and create date product.
     *
     * @return
     */
    @Override
    public int calculatePercent() {
        return this.food.calculatePercent();
    }

    public Food getFood(){
        return this.food;
    }
}
