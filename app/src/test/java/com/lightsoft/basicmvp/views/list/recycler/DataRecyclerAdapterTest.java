package com.lightsoft.basicmvp.views.list.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.lightsoft.basicmvp.BuildConfig;
import com.lightsoft.basicmvp.creators.ObjectsListCreator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class DataRecyclerAdapterTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Spy
    DataRecyclerAdapter<RecyclerView.ViewHolder, Object> adapter = new MockDataRecyclerAdapter();

    @Mock
    RecyclerView.AdapterDataObserver dataObserver;

    public void setUp() throws Exception {
        adapter.registerAdapterDataObserver(dataObserver);
    }

    @Test
    public void shouldNotifyDataSetChangedWhenNewDataSet() throws Exception {
        List<Object> objects = new ArrayList<>();
        adapter.setDataSet(objects);
        verify(adapter).notifyDataSetChanged();
    }

    @Test
    public void shouldReturnTheSameObjectAtTheSamePositionWhenElementGet() throws Exception {
        int size = 20;
        List<Object> objects = new ObjectsListCreator(size).createList();
        adapter.setDataSet(objects);
        compareObjectFromAdapterAndList(objects);
    }

    @Test
    public void shouldReturnNullElementIfDataSetIsNull() throws Exception {
        adapter.setDataSet(null);
        assertNull(adapter.getItemAtPosition(12));
    }

    @Test
    public void shouldReturnNullElementIfDataSetIsEmpty() throws Exception {
        adapter.setDataSet(new ArrayList<>());
        assertNull(adapter.getItemAtPosition(12));
    }

    @Test
    public void shouldRemoveOldDataWhenSetNewData() throws Exception {
        List<Object> oldObjects = new ObjectsListCreator(10).createList();
        List<Object> newObjects = new ObjectsListCreator(20).createList();
        adapter.setDataSet(oldObjects);
        adapter.setDataSet(newObjects);
        assertEquals(20, adapter.getItemCount());
        compareObjectFromAdapterAndList(newObjects);
    }

    @Test
    public void getItemCountShouldReturnZeroWhenDataSetIsNull() throws Exception {
        adapter.setDataSet(null);
        assertEquals(0, adapter.getItemCount());
    }

    @Test
    public void getItemCountShouldReturnTheSameSizeAsDataSet() throws Exception {
        int size = 22;
        List<Object> objects = new ObjectsListCreator(size).createList();
        adapter.setDataSet(objects);
        assertEquals(size, adapter.getItemCount());
    }

    private void compareObjectFromAdapterAndList(List<Object> newObjects) {
        for (int i = 0; i < adapter.getItemCount(); i++) {
            Object objectFromNewList = newObjects.get(i);
            Object objectFromAdapter = newObjects.get(i);
            assertEquals(objectFromNewList, objectFromAdapter);
        }
    }

    public static class MockDataRecyclerAdapter extends DataRecyclerAdapter<RecyclerView.ViewHolder, Object> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }
    }

}