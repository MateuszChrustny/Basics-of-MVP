package com.lightsoft.basicmvp.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lightsoft.basicmvp.BuildConfig;
import com.lightsoft.basicmvp.R;
import com.lightsoft.basicmvp.model.Contact;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class ContactItemHolderTest {

    private ContactItemHolder contactItemHolder;

    private TextView contactName;

    private TextView contactNumber;

    @Before
    public void setUp() throws Exception {
        View view = LayoutInflater.from(RuntimeEnvironment.application).inflate(R.layout.contact_list_item, null);
        contactName = view.findViewById(R.id.contactName);
        contactNumber = view.findViewById(R.id.contactNumber);
        contactItemHolder = new ContactItemHolder(view);
    }

    @Test
    public void shouldDisplayNameOfContact() throws Exception {
        final String NAME = "John";
        Contact contact = new Contact(NAME, null);
        contactItemHolder.bindContact(contact);
        assertEquals(NAME, contactName.getText().toString());
    }

    @Test
    public void shouldDisplayNumberOfContact() throws Exception {
        final String NUMBER = "78876786";
        Contact contact = new Contact(null, NUMBER);
        contactItemHolder.bindContact(contact);
        assertEquals(NUMBER, contactNumber.getText().toString());
    }
}