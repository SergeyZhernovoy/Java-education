package ru.szhernovoy.calculator.model;

import ru.szhernovoy.calculator.template.BaseAction;
import ru.szhernovoy.calculator.template.UserAction;

import java.io.ByteArrayOutputStream;

/**
 * Created by admin on 02.08.2016.
 */
public class MenuCalculator {

    /** constant count action*/
    private final int COUNT_ACTION = 4;
    /**user interact input  */
    private Input input;
    /** menu actions*/
    private UserAction[] actions = new UserAction[COUNT_ACTION];


    public void select(int key){
        this.actions[key].execute();
    }

    public void fillAction(){
        actions[0] = this.new EnterValue("Enter operand");
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

    private class EnterValue extends BaseAction{

        public EnterValue(String name){
            super(name);
        }

        @Override
        public void execute() {

        }

        @Override
        public int key() {
            return 0;
        }
    }

    //enter 1st operand
    //enter sec operand
    //add
    //div
    //sub
    //mul
    //equals
    //memory set
    //memory get

    /*private class AddNumber implements UserAction {


        @Override
        public void execute() {

        }

        @Override
        public String action() {
            return null;
        }
    }*/




}
