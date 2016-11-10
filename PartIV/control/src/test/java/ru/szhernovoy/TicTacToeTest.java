package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.control.Logic;
import ru.szhernovoy.io.*;

import static org.hamcrest.core.Is.is;

/**
 * Created by szhernovoy on 16.08.2016.
 */
public class TicTacToeTest {
    @Test
    public void whenSetSizeBoardThenFabricaGenerateIt(){

        int control = 5;
        Cell[][] cells = new GeneratorBoard(control).generate();
        Assert.assertThat(control,is(cells.length));

    }

    @Test
    public void whenSetXOnRowThatXisWinner(){

        Cell[][] cells = new GeneratorBoard().generate();
        cells[0][0].setIconX(true);
        cells[0][1].setIconX(true);
        cells[0][2].setIconX(true);

        Logic logic = new Logic();
        logic.loadBoard(cells);
        int result = logic.isWinner();
        int winner = 0;
        Assert.assertThat(winner,is(result));

    }



}
