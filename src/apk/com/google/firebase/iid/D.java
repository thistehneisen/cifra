package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

final class D extends BroadcastReceiver {

    /* renamed from: a reason: collision with root package name */
    private C0636z f6741a;

    public D(C0636z zVar) {
        this.f6741a = zVar;
    }

    public final void a() {
        if (FirebaseInstanceId.h()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.f6741a.a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final void onReceive(Context context, Intent intent) {
        C0636z zVar = this.f6741a;
        if (zVar != null && zVar.b()) {
            if (FirebaseInstanceId.h()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.a((Runnable) this.f6741a, 0);
            this.f6741a.a().unregisterReceiver(this);
            this.f6741a = null;
        }
    }
}
