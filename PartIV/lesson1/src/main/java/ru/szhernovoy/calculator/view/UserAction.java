package ru.szhernovoy.calculator.view;

import ru.szhernovoy.calculator.model.InteractiveCalculator;

/**Interface idenitifier user action in menu
 * Created by admin on 02.08.2016.
 */
public interface UserAction {

    /**
     * Method execute any action menu.
     * @param calc object what execute any action by menu
     * @param input type input
     */
    void execute(InteractiveCalculator calc, IO input);

    /**
     * number point menu
     * @return
     */
    int key();

    /**
     * print information for menu.
     * @return
     */
    String info();

}
