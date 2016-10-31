package ru.szhernovoy.bomberman.view;

import ru.szhernovoy.bomberman.model.Block;
import ru.szhernovoy.bomberman.model.Cell;

import java.util.Random;

/**
 * Created by admin on 27.10.2016.
 */
public class GameBoard {
    private final int SIZE;
    private final int COUNT_MONSTER;
    private final int COUNT_BLOCK;
    private Cell[][] gameBoard;
    private Random xyPosition = new Random();

    public GameBoard(int sizeBoard, int countMonster, int countBlock) {
        this.SIZE = sizeBoard;
        this.COUNT_MONSTER = countMonster;
        this.COUNT_BLOCK = countBlock;
        this.gameBoard = new Cell[this.SIZE][this.SIZE];
        for(int row= 0 ; row<this.SIZE; row++){
            for(int column = 0; column < this.SIZE;column++){
                this.gameBoard[row][column] = new Cell();
            }
        }
    }

    public void init(){


    }

    private int getRandom(){
        return this.xyPosition.nextInt(this.SIZE);
    }


    private void initBlock(){

        int countBlock = this.COUNT_BLOCK-1;
        while(countBlock >= 0){
            Cell cell = gameBoard[this.getRandom()][this.getRandom()];
            if(cell.getCharacter() == null){
                cell.setCharacter(new Block(String.format("Block %d",countBlock),countBlock,true));
                countBlock--;
            }
        }
    }

    private void initMosters(){

    }

    private void initPlayer(){

        int countBlock = this.COUNT_BLOCK-1;
        while(true){
            Cell cell = gameBoard[this.getRandom()][this.getRandom()];
            if(cell.getCharacter() == null){
                cell.setCharacter(new Block(String.format("Block %d",countBlock),countBlock,true));
                countBlock--;
            }
        }


    }


}
