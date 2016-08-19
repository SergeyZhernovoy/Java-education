package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.model.*;
import ru.szhernovoy.start.Menu;


import static org.hamcrest.core.Is.is;

/**
 * Created by admin on 14.08.2016.
 */
public class MenuTest {

    @Test
    public void controlFillingMenu(){

        MenuItem[] arrayLeapExternalDevices = new MenuItem[2];
        arrayLeapExternalDevices[0] = new MenuItem("CD-ROM","1.2.2.");
        arrayLeapExternalDevices[1] = new MenuItem("Monitor","1.2.1.");

        MenuItem[] arrayLeapInternalDevices = new MenuItem[2];
        arrayLeapInternalDevices[0] = new MenuItem("CPU","1.1.1.");
        arrayLeapInternalDevices[1] = new MenuItem("Motherboard","1.1.2.");

        MenuItem root1 = new MenuItem("Internal devices",arrayLeapInternalDevices,"1.1.");
        MenuItem root2 = new MenuItem("External devices",arrayLeapExternalDevices,"1.2.");

        MenuItem root = new MenuItem("Computer",2,"1.");
        root.addItem(root1);
        root.addItem(root2);

        Menu menu = new Menu(root);
        menu.print();

        String result = arrayLeapInternalDevices[0].getKeyStr();
        String control = "1.1.1.";

        Assert.assertThat(control,is(result));

    }


}
