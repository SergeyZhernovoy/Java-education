package ru.szhernovoy.generator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 18.08.2016.
 */
public class SimpleGenerator implements Template {

    /**value regex string for search */
    private static final String REGEX = "(\\$\\{)(\\w+)(\\})";
    private static Pattern pattern = Pattern.compile(REGEX);


    /**
     * Method return string with replacing keywords from array
     * @param template
     * @param map
     * @return
     */
    @Override
    public String generate(String template, Map<String, String> map) throws KeyException {

        StringBuffer builder = new StringBuffer();
        Matcher matcher = SimpleGenerator.pattern.matcher(template);
        int countKey =0;
        int mapSize = map.size();


        while (matcher.find()) {
            String key = getCleanKey(matcher.group());
            countKey++;
            if(map.containsKey(key)){
                matcher.appendReplacement(builder,map.get(key));
                countKey--;
                mapSize--;
            }
        }

        if(countKey > mapSize){
            throw new KeyException("Keywords in template are more ");
        }
        if(countKey < mapSize){
            throw  new KeyException("Don't find key");
        }

        return builder.toString();
    }

    /**
     * Method return key without special symbols
     * @param key
     * @return
     */
    public String getCleanKey(String key) {
        String result = key;
        result = result.substring(2, key.length() - 1);
        return result;
    }

}