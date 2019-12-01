package io.intercom.android.sdk.views;

import android.view.View;
import b.g.a.a;
import io.intercom.android.sdk.R;
import io.intercom.android.sdk.identity.AppConfig;
import io.intercom.android.sdk.utilities.BackgroundUtils;

public class ActiveStatePresenter {
    private static final String ENGLISH_LOCALE = "en";

    public void presentStateDot(boolean z, View view, AppConfig appConfig) {
        if (!ENGLISH_LOCALE.equals(appConfig.getLocale())) {
            view.setBackgroundResource(0);
        } else {
            BackgroundUtils.setBackground(view, new ActiveStateDrawable(a.a(view.getContext(), z ? R.color.intercom_active_state : R.color.intercom_away_state), a.a(view.getContext(), R.color.intercom_white), view.getResources().getDisplayMetrics().density * 1.0f));
        }
    }
}
