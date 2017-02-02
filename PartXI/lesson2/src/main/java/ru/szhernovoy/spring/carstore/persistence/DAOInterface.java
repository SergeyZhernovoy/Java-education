package ru.szhernovoy.spring.carstore.persistence;

import java.util.Collection;

/**
 * Created by admin on 10.01.2017.
 * @param <T> .
 */
public interface DAOInterface<T> {
    /**
     * Created by admin on 10.01.2017.
     * @param t .
     * @return T
     */
    T create(T t);

    /**
     * Created by admin on 10.01.2017.
     * @param t .
     * @return T
     */
    T  update(T t);

    /**
     * Created by admin on 10.01.2017.
     * @param t .
     * @return boolean
     */
    boolean delete(T t);

    /**
     * Created by admin on 10.01.2017.
     * @param id .
     * @return Collection<T>
     */
    Collection<T> get(int id);

    /**
     * Created by admin on 10.01.2017.
     * @return Collection<T>
     */
    Collection<T> get();
}
