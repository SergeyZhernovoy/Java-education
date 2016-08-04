package ru.szhernovoy.calculator.controller;

import ru.szhernovoy.calculator.view.BaseAction;
import ru.szhernovoy.calculator.model.InteractiveCalculator;
import ru.szhernovoy.calculator.view.IO;
import ru.szhernovoy.calculator.view.UserAction;

/**
 * Created by admin on 02.08.2016.
 */
public class MenuCalculator {

    /** constant count action*/
    private final int COUNT_ACTION = 3;
    /**user interact input  */
    private IO input;

    private InteractiveCalculator calc;
    /** menu actions*/
    private UserAction[] actions = new UserAction[COUNT_ACTION];

    public MenuCalculator(InteractiveCalculator calc,IO input){
        this.input = input;
        this.calc = calc;
    }

    public void select(int key){
            actions[key].execute(calc,input);
    }

    public void fillActions(){
        actions[0] = this.new doCalculate("Do calculate. You can enter number (0...9), letter M/m (memory value), action (+ / * -)");
        actions[1] = this.new addInMemory("Save previously calculate in memory");
        actions[2] = this.new cleanCalculate("Clean all result calculate and memory");
    }

    public int[] getRangeKeys(){
        int[] range = new int[actions.length];
        int position = 0;
        for(UserAction action : actions){
            range[position++] = action.key();
        }
        return range;
    }

    public void show(){
        for(UserAction action : this.actions){
            if(action != null){
                input.println(action.info());
            }
        }
    }

    private class doCalculate extends BaseAction {

        public doCalculate(String name){
            super(name);
        }

        @Override
        public void execute(InteractiveCalculator interCalc,IO input) {
            interCalc.calculate(input);
        }

        @Override
        public int key() {
            return 0;
        }

    }

    private class addInMemory extends BaseAction {


        public addInMemory(String name){
            super(name);

        }

        @Override
        public void execute(InteractiveCalculator interCalc,IO input) {
            calc.addMemory();
        }

        @Override
        public int key() {
            return 1;
        }

    }

    private class cleanCalculate extends BaseAction {


        public cleanCalculate(String name){
            super(name);

        }

        @Override
        public void execute(InteractiveCalculator interCalc,IO input) {
            calc.clean();
        }

        @Override
        public int key() {
            return 2;
        }


    }
}
