package com.lightsoft.basicmvp.contacts;

import com.lightsoft.basicmvp.creators.ContactsListCreator;
import com.lightsoft.basicmvp.model.Contact;
import com.lightsoft.basicmvp.views.list.recycler.DataListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ContactsListViewTest {

    @Mock
    DataListView<Contact> dataListView;

    @Mock
    ContactsPresenter contactsPresenter;

    ContactsListView contactsListView;


    @Before
    public void setUp() throws Exception {

        contactsListView = new ContactsListView(dataListView);
        contactsListView.setPresenter(contactsPresenter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalExceptionWhenViewIsNull() throws Exception {
        new ContactsListView(null);
    }

    @Test
    public void shouldNotifyPresenterWhenViewIsCreated() throws Exception {
        verify(contactsPresenter).onViewCreated();
    }

    @Test
    public void shouldShowDataInDataListView() throws Exception {
        List<Contact> contacts = new ContactsListCreator(10).createList();
        contactsListView.showContacts(contacts);
        verify(dataListView).showData(contacts);
    }
}