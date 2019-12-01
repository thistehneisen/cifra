package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import b.g.b.a;

/* compiled from: ThemeUtils */
class na {

    /* renamed from: a reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f1002a = new ThreadLocal<>();

    /* renamed from: b reason: collision with root package name */
    static final int[] f1003b = {-16842910};

    /* renamed from: c reason: collision with root package name */
    static final int[] f1004c = {16842908};

    /* renamed from: d reason: collision with root package name */
    static final int[] f1005d = {16843518};

    /* renamed from: e reason: collision with root package name */
    static final int[] f1006e = {16842919};

    /* renamed from: f reason: collision with root package name */
    static final int[] f1007f = {16842912};

    /* renamed from: g reason: collision with root package name */
    static final int[] f1008g = {16842913};

    /* renamed from: h reason: collision with root package name */
    static final int[] f1009h = {-16842919, -16842908};

    /* renamed from: i reason: collision with root package name */
    static final int[] f1010i = new int[0];

    /* renamed from: j reason: collision with root package name */
    private static final int[] f1011j = new int[1];

    public static int a(Context context, int i2) {
        ColorStateList c2 = c(context, i2);
        if (c2 != null && c2.isStateful()) {
            return c2.getColorForState(f1003b, c2.getDefaultColor());
        }
        TypedValue a2 = a();
        context.getTheme().resolveAttribute(16842803, a2, true);
        return a(context, i2, a2.getFloat());
    }

    public static int b(Context context, int i2) {
        int[] iArr = f1011j;
        iArr[0] = i2;
        sa a2 = sa.a(context, (AttributeSet) null, iArr);
        try {
            return a2.a(0, 0);
        } finally {
            a2.a();
        }
    }

    public static ColorStateList c(Context context, int i2) {
        int[] iArr = f1011j;
        iArr[0] = i2;
        sa a2 = sa.a(context, (AttributeSet) null, iArr);
        try {
            return a2.a(0);
        } finally {
            a2.a();
        }
    }

    private static TypedValue a() {
        TypedValue typedValue = (TypedValue) f1002a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1002a.set(typedValue2);
        return typedValue2;
    }

    static int a(Context context, int i2, float f2) {
        int b2 = b(context, i2);
        return a.b(b2, Math.round(((float) Color.alpha(b2)) * f2));
    }
}
