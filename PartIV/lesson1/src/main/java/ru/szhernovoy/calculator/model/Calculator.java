package ru.szhernovoy.calculator.model;

/**
 * Class extend operation . It have memory about operand
 * Created by szhernovoy on 03.08.2016.
 */
public class Calculator extends Operation{
    /** save result calculation*/
    private double resultCalculation = 0;
    /**value of memory */
    private double memory = 0;
    /**determines the calculation sequence true - operand false - action +-*'//'= */
    private boolean typeOperation = true;

    private double operandOne = 0;
    private double operandNext = 0;


    /**
     * return result calculation
     * @return
     */
    public double GetResult(){
        return this.resultCalculation;
    }

    /**
     * Set operand for next calculation
     */
    public void setOperand(double value){
        this.operandOne = value;
    }

    public boolean getKindOperation(){
        return this.typeOperation;
    }
}
