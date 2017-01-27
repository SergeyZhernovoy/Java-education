package ru.szhernovoy.storages;/**
 * Created by szhernovoy on 27.01.2017.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportUser {

    private final Crud storage;

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportUser.class);

    @Autowired
    private ImportUser(Crud storage){
        this.storage = storage;
    }




}
