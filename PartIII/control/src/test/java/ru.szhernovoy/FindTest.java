package ru.szhernovoy;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;

/**
 * Created by Sergey on 27.07.2016.
 */
public class FindTest {
    @Test
    public void WhenFindFilesByMaskThatFindIt() throws IOException {
        String[] args = new String[]{"-d","d:\\public","-n", "*.txt", "-m", "-o", "log.txt"};
        //System.out.println(System.getProperty("user.home"));
        Find find = new Find(args);
        find.work();
        BufferedReader fileReader =  new BufferedReader(new FileReader(String.format("%s%slog.txt",System.getProperty("user.home"), File.separator)));
        StringBuilder builder = new StringBuilder();
        String input;
        int numberLine = 0;
        while((input = fileReader.readLine())!= null || numberLine++ < 10){
            builder.append(input);
        }
        String result = builder.toString();
        //System.out.println(result);
        Assert.assertThat(false,is(result.isEmpty()));

    }
}
