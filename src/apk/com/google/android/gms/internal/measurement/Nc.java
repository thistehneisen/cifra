package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

class Nc extends AbstractSet<Entry<K, V>> {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Gc f4994a;

    private Nc(Gc gc) {
        this.f4994a = gc;
    }

    public /* synthetic */ boolean add(Object obj) {
        Entry entry = (Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f4994a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.f4994a.clear();
    }

    public boolean contains(Object obj) {
        Entry entry = (Entry) obj;
        Object obj2 = this.f4994a.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public Iterator<Entry<K, V>> iterator() {
        return new Oc(this.f4994a, null);
    }

    public boolean remove(Object obj) {
        Entry entry = (Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f4994a.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.f4994a.size();
    }

    /* synthetic */ Nc(Gc gc, Fc fc) {
        this(gc);
    }
}
