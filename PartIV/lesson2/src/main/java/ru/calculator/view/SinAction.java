package ru.calculator.view;

import ru.calculator.model.InteractiveEngeneerCalculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;
import ru.szhernovoy.calculator.view.IO;
import ru.szhernovoy.calculator.view.UserAction;

/**
 * Created by Sergey on 05.08.2016.
 */
public class SinAction implements UserAction {

    private InteractiveEngeneerCalculator engeneerCalc;

    public SinAction(InteractiveEngeneerCalculator calc){
        this.engeneerCalc = calc;
    }

    @Override
    public void execute(InteractiveCalculator calc, IO input) {
        this.engeneerCalc.calcSinus();
    }

    @Override
    public int key() {
        return 4;
    }

    @Override
    public String info() {
        return String.format("%s.) %s", this.key(),"Calculate sinus");
    }
}
