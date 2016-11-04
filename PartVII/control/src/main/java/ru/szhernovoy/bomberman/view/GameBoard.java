package ru.szhernovoy.bomberman.view;

import ru.szhernovoy.bomberman.model.*;
import java.util.Random;

/**
 * Created by admin on 27.10.2016.
 */
public class GameBoard {
    /**constant SIZE game board */
    private final int SIZE;
    /**constant COUNT stay block  */
    private final int COUNT_BLOCK;
    /**array cell - main game board */
    private Cell[][] gameBoard;
    /**return X || Y position in array */
    private Random xyPosition = new Random();
    /**main pool thread monsters */
    private Thread[] threads;

    public GameBoard(int sizeBoard, int countMonster, int countBlock) {
        this.SIZE = sizeBoard;
        this.threads = new Thread[countMonster];
        this.COUNT_BLOCK = countBlock;
        this.gameBoard = new Cell[this.SIZE][this.SIZE];
        for(int row= 0 ; row<this.SIZE; row++){
            for(int column = 0; column < this.SIZE;column++){
                this.gameBoard[row][column] = new Cell();
            }
        }
    }

    public GameBoard(final Cell[][] board, int countMonster, int countBlock) {
        this.SIZE = board.length;
        this.threads = new Thread[countMonster];
        this.COUNT_BLOCK = countBlock;
        this.gameBoard = board;

    }


    /**init all method game board */
    public void init(){
        this.initBlock();
        this.initMosters();
        this.initPlayer();
    }

    /**start game */
    public void start(){
        for (Thread thread : this.threads){
            thread.start();
        }
    }


    /**get XY position */
    private int getRandom(){
        return this.xyPosition.nextInt(this.SIZE);
    }


    /**setter block in game board */
    public void initBlock(){

        int countBlock = this.COUNT_BLOCK-1;
        while(countBlock >= 0){
            int x = this.getRandom();
            int y = this.getRandom();
            Cell cell = this.gameBoard[x][y];
            if(cell.getCharacter() == null){
                cell.setCharacter(new Block(String.format("B%d",countBlock),countBlock,this.gameBoard,x,y));
                countBlock--;
            }
        }
    }

    /**setter monster in game board */
    public void initMosters(){

        for(int count = 0; count < this.threads.length; count++){
            Monster monster;
            while(true){
                int x = this.getRandom();
                int y = this.getRandom();
                Cell cell = this.gameBoard[x][y];
                if(cell.getCharacter() == null){
                    monster = new Monster(String.format("M%d",count),count,this.gameBoard,x,y);
                    cell.setCharacter(monster);
                    break;
                }
            }
            this.threads[count] = new Thread(monster);
        }
    }

    /**setter player in game board */
    public void initPlayer(){

        while(true){
            int x = this.getRandom();
            int y = this.getRandom();
            Cell cell = this.gameBoard[x][y];
            if(cell.getCharacter() == null){
                cell.setCharacter(new Human("P",1,this.gameBoard,x,y));
                break;
            }
        }
    }

    public void stop(){
        for (Thread thread : this.threads){
            thread.interrupt();
        }
    }


    public void print(){

        int  y = 0;
        System.out.print("\t[\\]");

        for(int index = 0; index < this.gameBoard.length; index++){
            System.out.print(String.format("\t[%s]",index));
        }
        System.out.println("");
        for (Cell[] row : this.gameBoard) {
            System.out.print("\t["+ y++ +"]");
            for (Cell cell : row) {
                AbstractCharacter charT = cell.getCharacter();
                System.out.print(""+(charT == null ? "  ":"["+ charT+"]"));
            }
            System.out.println();
        }
        System.out.println();
    }




    public static void main(String[] args) throws InterruptedException {
        GameBoard newGame = new GameBoard(9,3,3);
        newGame.init();
        newGame.print();
        newGame.start();
        Thread.sleep(2000);
        long timeOut = 0;
        while(timeOut < 1800000){
            newGame.print();
            Thread.sleep(2000);
            timeOut += 2000;
        }

        newGame.stop();
        System.out.println("End game");
        newGame.print();



    }

}
