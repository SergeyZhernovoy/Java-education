package ru.szhernovoy.generic;

/**
 * Created by admin on 07.09.2016.
 */
public class SimpleArray <T> {

    private Object[] obj;
    private int position = 0;

    public SimpleArray(int size) {
        this.obj = new Object[size];
    }

    public SimpleArray(T[] value) {
        this.obj = value;
        this.position = value.length;
    }

    public void add(T value){
        this.obj[position++] = value;
     }

    public T get(int index){
        return (T) this.obj[index];
    }

    public void update(T value, int index){

        if(index <= position){
            this.obj[index] = value;
        }
    }

    public void delete(int index){
        this.position--;
        for(int current = index; current < this.obj.length;current++){
            if((current +1)  < this.obj.length){
                this.obj[current] = this.obj[current+1];
            }
            else{
                this.obj[current] = null;
            }

        }
    }

    public int getSize(){
        return this.obj.length;
    }

}
