package ru.szhernovoy.generator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 18.08.2016.
 */
public class SimpleGenerator implements Template {

    private String[] regex;
    private Matcher matcher;

    public SimpleGenerator(String[] regex){
        this.regex = regex;
    }

    @Override
    public String generate(String template, Object[] value) {

        String result = template;
        int position = 0;
        for(int index = 0 ; index < this.regex.length; index++){
            if(template.contains(this.regex[index])){
                for(;position < value.length;position++){
                    result = result.replaceAll(this.regex[index],value[position].toString());
                }
            }

           /* this.matcher = Pattern.compile(this.regex[index]).matcher(template);
            if(this.matcher.find()){
               for(;position < value.length;position++){
                   result = result.replaceAll(this.regex[index],value[position].toString());
               }
            }*/
        }
       return result;
    }
}
