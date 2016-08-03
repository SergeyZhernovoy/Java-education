package ru.szhernovoy.calculator.start;

import ru.szhernovoy.calculator.model.Calculator;
import ru.szhernovoy.calculator.model.MenuCalculator;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveCalculator {

    private MenuCalculator menu;

    private Calculator calc;


    public static void main(String[] args) {
        MenuCalculator menu = new MenuCalculator();
        Calculator calc = new Calculator();
    }

}
