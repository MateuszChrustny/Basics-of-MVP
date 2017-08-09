package com.lightsoft.basicmvp.contacts;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lightsoft.basicmvp.BuildConfig;
import com.lightsoft.basicmvp.R;
import com.lightsoft.basicmvp.model.Contact;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class ContactsListViewTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    View layoutView;

    ContactsListView contactsListView;

    @Mock
    ContactsPresenter contactsPresenter;

    @Before
    public void setUp() throws Exception {
        Activity activity = Robolectric.buildActivity(Activity.class).create().get();
        layoutView = LayoutInflater.from(activity)
                .inflate(R.layout.contacts_list,null, false);

        contactsListView = new ContactsListView(layoutView);
        contactsListView.setPresenter(contactsPresenter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalExceptionWhenViewIsNull() throws Exception {
        new ContactsListView(null);
    }

    @Test
    public void shouldCreateContactListViewWhenLayoutViewIsNotNull() throws Exception {
        ContactsView contactsView = new ContactsListView(layoutView);
        assertNotNull(contactsView);
    }

    @Test
    public void shouldNotifyPresenterWhenViewIsCreated() throws Exception {
        verify(contactsPresenter).onViewCreated();
    }

    @Test
    public void showContactsShouldShowPlainListInTextView() throws Exception {
        List<Contact> contacts = new ArrayList<>(2);
        Contact contact1 = new Contact("Contact1", "1");
        Contact contact2 = new Contact("Contact2", "2");
        contacts.add(contact1);
        contacts.add(contact2);
        contactsListView.showContacts(contacts);
        TextView contactList = layoutView.findViewById(R.id.plainList);
        String expectedText = "Contact1 : 1\nContact2 : 2";
        assertEquals(expectedText, contactList.getText());
    }
}