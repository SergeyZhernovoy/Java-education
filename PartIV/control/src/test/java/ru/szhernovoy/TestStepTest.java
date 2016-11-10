package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;
import ru.szhernovoy.io.TestStep;

import static org.hamcrest.core.Is.is;

/**
 * Created by Sergey on 09.09.2016.
 */
public class TestStepTest {
    @Test
    public void getLuckyStep() throws Exception {

        int[][] board = new int[][]{
                {1,1,0},
                {0,0,0},
                {0,2,1}
        };
        int[] xy = new int[]{0,2};
        TestStep test = new TestStep(board);
        int[] xyTest = test.getLuckyStep(1);
        Assert.assertThat(true,is((xyTest[0] == xy[0]) && (xyTest[1] == xy[1])));
    }

}