package io.intercom.com.bumptech.glide.h;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: LruCache */
public class e<T, Y> {

    /* renamed from: a reason: collision with root package name */
    private final LinkedHashMap<T, Y> f9397a = new LinkedHashMap<>(100, 0.75f, true);

    /* renamed from: b reason: collision with root package name */
    private final long f9398b;

    /* renamed from: c reason: collision with root package name */
    private long f9399c;

    /* renamed from: d reason: collision with root package name */
    private long f9400d = 0;

    public e(long j2) {
        this.f9398b = j2;
        this.f9399c = j2;
    }

    public synchronized Y a(T t) {
        return this.f9397a.get(t);
    }

    /* access modifiers changed from: protected */
    public void a(T t, Y y) {
    }

    /* access modifiers changed from: protected */
    public int b(Y y) {
        return 1;
    }

    public synchronized long b() {
        return this.f9400d;
    }

    public synchronized Y c(T t) {
        Y remove;
        remove = this.f9397a.remove(t);
        if (remove != null) {
            this.f9400d -= (long) b(remove);
        }
        return remove;
    }

    public void a() {
        a(0);
    }

    public synchronized Y b(T t, Y y) {
        if (((long) b(y)) >= this.f9399c) {
            a(t, y);
            return null;
        }
        Y put = this.f9397a.put(t, y);
        if (y != null) {
            this.f9400d += (long) b(y);
        }
        if (put != null) {
            this.f9400d -= (long) b(put);
            if (!put.equals(y)) {
                a(t, put);
            }
        }
        c();
        return put;
    }

    /* access modifiers changed from: protected */
    public synchronized void a(long j2) {
        while (this.f9400d > j2) {
            Iterator it = this.f9397a.entrySet().iterator();
            Entry entry = (Entry) it.next();
            Object value = entry.getValue();
            this.f9400d -= (long) b(value);
            Object key = entry.getKey();
            it.remove();
            a(key, value);
        }
    }

    private void c() {
        a(this.f9399c);
    }
}
