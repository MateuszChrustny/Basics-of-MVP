package com.lightsoft.basicmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lightsoft.basicmvp.contacts.ContactsPresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.layoutContainer, new ContactsFragment())
                .commit();
    }
}
