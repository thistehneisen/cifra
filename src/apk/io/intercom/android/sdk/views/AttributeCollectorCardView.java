package io.intercom.android.sdk.views;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import b.g.i.C0246g;
import io.intercom.android.sdk.R;

public class AttributeCollectorCardView extends LinearLayout {
    private static final long ANIMATE_DURATION = 400;
    private final int expandedLeftMargin;
    private final int expandedPadding;
    private final int expandedShadowSize;
    private AnimatorUpdateListener heightAnimateListener;
    /* access modifiers changed from: private */
    public final int originalBottomMargin;
    private final int originalLeftMargin;
    /* access modifiers changed from: private */
    public final int originalPadding;
    private final int originalShadowSize;
    private AnimatorUpdateListener shadowAnimateListener;
    private final int shadowSizeDiff;
    private AnimatorUpdateListener verticalMarginAnimateListener;
    private AnimatorUpdateListener widthAnimateListener;

    public AttributeCollectorCardView(Context context) {
        this(context, null);
    }

    public void animateBack(AnimatorListener animatorListener) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.expandedLeftMargin, this.originalLeftMargin});
        ofInt.addUpdateListener(this.widthAnimateListener);
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{this.expandedPadding, this.originalPadding});
        ofInt2.addUpdateListener(this.heightAnimateListener);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(new int[]{this.expandedShadowSize, this.originalShadowSize});
        ofInt3.addUpdateListener(this.shadowAnimateListener);
        ValueAnimator ofInt4 = ValueAnimator.ofInt(new int[]{this.shadowSizeDiff, 0});
        ofInt4.addUpdateListener(this.verticalMarginAnimateListener);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(ANIMATE_DURATION);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.playTogether(new Animator[]{ofInt, ofInt2, ofInt3, ofInt4});
        animatorSet.addListener(animatorListener);
        animatorSet.start();
    }

    public void animateToExpand() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.originalLeftMargin, this.expandedLeftMargin});
        ofInt.addUpdateListener(this.widthAnimateListener);
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{this.originalPadding, this.expandedPadding});
        ofInt2.addUpdateListener(this.heightAnimateListener);
        ValueAnimator ofInt3 = ValueAnimator.ofInt(new int[]{this.originalShadowSize, this.expandedShadowSize});
        ofInt3.addUpdateListener(this.shadowAnimateListener);
        ValueAnimator ofInt4 = ValueAnimator.ofInt(new int[]{0, this.shadowSizeDiff});
        ofInt4.addUpdateListener(this.verticalMarginAnimateListener);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(ANIMATE_DURATION);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.playTogether(new Animator[]{ofInt, ofInt2, ofInt3, ofInt4});
        animatorSet.start();
    }

    public boolean isExpanded() {
        return C0246g.b((LayoutParams) getLayoutParams()) < this.originalLeftMargin;
    }

    public AttributeCollectorCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.widthAnimateListener = new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LayoutParams layoutParams = (LayoutParams) AttributeCollectorCardView.this.getLayoutParams();
                C0246g.b(layoutParams, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                AttributeCollectorCardView.this.setLayoutParams(layoutParams);
            }
        };
        this.heightAnimateListener = new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                int access$000 = AttributeCollectorCardView.this.originalPadding;
                AttributeCollectorCardView.this.setPadding(access$000, intValue, access$000, intValue);
            }
        };
        this.shadowAnimateListener = new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (VERSION.SDK_INT >= 21) {
                    AttributeCollectorCardView.this.setElevation((float) ((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            }
        };
        this.verticalMarginAnimateListener = new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LayoutParams layoutParams = (LayoutParams) AttributeCollectorCardView.this.getLayoutParams();
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                layoutParams.topMargin = intValue;
                layoutParams.bottomMargin = intValue + AttributeCollectorCardView.this.originalBottomMargin;
                AttributeCollectorCardView.this.setLayoutParams(layoutParams);
            }
        };
        Resources resources = context.getResources();
        this.originalPadding = resources.getDimensionPixelSize(R.dimen.intercom_container_cell_padding);
        this.originalLeftMargin = resources.getDimensionPixelSize(R.dimen.intercom_attribute_part_left_margin);
        this.expandedLeftMargin = resources.getDimensionPixelSize(R.dimen.intercom_cell_horizontal_padding);
        this.expandedPadding = resources.getDimensionPixelSize(R.dimen.intercom_attribute_part_expanded_vertical_padding);
        this.originalShadowSize = resources.getDimensionPixelSize(R.dimen.intercom_card_shadow_size);
        this.expandedShadowSize = resources.getDimensionPixelSize(R.dimen.intercom_attribute_card_expanded_shadow_size);
        this.originalBottomMargin = resources.getDimensionPixelSize(R.dimen.intercom_card_bottom_margin);
        this.shadowSizeDiff = this.expandedShadowSize - this.originalShadowSize;
    }
}
