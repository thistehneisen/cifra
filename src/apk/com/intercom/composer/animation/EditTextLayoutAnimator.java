package com.intercom.composer.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import b.j.a.a.b;

public class EditTextLayoutAnimator {
    private static final long EDIT_TEXT_ANIMATION_MS = 350;
    AnimationStatus animationStatus = AnimationStatus.SHOWN;
    final AnimatorUpdateListener animationUpdateListener = new AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((LayoutParams) EditTextLayoutAnimator.this.editText.getLayoutParams()).bottomMargin = ((Float) valueAnimator.getAnimatedValue()).intValue();
            EditTextLayoutAnimator.this.editText.requestLayout();
        }
    };
    private ObjectAnimator animator;
    /* access modifiers changed from: private */
    public final View editText;
    /* access modifiers changed from: private */
    public EditTextLayoutAnimatorInternalListener editTextLayoutAnimatorListener;
    final AnimatorListener hideEditTextAnimationListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            EditTextLayoutAnimator editTextLayoutAnimator = EditTextLayoutAnimator.this;
            editTextLayoutAnimator.animationStatus = AnimationStatus.HIDDEN;
            if (editTextLayoutAnimator.editTextLayoutAnimatorListener != null) {
                EditTextLayoutAnimator.this.editTextLayoutAnimatorListener.onEditTextLayoutAnimationEnd(AnimationStatus.HIDDEN);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            EditTextLayoutAnimator.this.animationStatus = AnimationStatus.HIDING;
        }
    };
    final AnimatorListener showEditTextAnimationListener = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            EditTextLayoutAnimator editTextLayoutAnimator = EditTextLayoutAnimator.this;
            editTextLayoutAnimator.animationStatus = AnimationStatus.SHOWN;
            if (editTextLayoutAnimator.editTextLayoutAnimatorListener != null) {
                EditTextLayoutAnimator.this.editTextLayoutAnimatorListener.onEditTextLayoutAnimationEnd(AnimationStatus.SHOWN);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            EditTextLayoutAnimator.this.animationStatus = AnimationStatus.SHOWING;
        }
    };

    public EditTextLayoutAnimator(View view) {
        this.editText = view;
    }

    public void hideEditText() {
        if (this.animationStatus == AnimationStatus.SHOWING) {
            ObjectAnimator objectAnimator = this.animator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
        if (this.animationStatus == AnimationStatus.SHOWN) {
            View view = this.editText;
            this.animator = ObjectAnimator.ofFloat(view, "layout_marginBottom", new float[]{0.0f, (float) (-view.getHeight())});
            this.animator.setDuration(EDIT_TEXT_ANIMATION_MS);
            this.animator.setInterpolator(new b());
            this.animator.addUpdateListener(this.animationUpdateListener);
            this.animator.addListener(this.hideEditTextAnimationListener);
            this.animator.start();
        }
    }

    public void setEditTextLayoutAnimatorListener(EditTextLayoutAnimatorInternalListener editTextLayoutAnimatorInternalListener) {
        this.editTextLayoutAnimatorListener = editTextLayoutAnimatorInternalListener;
    }

    public void showEditText(boolean z) {
        if (this.animationStatus == AnimationStatus.HIDING) {
            ObjectAnimator objectAnimator = this.animator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
        }
        if (this.animationStatus == AnimationStatus.HIDDEN) {
            View view = this.editText;
            this.animator = ObjectAnimator.ofFloat(view, "layout_marginBottom", new float[]{(float) (-view.getHeight()), 0.0f});
            this.animator.setDuration(z ? EDIT_TEXT_ANIMATION_MS : 0);
            this.animator.setInterpolator(new b());
            this.animator.addUpdateListener(this.animationUpdateListener);
            this.animator.addListener(this.showEditTextAnimationListener);
            this.animator.start();
        }
    }
}
