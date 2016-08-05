package ru.calculator.model;

import ru.szhernovoy.calculator.model.Calculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveEngeneerCalculator extends InteractiveCalculator{

    private final Calculator calc;

    public InteractiveEngeneerCalculator(final Calculator calc){
        super(calc);
        this.calc = calc;
    }

    public void calcSinus(){
        calc.setResult(Math.cos(calc.getMemory()));
        System.out.println(String.format("Result calculation sinus = %f",calc.getResult()));
    }

    public void calcCosinus(){
        calc.setResult(Math.sin(calc.getMemory()));
        System.out.println(String.format("Result calculation cosinus = %f",calc.getResult()));
    }


}
