package com.imagine.world.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by tuan on 10/19/14.
 */
public class SearchableList<E> extends ArrayList {
    public int indexOf(E o,Comparator<E> comparator) {
        Collections.sort(this,comparator);
        return Collections.binarySearch(this, o, comparator);
    }

    public static <E> SearchableList<E> newSearchableList(E[] listE){
        SearchableList<E> searchableList = new SearchableList();
        searchableList.addAll(Arrays.asList(listE));
        return searchableList;
    }

    @Override
    public E get(int index) {
        return (E) super.get(index);
    }

    public E get(E o, Comparator<E> comparator){
        return this.get(this.indexOf(o,comparator));
    }
}
