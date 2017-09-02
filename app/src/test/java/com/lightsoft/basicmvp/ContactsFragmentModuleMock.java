package com.lightsoft.basicmvp;

import android.view.View;

import com.lightsoft.basicmvp.contacts.ContactsPresenter;
import com.lightsoft.basicmvp.contacts.ContactsView;
import com.lightsoft.basicmvp.model.Contact;
import com.lightsoft.basicmvp.views.list.recycler.DataListView;
import com.lightsoft.basicmvp.views.list.recycler.DataRecyclerAdapter;

import org.mockito.Mock;

import java.util.List;

/**
 * Created by Mateusz on 28.08.2017.
 */

public class ContactsFragmentModuleMock implements ContactsFragmentModule {

    @Mock
    DataProvider<List<Contact>> dataProvider;

    @Mock
    ContactsView contactsView;

    @Mock
    ContactsPresenter contactsPresenter;

    @Mock
    DataListView<Contact> dataListView;

    @Override
    public int layoutId() {
        return R.layout.contacts_list;
    }

    @Override
    public int listId() {
        return R.id.contactsList;
    }

    @Override
    public DataProvider<List<Contact>> createDataProvider() {
        return dataProvider;
    }

    @Override
    public DataRecyclerAdapter<?, Contact> createContactsAdapter() {
        return null;
    }

    @Override
    public ContactsView createContactsView(DataListView<Contact> contactsListView) {
        return contactsView;
    }

    @Override
    public ContactsPresenter createPresenter(ContactsView contactsView, DataProvider<List<Contact>> dataProvider) {
        return contactsPresenter;
    }

    @Override
    public DataListView<Contact> createDataListView(View list) {
        return dataListView;
    }
}
