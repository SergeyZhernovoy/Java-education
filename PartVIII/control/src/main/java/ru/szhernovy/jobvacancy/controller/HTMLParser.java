package ru.szhernovy.jobvacancy.controller;/**
 * Created by szhernovoy on 14.11.2016.
 */

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import ru.szhernovy.jobvacancy.model.Vacancy;

import java.util.Set;


public class HTMLParser {
    private final String REGEX = "\\[0-9]";
    private final Set<Vacancy> storage;
    private static Logger log = LoggerFactory.getLogger(HTMLParser.class);

    public HTMLParser(Set<Vacancy> storage) {
        this.storage = storage;
    }
}
