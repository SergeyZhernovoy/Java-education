package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;

import static org.hamcrest.core.Is.is;

/**
 * Created by szhernovoy on 22.07.2016.
 */
public class TestChatConsole {
    @Test
    public void InputMessageShouldGetAnswer()  {
        MockIO io = new MockIO(new String[] {"hello","how are you ?", "стоп","продолжить","закончить"});
        ChatConsole cht = new ChatConsole(io);
        cht.init();
        cht.work();
        Assert.assertThat(io.getOut().split("\n")[0],is("Welcome to chat..."));
    }
}
