package b.a.a.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.C0175o;
import java.util.WeakHashMap;

/* compiled from: AppCompatResources */
public final class a {

    /* renamed from: a reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f2145a = new ThreadLocal<>();

    /* renamed from: b reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0018a>> f2146b = new WeakHashMap<>(0);

    /* renamed from: c reason: collision with root package name */
    private static final Object f2147c = new Object();

    /* renamed from: b.a.a.a.a$a reason: collision with other inner class name */
    /* compiled from: AppCompatResources */
    private static class C0018a {

        /* renamed from: a reason: collision with root package name */
        final ColorStateList f2148a;

        /* renamed from: b reason: collision with root package name */
        final Configuration f2149b;

        C0018a(ColorStateList colorStateList, Configuration configuration) {
            this.f2148a = colorStateList;
            this.f2149b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i2) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList c2 = c(context, i2);
        if (c2 != null) {
            return c2;
        }
        ColorStateList d2 = d(context, i2);
        if (d2 == null) {
            return b.g.a.a.b(context, i2);
        }
        a(context, i2, d2);
        return d2;
    }

    public static Drawable b(Context context, int i2) {
        return C0175o.a().a(context, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0034, code lost:
        return null;
     */
    private static ColorStateList c(Context context, int i2) {
        synchronized (f2147c) {
            SparseArray sparseArray = (SparseArray) f2146b.get(context);
            if (sparseArray != null && sparseArray.size() > 0) {
                C0018a aVar = (C0018a) sparseArray.get(i2);
                if (aVar != null) {
                    if (aVar.f2149b.equals(context.getResources().getConfiguration())) {
                        ColorStateList colorStateList = aVar.f2148a;
                        return colorStateList;
                    }
                    sparseArray.remove(i2);
                }
            }
        }
    }

    private static ColorStateList d(Context context, int i2) {
        if (e(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return b.g.a.a.a.a(resources, resources.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean e(Context context, int i2) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i2, a2, true);
        int i3 = a2.type;
        if (i3 < 28 || i3 > 31) {
            return false;
        }
        return true;
    }

    private static void a(Context context, int i2, ColorStateList colorStateList) {
        synchronized (f2147c) {
            SparseArray sparseArray = (SparseArray) f2146b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f2146b.put(context, sparseArray);
            }
            sparseArray.append(i2, new C0018a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    private static TypedValue a() {
        TypedValue typedValue = (TypedValue) f2145a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f2145a.set(typedValue2);
        return typedValue2;
    }
}
