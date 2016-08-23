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

    public void initGame() {
        final Cell[][] cells = generator.generate();
        this.board.drawBoard(cells);
        this.logic.loadBoard(cells);
    }

    public void initPlayer(Player human){
        Player computer = new Computer(this.logic);
        human.setBoardSize(this.board.rangeBoard());
        boolean choice = "y".equals(human.firstStep("Do you want do step first ? (y/n) ?"));
        if (choice) {
            this.actors[0] = human;
            this.actors[1] = computer;
        } else {
            this.actors[0] = computer;
            this.actors[1] = human;
        }

    }

     public void work(){
        this.board.drawScreenOnInit();
        do{
            //this.board.drawCell();
            for(int index = 0; index < this.actors.length; index++){
                boolean resultAnswer = false;
                while(!resultAnswer){
                       resultAnswer = this.logic.control(this.actors[index].select("Enter position"),index);
                }
                if(this.logic.finish()){
                    break;
                }
            }

        }while(!this.logic.finish());
    }

    public static void main(String[] args) {

        Logic logic = new Logic();
        Board board = new Board();
        GeneratorBoard generator = new GeneratorBoard();
        ValidateIO valid = new ValidateIO();
        Player human = new Human(valid);
        Game base = new Game(logic,board,generator);
        base.initGame();
        base.initPlayer(human);
        base.work();
}
}
