package b.g.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import android.os.Handler;
import b.d.g;
import b.g.a.a.c.a;
import b.g.a.a.c.b;
import b.g.a.a.c.d;
import b.g.a.a.h;
import b.g.f.f;

/* compiled from: TypefaceCompat */
public class c {

    /* renamed from: a reason: collision with root package name */
    private static final j f2500a;

    /* renamed from: b reason: collision with root package name */
    private static final g<String, Typeface> f2501b = new g<>(16);

    static {
        int i2 = VERSION.SDK_INT;
        if (i2 >= 28) {
            f2500a = new g();
        } else if (i2 >= 26) {
            f2500a = new f();
        } else if (i2 >= 24 && e.a()) {
            f2500a = new e();
        } else if (VERSION.SDK_INT >= 21) {
            f2500a = new d();
        } else {
            f2500a = new j();
        }
    }

    public static Typeface a(Resources resources, int i2, int i3) {
        return (Typeface) f2501b.b(b(resources, i2, i3));
    }

    private static String b(Resources resources, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(resources.getResourcePackageName(i2));
        String str = "-";
        sb.append(str);
        sb.append(i2);
        sb.append(str);
        sb.append(i3);
        return sb.toString();
    }

    public static Typeface a(Context context, a aVar, Resources resources, int i2, int i3, h.a aVar2, Handler handler, boolean z) {
        Typeface typeface;
        if (aVar instanceof d) {
            d dVar = (d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.a() == 0) {
                z2 = true;
            }
            typeface = f.a(context, dVar.b(), aVar2, handler, z2, z ? dVar.c() : -1, i3);
        } else {
            typeface = f2500a.a(context, (b) aVar, resources, i3);
            if (aVar2 != null) {
                if (typeface != null) {
                    aVar2.a(typeface, handler);
                } else {
                    aVar2.a(-3, handler);
                }
            }
        }
        if (typeface != null) {
            f2501b.a(b(resources, i2, i3), typeface);
        }
        return typeface;
    }

    public static Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        Typeface a2 = f2500a.a(context, resources, i2, str, i3);
        if (a2 != null) {
            f2501b.a(b(resources, i2, i3), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        return f2500a.a(context, cancellationSignal, bVarArr, i2);
    }
}
