package ru.szhernovoy.repositories;


import org.springframework.data.repository.CrudRepository;
import ru.szhernovoy.domain.Body;

/**
 * Created by Admin on 05.02.2017.
 */
public interface BodyCrud extends CrudRepository<Body,Integer> {

}
