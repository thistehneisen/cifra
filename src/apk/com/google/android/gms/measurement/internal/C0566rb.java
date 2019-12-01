package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.q;

/* renamed from: com.google.android.gms.measurement.internal.rb reason: case insensitive filesystem */
class C0566rb extends BroadcastReceiver {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final Kd f6075a;

    /* renamed from: b reason: collision with root package name */
    private boolean f6076b;

    /* renamed from: c reason: collision with root package name */
    private boolean f6077c;

    C0566rb(Kd kd) {
        q.a(kd);
        this.f6075a = kd;
    }

    public final void a() {
        this.f6075a.n();
        this.f6075a.d().j();
        this.f6075a.d().j();
        if (this.f6076b) {
            this.f6075a.e().B().a("Unregistering connectivity change receiver");
            this.f6076b = false;
            this.f6077c = false;
            try {
                this.f6075a.a().unregisterReceiver(this);
            } catch (IllegalArgumentException e2) {
                this.f6075a.e().t().a("Failed to unregister the network broadcast receiver", e2);
            }
        }
    }

    public final void b() {
        this.f6075a.n();
        this.f6075a.d().j();
        if (!this.f6076b) {
            this.f6075a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f6077c = this.f6075a.l().v();
            this.f6075a.e().B().a("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f6077c));
            this.f6076b = true;
        }
    }

    public void onReceive(Context context, Intent intent) {
        this.f6075a.n();
        String action = intent.getAction();
        this.f6075a.e().B().a("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean v = this.f6075a.l().v();
            if (this.f6077c != v) {
                this.f6077c = v;
                this.f6075a.d().a((Runnable) new C0581ub(this, v));
            }
            return;
        }
        this.f6075a.e().w().a("NetworkBroadcastReceiver received unknown action", action);
    }
}
