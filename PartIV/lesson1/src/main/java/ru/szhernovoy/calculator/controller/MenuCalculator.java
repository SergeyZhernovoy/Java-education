package ru.szhernovoy.calculator.controller;

import ru.szhernovoy.calculator.view.BaseAction;
import ru.szhernovoy.calculator.model.InteractiveCalculator;
import ru.szhernovoy.calculator.view.IO;
import ru.szhernovoy.calculator.view.UserAction;

/**
 * Created by admin on 02.08.2016.
 */
public class MenuCalculator {

    /**user interact input  */
    private final IO input;

    /**ref to calculator */
    private final InteractiveCalculator calc;
    /** menu actions*/
    private UserAction[] actions;
    private int position = 0;

    /**
     * Constructor. Set object input and calculator.
     * @param calc ref
     * @param input ref
     */
    public MenuCalculator(final InteractiveCalculator calc,final IO input, int size){
        this.input = input;
        this.calc = calc;
        this.actions = new UserAction[size];
    }

    /**
     * Get by key method execute from menu of calculator.
     * @param key
     */
    public void select(int key){
            actions[key].execute(calc,input);
    }

    /**
     * Add action in array actions
     * @param action
     */
    public void addAction(UserAction action){
        this.actions[this.position++] = action;
    }

    /**
     * fill menu calculator.
     */
    public void fillActions(){
        actions[this.position++] = this.new DoCalculate("Do calculate. You can enter number (0...9), letter M/m (memory value), action (+ / * -)");
        actions[this.position++] = this.new addInMemory("Save previously calculate in memory");
        actions[this.position++] = this.new cleanCalculate("Clean all result calculate and memory");
    }

    /**
     * Get array all keys action for checking.
     * @return
     */
    public int[] getRangeKeys(){
        int[] range = new int[actions.length];
        int position = 0;
        for(UserAction action : actions){
            range[position++] = action.key();
        }
        return range;
    }

    /**
     * Show menu.
     */
    public void show(){
        for(UserAction action : this.actions){
            if(action != null){
                input.println(action.info());
            }
        }
    }

    /**
     * class for menu. It does call method calculate
     */
    private class DoCalculate extends BaseAction {

        /**
         * Set name for show in menu.
         * @param name
         */
        public DoCalculate(String name){
            super(name);
        }

        /**
         * main method for calculate.
         * @param interCalc
         * @param input type input
         */
        @Override
        public void execute(InteractiveCalculator interCalc,IO input) {
            interCalc.calculate(input);
        }

        /**
         * Get number point in menu
         * @return
         */
        @Override
        public int key() {
            return 0;
        }

    }

    /**
     * Class add value in memory
     */
    private class addInMemory extends BaseAction {

        /**
         * Set name for show in memory
         * @param name
         */
        public addInMemory(String name){
            super(name);

        }

        /**
         * method add value in memory
         * @param interCalc
         * @param input type input
         */
        @Override
        public void execute(InteractiveCalculator interCalc,IO input) {
            calc.addMemory();
        }
        /**
         * Get number point in menu
         * @return
         */
        @Override
        public int key() {
            return 1;
        }

    }

    /**
     * Clean all value in calculator
     */
    private class cleanCalculate extends BaseAction {

        /**
         * Set name for show in memory
         * @param name
         */
        public cleanCalculate(String name){
            super(name);

        }

        /**
         * Method clean memory and result in calculator
         * @param interCalc
         * @param input type input
         */

        @Override
        public void execute(InteractiveCalculator interCalc,IO input) {
            calc.clean();
        }
        /**
         * Get number point in menu
         * @return
         */
        @Override
        public int key() {
            return 2;
        }


    }
}
