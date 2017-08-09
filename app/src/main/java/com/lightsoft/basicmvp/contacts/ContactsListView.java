package com.lightsoft.basicmvp.contacts;

import android.view.View;
import android.widget.TextView;

import com.lightsoft.basicmvp.R;
import com.lightsoft.basicmvp.model.Contact;

import java.util.List;

public class ContactsListView implements ContactsView {
    private View rootView;

    private TextView plainList;

    private ContactsPresenter presenter;


    public ContactsListView(View rootView) {
        if (rootView == null)
            throw new IllegalArgumentException("rootView argument cannot be null");
        this.rootView = rootView;
        plainList = this.rootView.findViewById(R.id.plainList);
    }

    @Override
    public void setPresenter(ContactsPresenter contactsPresenter) {
        this.presenter = contactsPresenter;
        this.presenter.onViewCreated();
    }

    @Override
    public void showContacts(List<Contact> contacts) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Contact contact : contacts) {
            stringBuilder.append(contact.getName())
                    .append(" : ")
                    .append(contact.getPhoneNumber())
                    .append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        plainList.setText(stringBuilder.toString());
    }

    @Override
    public View getRootView() {
        return rootView;
    }
}
