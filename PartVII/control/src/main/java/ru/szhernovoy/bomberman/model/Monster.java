package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public class Monster extends AbstractCharacter implements Runnable{


    public Monster(String name, int id,Cell[][] cells,int x, int y) {
        super(name, id, cells,x ,y);
    }

    @Override
    public void move(Direction step) {

        boolean makeStep = false;
        synchronized (this.cells[xPosition][yPosition]) {
        while(!makeStep){

                int X = nextX;
                int Y = nextY;

               if(checkMove(step)){
               if(this.next.getCharacter() != null) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
               }

                    if (this.next.getCharacter() == null) {
                        synchronized (this.next) {

                            this.next.setCharacter(this);
                            this.cells[xPosition][yPosition].erase();
                            System.out.println(String.format("%s do move from %d%d to %d%d %s", this.name, this.xPosition, this.yPosition, this.nextX, this.nextY, step));
                            this.xPosition = nextX;
                            this.yPosition = nextY;
                            makeStep = true;
                        }
                    } else {
                        System.out.println(String.format("%s. Many wait.  do not move to %d%d", this.name, this.nextX, this.nextY));
                        step = Direction.getRandomDirection();
                        nextX = X;
                        nextY = Y;
                    }

                }
               else{
                   System.out.println(String.format("%s wrong way . do not move to %d%d",this.name,this.nextX,this.nextY));
                   step = Direction.getRandomDirection();
                   nextX = X;
                   nextY = Y;
               }

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
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
            move(Direction.getRandomDirection());
        }
    }
}
