package com.bumptech.glide.h;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: LruCache */
public class i<T, Y> {

    /* renamed from: a reason: collision with root package name */
    private final Map<T, Y> f3524a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b reason: collision with root package name */
    private final long f3525b;

    /* renamed from: c reason: collision with root package name */
    private long f3526c;

    /* renamed from: d reason: collision with root package name */
    private long f3527d;

    public i(long j2) {
        this.f3525b = j2;
        this.f3526c = j2;
    }

    public synchronized Y a(T t) {
        return this.f3524a.get(t);
    }

    /* access modifiers changed from: protected */
    public void a(T t, Y y) {
    }

    /* access modifiers changed from: protected */
    public int b(Y y) {
        return 1;
    }

    public synchronized long b() {
        return this.f3526c;
    }

    public synchronized Y c(T t) {
        Y remove;
        remove = this.f3524a.remove(t);
        if (remove != null) {
            this.f3527d -= (long) b(remove);
        }
        return remove;
    }

    public void a() {
        a(0);
    }

    public synchronized Y b(T t, Y y) {
        long b2 = (long) b(y);
        if (b2 >= this.f3526c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.f3527d += b2;
        }
        Y put = this.f3524a.put(t, y);
        if (put != null) {
            this.f3527d -= (long) b(put);
            if (!put.equals(y)) {
                a(t, put);
            }
        }
        c();
        return put;
    }

    /* access modifiers changed from: protected */
    public synchronized void a(long j2) {
        while (this.f3527d > j2) {
            Iterator it = this.f3524a.entrySet().iterator();
            Entry entry = (Entry) it.next();
            Object value = entry.getValue();
            this.f3527d -= (long) b(value);
            Object key = entry.getKey();
            it.remove();
            a(key, value);
        }
    }

    private void c() {
        a(this.f3526c);
    }
}
