package ru.szhernovoy.tree;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Sergey on 25.09.2016.
 */
public class BinaryTreeTest {
    @Test
    public void whenAddInBinaryTreeWeGetValueByKey() throws Exception {

        BinaryTree<Integer,String> phoneBook = new BinaryTree<>();
        Integer one = 1;
        String name1 = "Sergey";
        phoneBook.put(one,name1);
        phoneBook.put(2,"Nick");
        phoneBook.put(3,"Petr");
        phoneBook.put(4,"");
        phoneBook.put(14,"Rame");
        phoneBook.put(43,"Julia");
        phoneBook.put(5,"Dasha");
        phoneBook.put(32,"Lera");
        phoneBook.put(3,"Dima");
        phoneBook.put(6,"Sasha");

        String result = phoneBook.get(3);
        Assert.assertThat("Dima",is(result));


    }


}