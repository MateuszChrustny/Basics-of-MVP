package com.lightsoft.basicmvp.contacts;

import com.lightsoft.basicmvp.model.Contact;
import com.lightsoft.basicmvp.views.list.recycler.DataListView;

import java.util.List;

public class ContactsListView implements ContactsView {

    private ContactsPresenter presenter;

    private DataListView dataListView;

    public ContactsListView(DataListView dataListView) {
        if(dataListView == null) throw new IllegalArgumentException("dataListView should not be null");
        this.dataListView = dataListView;
    }

    @Override
    public void setPresenter(ContactsPresenter contactsPresenter) {
        this.presenter = contactsPresenter;
        this.presenter.onViewCreated();
    }

    @Override
    public void showContacts(List<Contact> contacts) {
        dataListView.showData(contacts);
    }
}
