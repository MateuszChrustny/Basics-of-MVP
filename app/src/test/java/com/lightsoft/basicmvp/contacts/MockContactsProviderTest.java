package com.lightsoft.basicmvp.contacts;

import org.junit.Test;

import static org.junit.Assert.*;

public class MockContactsProviderTest {
    @Test
    public void shouldGenerateTenContacts() throws Exception {
        MockContactsProvider mockContactsProvider = new MockContactsProvider();
        mockContactsProvider.loadData((list)->assertEquals(10, list.size()));
    }
}