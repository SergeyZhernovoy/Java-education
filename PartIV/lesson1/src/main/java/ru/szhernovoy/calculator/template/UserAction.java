package ru.szhernovoy.calculator.template;

import ru.szhernovoy.calculator.model.Input;

/**
 * Created by admin on 02.08.2016.
 */
public interface UserAction {

    void execute();

    int key();

    String info();

    void inputAction(Input input);

}
