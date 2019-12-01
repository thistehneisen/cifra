package io.intercom.android.sdk.activities;

import android.app.Activity;
import io.intercom.android.sdk.views.IntercomToolbar.Listener;

class InAppToolbarListener implements Listener {
    private final Activity activity;

    InAppToolbarListener(Activity activity2) {
        this.activity = activity2;
    }

    public void onCloseClicked() {
        this.activity.onBackPressed();
    }

    public void onInboxClicked() {
    }

    public void onToolbarClicked() {
    }
}
