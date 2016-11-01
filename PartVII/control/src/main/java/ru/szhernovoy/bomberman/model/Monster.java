package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public class Monster extends AbstractCharacter implements Runnable{


    public Monster(String name, int id, boolean isLife,Cell[][] cells,int x, int y) {
        super(name, id, isLife,cells,x ,y,Type.MONSTER);
    }

    @Override
    public void move(Direction step) {

        boolean makeStep = false;

        while(!makeStep){
            if(checkMove(step)){
               if(this.next.getCharacter() != null) {
                    try {
                        this.wait(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (this.next.getCharacter() == null) {
                        synchronized (this.next){
                            synchronized (this.cells[xPosition][yPosition]){
                                this.next.setCharacter(this);
                                this.cells[xPosition][yPosition].erase();
                                this.xPosition = nextX;
                                this.yPosition = nextY;
                            }
                        }
                    }
                    else{
                        step = Direction.getRandomDirection();
                    }
                }
            }
            else{
                step = Direction.getRandomDirection();
            }
        }
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                this.wait(1000);
            } catch (InterruptedException e) {
                break;
            }
            move(Direction.getRandomDirection());
        }
    }
}
