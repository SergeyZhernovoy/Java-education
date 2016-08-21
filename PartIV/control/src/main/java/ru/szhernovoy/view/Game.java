package ru.szhernovoy.view;

import ru.szhernovoy.control.ConsoleIO;
import ru.szhernovoy.control.Logic;
import ru.szhernovoy.model.*;

/**
 * Created by szhernovoy on 16.08.2016.
 */
public class Game {

    private final GeneratorBoard generator;
    private final Board board;
    private final Logic logic;
    private Player[] actors = new Player[2];
    private IO io;


    public Game(final Logic logic, final Board board, final GeneratorBoard generator, IO io) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
      //  this.actors = actors;
        this.io = io;
    }


    public void initGame(Player human, Player computer) {
        final Cell[][] cells = generator.generate();
        this.board.drawScreenOnInit();
        boolean choice = io.ask("Do you want do step first ? (y/n) ?",new String[]{"y","n"});
        if(choice){
            this.actors[0] = human;
            this.actors[1] = computer;
        }
        else{
            this.actors[0] = computer;
            this.actors[1] = human;
        }
        this.board.drawBoard(cells);
        this.logic.loadBoard(cells);
    }

    public void work(){
        int[] rangeBoard = this.board.rangeBoard();

        do{
            this.board.drawCell();
            for(int index = 0; index < this.actors.length; index++){
                boolean resultAnswer = false;
                while(!resultAnswer){
                       resultAnswer = this.logic.control(this.actors[index].select(io.ask("Enter position X",rangeBoard) ,io.ask("Enter position Y",rangeBoard)),index);
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


        Game base = new Game(logic,board,generator,new ConsoleIO());
        //base.initGame();
}
}
