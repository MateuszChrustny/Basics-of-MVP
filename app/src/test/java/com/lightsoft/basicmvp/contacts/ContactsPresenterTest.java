package com.lightsoft.basicmvp.contacts;

import com.lightsoft.basicmvp.DataProvider;
import com.lightsoft.basicmvp.model.Contact;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ContactsPresenterTest {

    @Mock
    ContactsView contactsView;

    @Mock
    DataProvider<List<Contact>> contactsProvider;

    ContactsPresenter contactsPresenter;

    @Before
    public void setUp() throws Exception {
        contactsPresenter = new ContactsPresenter(contactsView, contactsProvider);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalExceptionWhenViewIsNull() throws Exception {
        new ContactsPresenter(null, contactsProvider);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalExceptionWhenDataProviderIsNull() throws Exception {
        new ContactsPresenter(contactsView, null);
    }

    @Test
    public void shouldCreateContactsPresenterWhenNoOneArgumentIsNull() throws Exception {
        ContactsPresenter contactsPresenter = new ContactsPresenter(contactsView, contactsProvider);
        assertNotNull(contactsPresenter);
    }

    @Test
    public void shouldLoadContactsWhenViewCreated() throws Exception {
        contactsPresenter.onViewCreated();
        verify(contactsProvider).loadData(any());
    }

    @Test
    public void shouldShowContactsWhenContactsLoaded() throws Exception {
        contactsPresenter.onContactsLoaded(mock(List.class));
        verify(contactsView).showContacts(any(List.class));
    }
}