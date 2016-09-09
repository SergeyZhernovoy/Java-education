package ru.szhernovoy.store;

/**
 * Created by admin on 07.09.2016.
 */
public interface Store <T extends Base> {

    boolean update(T t);

    boolean add(T t);

    boolean delete(String id);

    T get(String id) ;

}
