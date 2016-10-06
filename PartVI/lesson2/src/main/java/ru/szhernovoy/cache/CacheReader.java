package ru.szhernovoy.cache;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey on 05.10.2016.
 */
public class CacheReader {

    /**Main storage for cache */
    private Map<String,SoftReference<String>> cache;

    private final String PATH;

    public CacheReader(Map<String,SoftReference<String>> mapCache, final String path){
        this.cache = mapCache;
        this.PATH = path;
    }

    public CacheReader(final String path){
        this.cache = new HashMap<>();
        this.PATH = path;
    }

    /**
     * Method do auto unboxing value from cache
     * @return
     */
    public String get(String key){

        String text = null;
        if(this.cache.containsKey(key)){
            text = this.cache.get(key).get();
            if(text == null){
               addValueInCache(key);
            }
        }
        else{
            addValueInCache(key);
            text = this.cache.get(key).get();
        }

        return text;

    }

    /**
     * Add text from file into cache
     * @param fileName
     * @return
     */
    public boolean addValueInCache(String fileName){
        String fullName  = String.format("%s%s%s",this.PATH, File.separator,fileName);
        File file = new File(fullName);
        StringBuilder text = new StringBuilder();
        if(file.exists() && file.canRead() && file.isFile()){
            try(BufferedReader in = new BufferedReader(new FileReader(fullName))){
                String next = null;
                while((next = in.readLine()) != null){
                      text.append(String.format("%s\n",next));
                 }

                 this.cache.put(fileName,new SoftReference<String>(text.toString()));

            } catch (FileNotFoundException e) {
                System.out.println("File not exist");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

}
