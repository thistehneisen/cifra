package io.intercom.android.sdk.activities;

import android.content.Context;
import androidx.appcompat.app.C0147n;
import io.intercom.android.sdk.Injector;
import io.intercom.android.sdk.utilities.ContextLocaliser;

public abstract class IntercomBaseActivity extends C0147n {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        new ContextLocaliser(Injector.get().getAppConfigProvider()).applyOverrideConfiguration(this, context);
    }
}
