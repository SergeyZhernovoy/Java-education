package ru.szhernovoy.tree;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by szhernovoy on 24.09.2016.
 */
public class SimpleTreeTest {
    @Test
    public void whenAddHandInTreeThatWeCanGetItInList() throws Exception {

        SimpleTree<Integer> simple = new SimpleTree<>();
        simple.addChild(new Leaf<Integer>(),1);
        simple.addChild(new Leaf<Integer>(),2);
        simple.addChild(new Leaf<Integer>(),3);
        simple.addChild(new Leaf<Integer>(),4);

        String control =   "1234";

        List<Integer> test  = simple.getChildren();
        String result = "";
        for (int index = 0;index < 4; index++){
             result = String.format("%s%s",result,String.valueOf(test.get(index)));
        }

          assertThat(result,is(control));

    }

    @Test
    public void whenAddAutoInTreeWeShouldGetArraySizeByCountItemInTree() throws Exception {

        SimpleTree<Integer> simple = new SimpleTree<>();
        for(int index = 0;index < 10000; index++){
            simple.addChild(new Leaf<Integer>(),index);
        }
        int control = 10000;
        int result = simple.getChildren().size();
        assertThat(result,is(control));
    }

}