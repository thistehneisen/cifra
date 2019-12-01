package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.graphics.drawable.a;
import b.a.j;
import b.g.i.B;

public class SwitchCompat extends CompoundButton {

    /* renamed from: a reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f885a = new ma(Float.class, "thumbPos");

    /* renamed from: b reason: collision with root package name */
    private static final int[] f886b = {16842912};
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private final TextPaint H;
    private ColorStateList I;
    private Layout J;
    private Layout K;
    private TransformationMethod L;
    ObjectAnimator M;
    private final Rect N;

    /* renamed from: c reason: collision with root package name */
    private Drawable f887c;

    /* renamed from: d reason: collision with root package name */
    private ColorStateList f888d;

    /* renamed from: e reason: collision with root package name */
    private Mode f889e;

    /* renamed from: f reason: collision with root package name */
    private boolean f890f;

    /* renamed from: g reason: collision with root package name */
    private boolean f891g;

    /* renamed from: h reason: collision with root package name */
    private Drawable f892h;

    /* renamed from: i reason: collision with root package name */
    private ColorStateList f893i;

    /* renamed from: j reason: collision with root package name */
    private Mode f894j;

    /* renamed from: k reason: collision with root package name */
    private boolean f895k;

    /* renamed from: l reason: collision with root package name */
    private boolean f896l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private CharSequence q;
    private CharSequence r;
    private boolean s;
    private int t;
    private int u;
    private float v;
    private float w;
    private VelocityTracker x;
    private int y;
    float z;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    private static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private void b() {
        if (this.f892h == null) {
            return;
        }
        if (this.f895k || this.f896l) {
            this.f892h = this.f892h.mutate();
            if (this.f895k) {
                a.a(this.f892h, this.f893i);
            }
            if (this.f896l) {
                a.a(this.f892h, this.f894j);
            }
            if (this.f892h.isStateful()) {
                this.f892h.setState(getDrawableState());
            }
        }
    }

    private void c() {
        ObjectAnimator objectAnimator = this.M;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.z > 0.5f;
    }

    private int getThumbOffset() {
        float f2;
        if (Ga.a(this)) {
            f2 = 1.0f - this.z;
        } else {
            f2 = this.z;
        }
        return (int) ((f2 * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f892h;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.N;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.f887c;
        if (drawable2 != null) {
            rect = K.c(drawable2);
        } else {
            rect = K.f811a;
        }
        return ((((this.A - this.C) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    public void a(Context context, int i2) {
        sa a2 = sa.a(context, i2, j.TextAppearance);
        ColorStateList a3 = a2.a(j.TextAppearance_android_textColor);
        if (a3 != null) {
            this.I = a3;
        } else {
            this.I = getTextColors();
        }
        int c2 = a2.c(j.TextAppearance_android_textSize, 0);
        if (c2 != 0) {
            float f2 = (float) c2;
            if (f2 != this.H.getTextSize()) {
                this.H.setTextSize(f2);
                requestLayout();
            }
        }
        a(a2.d(j.TextAppearance_android_typeface, -1), a2.d(j.TextAppearance_android_textStyle, -1));
        if (a2.a(j.TextAppearance_textAllCaps, false)) {
            this.L = new b.a.c.a(getContext());
        } else {
            this.L = null;
        }
        a2.a();
    }

    public void draw(Canvas canvas) {
        Rect rect;
        int i2;
        int i3;
        Rect rect2 = this.N;
        int i4 = this.D;
        int i5 = this.E;
        int i6 = this.F;
        int i7 = this.G;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f887c;
        if (drawable != null) {
            rect = K.c(drawable);
        } else {
            rect = K.f811a;
        }
        Drawable drawable2 = this.f892h;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i8 = rect2.left;
            thumbOffset += i8;
            if (rect != null) {
                int i9 = rect.left;
                if (i9 > i8) {
                    i4 += i9 - i8;
                }
                int i10 = rect.top;
                int i11 = rect2.top;
                i2 = i10 > i11 ? (i10 - i11) + i5 : i5;
                int i12 = rect.right;
                int i13 = rect2.right;
                if (i12 > i13) {
                    i6 -= i12 - i13;
                }
                int i14 = rect.bottom;
                int i15 = rect2.bottom;
                if (i14 > i15) {
                    i3 = i7 - (i14 - i15);
                    this.f892h.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f892h.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f887c;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i16 = thumbOffset - rect2.left;
            int i17 = thumbOffset + this.C + rect2.right;
            this.f887c.setBounds(i16, i5, i17, i7);
            Drawable background = getBackground();
            if (background != null) {
                a.a(background, i16, i5, i17, i7);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f2, float f3) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.f887c;
        if (drawable != null) {
            a.a(drawable, f2, f3);
        }
        Drawable drawable2 = this.f892h;
        if (drawable2 != null) {
            a.a(drawable2, f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f887c;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f892h;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!Ga.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        if (!TextUtils.isEmpty(getText())) {
            compoundPaddingLeft += this.o;
        }
        return compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (Ga.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        if (!TextUtils.isEmpty(getText())) {
            compoundPaddingRight += this.o;
        }
        return compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.s;
    }

    public boolean getSplitTrack() {
        return this.p;
    }

    public int getSwitchMinWidth() {
        return this.n;
    }

    public int getSwitchPadding() {
        return this.o;
    }

    public CharSequence getTextOff() {
        return this.r;
    }

    public CharSequence getTextOn() {
        return this.q;
    }

    public Drawable getThumbDrawable() {
        return this.f887c;
    }

    public int getThumbTextPadding() {
        return this.m;
    }

    public ColorStateList getThumbTintList() {
        return this.f888d;
    }

    public Mode getThumbTintMode() {
        return this.f889e;
    }

    public Drawable getTrackDrawable() {
        return this.f892h;
    }

    public ColorStateList getTrackTintList() {
        return this.f893i;
    }

    public Mode getTrackTintMode() {
        return this.f894j;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f887c;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f892h;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.M;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.M.end();
            this.M = null;
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, f886b);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        Rect rect = this.N;
        Drawable drawable = this.f892h;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.E + rect.top;
        int i4 = this.G - rect.bottom;
        Drawable drawable2 = this.f887c;
        if (drawable != null) {
            if (!this.p || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect c2 = K.c(drawable2);
                drawable2.copyBounds(rect);
                rect.left += c2.left;
                rect.right -= c2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.J : this.K;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.I;
            if (colorStateList != null) {
                this.H.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.H.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i2 = bounds.left + bounds.right;
            } else {
                i2 = getWidth();
            }
            canvas.translate((float) ((i2 / 2) - (layout.getWidth() / 2)), (float) (((i3 + i4) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.q : this.r;
        if (!TextUtils.isEmpty(charSequence)) {
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        super.onLayout(z2, i2, i3, i4, i5);
        int i12 = 0;
        if (this.f887c != null) {
            Rect rect = this.N;
            Drawable drawable = this.f892h;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect c2 = K.c(this.f887c);
            i6 = Math.max(0, c2.left - rect.left);
            i12 = Math.max(0, c2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (Ga.a(this)) {
            i8 = getPaddingLeft() + i6;
            i7 = ((this.A + i8) - i6) - i12;
        } else {
            i7 = (getWidth() - getPaddingRight()) - i12;
            i8 = (i7 - this.A) + i6 + i12;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i11 = this.B;
            i10 = paddingTop - (i11 / 2);
        } else if (gravity != 80) {
            i10 = getPaddingTop();
            i11 = this.B;
        } else {
            i9 = getHeight() - getPaddingBottom();
            i10 = i9 - this.B;
            this.D = i8;
            this.E = i10;
            this.G = i9;
            this.F = i7;
        }
        i9 = i11 + i10;
        this.D = i8;
        this.E = i10;
        this.G = i9;
        this.F = i7;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.s) {
            if (this.J == null) {
                this.J = a(this.q);
            }
            if (this.K == null) {
                this.K = a(this.r);
            }
        }
        Rect rect = this.N;
        Drawable drawable = this.f887c;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i5 = (this.f887c.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.f887c.getIntrinsicHeight();
        } else {
            i5 = 0;
            i4 = 0;
        }
        this.C = Math.max(this.s ? Math.max(this.J.getWidth(), this.K.getWidth()) + (this.m * 2) : 0, i5);
        Drawable drawable2 = this.f892h;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.f892h.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.f887c;
        if (drawable3 != null) {
            Rect c2 = K.c(drawable3);
            i7 = Math.max(i7, c2.left);
            i8 = Math.max(i8, c2.right);
        }
        int max = Math.max(this.n, (this.C * 2) + i7 + i8);
        int max2 = Math.max(i6, i4);
        this.A = max;
        this.B = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.q : this.r;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00bb;
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i2 = this.t;
                    if (i2 != 0) {
                        if (i2 == 1) {
                            float x2 = motionEvent.getX();
                            float y2 = motionEvent.getY();
                            if (Math.abs(x2 - this.v) > ((float) this.u) || Math.abs(y2 - this.w) > ((float) this.u)) {
                                this.t = 2;
                                getParent().requestDisallowInterceptTouchEvent(true);
                                this.v = x2;
                                this.w = y2;
                                return true;
                            }
                        } else if (i2 == 2) {
                            float x3 = motionEvent.getX();
                            int thumbScrollRange = getThumbScrollRange();
                            float f2 = x3 - this.v;
                            float f3 = thumbScrollRange != 0 ? f2 / ((float) thumbScrollRange) : f2 > 0.0f ? 1.0f : -1.0f;
                            if (Ga.a(this)) {
                                f3 = -f3;
                            }
                            float a2 = a(this.z + f3, 0.0f, 1.0f);
                            if (a2 != this.z) {
                                this.v = x3;
                                setThumbPosition(a2);
                            }
                            return true;
                        }
                    }
                }
            }
            if (this.t == 2) {
                b(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.t = 0;
            this.x.clear();
        } else {
            float x4 = motionEvent.getX();
            float y3 = motionEvent.getY();
            if (isEnabled() && a(x4, y3)) {
                this.t = 1;
                this.v = x4;
                this.w = y3;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z2) {
        super.setChecked(z2);
        boolean isChecked = isChecked();
        if (getWindowToken() == null || !B.C(this)) {
            c();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        a(isChecked);
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(androidx.core.widget.j.a((TextView) this, callback));
    }

    public void setShowText(boolean z2) {
        if (this.s != z2) {
            this.s = z2;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z2) {
        this.p = z2;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.n = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.o = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.H.getTypeface() != null && !this.H.getTypeface().equals(typeface)) || (this.H.getTypeface() == null && typeface != null)) {
            this.H.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.r = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.q = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f887c;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f887c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* access modifiers changed from: 0000 */
    public void setThumbPosition(float f2) {
        this.z = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(b.a.a.a.a.b(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.m = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f888d = colorStateList;
        this.f890f = true;
        a();
    }

    public void setThumbTintMode(Mode mode) {
        this.f889e = mode;
        this.f891g = true;
        a();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f892h;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f892h = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(b.a.a.a.a.b(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f893i = colorStateList;
        this.f895k = true;
        b();
    }

    public void setTrackTintMode(Mode mode) {
        this.f894j = mode;
        this.f896l = true;
        b();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f887c || drawable == this.f892h;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.a.a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f888d = null;
        this.f889e = null;
        this.f890f = false;
        this.f891g = false;
        this.f893i = null;
        this.f894j = null;
        this.f895k = false;
        this.f896l = false;
        this.x = VelocityTracker.obtain();
        this.N = new Rect();
        this.H = new TextPaint(1);
        Resources resources = getResources();
        this.H.density = resources.getDisplayMetrics().density;
        sa a2 = sa.a(context, attributeSet, j.SwitchCompat, i2, 0);
        this.f887c = a2.b(j.SwitchCompat_android_thumb);
        Drawable drawable = this.f887c;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        this.f892h = a2.b(j.SwitchCompat_track);
        Drawable drawable2 = this.f892h;
        if (drawable2 != null) {
            drawable2.setCallback(this);
        }
        this.q = a2.e(j.SwitchCompat_android_textOn);
        this.r = a2.e(j.SwitchCompat_android_textOff);
        this.s = a2.a(j.SwitchCompat_showText, true);
        this.m = a2.c(j.SwitchCompat_thumbTextPadding, 0);
        this.n = a2.c(j.SwitchCompat_switchMinWidth, 0);
        this.o = a2.c(j.SwitchCompat_switchPadding, 0);
        this.p = a2.a(j.SwitchCompat_splitTrack, false);
        ColorStateList a3 = a2.a(j.SwitchCompat_thumbTint);
        if (a3 != null) {
            this.f888d = a3;
            this.f890f = true;
        }
        Mode a4 = K.a(a2.d(j.SwitchCompat_thumbTintMode, -1), null);
        if (this.f889e != a4) {
            this.f889e = a4;
            this.f891g = true;
        }
        if (this.f890f || this.f891g) {
            a();
        }
        ColorStateList a5 = a2.a(j.SwitchCompat_trackTint);
        if (a5 != null) {
            this.f893i = a5;
            this.f895k = true;
        }
        Mode a6 = K.a(a2.d(j.SwitchCompat_trackTintMode, -1), null);
        if (this.f894j != a6) {
            this.f894j = a6;
            this.f896l = true;
        }
        if (this.f895k || this.f896l) {
            b();
        }
        int g2 = a2.g(j.SwitchCompat_switchTextAppearance, 0);
        if (g2 != 0) {
            a(context, g2);
        }
        a2.a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.u = viewConfiguration.getScaledTouchSlop();
        this.y = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private void b(MotionEvent motionEvent) {
        boolean z2;
        this.t = 0;
        boolean z3 = true;
        boolean z4 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z4) {
            this.x.computeCurrentVelocity(1000);
            float xVelocity = this.x.getXVelocity();
            if (Math.abs(xVelocity) > ((float) this.y)) {
                if (!Ga.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z3 = false;
                }
                z2 = z3;
            } else {
                z2 = getTargetCheckedState();
            }
        } else {
            z2 = isChecked;
        }
        if (z2 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z2);
        a(motionEvent);
    }

    private void a(int i2, int i3) {
        Typeface typeface = i2 != 1 ? i2 != 2 ? i2 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
        a(typeface, i3);
    }

    public void a(Typeface typeface, int i2) {
        Typeface typeface2;
        float f2 = 0.0f;
        boolean z2 = false;
        if (i2 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i2);
            } else {
                typeface2 = Typeface.create(typeface, i2);
            }
            setSwitchTypeface(typeface2);
            int i3 = (~(typeface2 != null ? typeface2.getStyle() : 0)) & i2;
            TextPaint textPaint = this.H;
            if ((i3 & 1) != 0) {
                z2 = true;
            }
            textPaint.setFakeBoldText(z2);
            TextPaint textPaint2 = this.H;
            if ((i3 & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint2.setTextSkewX(f2);
            return;
        }
        this.H.setFakeBoldText(false);
        this.H.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    private void a() {
        if (this.f887c == null) {
            return;
        }
        if (this.f890f || this.f891g) {
            this.f887c = this.f887c.mutate();
            if (this.f890f) {
                a.a(this.f887c, this.f888d);
            }
            if (this.f891g) {
                a.a(this.f887c, this.f889e);
            }
            if (this.f887c.isStateful()) {
                this.f887c.setState(getDrawableState());
            }
        }
    }

    private Layout a(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.L;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.H;
        StaticLayout staticLayout = new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        return staticLayout;
    }

    private boolean a(float f2, float f3) {
        boolean z2 = false;
        if (this.f887c == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f887c.getPadding(this.N);
        int i2 = this.E;
        int i3 = this.u;
        int i4 = i2 - i3;
        int i5 = (this.D + thumbOffset) - i3;
        int i6 = this.C + i5;
        Rect rect = this.N;
        int i7 = i6 + rect.left + rect.right + i3;
        int i8 = this.G + i3;
        if (f2 > ((float) i5) && f2 < ((float) i7) && f3 > ((float) i4) && f3 < ((float) i8)) {
            z2 = true;
        }
        return z2;
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void a(boolean z2) {
        this.M = ObjectAnimator.ofFloat(this, f885a, new float[]{z2 ? 1.0f : 0.0f});
        this.M.setDuration(250);
        if (VERSION.SDK_INT >= 18) {
            this.M.setAutoCancel(true);
        }
        this.M.start();
    }
}
