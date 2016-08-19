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

        StringBuffer builder = new StringBuffer(template);
        Matcher matcher = SimpleGenerator.pattern.matcher(template);
        int countKey = 0;

        while (matcher.find()) {
            String key = getCleanKey(matcher.group());
            if(map.containsKey(key)){
                matcher.appendReplacement(builder,map.get(key));
                countKey++;
            }
            else{
                throw  new KeyException(String.format("Don't find key  - %s",key));
            }
        }

        if(countKey != map.size()){
            throw new KeyException(String.format("Keywords %d in template are more  - %d",countKey,map.size()));
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