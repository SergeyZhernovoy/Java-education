package ru.szhernovoy.view;


/**
 * Created by szhernovoy on 20.08.2016.
 */
public class Cell {

    private boolean iconX = false;
    private boolean iconO = false;
    private boolean empty = true;

    public boolean isIconX() {
        return iconX;
    }

    public void setIconX(boolean iconX) {
        this.iconX = iconX;
    }

    public boolean isIconO() {
        return iconO;
    }

    public void setIconO(boolean iconO) {
        this.iconO = iconO;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public void draw() {

        if(this.empty){
            System.out.print("[ ]");
        }
        else{
            if(this.iconX){
                System.out.print("[X]");
            }
            if(this.iconO){
                System.out.print("[O]");
            }
        }
     }
}
