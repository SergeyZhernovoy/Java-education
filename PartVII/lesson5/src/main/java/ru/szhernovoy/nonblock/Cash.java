package ru.szhernovoy.nonblock;

import com.sun.javafx.sg.prism.NGShape;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

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

    public void update(E newModel) throws OptimisticException {
        this.cash.computeIfPresent(newModel.getId(), new BiFunction<Integer, E, E>() {
            @Override
            public E apply(Integer integer, E oldModel) {
                if (oldModel.getVersion() == newModel.getVersion()) {
                    newModel.increment();
                    return newModel;
                } else {
                    throw new OptimisticException("version is uncorrect");
                }
            }
        });
    }

}
