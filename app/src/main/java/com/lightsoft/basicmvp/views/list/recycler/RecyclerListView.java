package com.lightsoft.basicmvp.views.list.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class RecyclerListView<D> implements DataListView<D> {
    @NonNull
    private RecyclerView recyclerView;

    @NonNull
    private DataRecyclerAdapter<?, D> recyclerAdapter;

    public RecyclerListView(RecyclerView recyclerView, DataRecyclerAdapter<?, D> recyclerAdapter, RecyclerView.LayoutManager layoutManager) {
        if (recyclerView == null || recyclerAdapter == null || layoutManager == null)
            throw new IllegalArgumentException("Any argument cannot be null");
        this.recyclerView = recyclerView;
        this.recyclerAdapter = recyclerAdapter;
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(this.recyclerAdapter);
    }

    @Override
    public void showData(List<D> data) {
        recyclerAdapter.setDataSet(data);
    }
}
