package io.intercom.android.sdk.blocks;

import android.view.View;
import io.intercom.android.sdk.api.Api;
import io.intercom.android.sdk.utilities.LinkOpener;

public class LinkOpeningButtonClickListener implements ButtonClickListener {
    private final Api api;

    public LinkOpeningButtonClickListener(Api api2) {
        this.api = api2;
    }

    public void onButtonClicked(View view, String str) {
        LinkOpener.handleUrl(str, view.getContext(), this.api);
    }

    public boolean shouldHandleClicks() {
        return true;
    }
}
