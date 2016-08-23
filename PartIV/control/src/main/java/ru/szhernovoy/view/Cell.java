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
        setEmpty(false);
    }

    public boolean isIconO() {
        return iconO;
    }

    public void setIconO(boolean iconO) {
        this.iconO = iconO;
        setEmpty(false);
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public String image() {
        String image = "[ ]";
        if(this.iconX){
            image = "[X]";
        }
        if(this.iconO){
            image = "[O]";
        }
        return image;
     }
}
