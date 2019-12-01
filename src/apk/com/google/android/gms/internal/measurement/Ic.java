package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class Ic implements Iterator<Entry<K, V>> {

    /* renamed from: a reason: collision with root package name */
    private int f4967a;

    /* renamed from: b reason: collision with root package name */
    private Iterator<Entry<K, V>> f4968b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Gc f4969c;

    private Ic(Gc gc) {
        this.f4969c = gc;
        this.f4967a = this.f4969c.f4947b.size();
    }

    private final Iterator<Entry<K, V>> a() {
        if (this.f4968b == null) {
            this.f4968b = this.f4969c.f4951f.entrySet().iterator();
        }
        return this.f4968b;
    }

    public final boolean hasNext() {
        int i2 = this.f4967a;
        return (i2 > 0 && i2 <= this.f4969c.f4947b.size()) || a().hasNext();
    }

    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Entry) a().next();
        }
        List b2 = this.f4969c.f4947b;
        int i2 = this.f4967a - 1;
        this.f4967a = i2;
        return (Entry) b2.get(i2);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ Ic(Gc gc, Fc fc) {
        this(gc);
    }
}
