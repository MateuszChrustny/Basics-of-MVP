package com.lightsoft.basicmvp.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lightsoft.basicmvp.R;
import com.lightsoft.basicmvp.model.Contact;
import com.lightsoft.basicmvp.views.list.recycler.DataRecyclerAdapter;

public class ContactsListAdapter extends DataRecyclerAdapter<ContactItemHolder, Contact> {


    @Override
    public ContactItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contactView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item, null);
        return new ContactItemHolder(contactView);
    }

    @Override
    public void onBindViewHolder(ContactItemHolder holder, int position) {
        holder.bindContact(getItemAtPosition(position));
    }


}
