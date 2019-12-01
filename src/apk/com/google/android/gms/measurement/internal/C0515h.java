package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* renamed from: com.google.android.gms.measurement.internal.h reason: case insensitive filesystem */
final class C0515h implements Iterator<String> {

    /* renamed from: a reason: collision with root package name */
    private Iterator<String> f5934a = this.f5935b.f5944a.keySet().iterator();

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ C0520i f5935b;

    C0515h(C0520i iVar) {
        this.f5935b = iVar;
    }

    public final boolean hasNext() {
        return this.f5934a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f5934a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
