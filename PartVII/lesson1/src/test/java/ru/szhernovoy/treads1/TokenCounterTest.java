package ru.szhernovoy.treads1;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * Created by admin on 08.10.2016.
 */
public class TokenCounterTest {

    @Test
    public void whenTokenCountOnlyDelimetrThanValueSpaceWeCanGet() throws Exception {
        String simpleText = "Это текст для проверки";
        TokenCounter tokenCounter = new TokenCounter(true,simpleText);
        tokenCounter.run();
        int result = tokenCounter.getCount();
        Assert.assertThat(result,is(3));
    }

    @Test
    public void whenTokenCountWordThanValueWordWeCanGet() throws Exception {
        String simpleText = "Это текст для проверки";
        TokenCounter tokenCounter = new TokenCounter(false,simpleText);
        tokenCounter.run();
        int result = tokenCounter.getCount();
        Assert.assertThat(result,is(4));
    }


}