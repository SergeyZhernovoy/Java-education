package ru.szhernovoy.calculator.model;

import ru.szhernovoy.calculator.view.IO;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveCalculator {
    private final Calculator calc;
    /**determines the calculation sequence true - operand false - action +-*'//'= */
    private String[] action = new String[]{"+","/","*","-","="};

    public InteractiveCalculator(final Calculator calc){
        this.calc = calc;
    }


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
                    numeric = Double.valueOf(this.calc.getMemory()).toString();
                }

                if(!operation.equals("") && this.calc.getResult() !=0){
                    this.doCalculate(operation,numeric);
                }
                else {
                    this.calc.setResult(Double.valueOf(numeric));
                }
                operation = "";
                typeOperation = false;
            }
            else{
                typeOperation = true;
                operation = input.ask("Enter operand action:  ",this.action);
            }
        }while(!operation.equals("="));
        input.println(String.format("result calculate = %f",this.calc.getResult()));
    }

    /**
     * Refactor. Calculator do any operation
     * @param operation
     * @param operand
     */
    private void doCalculate(String operation,String operand){

        switch(operation){
            case "+": this.calc.setResult(calc.add(Double.valueOf(operand),calc.getResult()));
                break;
            case "-": this.calc.setResult(calc.sub(calc.getResult(),Double.valueOf(operand)));
                break;
            case "/": this.calc.setResult(calc.div(calc.getResult(),Double.valueOf(operand)));
                break;
            case "*": this.calc.setResult(calc.mult(calc.getResult(),Double.valueOf(operand)));
                break;
        }
    }

    /**
     * Method add in memory value
     */
    public void addMemory(){
        this.calc.addMemory();
    }

    /**
     * Method clean calculator
     */
    public void clean(){
        this.calc.clean();
    }

    /**
     * Get result calculation
     * @return
     */
    public double getResultCalculation(){
        return this.calc.getResult();
    }
}
