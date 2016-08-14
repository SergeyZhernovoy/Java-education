package ru.szhernovoy.start;

import ru.szhernovoy.model.*;

/**
 * Created by admin on 11.08.2016.
 */
public class StartUI {

    /** reg object Menu   */
    private final Menu menu;
    /**ref object Input */
    private final Input input;

    /**
     * Constructor.
     * @param menu
     * @param input
     */
    public StartUI(final Menu menu, final Input input){
        this.menu = menu;
        this.input = input;
    }

    /**
     *Main loop work with menu.
     */
    public void work(){

        do{
            menu.show();
            menu.select(this.input.ask("select point menu: "));
        }while(!"y".equals(this.input.ask("Exit ? ( press y)")));

    }

    public static void main(String[] args) {

        Output out = new ConsoleOutput();
        MenuItem item1 = new MenuItem("CPU",out);
        MenuItem item2 = new MenuItem("CD-ROM",out);
        MenuItem item3 = new MenuItem("Monitor",out);
        MenuItem item4 = new MenuItem("Motherboard",out);
        MenuItem item5 = new MenuItem("Keyboard",out);
        MenuItem item6 = new MenuItem("Mouse",out);
        MenuRoot root1 = new MenuRoot(2,"Computer device",out);
        MenuRoot root2 = new MenuRoot(3,"System block",out);
        MenuRoot root3 = new MenuRoot(2,"External device",out);
        MenuRoot root4 = new MenuRoot(1,"Internal device",out);
        root2.addItem(item1);
        root2.addItem(item2);
        root2.addItem(item4);
        root4.addItem(root2);
        root3.addItem(item5);
        root3.addItem(item6);
        root1.addItem(root3);
        root1.addItem(root4);
        MenuAction[] menuAction = new MenuAction[2];
        menuAction[0] = root1;
        menuAction[1] = item3;
        Input input = new ConsoleInput();
        Menu menu = new Menu(menuAction);
        menu.fillMenu();
        new StartUI(menu,input).work();
    }

}
