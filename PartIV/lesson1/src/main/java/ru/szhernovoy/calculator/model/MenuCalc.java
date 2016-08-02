package ru.szhernovoy.calculator.model;

import ru.szhernovoy.calculator.template.UserAction;

/**
 * Created by admin on 02.08.2016.
 */
public class MenuCalc {

    /** constant count action*/
    private final int COUNT_ACTION = 4;
    /**user interact input  */
    private Input input;
    /** menu actions*/
    private UserAction[] action = new UserAction[COUNT_ACTION];


    private class AddNumber implements UserAction {


        @Override
        public void execute() {

        }

        @Override
        public String action() {
            return null;
        }
    }




}
