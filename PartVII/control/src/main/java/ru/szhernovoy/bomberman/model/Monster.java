package ru.szhernovoy.bomberman.model;

/**
 * Created by admin on 27.10.2016.
 */
public class Monster extends AbstractCharacter implements Runnable{

    public Monster(String name, int id, boolean isLife,Cell[][] cells,int x, int y) {
        super(name, id, isLife,cells,x ,y);
    }

    @Override
    public void move(Direction step) {
        int sizeBoard = this.cells.length - 1;
        if(step == Direction.DOWN){

            while(){

            }
            int nextPositionY = yPosition-1
            if(nextPositionY >=0 && nextPositionY <= sizeBoard){

            }
            else{

            }

        }


    }

    private Direction checkMove(){



        return true;
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
       move(Direction.getRandomDirection());
    }
}
