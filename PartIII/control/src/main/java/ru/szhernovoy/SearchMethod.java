package ru.szhernovoy;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sergey on 29.07.2016.
 */
public class SearchMethod {

    private final int COUNT_METHODS = 3;
    private Search[] action = new Search[COUNT_METHODS];
    private String mask;


    public SearchMethod(String mask){
        this.mask = mask;
    }

    public FilenameFilter getAction(String typeMethod){

        int position = 0;
        for(; position <action.length; position++){
            if(this.action[position].key().equals(typeMethod)){
                break;
            }
        }
        return this.action[position];
    }

    public void init(){

        this.action[0] = this.new FindByName(this.mask);
        this.action[1] = this.new FindByMask(this.mask);
        this.action[2] = this.new FindByRegex(this.mask);
    }


    private class FindByName implements Search{

        private String filter;

        public String key(){
            return "-f";
        }

        public FindByName(String name){
            this.filter = name;
        }

        @Override
        public boolean accept(File dir, String name) {
            return this.filter.equals(name);
        }
    }

    private class FindByMask implements Search{

        private String filter;

        public String key(){
            return "-m";
        }

        public FindByMask(String mask){
            this.filter = mask.substring(mask.length() - 3);
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(this.filter);
        }
    }

    private class FindByRegex implements Search{

        private String filter;

        public String key(){
            return "-r";
        }

        public FindByRegex(String regex){
            this.filter = regex;
        }

        @Override
        public boolean accept(File dir, String name) {

            Matcher m = Pattern.compile(filter).matcher(name);
            return m.find();
        }
    }



}
