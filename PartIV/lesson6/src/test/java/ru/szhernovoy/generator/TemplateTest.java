package ru.szhernovoy.generator;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;


/**
 * Created by admin on 18.08.2016.
 */
public class TemplateTest {
    @Test
    public void replaceInTemplatePartWeShouldGetRightString(){
        String template = "Hello, ${name}, How are you ${subject}";
        Template templ = new SimpleGenerator();
        Map<String,String> map = new HashMap<>();
        map.put("name","Sergey");
        map.put("subject","my friend");
        String result = templ.generate(template, map);
        String check = "Hello, Sergey, How are you my friend";
        System.out.println(result);
        Assert.assertThat(check,is(result));
    }

    @Test
    public void replaceInTemplatePartWhenNoKeys(){
        String template = "Hello, ${name}, How are you ${subject}";
        Template templ = new SimpleGenerator();
        Map<String,String> map = new HashMap<>();
        map.put("subject","my friend");
        String result = templ.generate(template, map);
        String check = "Hello, ${name}, How are you my friend";
       // Assert.assertThat(check,is(result));
    }

    @Test
    public void replaceInTemplatePartWhenKeysAreMore(){
        String template = "Hello, ${name}, How are you ${subject}";
        Template templ = new SimpleGenerator();
        Map<String,String> map = new HashMap<>();
        map.put("name","Sergey");
        map.put("subject","my friend");
        String result = templ.generate(template, map);
        String check = "Hello, Sergey, How are you my friend";
      //  Assert.assertThat(check,is(result));
    }
}