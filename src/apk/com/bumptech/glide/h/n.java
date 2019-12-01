package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import com.bumptech.glide.load.b.r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: Util */
public final class n {

    /* renamed from: a reason: collision with root package name */
    private static final char[] f3533a = "0123456789abcdef".toCharArray();

    /* renamed from: b reason: collision with root package name */
    private static final char[] f3534b = new char[64];

    public static int a(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    public static String a(byte[] bArr) {
        String a2;
        synchronized (f3534b) {
            a2 = a(bArr, f3534b);
        }
        return a2;
    }

    private static boolean b(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean b(int i2, int i3) {
        return b(i2) && b(i3);
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean b() {
        return !c();
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static String a(byte[] bArr, char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b2 = bArr[i2] & 255;
            int i3 = i2 * 2;
            char[] cArr2 = f3533a;
            cArr[i3] = cArr2[b2 >>> 4];
            cArr[i3 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Cannot obtain size for recycled Bitmap: ");
        sb.append(bitmap);
        sb.append("[");
        sb.append(bitmap.getWidth());
        sb.append("x");
        sb.append(bitmap.getHeight());
        sb.append("] ");
        sb.append(bitmap.getConfig());
        throw new IllegalStateException(sb.toString());
    }

    public static int a(int i2, int i3, Config config) {
        return i2 * i3 * a(config);
    }

    private static int a(Config config) {
        if (config == null) {
            config = Config.ARGB_8888;
        }
        int i2 = m.f3532a[config.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2 || i2 == 3) {
            return 2;
        }
        return i2 != 4 ? 4 : 8;
    }

    public static void a() {
        if (!c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static <T> Queue<T> a(int i2) {
        return new ArrayDeque(i2);
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof r) {
            return ((r) obj).a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    public static int a(float f2) {
        return a(f2, 17);
    }

    public static int a(float f2, int i2) {
        return a(Float.floatToIntBits(f2), i2);
    }

    public static int a(Object obj, int i2) {
        return a(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static int a(boolean z, int i2) {
        return a(z ? 1 : 0, i2);
    }
}
