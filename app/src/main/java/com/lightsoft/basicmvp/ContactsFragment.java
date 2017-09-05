package com.lightsoft.basicmvp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lightsoft.basicmvp.contacts.ContactsListAdapter;
import com.lightsoft.basicmvp.contacts.ContactsListView;
import com.lightsoft.basicmvp.contacts.ContactsPresenter;
import com.lightsoft.basicmvp.contacts.ContactsView;
import com.lightsoft.basicmvp.contacts.MockContactsProvider;
import com.lightsoft.basicmvp.model.Contact;
import com.lightsoft.basicmvp.views.list.recycler.DataListView;
import com.lightsoft.basicmvp.views.list.recycler.RecyclerListView;

import java.util.List;

public class ContactsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contacts_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View listView = view.findViewById(R.id.contactsList);
        configureModules(listView);
    }

    private void configureModules(View listView) {
        DataListView<Contact> contactsListView = createDataListView(listView);
        ContactsView contactsView = new ContactsListView(contactsListView);
        DataProvider<List<Contact>> dataProvider = new MockContactsProvider();
        ContactsPresenter presenter = new ContactsPresenter(contactsView, dataProvider);
    }

    private DataListView<Contact> createDataListView(View listView) {
        if (listView instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) listView;
            return new RecyclerListView<>(recyclerView, new ContactsListAdapter(),
                                          new LinearLayoutManager(recyclerView.getContext()));
        }
        return null;
    }
}
