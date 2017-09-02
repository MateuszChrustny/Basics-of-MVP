package com.lightsoft.basicmvp.creators;

public class ObjectsListCreator extends ListCreator<Object> {

    public ObjectsListCreator(int size) {
        super(size);
    }

    @Override
    public Object createObject(int position) {
        return new Object();
    }
}
