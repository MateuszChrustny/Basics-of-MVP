package com.lightsoft.basicmvp.contacts;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lightsoft.basicmvp.BuildConfig;
import com.lightsoft.basicmvp.creators.ContactsListCreator;
import com.lightsoft.basicmvp.model.Contact;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class ContactsListAdapterTest {
    ContactsListAdapter adapter;

    @Before
    public void setUp() throws Exception {
        adapter = new ContactsListAdapter();
    }

    @Test
    public void shouldCreateViewHolder() throws Exception {
        ViewGroup rootView = new LinearLayout(RuntimeEnvironment.application);
        ContactItemHolder viewHolder = adapter.onCreateViewHolder(rootView, 0);
        assertNotNull(viewHolder);
    }

    @Test
    public void shouldBindDataIntoViewHolder() throws Exception {
        List<Contact> contactList = new ContactsListCreator(10).createList();
        adapter.setDataSet(contactList);
        ContactItemHolder contactItemHolder = Mockito.mock(ContactItemHolder.class);
        adapter.onBindViewHolder(contactItemHolder, 1);
        verify(contactItemHolder).bindContact(contactList.get(1));
    }
}