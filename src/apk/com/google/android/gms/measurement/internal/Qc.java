package com.google.android.gms.measurement.internal;

import java.util.Map;

final /* synthetic */ class Qc implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final Rc f5689a;

    /* renamed from: b reason: collision with root package name */
    private final int f5690b;

    /* renamed from: c reason: collision with root package name */
    private final Exception f5691c;

    /* renamed from: d reason: collision with root package name */
    private final byte[] f5692d;

    /* renamed from: e reason: collision with root package name */
    private final Map f5693e;

    Qc(Rc rc, int i2, Exception exc, byte[] bArr, Map map) {
        this.f5689a = rc;
        this.f5690b = i2;
        this.f5691c = exc;
        this.f5692d = bArr;
        this.f5693e = map;
    }

    public final void run() {
        this.f5689a.a(this.f5690b, this.f5691c, this.f5692d, this.f5693e);
    }
}
