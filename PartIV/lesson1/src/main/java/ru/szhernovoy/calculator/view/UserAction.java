package ru.szhernovoy.calculator.view;

import ru.szhernovoy.calculator.model.InteractiveCalculator;

/**
 * Created by admin on 02.08.2016.
 */
public interface UserAction {

    void execute(InteractiveCalculator calc, IO input);

    int key();

    String info();

}
