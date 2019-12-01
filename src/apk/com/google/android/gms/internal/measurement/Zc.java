package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class Zc implements Iterator<String> {

    /* renamed from: a reason: collision with root package name */
    private Iterator<String> f5108a = this.f5109b.f5087a.iterator();

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Xc f5109b;

    Zc(Xc xc) {
        this.f5109b = xc;
    }

    public final boolean hasNext() {
        return this.f5108a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f5108a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
