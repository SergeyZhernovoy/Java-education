package ru.szhernovoy.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by szhernovoy on 24.09.2016.
 */
public class Leaf<E> {

        private E value;
        private Leaf<E> next;
        private Leaf<E> prev;
        private final int COUNT_LEAF_ON_LEVEL = 4;
        private int countLeaf = 0;
        private final List<Leaf<E>> child = new ArrayList<Leaf<E>>(COUNT_LEAF_ON_LEVEL);


    public boolean setValue(E value) {
        this.value = value;
        return true;
    }

    public E getValue() {
        return value;
    }

    public List<Leaf<E>> getChildrenLeaf(){
        return this.child;
    }

    public int getCountLeaf(){
        return this.countLeaf;
    }

    /**
     * Method reccurcy add leaf in linked list of tree
     * @param next
     * @return
     */
    public boolean addNext(Leaf<E> next) {
        boolean result = false;
        if(possibleSetLeafOnLevel()){
           this.next = next;
           next.prev = this;
           this.child.add( next);
           this.countLeaf++;
           result = true;
        }
        else{
            Iterator<Leaf<E>> iterChild = this.child.iterator();
            while(iterChild.hasNext()){
                 Leaf<E> child = iterChild.next();
                 result = child.addNext(next);
                 if(result){
                    break;
                 }
            }
        }

        return result;
    }

    private boolean possibleSetLeafOnLevel(){
        return this.countLeaf <= (this.COUNT_LEAF_ON_LEVEL - 1);
    }

}
