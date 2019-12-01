package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import b.a.f;
import b.a.j;
import b.g.i.B;

public class ActionBarContainer extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    private boolean f700a;

    /* renamed from: b reason: collision with root package name */
    private View f701b;

    /* renamed from: c reason: collision with root package name */
    private View f702c;

    /* renamed from: d reason: collision with root package name */
    private View f703d;

    /* renamed from: e reason: collision with root package name */
    Drawable f704e;

    /* renamed from: f reason: collision with root package name */
    Drawable f705f;

    /* renamed from: g reason: collision with root package name */
    Drawable f706g;

    /* renamed from: h reason: collision with root package name */
    boolean f707h;

    /* renamed from: i reason: collision with root package name */
    boolean f708i;

    /* renamed from: j reason: collision with root package name */
    private int f709j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    private int a(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private boolean b(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f704e;
        if (drawable != null && drawable.isStateful()) {
            this.f704e.setState(getDrawableState());
        }
        Drawable drawable2 = this.f705f;
        if (drawable2 != null && drawable2.isStateful()) {
            this.f705f.setState(getDrawableState());
        }
        Drawable drawable3 = this.f706g;
        if (drawable3 != null && drawable3.isStateful()) {
            this.f706g.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        return this.f701b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f704e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f705f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        Drawable drawable3 = this.f706g;
        if (drawable3 != null) {
            drawable3.jumpToCurrentState();
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f702c = findViewById(f.action_bar);
        this.f703d = findViewById(f.action_context_bar);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f700a || super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.f701b;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i4, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.f707h) {
            Drawable drawable = this.f706g;
            if (drawable != null) {
                drawable.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z2 = false;
            }
        } else {
            if (this.f704e != null) {
                if (this.f702c.getVisibility() == 0) {
                    this.f704e.setBounds(this.f702c.getLeft(), this.f702c.getTop(), this.f702c.getRight(), this.f702c.getBottom());
                } else {
                    View view2 = this.f703d;
                    if (view2 == null || view2.getVisibility() != 0) {
                        this.f704e.setBounds(0, 0, 0, 0);
                    } else {
                        this.f704e.setBounds(this.f703d.getLeft(), this.f703d.getTop(), this.f703d.getRight(), this.f703d.getBottom());
                    }
                }
                z3 = true;
            }
            this.f708i = z4;
            if (z4) {
                Drawable drawable2 = this.f705f;
                if (drawable2 != null) {
                    drawable2.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                }
            }
            z2 = z3;
        }
        if (z2) {
            invalidate();
        }
    }

    public void onMeasure(int i2, int i3) {
        if (this.f702c == null && MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            int i4 = this.f709j;
            if (i4 >= 0) {
                i3 = MeasureSpec.makeMeasureSpec(Math.min(i4, MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i2, i3);
        if (this.f702c != null) {
            int mode = MeasureSpec.getMode(i3);
            View view = this.f701b;
            if (!(view == null || view.getVisibility() == 8 || mode == 1073741824)) {
                int i5 = !b(this.f702c) ? a(this.f702c) : !b(this.f703d) ? a(this.f703d) : 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(i5 + a(this.f701b), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Drawable drawable2 = this.f704e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f704e);
        }
        this.f704e = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            View view = this.f702c;
            if (view != null) {
                this.f704e.setBounds(view.getLeft(), this.f702c.getTop(), this.f702c.getRight(), this.f702c.getBottom());
            }
        }
        boolean z = true;
        if (!this.f707h ? !(this.f704e == null && this.f705f == null) : this.f706g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2 = this.f706g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f706g);
        }
        this.f706g = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f707h) {
                Drawable drawable3 = this.f706g;
                if (drawable3 != null) {
                    drawable3.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                }
            }
        }
        if (!this.f707h ? this.f704e == null && this.f705f == null : this.f706g == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2 = this.f705f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.f705f);
        }
        this.f705f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f708i) {
                Drawable drawable3 = this.f705f;
                if (drawable3 != null) {
                    drawable3.setBounds(this.f701b.getLeft(), this.f701b.getTop(), this.f701b.getRight(), this.f701b.getBottom());
                }
            }
        }
        boolean z = true;
        if (!this.f707h ? !(this.f704e == null && this.f705f == null) : this.f706g != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(Y y) {
        View view = this.f701b;
        if (view != null) {
            removeView(view);
        }
        this.f701b = y;
        if (y != null) {
            addView(y);
            ViewGroup.LayoutParams layoutParams = y.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            y.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f700a = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.f704e;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
        Drawable drawable2 = this.f705f;
        if (drawable2 != null) {
            drawable2.setVisible(z, false);
        }
        Drawable drawable3 = this.f706g;
        if (drawable3 != null) {
            drawable3.setVisible(z, false);
        }
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    public ActionMode startActionModeForChild(View view, Callback callback, int i2) {
        if (i2 != 0) {
            return super.startActionModeForChild(view, callback, i2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f704e && !this.f707h) || (drawable == this.f705f && this.f708i) || ((drawable == this.f706g && this.f707h) || super.verifyDrawable(drawable));
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        B.a((View) this, (Drawable) new C0155b(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionBar);
        this.f704e = obtainStyledAttributes.getDrawable(j.ActionBar_background);
        this.f705f = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundStacked);
        this.f709j = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_height, -1);
        if (getId() == f.split_action_bar) {
            this.f707h = true;
            this.f706g = obtainStyledAttributes.getDrawable(j.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f707h ? this.f704e == null && this.f705f == null : this.f706g == null) {
            z = true;
        }
        setWillNotDraw(z);
    }
}
