package com.intercom.composer.animation;

import android.app.Activity;

public class EditTextLayoutAnimatorInternalListener {
    private final Activity activity;

    public EditTextLayoutAnimatorInternalListener(Activity activity2) {
        this.activity = activity2;
    }

    /* access modifiers changed from: 0000 */
    public void onEditTextLayoutAnimationEnd(AnimationStatus animationStatus) {
        Activity activity2 = this.activity;
        if (activity2 instanceof EditTextLayoutAnimatorListener) {
            ((EditTextLayoutAnimatorListener) activity2).onEditTextLayoutAnimationEnd(animationStatus);
        }
    }
}
