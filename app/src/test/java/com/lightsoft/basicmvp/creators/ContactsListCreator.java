package com.lightsoft.basicmvp.creators;

import com.lightsoft.basicmvp.model.Contact;

/**
 * Created by Mateusz on 19.08.2017.
 */

public class ContactsListCreator extends ListCreator<Contact> {
    public ContactsListCreator(int size) {
        super(size);
    }

    @Override
    Contact createObject(int position) {
        return new Contact("Contact" + position, "222222" + position);
    }
}
