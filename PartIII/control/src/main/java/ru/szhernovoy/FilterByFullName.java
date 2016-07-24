package ru.szhernovoy;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by admin on 24.07.2016.
 */
public class FilterByFullName implements FilenameFilter {

    private String nameFull;


    @Override
    public boolean accept(File dir, String name) {
        return false;
    }
}
