package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class Xc extends AbstractList<String> implements Ub, RandomAccess {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final Ub f5087a;

    public Xc(Ub ub) {
        this.f5087a = ub;
    }

    public final void a(Xa xa) {
        throw new UnsupportedOperationException();
    }

    public final Ub c() {
        return this;
    }

    public final List<?> d() {
        return this.f5087a.d();
    }

    public final Object e(int i2) {
        return this.f5087a.e(i2);
    }

    public final /* synthetic */ Object get(int i2) {
        return (String) this.f5087a.get(i2);
    }

    public final Iterator<String> iterator() {
        return new Zc(this);
    }

    public final ListIterator<String> listIterator(int i2) {
        return new Wc(this, i2);
    }

    public final int size() {
        return this.f5087a.size();
    }
}
