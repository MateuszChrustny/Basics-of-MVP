package com.lightsoft.basicmvp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lightsoft.basicmvp.contacts.ContactsListView;
import com.lightsoft.basicmvp.contacts.ContactsPresenter;
import com.lightsoft.basicmvp.contacts.ContactsView;
import com.lightsoft.basicmvp.contacts.MockContactsProvider;

/**
 * Created by Mateusz on 23.07.2017.
 */

public class ContactsFragment extends Fragment{

    private ContactsPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.contacts_list, null);
        ContactsView contactsView = new ContactsListView(rootView);
        presenter = new ContactsPresenter(contactsView, new MockContactsProvider());
        return rootView;
    }
}
