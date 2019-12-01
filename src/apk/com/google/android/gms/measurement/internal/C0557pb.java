package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.q;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.pb reason: case insensitive filesystem */
final class C0557pb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final C0562qb f6058a;

    /* renamed from: b reason: collision with root package name */
    private final int f6059b;

    /* renamed from: c reason: collision with root package name */
    private final Throwable f6060c;

    /* renamed from: d reason: collision with root package name */
    private final byte[] f6061d;

    /* renamed from: e reason: collision with root package name */
    private final String f6062e;

    /* renamed from: f reason: collision with root package name */
    private final Map<String, List<String>> f6063f;

    private C0557pb(String str, C0562qb qbVar, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        q.a(qbVar);
        this.f6058a = qbVar;
        this.f6059b = i2;
        this.f6060c = th;
        this.f6061d = bArr;
        this.f6062e = str;
        this.f6063f = map;
    }

    public final void run() {
        this.f6058a.a(this.f6062e, this.f6059b, this.f6060c, this.f6061d, this.f6063f);
    }
}
