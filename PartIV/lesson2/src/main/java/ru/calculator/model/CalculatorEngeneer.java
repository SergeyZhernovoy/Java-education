package ru.calculator.model;

import ru.szhernovoy.calculator.model.Calculator;

/**
 * Class extend operation . It have memory about operand
 * Created by szhernovoy on 03.08.2016.
 */
public class CalculatorEngeneer extends Calculator{


    public double cos(double operand){
        return Math.cos(operand);
    }

    public double sin(double operand){
        return  Math.sin(operand);
    }

}
