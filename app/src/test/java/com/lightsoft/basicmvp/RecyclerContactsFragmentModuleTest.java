package com.lightsoft.basicmvp;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lightsoft.basicmvp.contacts.ContactsView;
import com.lightsoft.basicmvp.views.list.recycler.DataListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class RecyclerContactsFragmentModuleTest {

    ContactsFragmentModule contactsFragmentModule;

    @Before
    public void setUp() throws Exception {
        contactsFragmentModule = new RecyclerContactsFragmentModule();
    }

    @Test
    public void shouldReturnContactsListLayout() throws Exception {
        assertEquals(contactsFragmentModule.layoutId(), R.layout.contacts_list);
    }

    @Test
    public void shouldReturnRecyclerViewId() throws Exception {
        assertEquals(contactsFragmentModule.listId(), R.id.contactsList);
    }

    @Test
    public void shouldReturnDataProvider() throws Exception {
        assertNotNull(contactsFragmentModule.createDataProvider());
    }

    @Test
    public void shouldReturnContactAdapter() throws Exception {
        assertNotNull(contactsFragmentModule.createContactsAdapter());
    }

    @Test
    public void shouldCreateContactsView() throws Exception {
        assertNotNull(contactsFragmentModule.createContactsView(Mockito.mock(DataListView.class)));
    }

    @Test
    public void shouldCreatePresenter() throws Exception {
        assertNotNull(contactsFragmentModule.createPresenter(Mockito.mock(ContactsView.class), Mockito.mock(DataProvider.class)));
    }

    @Test
    public void shouldCreateDataListViewWhenViewIsRecyclerView() throws Exception {
        assertNotNull(contactsFragmentModule.createDataListView(Mockito.mock(RecyclerView.class)));
    }

    @Test
    public void shouldNotCreateDataListViewWhenViewInNotRecyclerView() throws Exception {
        assertNull(contactsFragmentModule.createDataListView(Mockito.mock(View.class)));
    }
}