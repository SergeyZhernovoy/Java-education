package ru.szhernovoy.generator;

import java.rmi.UnexpectedException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 18.08.2016.
 */
public class SimpleGenerator implements Template {

    private final String REGEX = "\\$\\{\\w+\\}";


    @Override
    public String generate(String template, Map<String, String> map) {
        StringBuffer builder = new StringBuffer(template);
        Matcher matcher = Pattern.compile(this.REGEX).matcher(template);
        while (matcher.find()) {
            String key = getCleanKey(matcher.group());
            if(map.containsKey(key)){
               builder.replace(matcher.start(),matcher.end(),map.get(key));

            }
         }
        return builder.toString();
    }

    public String getCleanKey(String key) {
        String result = key;
        try {
            result = result.substring(2, key.length() - 1);
        } catch (StringIndexOutOfBoundsException exc) {
            System.out.println("String index out");
        }

        return result;
    }

}