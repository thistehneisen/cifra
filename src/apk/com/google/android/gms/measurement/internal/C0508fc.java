package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: com.google.android.gms.measurement.internal.fc reason: case insensitive filesystem */
final class C0508fc implements Callable<List<Td>> {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ ae f5911a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Pb f5912b;

    C0508fc(Pb pb, ae aeVar) {
        this.f5912b = pb;
        this.f5911a = aeVar;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.f5912b.f5680a.p();
        return this.f5912b.f5680a.j().a(this.f5911a.f5819a);
    }
}
