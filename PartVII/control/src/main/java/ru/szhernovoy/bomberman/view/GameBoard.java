package ru.szhernovoy.bomberman.view;

import ru.szhernovoy.bomberman.model.*;
import java.util.Random;

/**
 * Created by admin on 27.10.2016.
 */
public class GameBoard {
    private final int SIZE;
    private final int COUNT_BLOCK;
    private Cell[][] gameBoard;
    private Random xyPosition = new Random();
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

    public void init(){
        this.initBlock();
        this.initMosters();
        this.initPlayer();
    }

    public void start(){
        for (Thread thread : this.threads){
            thread.start();
        }
    }


    private int getRandom(){
        return this.xyPosition.nextInt(this.SIZE);
    }


    private void initBlock(){

        int countBlock = this.COUNT_BLOCK-1;
        while(countBlock >= 0){
            int x = this.getRandom();
            int y = this.getRandom();
            Cell cell = this.gameBoard[x][y];
            if(cell.getCharacter() == null){
                cell.setCharacter(new Block(String.format("Block_%d",countBlock),countBlock,true,this.gameBoard,x,y));
                countBlock--;
            }
        }
    }

    private void initMosters(){

        for(int count = 0; count < this.threads.length; count++){
            Monster monster;
            while(true){
                int x = this.getRandom();
                int y = this.getRandom();
                Cell cell = this.gameBoard[x][y];
                if(cell.getCharacter() == null){
                    monster = new Monster(String.format("Monster_%d",count),count,true,this.gameBoard,x,y);
                    cell.setCharacter(monster);
                }
            }
            this.threads[count] = new Thread();
        }
    }

    private void initPlayer(){

        while(true){
            int x = this.getRandom();
            int y = this.getRandom();
            Cell cell = this.gameBoard[x][y];
            if(cell.getCharacter() == null){
                cell.setCharacter(new Human("Player",1,true,this.gameBoard,x,y));
                break;
            }
        }
    }


}
