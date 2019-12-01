package e.b.d.f;

import e.b.d.c.i;
import e.b.d.j.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: SpscLinkedArrayQueue */
public final class c<T> implements i<T> {

    /* renamed from: a reason: collision with root package name */
    static final int f8186a = Integer.getInteger("jctools.spsc.max.lookahead.step", CodedOutputStream.DEFAULT_BUFFER_SIZE).intValue();

    /* renamed from: b reason: collision with root package name */
    private static final Object f8187b = new Object();

    /* renamed from: c reason: collision with root package name */
    final AtomicLong f8188c = new AtomicLong();

    /* renamed from: d reason: collision with root package name */
    int f8189d;

    /* renamed from: e reason: collision with root package name */
    long f8190e;

    /* renamed from: f reason: collision with root package name */
    final int f8191f;

    /* renamed from: g reason: collision with root package name */
    AtomicReferenceArray<Object> f8192g;

    /* renamed from: h reason: collision with root package name */
    final int f8193h;

    /* renamed from: i reason: collision with root package name */
    AtomicReferenceArray<Object> f8194i;

    /* renamed from: j reason: collision with root package name */
    final AtomicLong f8195j = new AtomicLong();

    public c(int i2) {
        int a2 = j.a(Math.max(8, i2));
        int i3 = a2 - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(a2 + 1);
        this.f8192g = atomicReferenceArray;
        this.f8191f = i3;
        a(a2);
        this.f8194i = atomicReferenceArray;
        this.f8193h = i3;
        this.f8190e = (long) (i3 - 1);
        b(0);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j2, int i2) {
        a(atomicReferenceArray, i2, (Object) t);
        b(j2 + 1);
        return true;
    }

    private static int b(int i2) {
        return i2;
    }

    private AtomicReferenceArray<Object> b(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        b(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) a(atomicReferenceArray, i2);
        a(atomicReferenceArray, i2, (Object) null);
        return atomicReferenceArray2;
    }

    private long c() {
        return this.f8195j.get();
    }

    private long d() {
        return this.f8188c.get();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return d() == c();
    }

    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f8192g;
            long b2 = b();
            int i2 = this.f8191f;
            int a2 = a(b2, i2);
            if (b2 < this.f8190e) {
                return a(atomicReferenceArray, t, b2, a2);
            }
            long j2 = ((long) this.f8189d) + b2;
            if (a(atomicReferenceArray, a(j2, i2)) == null) {
                this.f8190e = j2 - 1;
                return a(atomicReferenceArray, t, b2, a2);
            } else if (a(atomicReferenceArray, a(1 + b2, i2)) == null) {
                return a(atomicReferenceArray, t, b2, a2);
            } else {
                a(atomicReferenceArray, b2, a2, t, (long) i2);
                return true;
            }
        } else {
            throw new NullPointerException("Null is not a valid element");
        }
    }

    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.f8194i;
        long a2 = a();
        int i2 = this.f8193h;
        int a3 = a(a2, i2);
        T a4 = a(atomicReferenceArray, a3);
        boolean z = a4 == f8187b;
        if (a4 != null && !z) {
            a(atomicReferenceArray, a3, (Object) null);
            a(a2 + 1);
            return a4;
        } else if (z) {
            return a(b(atomicReferenceArray, i2 + 1), a2, i2);
        } else {
            return null;
        }
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2, T t, long j3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.f8192g = atomicReferenceArray2;
        this.f8190e = (j3 + j2) - 1;
        a(atomicReferenceArray2, i2, (Object) t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i2, f8187b);
        b(j2 + 1);
    }

    private long b() {
        return this.f8188c.get();
    }

    private void b(long j2) {
        this.f8188c.lazySet(j2);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        a(atomicReferenceArray, length, (Object) atomicReferenceArray2);
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j2, int i2) {
        this.f8194i = atomicReferenceArray;
        int a2 = a(j2, i2);
        T a3 = a(atomicReferenceArray, a2);
        if (a3 != null) {
            a(atomicReferenceArray, a2, (Object) null);
            a(j2 + 1);
        }
        return a3;
    }

    private void a(int i2) {
        this.f8189d = Math.min(i2 / 4, f8186a);
    }

    private long a() {
        return this.f8195j.get();
    }

    private void a(long j2) {
        this.f8195j.lazySet(j2);
    }

    private static int a(long j2, int i2) {
        int i3 = ((int) j2) & i2;
        b(i3);
        return i3;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }
}
