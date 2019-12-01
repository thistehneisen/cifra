package io.intercom.android.sdk.utilities;

import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import io.intercom.android.sdk.R;

public class BackgroundUtils {
    public static void animateBackground(int i2, int i3, int i4, final View view, AnimatorListener animatorListener) {
        ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        ofObject.setDuration((long) i4);
        ofObject.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        if (animatorListener != null) {
            ofObject.addListener(animatorListener);
        }
        ofObject.start();
    }

    public static void setBackground(View view, Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void setRippleButtonBackgroundColor(Drawable drawable, int i2, int i3) {
        if (VERSION.SDK_INT >= 21) {
            ((GradientDrawable) ((RippleDrawable) drawable).findDrawableByLayerId(i2)).setColor(i3);
        } else {
            ((GradientDrawable) ((LayerDrawable) drawable).findDrawableByLayerId(i2)).setColor(i3);
        }
    }

    public static void setRippleButtonStroke(Context context, Drawable drawable, int i2, int i3) {
        if (VERSION.SDK_INT >= 21) {
            updateStroke((GradientDrawable) ((RippleDrawable) drawable).findDrawableByLayerId(i2), context, i3);
        } else {
            updateStroke((GradientDrawable) ((LayerDrawable) drawable).findDrawableByLayerId(i2), context, i3);
        }
    }

    private static void updateStroke(GradientDrawable gradientDrawable, Context context, int i2) {
        gradientDrawable.setStroke(context.getResources().getDimensionPixelSize(R.dimen.intercom_home_button_stroke_size), i2);
    }
}
