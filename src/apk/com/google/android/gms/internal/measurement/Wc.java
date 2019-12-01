package com.google.android.gms.internal.measurement;

import java.util.ListIterator;

final class Wc implements ListIterator<String> {

    /* renamed from: a reason: collision with root package name */
    private ListIterator<String> f5075a = this.f5077c.f5087a.listIterator(this.f5076b);

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ int f5076b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Xc f5077c;

    Wc(Xc xc, int i2) {
        this.f5077c = xc;
        this.f5076b = i2;
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.f5075a.hasNext();
    }

    public final boolean hasPrevious() {
        return this.f5075a.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return (String) this.f5075a.next();
    }

    public final int nextIndex() {
        return this.f5075a.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return (String) this.f5075a.previous();
    }

    public final int previousIndex() {
        return this.f5075a.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
