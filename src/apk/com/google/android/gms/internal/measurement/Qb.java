package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class Qb<K> implements Entry<K, Object> {

    /* renamed from: a reason: collision with root package name */
    private Entry<K, Ob> f5020a;

    private Qb(Entry<K, Ob> entry) {
        this.f5020a = entry;
    }

    public final Ob a() {
        return (Ob) this.f5020a.getValue();
    }

    public final K getKey() {
        return this.f5020a.getKey();
    }

    public final Object getValue() {
        if (((Ob) this.f5020a.getValue()) == null) {
            return null;
        }
        Ob.c();
        throw null;
    }

    public final Object setValue(Object obj) {
        if (obj instanceof C0400mc) {
            return ((Ob) this.f5020a.getValue()).a((C0400mc) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
