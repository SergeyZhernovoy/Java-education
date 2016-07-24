package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.szhernovoy.client.ChatClient;
import ru.szhernovoy.server.ChatServer;

import java.io.IOException;

import static org.hamcrest.core.Is.is;

/**
 * Created by szhernovoy on 22.07.2016.
 */
public class ChatConsoleTest {
    @Test
    public void InputMessageShouldGetAnswer()  {
        MockIO io = new MockIO(new String[] {"hello","how are you ?", "стоп","продолжить","закончить"});
        ChatClient client = new ChatClient(io);
        client.init();
        client.work();
        //System.out.println(io.getOut().split("\n")[0]);
        Assert.assertThat(io.getOut().split("\n")[0],is("A caelo usque ad centrum — «от небес до центра [Земли]»"));
    }
    @Before
    public void CreateServer()  {
        ChatServer server = null;
        try {
            server = new ChatServer();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        server.init();
        server.work();
    }
}
