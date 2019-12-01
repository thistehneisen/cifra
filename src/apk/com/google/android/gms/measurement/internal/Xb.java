package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class Xb implements Callable<List<de>> {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5761a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5762b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5763c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Pb f5764d;

    Xb(Pb pb, ae aeVar, String str, String str2) {
        this.f5764d = pb;
        this.f5761a = aeVar;
        this.f5762b = str;
        this.f5763c = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f5764d.f5680a.p();
        return this.f5764d.f5680a.j().b(this.f5761a.f5819a, this.f5762b, this.f5763c);
    }
}
