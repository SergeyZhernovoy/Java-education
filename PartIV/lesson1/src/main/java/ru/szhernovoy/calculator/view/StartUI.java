package ru.szhernovoy.calculator.view;

import ru.szhernovoy.calculator.controller.MenuCalculator;
import ru.szhernovoy.calculator.model.Calculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;

/**
 * Created by szhernovoy on 04.08.2016.
 */
public class StartUI {
    private IO input;
    InteractiveCalculator calc;
    MenuCalculator menu ;

    public StartUI(IO input,InteractiveCalculator calc, MenuCalculator menu){
        this.input = input;
        this.calc = calc;
        this.menu = menu;
    }

    public void init(){

        menu.fillActions();
        int[] range = menu.getRangeKeys();
        do{
            menu.show();
            menu.select(input.ask("select: ",range));

        }
        while(!"y".equals(this.input.ask("Exit? (y)")));

    }

    public static void main(String[] args){

        ValidateInput input = new ValidateInput();
        InteractiveCalculator calc = new InteractiveCalculator();
        MenuCalculator menu = new MenuCalculator(calc,input);
        new StartUI(input,calc,menu).init();
    }
}
