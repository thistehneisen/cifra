package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.sf;

/* renamed from: com.google.android.gms.measurement.internal.fd reason: case insensitive filesystem */
final class C0509fd implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0525j f5913a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ String f5914b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ sf f5915c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Zc f5916d;

    C0509fd(Zc zc, C0525j jVar, String str, sf sfVar) {
        this.f5916d = zc;
        this.f5913a = jVar;
        this.f5914b = str;
        this.f5915c = sfVar;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            C0487bb d2 = this.f5916d.f5791d;
            if (d2 == null) {
                this.f5916d.e().t().a("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = d2.a(this.f5913a, this.f5914b);
            this.f5916d.J();
            this.f5916d.m().a(this.f5915c, bArr);
        } catch (RemoteException e2) {
            this.f5916d.e().t().a("Failed to send event to the service to bundle", e2);
        } finally {
            this.f5916d.m().a(this.f5915c, bArr);
        }
    }
}
