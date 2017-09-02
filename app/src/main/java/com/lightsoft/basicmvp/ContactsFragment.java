package com.lightsoft.basicmvp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lightsoft.basicmvp.contacts.ContactsPresenter;
import com.lightsoft.basicmvp.contacts.ContactsView;
import com.lightsoft.basicmvp.model.Contact;
import com.lightsoft.basicmvp.views.list.recycler.DataListView;

import java.util.List;

public class ContactsFragment extends Fragment {

    ContactsFragmentModule contactsModule = new RecyclerContactsFragmentModule();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(contactsModule.layoutId(), null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        View listView = view.findViewById(contactsModule.listId());
        configureModule(listView);
    }

    private void configureModule(View listView) {
        DataListView<Contact> contactsListView = contactsModule.createDataListView(listView);
        ContactsView contactsView = contactsModule.createContactsView(contactsListView);
        DataProvider<List<Contact>> dataProvider = contactsModule.createDataProvider();
        ContactsPresenter presenter = contactsModule.createPresenter(contactsView, dataProvider);
    }
}
