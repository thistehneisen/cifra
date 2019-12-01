package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.Af;

final class Hb implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Ob f5577a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ long f5578b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ Bundle f5579c;

    /* renamed from: d reason: collision with root package name */
    private final /* synthetic */ Context f5580d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ C0532kb f5581e;

    /* renamed from: f reason: collision with root package name */
    private final /* synthetic */ PendingResult f5582f;

    Hb(Eb eb, Ob ob, long j2, Bundle bundle, Context context, C0532kb kbVar, PendingResult pendingResult) {
        this.f5577a = ob;
        this.f5578b = j2;
        this.f5579c = bundle;
        this.f5580d = context;
        this.f5581e = kbVar;
        this.f5582f = pendingResult;
    }

    public final void run() {
        long a2 = this.f5577a.h().f6108k.a();
        long j2 = this.f5578b;
        if (a2 > 0 && (j2 >= a2 || j2 <= 0)) {
            j2 = a2 - 1;
        }
        if (j2 > 0) {
            this.f5579c.putLong("click_timestamp", j2);
        }
        this.f5579c.putString("_cis", "referrer broadcast");
        Ob.a(this.f5580d, (Af) null).y().b("auto", "_cmp", this.f5579c);
        this.f5581e.B().a("Install campaign recorded");
        PendingResult pendingResult = this.f5582f;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
