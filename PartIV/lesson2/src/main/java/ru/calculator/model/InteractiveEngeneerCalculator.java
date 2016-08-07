package ru.calculator.model;

import ru.szhernovoy.calculator.model.InteractiveCalculator;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveEngeneerCalculator extends InteractiveCalculator{

    /**
     * Method call func calculate sinus and print result.
     */
    public void calcSinus(){
        this.setResult(Math.cos(this.getMemory()));
        System.out.println(String.format("Result calculation sinus = %f",this.getResultCalculation()));
    }
    /**
     * Method call func calculate cosinus and print result.
     */
    public void calcCosinus(){
        this.setResult(Math.sin(this.getMemory()));
        System.out.println(String.format("Result calculation cosinus = %f",this.getResultCalculation()));
    }


}
