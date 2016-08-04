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


    private double operandOne = 0;
    private double operandNext = 0;


    /**
     * return result calculation
     * @return
     */
    public double getResult(){
        return this.resultCalculation;
    }
    public void setResult(double result){
        this.resultCalculation = result;
    }

    /**
     * Этот метод возвращает результат сложения двух чисел
     *@param addNumber1
     *@param addNumber2
     */
    public double add(double addNumber1,double addNumber2){
        return addNumber1 + addNumber2;
    }
    /**
     * Этот метод возвращает результат вычитания двух чисел
     *@param subNumber1
     *@param subNumber2
     */
    public double sub(double subNumber1,double subNumber2){
        return subNumber1 - subNumber2;
    }
    /**
     * Этот метод возвращает результат умножения двух чисел
     *@param mulNumber1
     *@param mulNumber2
     */
    public double mult(double mulNumber1,double mulNumber2){
        return mulNumber1 * mulNumber2;
    }
    /**
     * Этот метод возвращает результат деления двух чисел
     *@param divNumber1
     *@param divNumber2
     */
    public double div(double divNumber1,double divNumber2){

        double result = 0;
        try{
            result = divNumber1 / divNumber2;
        } catch (ArithmeticException exc){
            System.out.println("divide by zero");
        }
        return result;
    }


}
