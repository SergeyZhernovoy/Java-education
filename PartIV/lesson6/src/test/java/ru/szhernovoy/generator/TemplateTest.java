package ru.szhernovoy.generator;

import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.core.Is.is;


/**
 * Created by admin on 18.08.2016.
 */
public class TemplateTest {
    @Test
    public void replaceInTemplatePartWeShouldGetRightString(){
        String template = "Hello, ${name}";
        Template templ = new SimpleGenerator(new String[]{"${name}"});
        String result = templ.generate(template, new String[]{"Sergey"});
        String check = "Hello, Sergey";
        System.out.println(result);
       // Assert.assertThat(check,is(result));
    }

}