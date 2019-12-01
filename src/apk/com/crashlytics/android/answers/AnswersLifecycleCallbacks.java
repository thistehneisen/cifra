package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;
import io.fabric.sdk.android.b.C0097b;

class AnswersLifecycleCallbacks extends C0097b {
    private final SessionAnalyticsManager analyticsManager;
    private final BackgroundManager backgroundManager;

    public AnswersLifecycleCallbacks(SessionAnalyticsManager sessionAnalyticsManager, BackgroundManager backgroundManager2) {
        this.analyticsManager = sessionAnalyticsManager;
        this.backgroundManager = backgroundManager2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        this.analyticsManager.onLifecycle(activity, Type.PAUSE);
        this.backgroundManager.onActivityPaused();
    }

    public void onActivityResumed(Activity activity) {
        this.analyticsManager.onLifecycle(activity, Type.RESUME);
        this.backgroundManager.onActivityResumed();
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.analyticsManager.onLifecycle(activity, Type.START);
    }

    public void onActivityStopped(Activity activity) {
        this.analyticsManager.onLifecycle(activity, Type.STOP);
    }
}
