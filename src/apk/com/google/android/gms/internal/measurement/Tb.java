package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class Tb<K> implements Iterator<Entry<K, Object>> {

    /* renamed from: a reason: collision with root package name */
    private Iterator<Entry<K, Object>> f5049a;

    public Tb(Iterator<Entry<K, Object>> it) {
        this.f5049a = it;
    }

    public final boolean hasNext() {
        return this.f5049a.hasNext();
    }

    public final /* synthetic */ Object next() {
        Entry entry = (Entry) this.f5049a.next();
        return entry.getValue() instanceof Ob ? new Qb(entry) : entry;
    }

    public final void remove() {
        this.f5049a.remove();
    }
}
