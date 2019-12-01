package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.measurement.internal.od reason: case insensitive filesystem */
final class C0554od implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6049a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f6050b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ String f6051c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ String f6052d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ boolean f6053e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ ae f6054f;

    /* renamed from: g reason: collision with root package name */
    private final /* synthetic */ Zc f6055g;

    C0554od(Zc zc, AtomicReference atomicReference, String str, String str2, String str3, boolean z, ae aeVar) {
        this.f6055g = zc;
        this.f6049a = atomicReference;
        this.f6050b = str;
        this.f6051c = str2;
        this.f6052d = str3;
        this.f6053e = z;
        this.f6054f = aeVar;
    }

    public final void run() {
        synchronized (this.f6049a) {
            try {
                C0487bb d2 = this.f6055g.f5791d;
                if (d2 == null) {
                    this.f6055g.e().t().a("Failed to get user properties", C0532kb.a(this.f6050b), this.f6051c, this.f6052d);
                    this.f6049a.set(Collections.emptyList());
                    this.f6049a.notify();
                    return;
                }
                if (TextUtils.isEmpty(this.f6050b)) {
                    this.f6049a.set(d2.a(this.f6051c, this.f6052d, this.f6053e, this.f6054f));
                } else {
                    this.f6049a.set(d2.a(this.f6050b, this.f6051c, this.f6052d, this.f6053e));
                }
                this.f6055g.J();
                this.f6049a.notify();
            } catch (RemoteException e2) {
                try {
                    this.f6055g.e().t().a("Failed to get user properties", C0532kb.a(this.f6050b), this.f6051c, e2);
                    this.f6049a.set(Collections.emptyList());
                    this.f6049a.notify();
                } catch (Throwable th) {
                    this.f6049a.notify();
                    throw th;
                }
            }
        }
    }
}
