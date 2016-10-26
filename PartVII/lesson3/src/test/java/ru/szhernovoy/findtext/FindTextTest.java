package ru.szhernovoy.findtext;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 23.10.2016.
 */
public class FindTextTest {
    @Test
    public void whenRunThreadFromFindFileThatGetItToScreen() throws Exception {

        FindText findText = new FindText(true,"explorer");
        try {
            findText.startThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> resultSearch;
        String result = "";
        while (result.isEmpty()){
             resultSearch = findText.getResult();
             if(resultSearch.size() > 0){
             result = resultSearch.get(0);
             }
        }

        System.out.println(result);
        Assert.assertThat(result.isEmpty(),is(false));

    }

}


