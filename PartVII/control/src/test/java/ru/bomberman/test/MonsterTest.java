package ru.bomberman.test;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.bomberman.model.*;
import ru.szhernovoy.bomberman.view.GameBoard;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 02.11.2016.
 */
public class MonsterTest {

    @Test
    public void whenMonsterWantWalkToNextCellIfItNormalCell(){

        Cell[] [] gameBoard = new Cell[4][4];
        for(int row= 0 ; row<4; row++){
            for(int column = 0; column < 4;column++){
                gameBoard[row][column] = new Cell();
            }
        }
        Monster monster1 = new Monster("M1",1,gameBoard,0,0);
        Monster monster2 = new Monster("M2",1,gameBoard,2,3);
        GameBoard game =  new GameBoard(gameBoard,2,3);
        gameBoard[0][0].setCharacter(monster1);
        gameBoard[2][3].setCharacter(monster2);
        boolean result = monster1.checkMove(Direction.RIGHT);
        Assert.assertThat(result,is(true));

    }
    @Test
    public void whenMonsterWantWalkToNextCellIfItEndBoard(){
        Cell[] [] gameBoard = new Cell[4][4];
        for(int row= 0 ; row<4; row++){
            for(int column = 0; column < 4;column++){
                gameBoard[row][column] = new Cell();
            }
        }
        Monster monster1 = new Monster("M1",1,gameBoard,0,0);
        Monster monster2 = new Monster("M2",1,gameBoard,2,3);
        GameBoard game =  new GameBoard(gameBoard,2,3);
        gameBoard[0][0].setCharacter(monster1);
        gameBoard[2][3].setCharacter(monster2);
        boolean result = monster1.checkMove(Direction.LEFT);
        Assert.assertThat(result,is(false));
    }
    @Test
    public void whenMonsterWantWalkToNextCellIfCellNotNull(){
        Cell[] [] gameBoard = new Cell[4][4];
        for(int row= 0 ; row<4; row++){
            for(int column = 0; column < 4;column++){
                gameBoard[row][column] = new Cell();
            }
        }
        Monster monster1 = new Monster("M1",1,gameBoard,0,0);
        Monster monster2 = new Monster("M2",1,gameBoard,0,1);
        GameBoard game =  new GameBoard(gameBoard,2,3);
        gameBoard[0][0].setCharacter(monster1);
        gameBoard[0][1].setCharacter(monster2);
        //game.print();
        monster1.move(Direction.RIGHT);
        //game.print();
        AbstractCharacter result = gameBoard[0][1].getCharacter();


        //boolean result = monster1.checkMove(Direction.RIGHT);
        Assert.assertThat(result,is((AbstractCharacter) monster2));
    }




}