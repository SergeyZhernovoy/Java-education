package ru.szhernovoy;

import java.util.Arrays;

/**
 * Created by szhernovoy on 26.07.2016.
 */
public class ErrorMsg {
    private String[] msg = new String[6];
    private int position =0;

    public int add(String msg){
        if(this.position != msg.length()) {
            this.msg[position++] = msg;
        }
        return position;
    }

    public int delete(String key){
        int index = 0;
        for (; index < this.msg.length; index++){
            if(this.msg[index] != null && this.msg[index].equals(key)){
                this.msg[index] = null;
                break;
            }
        }
        return index;

    }

    public int correctMessage(String[] correct){
        int index = 0;
        for (; index < this.msg.length; index++){
             if(this.msg[index] != null ){
                 this.msg[index] = String.format("\n%s %s",this.msg[index],correct[index]);
                 break;
             }
        }
        return index;

    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        for (String message : this.msg){
            if(message != null) {
                builder.append(message);
            }
        }
        return builder.toString();
    }
}
