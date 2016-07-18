package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.io.StringReader;

import static org.hamcrest.core.Is.is;

/**
 * Created by admin on 18.07.2016.
 */
public class TestAddTwoNum {
    @Test
    public void WhenPutInFlowIntThanGetItFromFlow() throws IOException {
        AddTwoNum obj = new AddTwoNum();
        System.setIn(new StringBufferInputStream("1"));
        try {
            int result = obj.mainFlow(new InputStreamReader(System.in));
            int message = 1;
            Assert.assertThat(result,is(message));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
