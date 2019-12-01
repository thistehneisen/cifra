package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.dc reason: case insensitive filesystem */
final class C0498dc implements Callable<byte[]> {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0525j f5871a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5872b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Pb f5873c;

    C0498dc(Pb pb, C0525j jVar, String str) {
        this.f5873c = pb;
        this.f5871a = jVar;
        this.f5872b = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f5873c.f5680a.p();
        this.f5873c.f5680a.m().a(this.f5871a, this.f5872b);
        throw null;
    }
}
