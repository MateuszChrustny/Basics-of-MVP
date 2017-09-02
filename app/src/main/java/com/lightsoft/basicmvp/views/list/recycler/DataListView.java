package com.lightsoft.basicmvp.views.list.recycler;

import java.util.List;

/**
 * Created by Mateusz on 18.08.2017.
 */

public interface DataListView<D> {
    void showData(List<D> data);
}
