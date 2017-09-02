package com.lightsoft.basicmvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lightsoft.basicmvp.contacts.ContactsListAdapter;
import com.lightsoft.basicmvp.contacts.ContactsListView;
import com.lightsoft.basicmvp.contacts.ContactsPresenter;
import com.lightsoft.basicmvp.contacts.ContactsView;
import com.lightsoft.basicmvp.contacts.MockContactsProvider;
import com.lightsoft.basicmvp.model.Contact;
import com.lightsoft.basicmvp.views.list.recycler.DataListView;
import com.lightsoft.basicmvp.views.list.recycler.DataRecyclerAdapter;
import com.lightsoft.basicmvp.views.list.recycler.RecyclerListView;

import java.util.List;

public class RecyclerContactsFragmentModule implements ContactsFragmentModule {

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
        return new MockContactsProvider();
    }

    @Override
    public DataRecyclerAdapter<?, Contact> createContactsAdapter() {
        return new ContactsListAdapter();
    }

    @Override
    public ContactsView createContactsView(DataListView<Contact> contactsListView) {
        return new ContactsListView(contactsListView);
    }

    @Override
    public ContactsPresenter createPresenter(ContactsView contactsView, DataProvider<List<Contact>> dataProvider) {
        return new ContactsPresenter(contactsView, dataProvider);
    }

    @Override
    public DataListView<Contact> createDataListView(View list) {
        if (list instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) list;
            return new RecyclerListView<>(recyclerView, createContactsAdapter(), new LinearLayoutManager(recyclerView.getContext()));
        }
        return null;
    }
}
