package com.lightsoft.basicmvp;

import com.lightsoft.basicmvp.matchers.ViewMatcher;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.FragmentController;
import org.robolectric.annotation.Config;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 25)
public class ContactsFragmentTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Spy
    ContactsFragmentModuleMock contactsFragmentModule = new ContactsFragmentModuleMock();

    FragmentController fragmentController;

    @Before
    public void setUp() throws Exception {

        fragmentController = Robolectric.buildFragment(ContactsFragment.class);
        ContactsFragment fragment = (ContactsFragment) fragmentController.get();
        fragment.contactsModule = contactsFragmentModule;
    }

    @Test
    public void shouldCreateDataListViewWithViewIndicatedByModule() throws Exception {
        fragmentController.create().resume().start();
        verify(contactsFragmentModule).createDataListView(argThat(new ViewMatcher(contactsFragmentModule.listId())));
    }

    @Test
    public void shouldCreateContactsViewWithDataListViewDeliveredByModule() throws Exception {
        fragmentController.create().resume().start();
        verify(contactsFragmentModule).createContactsView(contactsFragmentModule.dataListView);
    }

    @Test
    public void shouldCreatePresenterWithViewAndDataProviderDeliveredByModule() throws Exception {
        fragmentController.create().resume().start();
        verify(contactsFragmentModule).createPresenter(contactsFragmentModule.contactsView, contactsFragmentModule.dataProvider);
    }

    @Test
    public void shouldUseLayoutDeliveredByModule() throws Exception {
        fragmentController.create().resume();

    }
}