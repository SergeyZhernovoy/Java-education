package ru.szhernovoy.jpa.carstore.persistance;


import org.springframework.data.repository.CrudRepository;
import ru.szhernovoy.jpa.carstore.domain.Body;

import java.util.List;

/**
 * Created by Admin on 05.02.2017.
 */

public interface BodyCrud extends CrudRepository<Body,Integer> {
        List<Body> findByAll();
        Body findById(int id);
}
