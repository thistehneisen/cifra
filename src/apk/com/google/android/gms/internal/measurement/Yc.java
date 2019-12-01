package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class Yc {

    /* renamed from: a reason: collision with root package name */
    private static final Logger f5090a = Logger.getLogger(Yc.class.getName());

    /* renamed from: b reason: collision with root package name */
    private static final Unsafe f5091b = c();

    /* renamed from: c reason: collision with root package name */
    private static final Class<?> f5092c = Qa.b();

    /* renamed from: d reason: collision with root package name */
    private static final boolean f5093d = d(Long.TYPE);

    /* renamed from: e reason: collision with root package name */
    private static final boolean f5094e = d(Integer.TYPE);

    /* renamed from: f reason: collision with root package name */
    private static final d f5095f;

    /* renamed from: g reason: collision with root package name */
    private static final boolean f5096g = e();

    /* renamed from: h reason: collision with root package name */
    private static final boolean f5097h = d();

    /* renamed from: i reason: collision with root package name */
    static final long f5098i = ((long) b(byte[].class));

    /* renamed from: j reason: collision with root package name */
    private static final long f5099j = ((long) b(boolean[].class));

    /* renamed from: k reason: collision with root package name */
    private static final long f5100k = ((long) c(boolean[].class));

    /* renamed from: l reason: collision with root package name */
    private static final long f5101l = ((long) b(int[].class));
    private static final long m = ((long) c(int[].class));
    private static final long n = ((long) b(long[].class));
    private static final long o = ((long) c(long[].class));
    private static final long p = ((long) b(float[].class));
    private static final long q = ((long) c(float[].class));
    private static final long r = ((long) b(double[].class));
    private static final long s = ((long) c(double[].class));
    private static final long t = ((long) b(Object[].class));
    private static final long u = ((long) c(Object[].class));
    private static final long v;
    private static final int w = ((int) (f5098i & 7));
    static final boolean x = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        public final void a(long j2, byte b2) {
            Memory.pokeByte((int) (j2 & -1), b2);
        }

        public final boolean c(Object obj, long j2) {
            if (Yc.x) {
                return Yc.m(obj, j2);
            }
            return Yc.n(obj, j2);
        }

        public final float d(Object obj, long j2) {
            return Float.intBitsToFloat(a(obj, j2));
        }

        public final double e(Object obj, long j2) {
            return Double.longBitsToDouble(b(obj, j2));
        }

        public final byte f(Object obj, long j2) {
            if (Yc.x) {
                return Yc.k(obj, j2);
            }
            return Yc.l(obj, j2);
        }

        public final void a(Object obj, long j2, byte b2) {
            if (Yc.x) {
                Yc.c(obj, j2, b2);
            } else {
                Yc.d(obj, j2, b2);
            }
        }

        public final void a(Object obj, long j2, boolean z) {
            if (Yc.x) {
                Yc.d(obj, j2, z);
            } else {
                Yc.e(obj, j2, z);
            }
        }

        public final void a(Object obj, long j2, float f2) {
            a(obj, j2, Float.floatToIntBits(f2));
        }

        public final void a(Object obj, long j2, double d2) {
            a(obj, j2, Double.doubleToLongBits(d2));
        }

        public final void a(byte[] bArr, long j2, long j3, long j4) {
            Memory.pokeByteArray((int) (j3 & -1), bArr, (int) j2, (int) j4);
        }
    }

    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        public final void a(long j2, byte b2) {
            this.f5102a.putByte(j2, b2);
        }

        public final boolean c(Object obj, long j2) {
            return this.f5102a.getBoolean(obj, j2);
        }

        public final float d(Object obj, long j2) {
            return this.f5102a.getFloat(obj, j2);
        }

        public final double e(Object obj, long j2) {
            return this.f5102a.getDouble(obj, j2);
        }

        public final byte f(Object obj, long j2) {
            return this.f5102a.getByte(obj, j2);
        }

        public final void a(Object obj, long j2, byte b2) {
            this.f5102a.putByte(obj, j2, b2);
        }

        public final void a(Object obj, long j2, boolean z) {
            this.f5102a.putBoolean(obj, j2, z);
        }

        public final void a(Object obj, long j2, float f2) {
            this.f5102a.putFloat(obj, j2, f2);
        }

        public final void a(Object obj, long j2, double d2) {
            this.f5102a.putDouble(obj, j2, d2);
        }

        public final void a(byte[] bArr, long j2, long j3, long j4) {
            this.f5102a.copyMemory(bArr, Yc.f5098i + j2, null, j3, j4);
        }
    }

    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        public final void a(long j2, byte b2) {
            Memory.pokeByte(j2, b2);
        }

        public final boolean c(Object obj, long j2) {
            if (Yc.x) {
                return Yc.m(obj, j2);
            }
            return Yc.n(obj, j2);
        }

        public final float d(Object obj, long j2) {
            return Float.intBitsToFloat(a(obj, j2));
        }

        public final double e(Object obj, long j2) {
            return Double.longBitsToDouble(b(obj, j2));
        }

        public final byte f(Object obj, long j2) {
            if (Yc.x) {
                return Yc.k(obj, j2);
            }
            return Yc.l(obj, j2);
        }

        public final void a(Object obj, long j2, byte b2) {
            if (Yc.x) {
                Yc.c(obj, j2, b2);
            } else {
                Yc.d(obj, j2, b2);
            }
        }

        public final void a(Object obj, long j2, boolean z) {
            if (Yc.x) {
                Yc.d(obj, j2, z);
            } else {
                Yc.e(obj, j2, z);
            }
        }

        public final void a(Object obj, long j2, float f2) {
            a(obj, j2, Float.floatToIntBits(f2));
        }

        public final void a(Object obj, long j2, double d2) {
            a(obj, j2, Double.doubleToLongBits(d2));
        }

        public final void a(byte[] bArr, long j2, long j3, long j4) {
            Memory.pokeByteArray(j3, bArr, (int) j2, (int) j4);
        }
    }

    static abstract class d {

        /* renamed from: a reason: collision with root package name */
        Unsafe f5102a;

        d(Unsafe unsafe) {
            this.f5102a = unsafe;
        }

        public final int a(Object obj, long j2) {
            return this.f5102a.getInt(obj, j2);
        }

        public abstract void a(long j2, byte b2);

        public abstract void a(Object obj, long j2, byte b2);

        public abstract void a(Object obj, long j2, double d2);

        public abstract void a(Object obj, long j2, float f2);

        public abstract void a(Object obj, long j2, boolean z);

        public abstract void a(byte[] bArr, long j2, long j3, long j4);

        public final long b(Object obj, long j2) {
            return this.f5102a.getLong(obj, j2);
        }

        public abstract boolean c(Object obj, long j2);

        public abstract float d(Object obj, long j2);

        public abstract double e(Object obj, long j2);

        public abstract byte f(Object obj, long j2);

        public final void a(Object obj, long j2, int i2) {
            this.f5102a.putInt(obj, j2, i2);
        }

        public final void a(Object obj, long j2, long j3) {
            this.f5102a.putLong(obj, j2, j3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fe  */
    static {
        long j2;
        d dVar = null;
        if (f5091b != null) {
            if (!Qa.a()) {
                dVar = new b(f5091b);
            } else if (f5093d) {
                dVar = new c(f5091b);
            } else if (f5094e) {
                dVar = new a(f5091b);
            }
        }
        f5095f = dVar;
        Field f2 = f();
        if (f2 != null) {
            d dVar2 = f5095f;
            if (dVar2 != null) {
                j2 = dVar2.f5102a.objectFieldOffset(f2);
                v = j2;
            }
        }
        j2 = -1;
        v = j2;
    }

    private Yc() {
    }

    static boolean a() {
        return f5097h;
    }

    static boolean b() {
        return f5096g;
    }

    private static int c(Class<?> cls) {
        if (f5097h) {
            return f5095f.f5102a.arrayIndexScale(cls);
        }
        return -1;
    }

    static float d(Object obj, long j2) {
        return f5095f.d(obj, j2);
    }

    static double e(Object obj, long j2) {
        return f5095f.e(obj, j2);
    }

    static Object f(Object obj, long j2) {
        return f5095f.f5102a.getObject(obj, j2);
    }

    /* access modifiers changed from: private */
    public static byte k(Object obj, long j2) {
        return (byte) (a(obj, -4 & j2) >>> ((int) (((~j2) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte l(Object obj, long j2) {
        return (byte) (a(obj, -4 & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean m(Object obj, long j2) {
        return k(obj, j2) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean n(Object obj, long j2) {
        return l(obj, j2) != 0;
    }

    static <T> T a(Class<T> cls) {
        try {
            return f5091b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int b(Class<?> cls) {
        if (f5097h) {
            return f5095f.f5102a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static boolean d() {
        Unsafe unsafe = f5091b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (Qa.a()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = f5090a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean e() {
        String str = "copyMemory";
        String str2 = "getLong";
        Unsafe unsafe = f5091b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod(str2, new Class[]{Object.class, Long.TYPE});
            if (f() == null) {
                return false;
            }
            if (Qa.a()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod(str2, new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod(str, new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger = f5090a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    static boolean c(Object obj, long j2) {
        return f5095f.c(obj, j2);
    }

    private static Field f() {
        if (Qa.a()) {
            Field a2 = a(Buffer.class, "effectiveDirectAddress");
            if (a2 != null) {
                return a2;
            }
        }
        Field a3 = a(Buffer.class, "address");
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
    }

    static int a(Object obj, long j2) {
        return f5095f.a(obj, j2);
    }

    static long b(Object obj, long j2) {
        return f5095f.b(obj, j2);
    }

    static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new _c());
        } catch (Throwable unused) {
            return null;
        }
    }

    static void a(Object obj, long j2, int i2) {
        f5095f.a(obj, j2, i2);
    }

    static void a(Object obj, long j2, long j3) {
        f5095f.a(obj, j2, j3);
    }

    /* access modifiers changed from: private */
    public static void c(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = ((~((int) j2)) & 3) << 3;
        int i3 = (255 & b2) << i2;
        a(obj, j3, i3 | (a(obj, j3) & (~(255 << i2))));
    }

    static void a(Object obj, long j2, boolean z) {
        f5095f.a(obj, j2, z);
    }

    static void a(Object obj, long j2, float f2) {
        f5095f.a(obj, j2, f2);
    }

    static void a(Object obj, long j2, double d2) {
        f5095f.a(obj, j2, d2);
    }

    static void a(Object obj, long j2, Object obj2) {
        f5095f.f5102a.putObject(obj, j2, obj2);
    }

    static byte a(byte[] bArr, long j2) {
        return f5095f.f(bArr, f5098i + j2);
    }

    static void a(byte[] bArr, long j2, byte b2) {
        f5095f.a((Object) bArr, f5098i + j2, b2);
    }

    static void a(byte[] bArr, long j2, long j3, long j4) {
        f5095f.a(bArr, j2, j3, j4);
    }

    static void a(long j2, byte b2) {
        f5095f.a(j2, b2);
    }

    static long a(ByteBuffer byteBuffer) {
        return f5095f.b(byteBuffer, v);
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void e(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : 0);
    }

    private static boolean d(Class<?> cls) {
        if (!Qa.a()) {
            return false;
        }
        try {
            Class<?> cls2 = f5092c;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static void d(Object obj, long j2, byte b2) {
        long j3 = -4 & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & (~(255 << i2))));
    }

    /* access modifiers changed from: private */
    public static void d(Object obj, long j2, boolean z) {
        c(obj, j2, z ? (byte) 1 : 0);
    }
}
