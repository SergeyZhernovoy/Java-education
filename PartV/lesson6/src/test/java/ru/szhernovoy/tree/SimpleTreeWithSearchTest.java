package ru.szhernovoy.tree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by admin on 24.09.2016.
 */
public class SimpleTreeWithSearchTest {
    @Test
    public void whenSearchValueInTreeWeShouldGetIt() throws Exception {

        SimpleTreeWithSearch<Integer> simple = new SimpleTreeWithSearch<>();
        simple.addChild(new Leaf<Integer>(),1);
        simple.addChild(new Leaf<Integer>(),2);
        simple.addChild(new Leaf<Integer>(),3);
        simple.addChild(new Leaf<Integer>(),4);

        Leaf<Integer> result = simple.searchByValue(3);

        assertThat(result.getValue(),is(3));

    }

    @Test
    public void whenWeAddMuchLeafIntoSimpleTreeThatItShouldBeUnbalance(){
        SimpleTreeWithSearch<Integer> simple = new SimpleTreeWithSearch<>();
        simple.addChild(new Leaf<Integer>(),1);
        simple.addChild(new Leaf<Integer>(),2);
        simple.addChild(new Leaf<Integer>(),3);
        simple.addChild(new Leaf<Integer>(),4);
        simple.addChild(new Leaf<Integer>(),5);
        simple.addChild(new Leaf<Integer>(),6);
        simple.addChild(new Leaf<Integer>(),7);
        simple.addChild(new Leaf<Integer>(),8);
        simple.addChild(new Leaf<Integer>(),9);
        simple.addChild(new Leaf<Integer>(),10);
        simple.addChild(new Leaf<Integer>(),11);
        simple.addChild(new Leaf<Integer>(),12);
        simple.addChild(new Leaf<Integer>(),13);

        boolean result = simple.isBalance();

        assertThat(result,is(false));
    }



}