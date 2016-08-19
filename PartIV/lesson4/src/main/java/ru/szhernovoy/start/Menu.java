package ru.szhernovoy.start;

import ru.szhernovoy.model.MenuItem;

/**
 * Created by admin on 13.08.2016.
 */
public class Menu {
    /**value save root menu item */
    private MenuItem menuActions;

    public Menu(MenuItem item){
        this.menuActions = item;
    }
    /**
     * Print point's menu on screen
     */
    public void print(){
        this.menuActions.info();
    }

    /**
     * Method for call point's execute from menu.
     * @param key
     */
    public void select(String key){
        this.menuActions.execute(key);
    }


}
