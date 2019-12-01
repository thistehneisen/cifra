package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.measurement.xd reason: case insensitive filesystem */
public abstract class C0466xd {

    /* renamed from: a reason: collision with root package name */
    protected volatile int f5419a = -1;

    /* access modifiers changed from: protected */
    public int a() {
        return 0;
    }

    public abstract C0466xd a(C0413od odVar) throws IOException;

    public void a(C0425qd qdVar) throws IOException {
    }

    public final int b() {
        int a2 = a();
        this.f5419a = a2;
        return a2;
    }

    /* renamed from: c */
    public C0466xd clone() throws CloneNotSupportedException {
        return (C0466xd) super.clone();
    }

    public String toString() {
        return C0460wd.a(this);
    }
}
