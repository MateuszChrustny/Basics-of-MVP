package com.lightsoft.basicmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.lightsoft.basicmvp.contacts.ContactsListView;
import com.lightsoft.basicmvp.contacts.ContactsPresenter;
import com.lightsoft.basicmvp.contacts.ContactsView;
import com.lightsoft.basicmvp.contacts.MockContactsProvider;

public class MainActivity extends AppCompatActivity {

    private ContactsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = getLayoutInflater().inflate(R.layout.contacts_list, null);
        ContactsView contactsView = new ContactsListView(rootView);
        setContentView(contactsView.getRootView());
        presenter = new ContactsPresenter(contactsView, new MockContactsProvider());
    }
}
