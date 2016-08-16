package ru.szhernovoy.start;

import ru.szhernovoy.model.MenuAction;
import ru.szhernovoy.model.MenuItem;

/**
 * Created by admin on 13.08.2016.
 */
public class Menu {

    /**
     * Main loop filling point of menu
     */
    public void fillMenu(MenuAction menuActions){
        int position = 0;
        menuActions.fillAction(String.valueOf(++position),"");
    }

    /**
     * Print point's menu on screen
     */
    public void show(MenuAction menuActions){
        menuActions.info();
    }

    /**
     * Method for call point's execute from menu.
     * @param key
     */
    public void select(String key,MenuAction menuActions ){
        menuActions.execute(key);
    }


}
