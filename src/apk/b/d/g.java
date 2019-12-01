package b.d;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map.Entry;

/* compiled from: LruCache */
public class g<K, V> {

    /* renamed from: a reason: collision with root package name */
    private final LinkedHashMap<K, V> f2282a;

    /* renamed from: b reason: collision with root package name */
    private int f2283b;

    /* renamed from: c reason: collision with root package name */
    private int f2284c;

    /* renamed from: d reason: collision with root package name */
    private int f2285d;

    /* renamed from: e reason: collision with root package name */
    private int f2286e;

    /* renamed from: f reason: collision with root package name */
    private int f2287f;

    /* renamed from: g reason: collision with root package name */
    private int f2288g;

    /* renamed from: h reason: collision with root package name */
    private int f2289h;

    public g(int i2) {
        if (i2 > 0) {
            this.f2284c = i2;
            this.f2282a = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int c(K k2, V v) {
        int b2 = b(k2, v);
        if (b2 >= 0) {
            return b2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Negative size: ");
        sb.append(k2);
        sb.append("=");
        sb.append(v);
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public V a(K k2) {
        return null;
    }

    public final V a(K k2, V v) {
        V put;
        if (k2 == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f2285d++;
            this.f2283b += c(k2, v);
            put = this.f2282a.put(k2, v);
            if (put != null) {
                this.f2283b -= c(k2, put);
            }
        }
        if (put != null) {
            a(false, k2, put, v);
        }
        a(this.f2284c);
        return put;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, K k2, V v, V v2) {
    }

    /* access modifiers changed from: protected */
    public int b(K k2, V v) {
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r0 = a(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        if (r0 != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r4.f2286e++;
        r1 = r4.f2282a.put(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        if (r1 == null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
        r4.f2282a.put(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        r4.f2283b += c(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r1 == null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
        a(false, r5, r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        a(r4.f2284c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        return r0;
     */
    public final V b(K k2) {
        if (k2 != null) {
            synchronized (this) {
                V v = this.f2282a.get(k2);
                if (v != null) {
                    this.f2288g++;
                    return v;
                }
                this.f2289h++;
            }
        } else {
            throw new NullPointerException("key == null");
        }
    }

    public final synchronized String toString() {
        int i2;
        i2 = this.f2288g + this.f2289h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f2284c), Integer.valueOf(this.f2288g), Integer.valueOf(this.f2289h), Integer.valueOf(i2 != 0 ? (this.f2288g * 100) / i2 : 0)});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        throw new java.lang.IllegalStateException(r0.toString());
     */
    public void a(int i2) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.f2283b < 0 || (this.f2282a.isEmpty() && this.f2283b != 0)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getClass().getName());
                    sb.append(".sizeOf() is reporting inconsistent results!");
                } else if (this.f2283b > i2) {
                    if (this.f2282a.isEmpty()) {
                        break;
                    }
                    Entry entry = (Entry) this.f2282a.entrySet().iterator().next();
                    key = entry.getKey();
                    value = entry.getValue();
                    this.f2282a.remove(key);
                    this.f2283b -= c(key, value);
                    this.f2287f++;
                }
            }
            a(true, key, value, null);
        }
    }
}
