package ru.szhernovoy.cache;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Sergey on 05.10.2016.
 */
public class CacheReaderTest {
    @Test
    public void whenAddDataToCacheWeGetItFromCachePossible() throws Exception {

        CacheReader cache = new CacheReader("d:\\Test");
        String textFile = cache.get("Adress.txt");
        Assert.assertThat(textFile,is("Пенза\nМосква\nПитер\n"));

    }



}