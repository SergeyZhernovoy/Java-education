package ru.szhernovoy.io;


/**
 * Created by szhernovoy on 20.08.2016.
 */
public class Cell {

    /**it value mean X  */
    private boolean iconX = false;
    /**it value mean O */
    private boolean iconO = false;
    /**it value - cell empty */
    private boolean empty = true;

    /**
     * Test cell on X.
     * @return
     */
    public boolean isIconX() {
        return iconX;
    }

    /**
     * Set "X" in cell
     * @param iconX
     */
    public void setIconX(boolean iconX) {
        this.iconX = iconX;
        setEmpty(false);
    }

    /**
     * Set "O" in cell.
     * @param iconO
     */
    public void setIconO(boolean iconO) {
        this.iconO = iconO;
        setEmpty(false);
    }

    /**
     * Test cell on empty
     * @return
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * Set empty in cell
     * @param empty
     */
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    /**
     * return value cell for draw .
     * @return
     */
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
