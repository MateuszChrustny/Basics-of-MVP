package com.lightsoft.basicmvp.views.list.recycler;

import android.support.v7.widget.RecyclerView;

import com.lightsoft.basicmvp.creators.ObjectsListCreator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RecyclerListViewTest {

    @Mock
    RecyclerView recyclerView;
    @Mock
    DataRecyclerAdapter<?, Object> dataRecyclerAdapter;
    @Mock
    RecyclerView.LayoutManager layoutManager;

    private RecyclerListView<Object> recyclerListView;

    @Before
    public void setUp() throws Exception {
        recyclerListView = new RecyclerListView<>(recyclerView, dataRecyclerAdapter, layoutManager);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenRecyclerViewIsNull() throws Exception {
        recyclerListView = new RecyclerListView<>(null, dataRecyclerAdapter, layoutManager);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenRecyclerAdapterIsNull() throws Exception {
        recyclerListView = new RecyclerListView<>(recyclerView, null, layoutManager);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenLayoutManagerIsNull() throws Exception {
        recyclerListView = new RecyclerListView<>(recyclerView, dataRecyclerAdapter, null);
    }

    @Test
    public void shouldSetLayoutManagerForRecyclerView() throws Exception {
        verify(recyclerView).setLayoutManager(layoutManager);
    }

    @Test
    public void shouldSetAdapterForRecyclerView() throws Exception {
        verify(recyclerView).setAdapter(dataRecyclerAdapter);
    }

    @Test
    public void shouldSetShowingDataIntoAdapter() throws Exception {
        List<Object> objects = new ObjectsListCreator(10).createList();
        recyclerListView.showData(objects);
        verify(dataRecyclerAdapter).setDataSet(objects);
    }
}