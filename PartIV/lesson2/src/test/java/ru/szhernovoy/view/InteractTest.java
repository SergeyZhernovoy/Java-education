package ru.szhernovoy.view;

import org.junit.Assert;
import org.junit.Test;
import ru.calculator.model.InteractiveEngeneerCalculator;
import ru.calculator.view.CosAction;
import ru.calculator.view.SinAction;
import ru.szhernovoy.calculator.controller.MenuCalculator;
import ru.szhernovoy.calculator.model.Calculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;
import ru.szhernovoy.calculator.view.MockIO;
import ru.szhernovoy.calculator.view.StartUI;
import ru.szhernovoy.calculator.view.UserAction;

import static org.hamcrest.core.Is.is;

/**
 * Created by admin on 05.08.2016.
 */
public class InteractTest {
    @Test
    public void whenAddTwoNumberAndCalculateCosinusWeShouldGetResultCosinus(){
        MockIO mockAdd = new MockIO(new String[]{"0","1","+","1","=","n","1","n","3","y"});
        Calculator tinyCalc = new Calculator();
        InteractiveEngeneerCalculator calc = new InteractiveEngeneerCalculator(tinyCalc);
        MenuCalculator menu = new MenuCalculator(calc,mockAdd,4);
        menu.fillActions();
        UserAction cos = new CosAction(calc);
        menu.addAction(cos);

        new StartUI(mockAdd,calc,menu).init();
        boolean result = calc.getResultCalculation() !=0;
        boolean message = true;
        Assert.assertThat(result, is(message));
    }
}