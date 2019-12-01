package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.md reason: case insensitive filesystem */
final class C0544md implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6028a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6029b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f6030c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ String f6031d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ ae f6032e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ Zc f6033f;

    C0544md(Zc zc, AtomicReference atomicReference, String str, String str2, String str3, ae aeVar) {
        this.f6033f = zc;
        this.f6028a = atomicReference;
        this.f6029b = str;
        this.f6030c = str2;
        this.f6031d = str3;
        this.f6032e = aeVar;
    }

    public final void run() {
        synchronized (this.f6028a) {
            try {
                C0487bb d2 = this.f6033f.f5791d;
                if (d2 == null) {
                    this.f6033f.e().t().a("Failed to get conditional properties", C0532kb.a(this.f6029b), this.f6030c, this.f6031d);
                    this.f6028a.set(Collections.emptyList());
                    this.f6028a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f6029b)) {
                    this.f6028a.set(d2.a(this.f6030c, this.f6031d, this.f6032e));
                } else {
                    this.f6028a.set(d2.a(this.f6029b, this.f6030c, this.f6031d));
                }
                this.f6033f.J();
                this.f6028a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f6033f.e().t().a("Failed to get conditional properties", C0532kb.a(this.f6029b), this.f6030c, e2);
                    this.f6028a.set(Collections.emptyList());
                    this.f6028a.notify();
                } catch (Throwable th) {
                    this.f6028a.notify();
                    throw th;
                }
            }
        }
    }
}
