package b.g.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import b.g.a.a.c.C0021c;
import b.g.a.a.c.b;
import b.g.f.f;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TypefaceCompatBaseImpl */
class j {

    /* renamed from: a reason: collision with root package name */
    private ConcurrentHashMap<Long, b> f2519a = new ConcurrentHashMap<>();

    /* compiled from: TypefaceCompatBaseImpl */
    private interface a<T> {
        int a(T t);

        boolean b(T t);
    }

    j() {
    }

    private static <T> T a(T[] tArr, int i2, a<T> aVar) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z = (i2 & 2) != 0;
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(aVar.a(t2) - i3) * 2) + (aVar.b(t2) == z ? 0 : 1);
            if (t == null || i4 > abs) {
                t = t2;
                i4 = abs;
            }
        }
        return t;
    }

    private static long a(Typeface typeface) {
        String str = "Could not retrieve font from family.";
        String str2 = "TypefaceCompatBaseImpl";
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e2) {
            Log.e(str2, str, e2);
            return 0;
        } catch (IllegalAccessException e3) {
            Log.e(str2, str, e3);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public f.b a(f.b[] bVarArr, int i2) {
        return (f.b) a(bVarArr, i2, new h(this));
    }

    /* access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!k.a(a2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(bVarArr, i2).c());
            try {
                Typeface a2 = a(context, inputStream);
                k.a((Closeable) inputStream);
                return a2;
            } catch (IOException unused) {
                k.a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                k.a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            k.a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            k.a((Closeable) inputStream2);
            throw th;
        }
    }

    private C0021c a(b bVar, int i2) {
        return (C0021c) a(bVar.a(), i2, new i(this));
    }

    public Typeface a(Context context, b bVar, Resources resources, int i2) {
        C0021c a2 = a(bVar, i2);
        if (a2 == null) {
            return null;
        }
        Typeface a3 = c.a(context, resources, a2.b(), a2.a(), i2);
        a(a3, bVar);
        return a3;
    }

    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!k.a(a2, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    private void a(Typeface typeface, b bVar) {
        long a2 = a(typeface);
        if (a2 != 0) {
            this.f2519a.put(Long.valueOf(a2), bVar);
        }
    }
}
