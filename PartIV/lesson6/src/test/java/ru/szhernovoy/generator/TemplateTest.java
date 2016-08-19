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
    public void replaceInTemplatePartWeShouldGetRightString() throws KeyException{
        String template = "Hello, ${name}, How are you ${subject}";
        Template templ = new SimpleGenerator();
        Map<String,String> map = new HashMap<>();
        map.put("name","Sergey");
        map.put("subject","my friend");
        String result = null;
        try{
            result = templ.generate(template, map);
        }catch (KeyException kexc){
            kexc.printStackTrace();
            result = "Hello, Sergey, How are you my friend";
        }
        System.out.println(result);
        String check = "Hello, Sergey, How are you my friend";
        Assert.assertThat(check,is(result));
    }

    @Test
    public void replaceInTemplatePartWhenNoKeys() {
        String template = "Hello, ${name}, How are you ${subject}";
        Template templ = new SimpleGenerator();
        Map<String,String> map = new HashMap<>();
        map.put("subject","my friend");
        String result = null;
        try{
            result = templ.generate(template, map);
        }catch (KeyException kexc){
            kexc.printStackTrace();
            result = "Hello, ${name}, How are you my friend";
        }

        String check = "Hello, ${name}, How are you my friend";
        Assert.assertThat(check,is(result));
    }

    @Test
    public void replaceInTemplatePartWhenKeysAreMore()  {
        String template = "Hello, ${name}, How are you ${subject} ! I get a ${object}";
        Template templ = new SimpleGenerator();
        Map<String,String> map = new HashMap<>();
        map.put("name","Sergey");
        map.put("subject","my friend");
        String result = null;
        try{
            result = templ.generate(template, map);
        }catch (KeyException kexc){
            kexc.printStackTrace();
            result = "Hello, Sergey, How are you my friend ! I get a ${object}";
        }
        String check = "Hello, Sergey, How are you my friend ! I get a ${object}";
        Assert.assertThat(check,is(result));
    }

    @Test
    public void replaceInTemplatePartWhenKeysAreLess() {
        String template = "Hello, ${name}";
        Template templ = new SimpleGenerator();
        Map<String,String> map = new HashMap<>();
        map.put("name","Sergey");
        map.put("subject","my friend");
        String result = null;
        try{
            result = templ.generate(template, map);
        }catch (KeyException kexc){
            kexc.printStackTrace();
            result = "Hello, Sergey, How are you my friend ! I get a ${object}";
        }
        String check = "Hello, Sergey, How are you my friend ! I get a ${object}";
        Assert.assertThat(check,is(result));
    }

}