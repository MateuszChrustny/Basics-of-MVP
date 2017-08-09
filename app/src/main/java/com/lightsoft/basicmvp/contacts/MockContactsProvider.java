package com.lightsoft.basicmvp.contacts;

import com.lightsoft.basicmvp.DataProvider;
import com.lightsoft.basicmvp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MockContactsProvider implements DataProvider<List<Contact>> {
    @Override
    public void loadData(DataCallback<List<Contact>> dataCallback) {
        int elements = 10;
        ArrayList<Contact> contacts = new ArrayList<>(elements);
        for (int i = 0; i < elements; i++) {
            Contact contact = new Contact("Contact_" + i, "+48222222" + i);
            contacts.add(contact);
        }
        dataCallback.onDataLoaded(contacts);
    }
}
