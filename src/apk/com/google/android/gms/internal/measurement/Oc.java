package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class Oc implements Iterator<Entry<K, V>> {

    /* renamed from: a reason: collision with root package name */
    private int f4999a;

    /* renamed from: b reason: collision with root package name */
    private boolean f5000b;

    /* renamed from: c reason: collision with root package name */
    private Iterator<Entry<K, V>> f5001c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Gc f5002d;

    private Oc(Gc gc) {
        this.f5002d = gc;
        this.f4999a = -1;
    }

    private final Iterator<Entry<K, V>> a() {
        if (this.f5001c == null) {
            this.f5001c = this.f5002d.f4948c.entrySet().iterator();
        }
        return this.f5001c;
    }

    public final boolean hasNext() {
        if (this.f4999a + 1 < this.f5002d.f4947b.size() || (!this.f5002d.f4948c.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ Object next() {
        this.f5000b = true;
        int i2 = this.f4999a + 1;
        this.f4999a = i2;
        if (i2 < this.f5002d.f4947b.size()) {
            return (Entry) this.f5002d.f4947b.get(this.f4999a);
        }
        return (Entry) a().next();
    }

    public final void remove() {
        if (this.f5000b) {
            this.f5000b = false;
            this.f5002d.f();
            if (this.f4999a < this.f5002d.f4947b.size()) {
                Gc gc = this.f5002d;
                int i2 = this.f4999a;
                this.f4999a = i2 - 1;
                gc.c(i2);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* synthetic */ Oc(Gc gc, Fc fc) {
        this(gc);
    }
}
