package io.intercom.android.sdk.views;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

abstract class AnimatorEndListener implements AnimatorListener {
    AnimatorEndListener() {
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
