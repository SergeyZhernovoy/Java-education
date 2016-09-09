package ru.szhernovoy.store;

import ru.szhernovoy.generic.SimpleArray;

import java.util.NoSuchElementException;

/**
 * Created by Sergey on 08.09.2016.
 */
public class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> sa;


    public AbstractStore(int size) {
        this.sa = new SimpleArray<T>(size);
     }

    public AbstractStore(SimpleArray<T> value) {
        this.sa = value;
    }

    private int findById(String id){
        int result = -1;
        for(int index =0 ;index < this.sa.getSize(); index++ ){
            if(this.sa.get(index).getId().equals(id)){
                result = index;
                break;
            }
        }

        if(result!= -1){
            return result;
        }
        else{
            throw new NoSuchElementException("Not element in array");
        }
    }

    @Override
    public boolean update(T t) {
        boolean result = false;

        int index = this.findById(t.getId());
        if(index > -1){
            this.sa.update(t, index);
            result = true;
        }
        return result;
    }

    @Override
    public boolean add(T t) {
        this.sa.add(t);
        return true;
    }

    @Override
    public boolean delete(String id) {

        boolean result = false;

        int index = this.findById(id);
        if(index > -1){
            this.sa.delete(index);
            result = true;
        }
        return result;
    }

    @Override
    public T get(String id) {
        int index = this.findById(id);
        return this.sa.get(index);
    }


}
