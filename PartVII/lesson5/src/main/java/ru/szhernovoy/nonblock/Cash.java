package ru.szhernovoy.nonblock;

import com.sun.javafx.sg.prism.NGShape;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by szhernovoy on 27.10.2016.
 */
public class Cash<E extends Model> {

    private Map<Integer,E> cash = new ConcurrentHashMap<>();

    public void add(E e){

        this.cash.put(e.getId(),e);

    }

    public void delete(E e){
        this.cash.remove(e.getId());

    }

    public void update(E e) {

        synchronized (this.cash) {
            E oldObject = this.cash.get(e.getId());

            if (oldObject.getVersion() == e.getVersion()) {
                e.increment();
                this.add(e);
            } else {
                throw new OptimisticException("version is uncorrect");
            }
        }
    }


}
