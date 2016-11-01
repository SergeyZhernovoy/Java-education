package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public abstract class AbstractCharacter implements ActionCharacter {

    protected final String name;
    protected final int id;
    protected boolean isLife;
    protected final Cell[][] cells;
    protected int xPosition;
    protected int yPosition;

    protected Cell next;
    protected int nextX;
    protected int nextY;

    public Type getType() {
        return type;
    }

    protected Type type;

    public AbstractCharacter(String name, int id, boolean isLife,final Cell[][] cells,int x, int y, Type type) {
        this.name = name;
        this.id = id;
        this.isLife = isLife;
        this.cells = cells;
        this.xPosition = x;
        this.yPosition = y;
        this.type = type;
    }

    @Override
    public String toString() {
        return getClass().getName()  +
                "{ name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean isLife() {
        return isLife;
    }


    protected boolean checkMove(Direction step){

        int sizeBoard = this.cells.length;
        boolean result = false;
        this.nextX = yPosition;
        this.nextY = xPosition;

        if(step == Direction.DOWN){
            if(++this.nextX < sizeBoard){
                this.next = this.cells[this.nextX][yPosition];
                result = true;
            }
        }
        if(step == Direction.UP){
            if(--this.nextX >= 0){
                this.next = this.cells[this.nextX][yPosition];
                result = true;
            }
        }
        if(step == Direction.LEFT){
            if(--this.nextY >= 0){
                this.next = this.cells[xPosition][this.nextY];
                result = true;
            }
        }
        if(step == Direction.RIGHT){
            if(++this.nextY < sizeBoard){
                this.next = this.cells[xPosition][this.nextY];
                result = true;
            }
        }
        return result;
    }


}
