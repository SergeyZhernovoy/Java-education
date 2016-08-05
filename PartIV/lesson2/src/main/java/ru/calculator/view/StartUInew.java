package ru.calculator.view;

import ru.calculator.model.InteractiveEngeneerCalculator;
import ru.szhernovoy.calculator.controller.MenuCalculator;
import ru.szhernovoy.calculator.view.StartUI;
import ru.szhernovoy.calculator.view.ValidateInput;

/**
 * Created by szhernovoy on 04.08.2016.
 */
public class StartUInew {

    /**
     * static method execute.
     * @param args
     */
    public static void main(String[] args){

        ValidateInput input = new ValidateInput();
        InteractiveEngeneerCalculator calc = new InteractiveEngeneerCalculator();
        MenuCalculator menu = new MenuCalculator(calc,input,5);
        menu.fillActions();
        UserActionExtended cos = new CosAction();
        menu.addAction(cos);
        UserActionExtended sin = new SinAction();
        menu.addAction(sin);
        new StartUI(input,calc,menu).init();
    }
}
