package ru.szhernovoy.calculator.model;

import ru.szhernovoy.calculator.model.Calculator;
import ru.szhernovoy.calculator.model.MenuCalculator;
import ru.szhernovoy.calculator.view.IO;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveCalculator {

    private IO input;
    private Calculator calc = new Calculator();
    private ValidateOperand valid = new ValidateOperand();


    /**determines the calculation sequence true - operand false - action +-*'//'= */
    private boolean typeOperation = true;

    public void calculate(){

    }



}
