package ru.szhernovoy.generator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 18.08.2016.
 */
public class SimpleGenerator implements Template {

    /**value regex string for search */
    private final String REGEX = "\\$\\{\\w+\\}";


    /**
     * Method return string with replacing keywords from array
     * @param template
     * @param map
     * @return
     */
    @Override
    public String generate(String template, Map<String, String> map) {

        StringBuilder resultBuilder = new StringBuilder();
        Matcher matcher = Pattern.compile(this.REGEX).matcher(template);
        int start = 0;
        while (matcher.find()) {
            resultBuilder.append(template.substring(start,matcher.start()));
            start = matcher.end();
            String key = getCleanKey(matcher.group());
            if(map.containsKey(key)){
                resultBuilder.append(map.get(key));
            }
            else{
                resultBuilder.append(matcher.group());
            }

        }
        return resultBuilder.toString();
    }

    /**
     * Method return key without special symbols
     * @param key
     * @return
     */
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