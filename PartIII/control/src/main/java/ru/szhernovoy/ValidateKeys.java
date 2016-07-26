package ru.szhernovoy;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by admin on 24.07.2016.
 */
class ValidateKeys {

    private FilenameFilter[] action = new FilenameFilter[3];
    private String[] filterKey = new String[3];
    private ErrorMsg msg =new ErrorMsg();

    private String filter;
    private String[] keys;
    private String typeKey;
    //keys
    private final String DIR     = "-d";
    private final String NAME    = "-n";
    private final String MASK_M  = "-m";
    private final String MASK_F  = "-f";
    private final String MASK_R  = "-r";
    private final String LOG     = "-o";

    //message error

    public  boolean validate(){

        boolean result =  true;
        int count = 0;

        String[] messageErrorFull = new String[] {"not found directory key","not found name file","not found mask (fullname / regular) key","not found mask (fullname / regular) key","not found mask (fullname / regular) key", "not found log file key"};

        for(int index = 0;index < keys.length;index++){
            if(keys[index].equals(DIR)) {
                count++;
                this.msg.delete(DIR);
            }

            if(keys[index].equals(MASK_M)||keys[index].equals(MASK_F)||keys[index].equals(MASK_R)) {
                count++;
                this.msg.delete(MASK_M);
                this.msg.delete(MASK_F);
                this.msg.delete(MASK_R);
                this.typeKey = keys[index];
            }

            if(keys[index].equals(NAME)) {
                count++;
                this.msg.delete(NAME);
                this.filter = keys[index];
            }

            if(keys[index].equals(LOG)) {
                count++;
                this.msg.delete(LOG);
            }
        }

        msg.correctMessage(messageErrorFull);
        String error = msg.toString();
        result = error.length() > 5 ? false : true;

        if(result){
            this.fillAction();
        }
        else{
            System.out.println(error);
        }
        return result;
    }

    public void fillAction(){

        action[0] = this.new FindByName(filter);
        action[1] = this.new FindByMask(filter);
        action[2] = this.new FindByRegex(filter);
    }

    public ValidateKeys(String[] keys) {
        this.filterKey[0] = MASK_F;
        this.filterKey[1] = MASK_M;
        this.filterKey[2] = MASK_R;
        this.keys = keys;

        msg.add(DIR);
        msg.add(NAME);
        msg.add(MASK_M);
        msg.add(MASK_F);
        msg.add(MASK_R);
        msg.add(LOG);
    }

    public FilenameFilter getAction(){

        int position = 0;
        for(; position <filterKey.length; position++){
            if(this.filterKey[position].equals(this.typeKey)){
                break;
            }
        }
        return this.action[position];
    }

    private class FindByName implements FilenameFilter{

        private String filter;

        public FindByName(String name){
            this.filter = name;
        }

        @Override
        public boolean accept(File dir, String name) {
            return this.filter.equals(name);
        }
    }

    private class FindByMask implements FilenameFilter{

        private String filter;

        public FindByMask(String mask){
               this.filter = mask.substring(mask.length() - 3);
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(this.filter);
        }
    }

    private class FindByRegex implements FilenameFilter{

        private String filter;

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
