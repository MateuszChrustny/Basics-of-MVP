package com.lightsoft.basicmvp.contacts;

import android.view.View;

import com.lightsoft.basicmvp.model.Contact;

import java.util.List;

public interface ContactsView {
    void setPresenter(ContactsPresenter contactsPresenter);

    void showContacts(List<Contact> contacts);

    View getRootView();
}
