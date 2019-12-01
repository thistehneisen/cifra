package com.google.android.gms.internal.measurement;

import java.util.Map.Entry;

final class Lc implements Comparable<Lc>, Entry<K, V> {

    /* renamed from: a reason: collision with root package name */
    private final K f4987a;

    /* renamed from: b reason: collision with root package name */
    private V f4988b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Gc f4989c;

    Lc(Gc gc, Entry<K, V> entry) {
        this(gc, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((Lc) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry entry = (Entry) obj;
        return a(this.f4987a, entry.getKey()) && a(this.f4988b, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.f4987a;
    }

    public final V getValue() {
        return this.f4988b;
    }

    public final int hashCode() {
        K k2 = this.f4987a;
        int i2 = 0;
        int hashCode = k2 == null ? 0 : k2.hashCode();
        V v = this.f4988b;
        if (v != null) {
            i2 = v.hashCode();
        }
        return hashCode ^ i2;
    }

    public final V setValue(V v) {
        this.f4989c.f();
        V v2 = this.f4988b;
        this.f4988b = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f4987a);
        String valueOf2 = String.valueOf(this.f4988b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    Lc(Gc gc, K k2, V v) {
        this.f4989c = gc;
        this.f4987a = k2;
        this.f4988b = v;
    }
}
