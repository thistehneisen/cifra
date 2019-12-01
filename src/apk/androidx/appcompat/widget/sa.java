package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import b.a.a.a.a;
import b.g.a.a.h;

/* compiled from: TintTypedArray */
public class sa {

    /* renamed from: a reason: collision with root package name */
    private final Context f1041a;

    /* renamed from: b reason: collision with root package name */
    private final TypedArray f1042b;

    /* renamed from: c reason: collision with root package name */
    private TypedValue f1043c;

    private sa(Context context, TypedArray typedArray) {
        this.f1041a = context;
        this.f1042b = typedArray;
    }

    public static sa a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new sa(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public Drawable b(int i2) {
        if (this.f1042b.hasValue(i2)) {
            int resourceId = this.f1042b.getResourceId(i2, 0);
            if (resourceId != 0) {
                return a.b(this.f1041a, resourceId);
            }
        }
        return this.f1042b.getDrawable(i2);
    }

    public Drawable c(int i2) {
        if (this.f1042b.hasValue(i2)) {
            int resourceId = this.f1042b.getResourceId(i2, 0);
            if (resourceId != 0) {
                return C0175o.a().a(this.f1041a, resourceId, true);
            }
        }
        return null;
    }

    public String d(int i2) {
        return this.f1042b.getString(i2);
    }

    public CharSequence e(int i2) {
        return this.f1042b.getText(i2);
    }

    public int f(int i2, int i3) {
        return this.f1042b.getLayoutDimension(i2, i3);
    }

    public int g(int i2, int i3) {
        return this.f1042b.getResourceId(i2, i3);
    }

    public static sa a(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new sa(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public int d(int i2, int i3) {
        return this.f1042b.getInt(i2, i3);
    }

    public int e(int i2, int i3) {
        return this.f1042b.getInteger(i2, i3);
    }

    public CharSequence[] f(int i2) {
        return this.f1042b.getTextArray(i2);
    }

    public boolean g(int i2) {
        return this.f1042b.hasValue(i2);
    }

    public static sa a(Context context, int i2, int[] iArr) {
        return new sa(context, context.obtainStyledAttributes(i2, iArr));
    }

    public int c(int i2, int i3) {
        return this.f1042b.getDimensionPixelSize(i2, i3);
    }

    public Typeface a(int i2, int i3, h.a aVar) {
        int resourceId = this.f1042b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1043c == null) {
            this.f1043c = new TypedValue();
        }
        return h.a(this.f1041a, resourceId, this.f1043c, i3, aVar);
    }

    public int b(int i2, int i3) {
        return this.f1042b.getDimensionPixelOffset(i2, i3);
    }

    public boolean a(int i2, boolean z) {
        return this.f1042b.getBoolean(i2, z);
    }

    public float a(int i2, float f2) {
        return this.f1042b.getFloat(i2, f2);
    }

    public int a(int i2, int i3) {
        return this.f1042b.getColor(i2, i3);
    }

    public ColorStateList a(int i2) {
        if (this.f1042b.hasValue(i2)) {
            int resourceId = this.f1042b.getResourceId(i2, 0);
            if (resourceId != 0) {
                ColorStateList a2 = a.a(this.f1041a, resourceId);
                if (a2 != null) {
                    return a2;
                }
            }
        }
        return this.f1042b.getColorStateList(i2);
    }

    public void a() {
        this.f1042b.recycle();
    }
}
