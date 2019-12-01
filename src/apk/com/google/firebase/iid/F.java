package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

final /* synthetic */ class F implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final G f6742a;

    /* renamed from: b reason: collision with root package name */
    private final Intent f6743b;

    F(G g2, Intent intent) {
        this.f6742a = g2;
        this.f6743b = intent;
    }

    public final void run() {
        G g2 = this.f6742a;
        String action = this.f6743b.getAction();
        StringBuilder sb = new StringBuilder(String.valueOf(action).length() + 61);
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("EnhancedIntentService", sb.toString());
        g2.a();
    }
}
