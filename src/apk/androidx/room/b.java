package androidx.room;

import android.util.Log;
import b.d.d;
import b.o.a.f;
import java.util.Arrays;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: InvalidationTracker */
public class b {

    /* renamed from: a reason: collision with root package name */
    private static final String[] f2029a = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: b reason: collision with root package name */
    b.d.b<String, Integer> f2030b;

    /* renamed from: c reason: collision with root package name */
    private String[] f2031c;

    /* renamed from: d reason: collision with root package name */
    long[] f2032d;

    /* renamed from: e reason: collision with root package name */
    Object[] f2033e = new Object[1];

    /* renamed from: f reason: collision with root package name */
    long f2034f = 0;

    /* renamed from: g reason: collision with root package name */
    final c f2035g;

    /* renamed from: h reason: collision with root package name */
    AtomicBoolean f2036h;

    /* renamed from: i reason: collision with root package name */
    private volatile boolean f2037i;

    /* renamed from: j reason: collision with root package name */
    volatile f f2038j;

    /* renamed from: k reason: collision with root package name */
    private a f2039k;

    /* renamed from: l reason: collision with root package name */
    final b.b.a.b.b<C0015b, c> f2040l;
    Runnable m;

    /* compiled from: InvalidationTracker */
    static class a {

        /* renamed from: a reason: collision with root package name */
        final long[] f2041a;

        /* renamed from: b reason: collision with root package name */
        final boolean[] f2042b;

        /* renamed from: c reason: collision with root package name */
        final int[] f2043c;

        a(int i2) {
            this.f2041a = new long[i2];
            this.f2042b = new boolean[i2];
            this.f2043c = new int[i2];
            Arrays.fill(this.f2041a, 0);
            Arrays.fill(this.f2042b, false);
        }
    }

    /* renamed from: androidx.room.b$b reason: collision with other inner class name */
    /* compiled from: InvalidationTracker */
    public static abstract class C0015b {
        public abstract void a(Set<String> set);
    }

    /* compiled from: InvalidationTracker */
    static class c {

        /* renamed from: a reason: collision with root package name */
        final int[] f2044a;

        /* renamed from: b reason: collision with root package name */
        private final String[] f2045b;

        /* renamed from: c reason: collision with root package name */
        private final long[] f2046c;

        /* renamed from: d reason: collision with root package name */
        final C0015b f2047d;

        /* renamed from: e reason: collision with root package name */
        private final Set<String> f2048e;

        /* access modifiers changed from: 0000 */
        public void a(long[] jArr) {
            int length = this.f2044a.length;
            Set set = null;
            for (int i2 = 0; i2 < length; i2++) {
                long j2 = jArr[this.f2044a[i2]];
                long[] jArr2 = this.f2046c;
                if (jArr2[i2] < j2) {
                    jArr2[i2] = j2;
                    if (length == 1) {
                        set = this.f2048e;
                    } else {
                        if (set == null) {
                            set = new d(length);
                        }
                        set.add(this.f2045b[i2]);
                    }
                }
            }
            if (set != null) {
                this.f2047d.a(set);
            }
        }
    }

    public b(c cVar, String... strArr) {
        this.f2036h = new AtomicBoolean(false);
        this.f2037i = false;
        this.f2040l = new b.b.a.b.b<>();
        this.m = new a(this);
        this.f2035g = cVar;
        this.f2039k = new a(strArr.length);
        this.f2030b = new b.d.b<>();
        int length = strArr.length;
        this.f2031c = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String lowerCase = strArr[i2].toLowerCase(Locale.US);
            this.f2030b.put(lowerCase, Integer.valueOf(i2));
            this.f2031c[i2] = lowerCase;
        }
        this.f2032d = new long[strArr.length];
        Arrays.fill(this.f2032d, 0);
    }

    /* access modifiers changed from: 0000 */
    public boolean a() {
        if (!this.f2035g.e()) {
            return false;
        }
        if (!this.f2037i) {
            this.f2035g.c().a();
        }
        if (this.f2037i) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }
}
