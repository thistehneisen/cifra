package b.g.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import b.d.i;
import b.g.a.a.c;
import b.g.a.a.c.C0021c;
import b.g.f.f.b;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: TypefaceCompatApi24Impl */
class e extends j {

    /* renamed from: b reason: collision with root package name */
    private static final Class f2507b;

    /* renamed from: c reason: collision with root package name */
    private static final Constructor f2508c;

    /* renamed from: d reason: collision with root package name */
    private static final Method f2509d;

    /* renamed from: e reason: collision with root package name */
    private static final Method f2510e;

    static {
        Method method;
        Method method2;
        Class cls;
        Constructor constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi24Impl", e2.getClass().getName(), e2);
            cls = null;
            method2 = null;
            method = null;
        }
        f2508c = constructor;
        f2507b = cls;
        f2509d = method;
        f2510e = method2;
    }

    e() {
    }

    public static boolean a() {
        if (f2509d == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f2509d != null;
    }

    private static Object b() {
        try {
            return f2508c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        try {
            return ((Boolean) f2509d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private static Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(f2507b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2510e.invoke(null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr, int i2) {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        i iVar = new i();
        for (b bVar : bVarArr) {
            Uri c2 = bVar.c();
            ByteBuffer byteBuffer = (ByteBuffer) iVar.get(c2);
            if (byteBuffer == null) {
                byteBuffer = k.a(context, cancellationSignal, c2);
                iVar.put(c2, byteBuffer);
            }
            if (byteBuffer == null || !a(b2, byteBuffer, bVar.b(), bVar.d(), bVar.e())) {
                return null;
            }
        }
        Typeface a2 = a(b2);
        if (a2 == null) {
            return null;
        }
        return Typeface.create(a2, i2);
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        C0021c[] a2;
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        for (C0021c cVar : bVar.a()) {
            ByteBuffer a3 = k.a(context, resources, cVar.b());
            if (a3 == null || !a(b2, a3, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return a(b2);
    }
}
