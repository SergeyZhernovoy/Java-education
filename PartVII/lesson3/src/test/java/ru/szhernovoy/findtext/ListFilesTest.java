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
public class ListFilesTest {
    @Test
    public void whenStartThreadThatGetAnySizeListFile() throws Exception {

        Set<File> myList = new ConcurrentSkipListSet<>();
        ListFiles anyFiles = new ListFiles(myList);
        anyFiles.startThread();
        Thread.sleep(1000);
        anyFiles.interruptAll();
        int sizeList = myList.size();
        Assert.assertThat(sizeList > 100, is(true));
    }

}