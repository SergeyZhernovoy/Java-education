package ru.szhernovoy.calculator.model;

import ru.szhernovoy.calculator.view.IO;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveCalculator {

    /**main ref on calc object */
    private Calculator calc = new Calculator();
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
                    numeric = Double.valueOf(calc.getMemory()).toString();
                }

                if(!operation.equals("") && this.calc.getResult() !=0){
                    this.doCalculate(operation,numeric);
                }
                else {
                    calc.setResult(Double.valueOf(numeric));
                }
                operation = "";
                typeOperation = false;
            }
            else{
                typeOperation = true;
                operation = input.ask("Enter operand action:  ",this.action);
            }
        }while(!operation.equals("="));
        input.println(String.format("result calculate = %f",calc.getResult()));
    }

    /**
     * Refactor. Calculator do any operation
     * @param operation
     * @param operand
     */
    private void doCalculate(String operation,String operand){

        switch(operation){
            case "+": calc.setResult(calc.add(Double.valueOf(operand),calc.getResult()));
                break;
            case "-": calc.setResult(calc.sub(calc.getResult(),Double.valueOf(operand)));
                break;
            case "/": calc.setResult(calc.div(calc.getResult(),Double.valueOf(operand)));
                break;
            case "*": calc.setResult(calc.mult(calc.getResult(),Double.valueOf(operand)));
                break;
        }
    }

    /**
     * Method add in memory value
     */
    public void addMemory(){
        calc.addMemory();
    }

    /**
     * Method clean calculator
     */
    public void clean(){
        calc.clean();
    }

    /**
     * Get result calculation
     * @return
     */
    public double getResultCalculation(){
        return calc.getResult();
    }
}
