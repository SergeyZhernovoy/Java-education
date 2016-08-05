package ru.calculator.view;

import ru.calculator.model.InteractiveEngeneerCalculator;
import ru.szhernovoy.calculator.view.IO;
import ru.szhernovoy.calculator.view.UserAction;

/**
 * Created by Sergey on 05.08.2016.
 */
public interface UserActionExtended extends UserAction{
   void execute(InteractiveEngeneerCalculator calc, IO input);
}
