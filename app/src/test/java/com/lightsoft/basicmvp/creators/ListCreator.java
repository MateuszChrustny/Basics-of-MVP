package com.lightsoft.basicmvp.creators;

import java.util.ArrayList;
import java.util.List;

abstract class ListCreator<T> {
    protected int size;

    ListCreator(int size) {
        this.size = size;
    }

    public List<T> createList() {
        List<T> objects = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            objects.add(createObject(i));
        }
        return objects;
    }

    abstract T createObject(int position);
}
