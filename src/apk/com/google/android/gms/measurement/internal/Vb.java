package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

final class Vb implements Callable<List<Td>> {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5739a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5740b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f5741c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Pb f5742d;

    Vb(Pb pb, ae aeVar, String str, String str2) {
        this.f5742d = pb;
        this.f5739a = aeVar;
        this.f5740b = str;
        this.f5741c = str2;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f5742d.f5680a.p();
        return this.f5742d.f5680a.j().a(this.f5739a.f5819a, this.f5740b, this.f5741c);
    }
}
