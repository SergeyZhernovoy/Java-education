package ru.szhernovoy.convert;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Sergey on 07.09.2016.
 */
public class ConvertIterator implements  Converter<Integer> {
    @Override
    public Iterator<Integer> convert(final Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Iterator<Integer>> bigBox = it;
            private Iterator<Integer> box = null;

            @Override
            public boolean hasNext() {

                boolean result = false;
                if(bigBox.hasNext() || (box != null && box.hasNext())){
                   result = true;
                }

                return result;
            }

            @Override
            public Integer next() {

                Integer result;
                if((box == null || !box.hasNext()) && bigBox.hasNext() ){
                   box = bigBox.next();
                }

                if(box.hasNext()){
                   result = box.next();
                }
                else{
                    throw new NoSuchElementException();
                }

            return result;

            }

            @Override
            public void remove() {

            }
        };
    }
}
