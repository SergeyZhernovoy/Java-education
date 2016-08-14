package ru.szhernovoy.model;

/**
 * Created by admin on 13.08.2016.
 */
public class Menu {

    /**
     * value storage point action menu 1st level.*/
   private MenuAction[] menuActions;

    /**
     * Constructor.
      * @param actions
     */
   public Menu( MenuAction[] actions){
        this.menuActions = actions;
    }

    /**
     * Main loop filling point of menu
     */
    public void fillMenu(){
        int position = 0;
        for (MenuAction item : menuActions){
            item.fillAction(String.valueOf(++position),"");
        }
    }

    /**
     * Print point's menu on screen
     */
    public void show(){
        for (MenuAction item : menuActions){
            item.info();
        }
    }

    /**
     * Method for call point's execute from menu.
     * @param key
     */
    public void select(String key){
        for (MenuAction item : menuActions){
            item.execute(key);
        }
    }

}
