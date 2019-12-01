package io.intercom.android.sdk.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import io.intercom.android.sdk.R;

public class ExpandableLayout extends LinearLayout {
    private static final long ANIMATION_DURATION = 100;
    private boolean attachedToWindow;
    private ObjectAnimator expandAnimator;
    private ObjectAnimator fadeAnimator;
    private boolean firstLayout = true;
    private int heightMeasureSpec;
    private boolean inLayout;
    private int widthMeasureSpec;

    private static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        private static final int NO_MEASURED_HEIGHT = -10;
        boolean canExpand;
        boolean isExpanded;
        boolean isExpanding;
        int originalHeight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.originalHeight = NO_MEASURED_HEIGHT;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableLayout);
            this.canExpand = obtainStyledAttributes.getBoolean(R.styleable.ExpandableLayout_intercomCanExpand, false);
            this.originalHeight = this.height;
            obtainStyledAttributes.recycle();
        }

        public void setHeight(int i2) {
            this.height = i2;
        }

        public LayoutParams(int i2, int i3, float f2) {
            super(i2, i3, f2);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }

        @TargetApi(19)
        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.originalHeight = NO_MEASURED_HEIGHT;
            this.originalHeight = this.height;
        }
    }

    private static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        boolean isExpanded;

        public SavedState(Parcel parcel) {
            super(parcel);
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.isExpanded = z;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.isExpanded ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ExpandableLayout(Context context) {
        super(context);
    }

    private boolean collapse(View view, boolean z) {
        if (checkExpandableView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.firstLayout || !this.attachedToWindow || !z) {
                layoutParams.isExpanded = false;
                layoutParams.isExpanding = false;
                layoutParams.height = layoutParams.originalHeight;
                view.setVisibility(8);
                return true;
            } else if (!layoutParams.isExpanded || layoutParams.isExpanding) {
                return false;
            } else {
                playCollapseAnimation(view);
                return true;
            }
        } else {
            throw new IllegalArgumentException("collapse(), View is not expandableView");
        }
    }

    private boolean expand(View view, boolean z) {
        if (checkExpandableView(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.firstLayout || !this.attachedToWindow || !z) {
                layoutParams.isExpanded = true;
                layoutParams.isExpanding = false;
                layoutParams.height = layoutParams.originalHeight;
                view.setVisibility(0);
                return true;
            } else if (layoutParams.isExpanded || layoutParams.isExpanding) {
                return false;
            } else {
                playExpandAnimation(view);
                return true;
            }
        } else {
            throw new IllegalArgumentException("expand(), View is not expandableView");
        }
    }

    private void playCollapseAnimation(final View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.isExpanding) {
            view.setVisibility(0);
            layoutParams.isExpanding = true;
            measure(this.widthMeasureSpec, this.heightMeasureSpec);
            this.expandAnimator = ObjectAnimator.ofInt(layoutParams, "height", new int[]{view.getMeasuredHeight(), 0});
            this.expandAnimator.setDuration(ANIMATION_DURATION);
            this.expandAnimator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.requestLayout();
                }
            });
            this.expandAnimator.addListener(new AnimatorEndListener() {
                public void onAnimationEnd(Animator animator) {
                    ExpandableLayout.this.performToggleState(view);
                }
            });
            view.setAlpha(0.0f);
            this.fadeAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f, 0.0f});
            this.fadeAnimator.setDuration(ANIMATION_DURATION);
            this.fadeAnimator.addListener(new AnimatorEndListener() {
                public void onAnimationEnd(Animator animator) {
                    view.setAlpha(0.0f);
                }
            });
            this.expandAnimator.setStartDelay(200);
            this.fadeAnimator.start();
            this.expandAnimator.start();
        }
    }

    private void playExpandAnimation(final View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.isExpanding) {
            view.setVisibility(0);
            layoutParams.isExpanding = true;
            measure(this.widthMeasureSpec, this.heightMeasureSpec);
            int measuredHeight = view.getMeasuredHeight();
            layoutParams.height = 0;
            this.expandAnimator = ObjectAnimator.ofInt(layoutParams, "height", new int[]{0, measuredHeight});
            this.expandAnimator.setDuration(ANIMATION_DURATION);
            this.expandAnimator.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.requestLayout();
                }
            });
            this.expandAnimator.addListener(new AnimatorEndListener() {
                public void onAnimationEnd(Animator animator) {
                    ExpandableLayout.this.performToggleState(view);
                }
            });
            view.setAlpha(0.0f);
            this.fadeAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f, 1.0f});
            this.fadeAnimator.setDuration(ANIMATION_DURATION);
            this.fadeAnimator.addListener(new AnimatorEndListener() {
                public void onAnimationEnd(Animator animator) {
                    view.setAlpha(1.0f);
                }
            });
            this.fadeAnimator.setStartDelay(200);
            this.expandAnimator.start();
            this.fadeAnimator.start();
        }
    }

    private void safeReleaseAnimator(ObjectAnimator objectAnimator) {
        if (objectAnimator != null && objectAnimator.isRunning()) {
            objectAnimator.end();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean checkExpandableView(View view) {
        return ((LayoutParams) view.getLayoutParams()).canExpand;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public View findExpandableView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).canExpand) {
                return getChildAt(i2);
            }
        }
        return null;
    }

    public boolean isExpanded() {
        View findExpandableView = findExpandableView();
        return findExpandableView != null && ((LayoutParams) findExpandableView.getLayoutParams()).isExpanded;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.attachedToWindow = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
        View findExpandableView = findExpandableView();
        safeReleaseAnimator(this.expandAnimator);
        safeReleaseAnimator(this.fadeAnimator);
        if (findExpandableView != null) {
            LayoutParams layoutParams = (LayoutParams) findExpandableView.getLayoutParams();
            if (layoutParams.isExpanded) {
                layoutParams.height = layoutParams.originalHeight;
                findExpandableView.setVisibility(0);
            } else {
                layoutParams.height = layoutParams.originalHeight;
                findExpandableView.setVisibility(8);
            }
            layoutParams.isExpanding = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.inLayout = true;
        super.onLayout(z, i2, i3, i4, i5);
        this.inLayout = false;
        this.firstLayout = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        this.widthMeasureSpec = i2;
        this.heightMeasureSpec = i3;
        View findExpandableView = findExpandableView();
        if (findExpandableView != null) {
            LayoutParams layoutParams = (LayoutParams) findExpandableView.getLayoutParams();
            if (layoutParams.weight != 0.0f) {
                throw new IllegalArgumentException("ExpandableView can't use weight");
            } else if (layoutParams.isExpanded || layoutParams.isExpanding) {
                findExpandableView.setVisibility(0);
            } else {
                findExpandableView.setVisibility(8);
            }
        }
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isExpanded && findExpandableView() != null) {
            setExpanded(true);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (isExpanded()) {
            savedState.isExpanded = true;
        }
        return savedState;
    }

    /* access modifiers changed from: 0000 */
    public void performToggleState(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.isExpanded) {
            layoutParams.isExpanded = false;
            view.setVisibility(8);
            layoutParams.height = layoutParams.originalHeight;
        } else {
            layoutParams.isExpanded = true;
        }
        layoutParams.isExpanding = false;
    }

    public void requestLayout() {
        if (!this.inLayout) {
            super.requestLayout();
        }
    }

    public boolean setExpanded(boolean z) {
        return setExpanded(z, false);
    }

    public boolean setExpanded(boolean z, boolean z2) {
        View findExpandableView = findExpandableView();
        boolean z3 = (findExpandableView == null || z == isExpanded()) ? false : z ? expand(findExpandableView, z2) : collapse(findExpandableView, z2);
        requestLayout();
        return z3;
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public ExpandableLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
