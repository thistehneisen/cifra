package b.g.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import b.g.a.a.c.C0021c;
import b.g.a.a.c.b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: TypefaceCompatApi26Impl */
public class f extends d {

    /* renamed from: g reason: collision with root package name */
    protected final Class f2511g;

    /* renamed from: h reason: collision with root package name */
    protected final Constructor f2512h;

    /* renamed from: i reason: collision with root package name */
    protected final Method f2513i;

    /* renamed from: j reason: collision with root package name */
    protected final Method f2514j;

    /* renamed from: k reason: collision with root package name */
    protected final Method f2515k;

    /* renamed from: l reason: collision with root package name */
    protected final Method f2516l;
    protected final Method m;

    public f() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor constructor;
        Method method5;
        Class cls = null;
        try {
            Class a2 = a();
            constructor = e(a2);
            method4 = b(a2);
            method3 = c(a2);
            method2 = f(a2);
            method = a(a2);
            Class cls2 = a2;
            method5 = d(a2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to collect necessary methods for class ");
            sb.append(e2.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", sb.toString(), e2);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f2511g = cls;
        this.f2512h = constructor;
        this.f2513i = method4;
        this.f2514j = method3;
        this.f2515k = method2;
        this.f2516l = method;
        this.m = method5;
    }

    private boolean a(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f2513i.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private void b(Object obj) {
        try {
            this.f2516l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean c() {
        if (this.f2513i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f2513i != null;
    }

    private Object d() {
        try {
            return this.f2512h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Constructor e(Class cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method f(Class cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method b(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    public Method d(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), cls2, cls2});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    private boolean c(Object obj) {
        try {
            return ((Boolean) this.f2515k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.f2514j.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public Method c(Class cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2});
    }

    /* access modifiers changed from: protected */
    public Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f2511g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.m.invoke(null, new Object[]{newInstance, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public Typeface a(Context context, b bVar, Resources resources, int i2) {
        C0021c[] a2;
        if (!c()) {
            return super.a(context, bVar, resources, i2);
        }
        Object d2 = d();
        if (d2 == null) {
            return null;
        }
        for (C0021c cVar : bVar.a()) {
            if (!a(context, d2, cVar.a(), cVar.c(), cVar.e(), cVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                b(d2);
                return null;
            }
        }
        if (!c(d2)) {
            return null;
        }
        return a(d2);
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, b.g.f.f.b[] bVarArr, int i2) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        Throwable th2;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!c()) {
            b.g.f.f.b a2 = a(bVarArr, i2);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.c(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.d()).setItalic(a2.e()).build();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return build;
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    th = r13;
                    th2 = th4;
                }
            } catch (IOException unused) {
                return null;
            }
        } else {
            Map a3 = b.g.f.f.a(context, bVarArr, cancellationSignal);
            Object d2 = d();
            if (d2 == null) {
                return null;
            }
            boolean z = false;
            for (b.g.f.f.b bVar : bVarArr) {
                ByteBuffer byteBuffer = (ByteBuffer) a3.get(bVar.c());
                if (byteBuffer != null) {
                    if (!a(d2, byteBuffer, bVar.b(), bVar.d(), bVar.e() ? 1 : 0)) {
                        b(d2);
                        return null;
                    }
                    z = true;
                }
            }
            if (!z) {
                b(d2);
                return null;
            } else if (!c(d2)) {
                return null;
            } else {
                Typeface a4 = a(d2);
                if (a4 == null) {
                    return null;
                }
                return Typeface.create(a4, i2);
            }
        }
        if (openFileDescriptor != null) {
            if (th != null) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th5) {
                    th.addSuppressed(th5);
                }
            } else {
                openFileDescriptor.close();
            }
        }
        throw th2;
        throw th2;
    }

    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        if (!c()) {
            return super.a(context, resources, i2, str, i3);
        }
        Object d2 = d();
        if (d2 == null) {
            return null;
        }
        if (!a(context, d2, str, 0, -1, -1, null)) {
            b(d2);
            return null;
        } else if (!c(d2)) {
            return null;
        } else {
            return a(d2);
        }
    }

    /* access modifiers changed from: protected */
    public Class a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    /* access modifiers changed from: protected */
    public Method a(Class cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }
}
