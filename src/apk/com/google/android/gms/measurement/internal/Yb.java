package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class Yb implements Callable<List<Td>> {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f5772a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5773b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5774c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Pb f5775d;

    Yb(Pb pb, String str, String str2, String str3) {
        this.f5775d = pb;
        this.f5772a = str;
        this.f5773b = str2;
        this.f5774c = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f5775d.f5680a.p();
        return this.f5775d.f5680a.j().a(this.f5772a, this.f5773b, this.f5774c);
    }
}
