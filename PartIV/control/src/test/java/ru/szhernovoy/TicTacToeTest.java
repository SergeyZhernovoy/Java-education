package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.view.*;

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



}
