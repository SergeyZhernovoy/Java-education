package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public abstract class AbstractCharacter implements ActionCharacter {

    /**variable contains name Character */
    protected final String name;
    /**variable contains unique ID Character */
    protected final int id;
    /**game board - array */
    protected final Cell[][] cells;
    /**current position Character X */
    protected int xPosition;
    /**current position Character Y */
    protected int yPosition;

    /**Next position Character */
    protected Cell next;
    /**current position Character X */
    protected int nextX;
    /**current position Character Y */
    protected int nextY;

    public AbstractCharacter(String name, int id,final Cell[][] cells,int x, int y) {
        this.name = name;
        this.id = id;
        this.cells = cells;
        this.xPosition = x;
        this.yPosition = y;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    /**
     * Check possible of move Character
     * @param step
     * @return
     */
    public boolean checkMove(Direction step){

        int sizeBoard = this.cells.length;
        boolean result = false;
        this.nextX = xPosition;
        this.nextY = yPosition;

        if(step == Direction.DOWN){
            if(++this.nextX < sizeBoard){
                this.next = this.cells[this.nextX][this.nextY];
                result = true;
            }
        }
        if(step == Direction.UP){
            if(--this.nextX >= 0){
                this.next = this.cells[this.nextX][this.nextY];
                result = true;
            }
        }
        if(step == Direction.LEFT){
            if(--this.nextY >= 0){
                this.next = this.cells[this.nextX][this.nextY];
                result = true;
            }
        }
        if(step == Direction.RIGHT){
            if(++this.nextY < sizeBoard){
                this.next = this.cells[this.nextX][this.nextY];
                result = true;
            }
        }
        return result;
    }


}
