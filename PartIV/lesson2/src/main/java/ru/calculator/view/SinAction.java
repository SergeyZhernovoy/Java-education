package ru.calculator.view;

import ru.calculator.model.InteractiveEngeneerCalculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;
import ru.szhernovoy.calculator.view.IO;

/**
 * Created by Sergey on 05.08.2016.
 */
public class SinAction implements UserActionExtended {

    @Override
    public void execute(InteractiveEngeneerCalculator calc, IO input) {
        calc.calcSinus();
    }

    @Override
    public void execute(InteractiveCalculator calc, IO input) {

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
