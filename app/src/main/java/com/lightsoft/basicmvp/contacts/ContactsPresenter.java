package com.lightsoft.basicmvp.contacts;

import com.lightsoft.basicmvp.DataProvider;
import com.lightsoft.basicmvp.model.Contact;

import java.util.List;

public class ContactsPresenter {
    private ContactsView contactsView;

    private DataProvider<List<Contact>> contactsDataProvider;

    public ContactsPresenter(ContactsView contactsView, DataProvider<List<Contact>> contactsDataProvider) {
        if (contactsView == null)
            throw new IllegalArgumentException("contactsView argument cannot be null");
        if(contactsDataProvider == null)
            throw  new IllegalArgumentException("contactsDataProvider argument cannot be null");
        this.contactsView = contactsView;
        this.contactsDataProvider = contactsDataProvider;
        this.contactsView.setPresenter(this);
    }

    public void onViewCreated() {
        contactsDataProvider.loadData(this::onContactsLoaded);
    }

    public void onContactsLoaded(List<Contact> contacts) {
        contactsView.showContacts(contacts);
    }
}
