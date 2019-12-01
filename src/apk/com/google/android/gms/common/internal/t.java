package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.api.a.h;

public class t<T extends IInterface> extends C0312g<T> {
    private final h<T> G;

    /* access modifiers changed from: protected */
    public T a(IBinder iBinder) {
        return this.G.a(iBinder);
    }

    public int e() {
        return super.e();
    }

    /* access modifiers changed from: protected */
    public String s() {
        return this.G.h();
    }

    /* access modifiers changed from: protected */
    public String t() {
        return this.G.i();
    }

    public h<T> w() {
        return this.G;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, T t) {
        this.G.a(i2, t);
    }
}
