package ru.calculator.model;

import ru.szhernovoy.calculator.model.InteractiveCalculator;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveEngeneerCalculator extends InteractiveCalculator{

    /**main ref on calc object */
    private CalculatorEngeneer calc = new CalculatorEngeneer();
    /**determines the calculation sequence true - operand false - action +-*'//'= */

    public void calcSinus(){
        calc.setResult(calc.cos(calc.getResult()));
        System.out.println(String.format("Result calculation sinus = %f",calc.getResult()));
    }

    public void calcCosinus(){
        calc.setResult(calc.sin(calc.getResult()));
        System.out.println(String.format("Result calculation cosinus = %f",calc.getResult()));
    }


}
