package ru.szhernovoy.view;

import ru.szhernovoy.control.*;
import ru.szhernovoy.model.*;

/**
 * Created by szhernovoy on 16.08.2016.
 */
public class Game {

    private final GeneratorBoard generator;
    private final Board board;
    private final Logic logic;
    private Player[] actors = new Player[2];


    public Game(final Logic logic, final Board board, final GeneratorBoard generator) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
    }

    public void initGame(Player human) throws ErrorInput {
        final Cell[][] cells = generator.generate();
        this.board.loadBoard(cells);
        this.logic.loadBoard(cells);
        initPlayer(human);
    }

    private void initPlayer(Player human) throws ErrorInput {
        Player computer = new Computer();
        human.setBoardSize(this.board.rangeBoard());
        computer.setBoardSize(this.board.rangeBoard());
        boolean choice = human.firstStep("Do you want do step first ? (y/n) ?");
        if (choice) {
            this.actors[0] = human;
            this.actors[1] = computer;
        } else {
            this.actors[0] = computer;
            this.actors[1] = human;
        }
    }

     public void work() throws ErrorInput {
        this.board.drawScreenOnInit();
        boolean gameOver = false;
        int winner = -1;
        do{
            this.board.drawCell();
            for(int index = 0; index < this.actors.length; index++){
                boolean resultAnswer = false;
                System.out.println(String.format("%s - step",this.actors[index].whoAreYou()));
                while(!resultAnswer){
                       int[] position = this.actors[index].select("Enter position");
                       resultAnswer = this.logic.control(position);
                       if(resultAnswer){
                          this.logic.setValue(position,index);
                       }
                       else{
                           System.out.println("Uncorrect step - try again...");
                       }
                }

                winner = this.logic.isWinner();
                gameOver = this.logic.finish() || (winner != -1);
                if(gameOver){
                    break;
                }
            }
        }while(!gameOver);
        this.board.endGame(this.actors,winner);

     }

    public static void main(String[] args) throws ErrorInput {
        Game base = new Game(new Logic(),new Board(),new GeneratorBoard());
        base.initGame(new Human(new ValidateIO()));
        base.work();
    }
}
