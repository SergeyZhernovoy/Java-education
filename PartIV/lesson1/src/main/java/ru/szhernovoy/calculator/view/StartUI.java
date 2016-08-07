package ru.szhernovoy.calculator.view;

import ru.szhernovoy.calculator.controller.MenuCalculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;

/**
 * Created by szhernovoy on 04.08.2016.
 */
public class StartUI {
    /** ref on object input in application*/
    private IO input;
    /** ref on object calculator*/
    InteractiveCalculator calc;
    /** ref on object manu program*/
    MenuCalculator menu ;

    /**
     * Constructor.
     * @param input object input , user action
     * @param calc obj interact calculator
     * @param menu obj menu user action with programm
     */
    public StartUI(IO input,InteractiveCalculator calc, MenuCalculator menu){
        this.input = input;
        this.calc = calc;
        this.menu = menu;
    }

    /**
     * main loop application.
     */
    public void init(){


        int[] range = menu.getRangeKeys();
        do{
            menu.show();
            menu.select(input.ask("select: ",range));

        }
        while(!"y".equals(this.input.ask("Exit? (y)")));

    }

    /**
     * static method execute.
     * @param args
     */
    public static void main(String[] args){

        ValidateInput input = new ValidateInput();
        InteractiveCalculator calc = new InteractiveCalculator();
        MenuCalculator menu = new MenuCalculator(calc,input,3);
        menu.fillActions();
        new StartUI(input,calc,menu).init();
    }
}
