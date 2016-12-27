package ru.szhernovoy.repository;

import java.util.Collection;

/**
 * Created by szhernovoy on 26.12.2016.
 */

public interface RepositoryInterface<T,E> {

        public E getModelWithRef();
        public void createModelWithRef();
        public Collection<E> getAllModelByRef(T t);

}
