package ru.szhernovoy.calculator.model;

import ru.szhernovoy.calculator.view.IO;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveCalculator {
    /** value storage result calculate*/
    private double result =0;
    /** value storage in memory*/
    private double memory = 0;
    /**determines the calculation sequence true - operand false - action +-*'//'= */
    private String[] action = new String[]{"+","/","*","-","="};


    /**
     * Main loop calculation.
     * @param input
     */
    public void calculate(IO input){
        String numeric;// = "";
        String operation = "";
        boolean typeOperation = true;
        do{
            if(typeOperation && !operation.equals("=")){
                numeric = input.ask("Enter operand numeric: ",typeOperation);
                if(numeric.equals("M") || numeric.equals("m")){
                    numeric = Double.valueOf(this.getMemory()).toString();
                }

                if(!operation.equals("") && this.getResultCalculation() !=0){
                    this.doCalculate(operation,numeric);
                }
                else {
                    this.result = Double.valueOf(numeric);
                }
                operation = "";
                typeOperation = false;
            }
            else{
                typeOperation = true;
                operation = input.ask("Enter operand action:  ",this.action);
            }
        }while(!operation.equals("="));
        input.println(String.format("result calculate = %f",this.result));
    }

    /**
     * Refactor. Intercalc do any operation
     * @param operation
     * @param operand
     */
    private void doCalculate(String operation,String operand){

        switch(operation){
            case "+": this.add(this.getResultCalculation(),Double.valueOf(operand));
                break;
            case "-": this.sub(this.getResultCalculation(),Double.valueOf(operand));
                break;
            case "/": this.div(this.getResultCalculation(),Double.valueOf(operand));
                break;
            case "*": this.mult(this.getResultCalculation(),Double.valueOf(operand));
                break;
        }
    }

    /**
     * Method add in memory value
     */
    public void addMemory(){
        this.memory = this.result;
    }

    /**
     * Method clean calculator
     */
    public void clean(){
       this.memory = 0;
    }

    /**
     * Get result calculation
     * @return
     */
    public double getResultCalculation(){
        return result;
    }

    /**
     * Set result.
     * @return
     * @param operand
     */
    public void setResult(double operand){
        this.result = operand;
    }

    /**
     * Этот метод возвращает результат сложения двух чисел
     *@param addNumber1
     *@param addNumber2
     */
    public void add(double addNumber1,double addNumber2){
        result = addNumber1 + addNumber2;
    }
    /**
     * Этот метод возвращает результат вычитания двух чисел
     *@param subNumber1
     *@param subNumber2
     */
    public void sub(double subNumber1,double subNumber2){
        result = subNumber1 - subNumber2;
    }
    /**
     * Этот метод возвращает результат умножения двух чисел
     *@param mulNumber1
     *@param mulNumber2
     */
    public void mult(double mulNumber1,double mulNumber2){
        result = mulNumber1 * mulNumber2;
    }
    /**
     * Этот метод возвращает результат деления двух чисел
     *@param divNumber1
     *@param divNumber2
     */
    public void div(double divNumber1,double divNumber2){

        try{
            this.result = divNumber1 / divNumber2;
        } catch (ArithmeticException exc){
            System.out.println("divide by zero");
        }
     }

    /**
     * Get value from memory.
     * @return
     */
    public double getMemory(){
        return this.memory;
    }

}
