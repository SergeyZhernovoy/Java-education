package ru.szhernovoy;

import java.io.FilenameFilter;


/**
 * Created by admin on 24.07.2016.
 */
class ValidateKeys {

    private ErrorMsg msg =new ErrorMsg();
    private SearchMethod method;

    //parametrs from keys
    private String filter;
    private String[] keys;
    private String typeKey;
    private String directoryName;

    //keys
    private final String DIR     = "-d";
    private final String NAME    = "-n";
    private final String MASK_M  = "-m";
    private final String MASK_F  = "-f";
    private final String MASK_R  = "-r";
    private final String LOG     = "-o";

    public ValidateKeys(String[] keys) {
        this.keys = keys;
        //all error add
        this.msg.add(DIR);
        this.msg.add(NAME);
        this.msg.add(MASK_M);
        this.msg.add(MASK_F);
        this.msg.add(MASK_R);
        this.msg.add(LOG);
    }


    public  boolean validate(){

        boolean result =  true;
        String[] messageErrorFull = new String[]
                {
                 "not found directory key",
                 "not found name file",
                 "not found mask (fullname / regular) key",
                 "not found mask (fullname / regular) key",
                 "not found mask (fullname / regular) key",
                 "not found log file key"
                };

        for(int index = 0;index < keys.length;index++){
            if(keys[index].equals(DIR)) {
                this.msg.delete(DIR);
                this.directoryName = keys[index+1];
            }

            if(keys[index].equals(MASK_M)||keys[index].equals(MASK_F)||keys[index].equals(MASK_R)) {
                this.msg.delete(MASK_M);
                this.msg.delete(MASK_F);
                this.msg.delete(MASK_R);
                this.typeKey = keys[index];
            }

            if(keys[index].equals(NAME)) {
                this.msg.delete(NAME);
                this.filter = keys[index+1];
            }

            if(keys[index].equals(LOG)) {
                this.msg.delete(LOG);
            }
        }

        msg.correctMessage(messageErrorFull);
        String error = msg.toString();
        result = error.length() <= 3;

        if(result){
           method = new SearchMethod(filter);
           method.init();
        }
        else{
           System.out.println(new StringBuilder()
                    .append("\nUse: find [-d <directory>] [-n <filename or mask or regular>] [-m/-f/-r] [-o <log file name>]\n")
                    .append(error));
        }
        return result;
    }

    public String getDirectory(){
        return this.directoryName;
    }

    public FilenameFilter getAction(){
         return method.getAction(this.typeKey);
    }

}
