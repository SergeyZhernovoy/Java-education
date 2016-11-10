package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.io.TicTacToeReccurcy;


import static org.hamcrest.core.Is.is;

/**
 * Created by szhernovoy on 06.10.2016.
 */
public class TicTacToeReccurcyTest {
    @Test
    public void hasWinner() throws Exception {
        int[][] board = new int[][]{
                {1,1,1},
                {1,1,0},
                {1,2,1}
        };
        boolean result;
        TicTacToeReccurcy test = new TicTacToeReccurcy(board);
        result = test.hasWinner();

        Assert.assertThat(true,is(result));
    }

}