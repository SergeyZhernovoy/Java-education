package ru.szhernovoy.extended;

import ru.szhernovoy.products.Food;

import java.util.GregorianCalendar;

/**
 * Created by szhernovoy on 09.08.2016.
 */
public abstract class FoodReproduct {

    private boolean canReproduct = false;
    private Food food;

    /**
     * Contructor.

     */
    public FoodReproduct(boolean canReproduct, Food food) {
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

    public int calculatePercent() {
        return this.food.calculatePercent();
    }

    public Food getFood(){
        return this.food;
    }


    public String getName(){
        return this.food.getName();
    }
}
