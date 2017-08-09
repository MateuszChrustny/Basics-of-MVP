package com.lightsoft.basicmvp;

public interface DataProvider<T> {
    void loadData(DataCallback<T> dataCallback);

    interface DataCallback<T> {
        void onDataLoaded(T data);
    }
}
