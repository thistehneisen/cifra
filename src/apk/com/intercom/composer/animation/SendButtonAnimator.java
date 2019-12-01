package com.intercom.composer.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;

public class SendButtonAnimator {
    private static final String ALPHA = "alpha";
    private static final long SEND_BUTTON_ANIMATION_MS = 100;
    AnimatorSet animatorSet;
    final View background;
    final AnimatorUpdateListener backgroundListener = new AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SendButtonAnimator.this.background.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    };
    final ImageView button;
    private ObjectAnimator hideSendAnimator;
    private final HideSendButtonAnimatorListener hideSendButtonAnimatorListener;
    private ObjectAnimator showSendAnimator;
    private final ShowSendButtonAnimatorListener showSendButtonAnimatorListener;

    public SendButtonAnimator(View view, ImageView imageView, ShowSendButtonAnimatorListener showSendButtonAnimatorListener2, HideSendButtonAnimatorListener hideSendButtonAnimatorListener2) {
        this.background = view;
        this.button = imageView;
        this.showSendButtonAnimatorListener = showSendButtonAnimatorListener2;
        this.hideSendButtonAnimatorListener = hideSendButtonAnimatorListener2;
        String str = "scaleX";
        String str2 = "scaleY";
        this.showSendAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(str, new float[]{0.6f, 1.0f}), PropertyValuesHolder.ofFloat(str2, new float[]{0.6f, 1.0f})});
        this.showSendAnimator.setStartDelay(50);
        this.hideSendAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f}), PropertyValuesHolder.ofFloat(str, new float[]{1.0f, 0.6f}), PropertyValuesHolder.ofFloat(str2, new float[]{1.0f, 0.6f})});
    }

    public void animateButtonVisibility(boolean z, AnimationStatus animationStatus) {
        boolean z2;
        if (z && (animationStatus == AnimationStatus.HIDING || animationStatus == AnimationStatus.HIDDEN || animationStatus == AnimationStatus.UNKNOWN)) {
            z2 = true;
        } else if (z) {
            return;
        } else {
            if (animationStatus == AnimationStatus.SHOWING || animationStatus == AnimationStatus.SHOWN || animationStatus == AnimationStatus.UNKNOWN) {
                z2 = false;
            } else {
                return;
            }
        }
        AnimatorSet animatorSet2 = this.animatorSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        this.animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.background, ALPHA, new float[]{z2 ? 1.0f : 0.0f});
        ofFloat.addUpdateListener(this.backgroundListener);
        AnimatorSet animatorSet3 = this.animatorSet;
        Animator[] animatorArr = new Animator[2];
        animatorArr[0] = ofFloat;
        animatorArr[1] = z2 ? this.showSendAnimator : this.hideSendAnimator;
        animatorSet3.playTogether(animatorArr);
        this.animatorSet.setDuration(SEND_BUTTON_ANIMATION_MS);
        this.animatorSet.addListener(z ? this.showSendButtonAnimatorListener : this.hideSendButtonAnimatorListener);
        this.animatorSet.start();
    }
}
