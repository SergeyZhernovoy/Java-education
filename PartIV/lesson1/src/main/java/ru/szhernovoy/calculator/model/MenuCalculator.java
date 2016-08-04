package ru.szhernovoy.calculator.model;

import ru.szhernovoy.calculator.view.IO;
import ru.szhernovoy.calculator.view.Input;
import ru.szhernovoy.calculator.view.UserAction;

/**
 * Created by admin on 02.08.2016.
 */
public class MenuCalculator {

    /** constant count action*/
    private final int COUNT_ACTION = 4;
    /**user interact input  */
    private IO input;

    private InteractiveCalculator calc;
    /** menu actions*/
    private UserAction[] actions = new UserAction[COUNT_ACTION];

    public void select(int key){

    }

    public void fillAction(){
        actions[0] = this.new doCalculate("Do calculate. You can enter number (0...9), letter M/m (memory value), action (+ / * -)",calc);
        actions[1] = this.new addInMemory("Save previously calculate in memory",calc);
        actions[2] = this.new cleanCalculate("Clean all result calculate and memory",calc);
        actions[3] = this.new exit("Exit...",calc);
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
                System.out.println(action.info());
            }
        }
    }

    private class doCalculate extends BaseAction {

        private InteractiveCalculator interCalc;
        public doCalculate(String name,InteractiveCalculator calc){
            super(name);
            this.interCalc = calc;
        }

        @Override
        public void execute() {
            interCalc.calculate();
        }

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void inputAction(IO input) {

        }
    }

    private class addInMemory extends BaseAction {

        private InteractiveCalculator interCalc;
        public addInMemory(String name,InteractiveCalculator calc){
            super(name);
            this.interCalc = calc;
        }

        @Override
        public void execute() {

        }

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void inputAction(IO input) {

        }
    }

    private class cleanCalculate extends BaseAction {

        private InteractiveCalculator interCalc;
        public cleanCalculate(String name,InteractiveCalculator calc){
            super(name);
            this.interCalc = calc;
        }

        @Override
        public void execute() {

        }

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void inputAction(IO input) {

        }
    }


    private class exit extends BaseAction {

        private InteractiveCalculator interCalc;
        public exit(String name,InteractiveCalculator calc){
            super(name);
            this.interCalc = calc;
        }

        @Override
        public void execute() {

        }

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void inputAction(IO input) {

        }
    }

}
