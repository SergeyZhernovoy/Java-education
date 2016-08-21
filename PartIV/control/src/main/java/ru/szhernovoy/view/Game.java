package ru.szhernovoy.view;

import ru.szhernovoy.control.ConsoleIO;
import ru.szhernovoy.control.GameRules;
import ru.szhernovoy.model.*;

/**
 * Created by szhernovoy on 16.08.2016.
 */
public class Game {

    private final GeneratorBoard generator;
    private final Board board;
    private final GameRules logic;
    private UserAction[] actors;
    private IO io;
    private boolean choice;


    public Game(final GameRules logic, final Board board, final GeneratorBoard generator, IO io) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
      //  this.actors = actors;
        this.io = io;
    }


    public void initGame() {
        final Cell[][] cells = generator.generate();
        this.board.drawScreenOnInit();
        this.choice = io.ask("Do you want do step first ? (y/n) ?",new String[]{"y","n"});
        this.board.drawBoard(cells);
    }

    public void work(){

        //choice right for 1st step

        do{

        }while(!this.logic.finish());

    }

    public void select(int x, int y, boolean bomb) {
     /*   this.logic.suggest(x, y, bomb);
        board.drawCell(x, y);
        if (this.logic.shouldBang(x, y)) {
            //this.board.drawBang();
        }
        if (this.logic.finish()) {
            board.congratulate();
        }*/
    }

    public static void main(String[] args) {

        GameRules logic = new GameRules();
        Board board = new Board();
        GeneratorBoard generator = new GeneratorBoard();


        Game base = new Game(logic,board,generator,new ConsoleIO());
        base.initGame();
}
}
