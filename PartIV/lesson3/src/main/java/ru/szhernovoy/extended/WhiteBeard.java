package ru.szhernovoy.extended;

import ru.szhernovoy.products.Food;

import java.util.GregorianCalendar;

/**
 * Created by admin on 11.08.2016.
 */
public class WhiteBeard extends FoodReproduct {

    /**
     * Contructor.
     *
     * @param canReproduct
     * @param food
     */
    public WhiteBeard(boolean canReproduct, Food food, GregorianCalendar today) {
        super(canReproduct, food, today);
    }
}
