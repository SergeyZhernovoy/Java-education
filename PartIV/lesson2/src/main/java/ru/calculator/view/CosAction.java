package ru.calculator.view;

import ru.calculator.model.InteractiveEngeneerCalculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;
import ru.szhernovoy.calculator.view.IO;
import ru.szhernovoy.calculator.view.UserAction;

/**
 * Created by Sergey on 05.08.2016.
 */
public class CosAction implements UserActionExtended {

    @Override
    public void execute(InteractiveEngeneerCalculator calc, IO input) {
        calc.calcCosinus();
    }

    @Override
    public void execute(InteractiveCalculator calc, IO input) {

    }

    @Override
    public int key() {
        return 3;
    }

    @Override
    public String info() {
        return String.format("%s.) %s", this.key(),"Calculate cosinus");
    }
}
