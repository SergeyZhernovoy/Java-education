package ru.szhernovoy.calculator.view;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.calculator.controller.MenuCalculator;
import ru.szhernovoy.calculator.model.Calculator;
import ru.szhernovoy.calculator.model.InteractiveCalculator;

import static org.hamcrest.core.Is.is;

/**
 * Created by admin on 05.08.2016.
 */
public class InteractTest {
    @Test
    public void whenAddTwoNumberWeShouldGetResultAdditional(){
        MockIO mockAdd = new MockIO(new String[]{"0","1","+","1","=","y"});
        Calculator tinyCalc = new Calculator();
        InteractiveCalculator calc = new InteractiveCalculator(tinyCalc);
        MenuCalculator menu = new MenuCalculator(calc,mockAdd,3);
        new StartUI(mockAdd,calc,menu).init();
        double result = calc.getResultCalculation();
        double message = 2.0;
        Assert.assertThat(result, is(message));
    }
}
