package com.lightsoft.basicmvp;

import android.view.View;

import com.lightsoft.basicmvp.contacts.ContactsPresenter;
import com.lightsoft.basicmvp.contacts.ContactsView;
import com.lightsoft.basicmvp.model.Contact;
import com.lightsoft.basicmvp.views.list.recycler.DataListView;
import com.lightsoft.basicmvp.views.list.recycler.DataRecyclerAdapter;

import java.util.List;

/**
 * Created by Mateusz on 24.08.2017.
 */

interface ContactsFragmentModule {
    int layoutId();

    int listId();

    DataProvider<List<Contact>> createDataProvider();

    DataRecyclerAdapter<?, Contact> createContactsAdapter();

    ContactsView createContactsView(DataListView<Contact> contactsListView);

    ContactsPresenter createPresenter(ContactsView contactsView, DataProvider<List<Contact>> dataProvider);

    DataListView<Contact> createDataListView(View list);
}
