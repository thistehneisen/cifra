package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import b.g.i.B;

public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a reason: collision with root package name */
    private TypedValue f752a;

    /* renamed from: b reason: collision with root package name */
    private TypedValue f753b;

    /* renamed from: c reason: collision with root package name */
    private TypedValue f754c;

    /* renamed from: d reason: collision with root package name */
    private TypedValue f755d;

    /* renamed from: e reason: collision with root package name */
    private TypedValue f756e;

    /* renamed from: f reason: collision with root package name */
    private TypedValue f757f;

    /* renamed from: g reason: collision with root package name */
    private final Rect f758g;

    /* renamed from: h reason: collision with root package name */
    private a f759h;

    public interface a {
        void a();

        void onDetachedFromWindow();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public void a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f756e == null) {
            this.f756e = new TypedValue();
        }
        return this.f756e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f757f == null) {
            this.f757f = new TypedValue();
        }
        return this.f757f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f754c == null) {
            this.f754c = new TypedValue();
        }
        return this.f754c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f755d == null) {
            this.f755d = new TypedValue();
        }
        return this.f755d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f752a == null) {
            this.f752a = new TypedValue();
        }
        return this.f752a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f753b == null) {
            this.f753b = new TypedValue();
        }
        return this.f753b;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f759h;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f759h;
        if (aVar != null) {
            aVar.onDetachedFromWindow();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int i4;
        TypedValue typedValue;
        int i5;
        float fraction;
        int i6;
        float fraction2;
        int i7;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = MeasureSpec.getMode(i2);
        int mode2 = MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.f755d : this.f754c;
            if (typedValue2 != null) {
                int i8 = typedValue2.type;
                if (i8 != 0) {
                    if (i8 == 5) {
                        fraction3 = typedValue2.getDimension(displayMetrics);
                    } else if (i8 == 6) {
                        int i9 = displayMetrics.widthPixels;
                        fraction3 = typedValue2.getFraction((float) i9, (float) i9);
                    } else {
                        i7 = 0;
                        if (i7 > 0) {
                            Rect rect = this.f758g;
                            i4 = MeasureSpec.makeMeasureSpec(Math.min(i7 - (rect.left + rect.right), MeasureSpec.getSize(i2)), 1073741824);
                            z = true;
                            if (mode2 == Integer.MIN_VALUE) {
                                TypedValue typedValue3 = z3 ? this.f756e : this.f757f;
                                if (typedValue3 != null) {
                                    int i10 = typedValue3.type;
                                    if (i10 != 0) {
                                        if (i10 == 5) {
                                            fraction2 = typedValue3.getDimension(displayMetrics);
                                        } else if (i10 == 6) {
                                            int i11 = displayMetrics.heightPixels;
                                            fraction2 = typedValue3.getFraction((float) i11, (float) i11);
                                        } else {
                                            i6 = 0;
                                            if (i6 > 0) {
                                                Rect rect2 = this.f758g;
                                                i3 = MeasureSpec.makeMeasureSpec(Math.min(i6 - (rect2.top + rect2.bottom), MeasureSpec.getSize(i3)), 1073741824);
                                            }
                                        }
                                        i6 = (int) fraction2;
                                        if (i6 > 0) {
                                        }
                                    }
                                }
                            }
                            super.onMeasure(i4, i3);
                            int measuredWidth = getMeasuredWidth();
                            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
                            if (!z && mode == Integer.MIN_VALUE) {
                                typedValue = !z3 ? this.f753b : this.f752a;
                                if (typedValue != null) {
                                    int i12 = typedValue.type;
                                    if (i12 != 0) {
                                        if (i12 == 5) {
                                            fraction = typedValue.getDimension(displayMetrics);
                                        } else if (i12 == 6) {
                                            int i13 = displayMetrics.widthPixels;
                                            fraction = typedValue.getFraction((float) i13, (float) i13);
                                        } else {
                                            i5 = 0;
                                            if (i5 > 0) {
                                                Rect rect3 = this.f758g;
                                                i5 -= rect3.left + rect3.right;
                                            }
                                            if (measuredWidth < i5) {
                                                makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, 1073741824);
                                                if (z2) {
                                                    super.onMeasure(makeMeasureSpec, i3);
                                                    return;
                                                }
                                                return;
                                            }
                                        }
                                        i5 = (int) fraction;
                                        if (i5 > 0) {
                                        }
                                        if (measuredWidth < i5) {
                                        }
                                    }
                                }
                            }
                            z2 = false;
                            if (z2) {
                            }
                        }
                    }
                    i7 = (int) fraction3;
                    if (i7 > 0) {
                    }
                }
            }
        }
        i4 = i2;
        z = false;
        if (mode2 == Integer.MIN_VALUE) {
        }
        super.onMeasure(i4, i3);
        int measuredWidth2 = getMeasuredWidth();
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(measuredWidth2, 1073741824);
        if (!z3) {
        }
        if (typedValue != null) {
        }
        z2 = false;
        if (z2) {
        }
    }

    public void setAttachListener(a aVar) {
        this.f759h = aVar;
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f758g.set(i2, i3, i4, i5);
        if (B.C(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f758g = new Rect();
    }
}
