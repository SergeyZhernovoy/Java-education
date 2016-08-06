package ru.calculator.model;

import ru.szhernovoy.calculator.model.Calculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveEngeneerCalculator extends InteractiveCalculator{

    /**value save ref on calculator */
    private final Calculator calc;

    /**
     * Set ref on object calculator in super class and this
     * @param calc
     */
    public InteractiveEngeneerCalculator(final Calculator calc){
        super(calc);
        this.calc = calc;
    }

    /**
     * Method call func calculate sinus and print result.
     */
    public void calcSinus(){
        calc.setResult(Math.cos(calc.getMemory()));
        System.out.println(String.format("Result calculation sinus = %f",calc.getResult()));
    }
    /**
     * Method call func calculate cosinus and print result.
     */
    public void calcCosinus(){
        calc.setResult(Math.sin(calc.getMemory()));
        System.out.println(String.format("Result calculation cosinus = %f",calc.getResult()));
    }


}
