package com.google.android.gms.measurement.internal;

public final class Za<V> {

    /* renamed from: a reason: collision with root package name */
    private static final Object f5780a = new Object();

    /* renamed from: b reason: collision with root package name */
    private final String f5781b;

    /* renamed from: c reason: collision with root package name */
    private final _a<V> f5782c;

    /* renamed from: d reason: collision with root package name */
    private final V f5783d;

    /* renamed from: e reason: collision with root package name */
    private final V f5784e;

    /* renamed from: f reason: collision with root package name */
    private final Object f5785f;

    /* renamed from: g reason: collision with root package name */
    private volatile V f5786g;

    /* renamed from: h reason: collision with root package name */
    private volatile V f5787h;

    private Za(String str, V v, V v2, _a<V> _aVar) {
        this.f5785f = new Object();
        this.f5786g = null;
        this.f5787h = null;
        this.f5781b = str;
        this.f5783d = v;
        this.f5784e = v2;
        this.f5782c = _aVar;
    }

    public final String a() {
        return this.f5781b;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0023, code lost:
        return r0;
     */
    public final V a(V v) {
        synchronized (this.f5785f) {
            V v2 = this.f5786g;
        }
        if (v != null) {
            return v;
        }
        if (C0535l.f6003a == null) {
            return this.f5783d;
        }
        synchronized (f5780a) {
            if (ee.a()) {
                V v3 = this.f5787h == null ? this.f5783d : this.f5787h;
            } else if (!ee.a()) {
                ee eeVar = C0535l.f6003a;
                try {
                    for (Za za : C0535l.f6004b) {
                        synchronized (f5780a) {
                            if (!ee.a()) {
                                za.f5787h = za.f5782c != null ? za.f5782c.get() : null;
                            } else {
                                throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                            }
                        }
                    }
                } catch (SecurityException e2) {
                    C0535l.a((Exception) e2);
                }
            } else {
                throw new IllegalStateException("Tried to refresh flag cache on main thread or on package side.");
            }
        }
        _a<V> _aVar = this.f5782c;
        if (_aVar == null) {
            ee eeVar2 = C0535l.f6003a;
            return this.f5783d;
        }
        try {
            return _aVar.get();
        } catch (SecurityException e3) {
            C0535l.a((Exception) e3);
            ee eeVar3 = C0535l.f6003a;
            return this.f5783d;
        }
    }
}
