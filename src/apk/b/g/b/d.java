package b.g.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import b.g.a.a.c;
import b.g.a.a.c.C0021c;
import b.g.f.f.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: TypefaceCompatApi21Impl */
class d extends j {

    /* renamed from: b reason: collision with root package name */
    private static Class f2502b = null;

    /* renamed from: c reason: collision with root package name */
    private static Constructor f2503c = null;

    /* renamed from: d reason: collision with root package name */
    private static Method f2504d = null;

    /* renamed from: e reason: collision with root package name */
    private static Method f2505e = null;

    /* renamed from: f reason: collision with root package name */
    private static boolean f2506f = false;

    d() {
    }

    private static void a() {
        Method method;
        Class cls;
        Method method2;
        if (!f2506f) {
            f2506f = true;
            Constructor constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
                method2 = null;
                cls = null;
                method = null;
            }
            f2503c = constructor;
            f2502b = cls;
            f2504d = method;
            f2505e = method2;
        }
    }

    private static Object b() {
        a();
        try {
            return f2503c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("/proc/self/fd/");
            sb.append(parcelFileDescriptor.getFd());
            String readlink = Os.readlink(sb.toString());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static Typeface a(Object obj) {
        a();
        try {
            Object newInstance = Array.newInstance(f2502b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f2505e.invoke(null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static boolean a(Object obj, String str, int i2, boolean z) {
        a();
        try {
            return ((Boolean) f2504d.invoke(obj, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0065, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0066, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x006a, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x006b, code lost:
        r3 = r7;
        r7 = r5;
        r5 = r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0065 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0020] */
    public Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr, int i2) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        Throwable th2;
        FileInputStream fileInputStream;
        Throwable th3;
        Throwable th4;
        if (bVarArr.length < 1) {
            return null;
        }
        b a2 = a(bVarArr, i2);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.c(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File a3 = a(openFileDescriptor);
                if (a3 != null) {
                    if (a3.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(a3);
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                        }
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    Typeface a4 = super.a(context, (InputStream) fileInputStream);
                    fileInputStream.close();
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return a4;
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    th3 = r5;
                    th4 = th6;
                }
            } catch (Throwable th7) {
            }
        } catch (IOException unused) {
            return null;
        }
        throw th4;
        if (th3 != null) {
            fileInputStream.close();
        } else {
            fileInputStream.close();
        }
        throw th4;
        if (openFileDescriptor != null) {
            if (th != null) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th8) {
                    th.addSuppressed(th8);
                }
            } else {
                openFileDescriptor.close();
            }
        }
        throw th2;
        throw th2;
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        Object b2 = b();
        C0021c[] a2 = bVar.a();
        int length = a2.length;
        int i3 = 0;
        while (i3 < length) {
            C0021c cVar = a2[i3];
            File a3 = k.a(context);
            if (a3 == null) {
                return null;
            }
            try {
                if (!k.a(a3, resources, cVar.b())) {
                    a3.delete();
                    return null;
                } else if (!a(b2, a3.getPath(), cVar.e(), cVar.f())) {
                    return null;
                } else {
                    a3.delete();
                    i3++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                a3.delete();
            }
        }
        return a(b2);
    }
}
