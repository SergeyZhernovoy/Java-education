package ru.szhernovoy.view;

import ru.szhernovoy.control.GameRules;
import ru.szhernovoy.model.*;

/**
 * Created by szhernovoy on 16.08.2016.
 */
public class Game {

    private final GeneratorBoard generator;
    private final Board board;
    private final Logic logic;
    private UserAction[] actors;

    public Game(final Logic logic, final Board board, final GeneratorBoard generator, UserAction[] actors) {
        this.generator = generator;
        this.board = board;
        this.logic = logic;
        this.actors = actors;
    }


    public void initGame() {
        final Cell[][] cells = generator.generate();
        this.board.drawBoard(cells);
       // this.logic.loadBoard(cells);
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

        Logic logic = new GameRules();
        Board board = new Board();
        GeneratorBoard generator = new GeneratorBoard();

        Game base = new Game(logic,board,generator);
        base.initGame();
    }
}
