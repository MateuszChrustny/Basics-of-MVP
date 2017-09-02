package com.lightsoft.basicmvp.matchers;

import android.view.View;

import org.mockito.ArgumentMatcher;

public class ViewMatcher implements ArgumentMatcher<View> {

    int viewId;

    public ViewMatcher(int viewId) {
        this.viewId = viewId;
    }

    @Override
    public boolean matches(View argument) {
        return argument.getId() == viewId;
    }
}
