package com.lightsoft.basicmvp.views.list.recycler;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class DataRecyclerAdapter<VH extends RecyclerView.ViewHolder, D> extends RecyclerView.Adapter<VH> {

    private ArrayList<D> data;

    public void setDataSet(List<D> contacts) {
        if (this.data != null) {
            this.data.clear();
            this.data = null;
        }
        if (contacts != null) {
            this.data = new ArrayList<>(contacts);
        }
        notifyDataSetChanged();
    }

    public D getItemAtPosition(int position) {
        if (data == null || data.size() <= position) return null;
        else return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
}
