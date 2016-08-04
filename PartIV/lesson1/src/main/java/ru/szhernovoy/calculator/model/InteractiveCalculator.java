package ru.szhernovoy.calculator.model;

import ru.szhernovoy.calculator.view.IO;

/**
 * Created by szhernovoy on 03.08.2016.
 */
public class InteractiveCalculator {

    private Calculator calc = new Calculator();
    private String[] action = new String[]{"+","/","*","-","="};
    /**determines the calculation sequence true - operand false - action +-*'//'= */

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
                    switch(operation){
                        case "+": calc.setResult(calc.add(Double.valueOf(numeric),calc.getResult()));
                            break;
                        case "-": calc.setResult(calc.sub(calc.getResult(),Double.valueOf(numeric)));
                            break;
                        case "/": calc.setResult(calc.div(calc.getResult(),Double.valueOf(numeric)));
                            break;
                        case "*": calc.setResult(calc.mult(calc.getResult(),Double.valueOf(numeric)));
                            break;
                     }
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

    public void addMemory(){
        calc.addMemory();
    }

    public void clean(){
        calc.clean();
    }

}
