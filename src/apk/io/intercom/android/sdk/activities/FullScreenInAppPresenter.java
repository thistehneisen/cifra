package io.intercom.android.sdk.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;

class FullScreenInAppPresenter {
    FullScreenInAppPresenter() {
    }

    /* access modifiers changed from: 0000 */
    public void closeWindow(final Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setAlpha(1.0f);
        decorView.animate().alpha(0.0f).setDuration(200).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                activity.finish();
                activity.overridePendingTransition(0, 0);
            }
        }).start();
    }
}
