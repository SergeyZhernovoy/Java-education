package ru.szhernovoy.extended;

import ru.szhernovoy.products.Food;

import java.util.GregorianCalendar;

/**
 * Created by szhernovoy on 09.08.2016.
 */
public abstract class FoodReproduct {

    /**value storage flag -product can be reproduct */
    private boolean canReproduct = false;
    /**ref on food */
    private Food food;
    /**value for test  */
    private GregorianCalendar today;

    /**
     * Contructor.

     */
    public FoodReproduct(boolean canReproduct, Food food, GregorianCalendar today) {
        this.canReproduct = canReproduct;
        this.food = food;
        this.today = today;
    }

    /**
     * Check product on reproduct.
     * @return
     */
    public boolean isCanReproduct(){
        return this.canReproduct;
    }

    /**
     * calculate difference between expire and create date product.
     *
     * @return
     */

    public int calculatePercent() {
        return this.food.calculatePercent(today);
    }

    /**
     * Getter for recieve food field.
     * @return
     */
    public Food getFood(){
        return this.food;
    }


    /**
     * Get name food.
     * @return
     */
    public String getName(){
        return this.food.getName();
    }
}
