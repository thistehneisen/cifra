package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

final class Wa extends Ya {

    /* renamed from: a reason: collision with root package name */
    private int f5072a = 0;

    /* renamed from: b reason: collision with root package name */
    private final int f5073b = this.f5074c.size();

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Xa f5074c;

    Wa(Xa xa) {
        this.f5074c = xa;
    }

    public final boolean hasNext() {
        return this.f5072a < this.f5073b;
    }

    public final byte nextByte() {
        int i2 = this.f5072a;
        if (i2 < this.f5073b) {
            this.f5072a = i2 + 1;
            return this.f5074c.f(i2);
        }
        throw new NoSuchElementException();
    }
}
