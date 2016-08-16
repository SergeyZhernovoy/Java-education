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
        arrayLeapExternalDevices[0] = new MenuItem("CD-ROM");
        arrayLeapExternalDevices[1] = new MenuItem("Monitor");

        MenuItem[] arrayLeapInternalDevices = new MenuItem[2];
        arrayLeapInternalDevices[0] = new MenuItem("CPU");
        arrayLeapInternalDevices[1] = new MenuItem("Motherboard");

        MenuItem root1 = new MenuItem("Internal devices",arrayLeapInternalDevices);
        MenuItem root2 = new MenuItem("External devices",arrayLeapExternalDevices);

        MenuItem root = new MenuItem("Computer",2);
        root.addItem(root1);
        root.addItem(root2);

        Menu menu = new Menu();
        menu.fillMenu(root);
        menu.show(root);
        String result = arrayLeapInternalDevices[0].getKeyStr();
        String control = "1.1.1";

        Assert.assertThat(control,is(result));

    }


}
