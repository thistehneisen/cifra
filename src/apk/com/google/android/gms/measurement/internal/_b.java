package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class _b implements Callable<List<de>> {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ String f5801a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5802b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5803c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Pb f5804d;

    _b(Pb pb, String str, String str2, String str3) {
        this.f5804d = pb;
        this.f5801a = str;
        this.f5802b = str2;
        this.f5803c = str3;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f5804d.f5680a.p();
        return this.f5804d.f5680a.j().b(this.f5801a, this.f5802b, this.f5803c);
    }
}
