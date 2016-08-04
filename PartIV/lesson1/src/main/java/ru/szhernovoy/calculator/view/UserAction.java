package ru.szhernovoy.calculator.view;

/**
 * Created by admin on 02.08.2016.
 */
public interface UserAction {

    void execute();

    int key();

    String info();

    void inputAction(IO input);

}
