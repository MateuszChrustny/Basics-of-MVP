package com.lightsoft.basicmvp.contacts;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.lightsoft.basicmvp.R;
import com.lightsoft.basicmvp.model.Contact;

public class ContactItemHolder extends RecyclerView.ViewHolder {

    private TextView contactName;
    private TextView contactNumber;

    public ContactItemHolder(View view) {
        super(view);
        contactName = view.findViewById(R.id.contactName);
        contactNumber = view.findViewById(R.id.contactNumber);
    }

    public void bindContact(Contact contact) {
        contactName.setText(contact.getName());
        contactNumber.setText(contact.getPhoneNumber());
    }
}
