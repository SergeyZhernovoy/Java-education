package ru.szhernovoy.findtext;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
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
        //
        Set<File> myList = new ConcurrentSkipListSet<>();
        FindText findText = new FindText(false,"explorer",myList);
        findText.startThread();

    }


}