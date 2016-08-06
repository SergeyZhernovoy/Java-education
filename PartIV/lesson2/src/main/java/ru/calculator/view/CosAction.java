package ru.calculator.view;

import ru.calculator.model.InteractiveEngeneerCalculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;
import ru.szhernovoy.calculator.view.IO;
import ru.szhernovoy.calculator.view.UserAction;

/**
 * Created by Sergey on 05.08.2016.
 */
public class CosAction implements UserAction {

    /**value save ref on calculator */
    private final InteractiveEngeneerCalculator engeneerCalc;

    /**
     * Constructor. Set ref calculator.
     * @param calc
     */
    public CosAction(final InteractiveEngeneerCalculator calc){
        this.engeneerCalc = calc;
    }

    /**
     * Method call new calculate from extended calculator.
     * @param calc object what execute any action by menu.
     * @param input type input
     */
    @Override
    public void execute(InteractiveCalculator calc, IO input) {
        this.engeneerCalc.calcCosinus();
    }
    /**
     * Get number point in menu.
     * @return
     */
    @Override
    public int key() {
        return 3;
    }
    /**
     * Method print key menu and name action menu.
     * @return
     */
    @Override
    public String info() {
        return String.format("%s.) %s", this.key(),"Calculate cosinus from value memory");
    }
}
