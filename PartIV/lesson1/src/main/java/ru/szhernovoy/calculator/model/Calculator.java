package ru.szhernovoy.calculator.model;

/**
 * Class extend operation . It have memory about operand
 * Created by szhernovoy on 03.08.2016.
 */
public class Calculator {
    /** save result calculation*/
    private double resultCalculation = 0;
    /**value of memory */
    private double memory = 0;
    /**operation calc */
    private Operation calc = new Operation();
    private double operandOne = 0;
    private double operandNext = 0;


    /**
     * return result calculation
     * @return
     */
    public double GetResult(){
        return this.resultCalculation;
    }

}
