package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public class Human extends AbstractCharacter {

    public Human(String name, int id, Cell[][] cells, int x, int y) {
        super(name, id, cells,x ,y);
    }

    @Override
    public void move(Direction step) {
            if(checkMove(step)){
                if (this.next.getCharacter() == null) {
                    synchronized (this.next) {
                        synchronized (this.cells[xPosition][yPosition]) {
                            this.next.setCharacter(this);
                            this.cells[xPosition][yPosition].erase();
                            this.xPosition = nextX;
                            this.yPosition = nextY;
                        }
                    }
                }
            }
    }

}
