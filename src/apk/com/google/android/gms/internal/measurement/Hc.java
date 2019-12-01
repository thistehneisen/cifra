package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map.Entry;

final class Hc extends Nc {

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Gc f4958b;

    private Hc(Gc gc) {
        this.f4958b = gc;
        super(gc, null);
    }

    public final Iterator<Entry<K, V>> iterator() {
        return new Ic(this.f4958b, null);
    }

    /* synthetic */ Hc(Gc gc, Fc fc) {
        this(gc);
    }
}
