package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.model.*;
import ru.szhernovoy.start.StartUI;

import static org.hamcrest.core.Is.is;

/**
 * Created by admin on 14.08.2016.
 */
public class StartUITest {

    @Test
    public void whenChoicePointInMenuGetItOnScreen(){

        IO stub = new StubInput(new String[]{"1","y"});
        MenuItem item1 = new MenuItem("CPU",stub);
        MenuItem item2 = new MenuItem("CD-ROM",stub);
        MenuItem item3 = new MenuItem("Monitor",stub);
        MenuItem item4 = new MenuItem("Motherboard",stub);
        MenuRoot root2 = new MenuRoot(3,"System block",stub);
        root2.addItem(item1);
        root2.addItem(item2);
        root2.addItem(item4);
        MenuAction[] menuAction = new MenuAction[2];
        menuAction[0] = root2;
        menuAction[1] = item3;

        Menu menu = new Menu(menuAction);
        menu.fillMenu();
        new StartUI(menu,stub).work();

        Assert.assertThat(true,is(stub.getResult().contains("System block")));
        //System.out.println("\n"+stub.getResult());
    }


}
