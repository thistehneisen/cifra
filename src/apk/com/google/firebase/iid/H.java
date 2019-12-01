package com.google.firebase.iid;

import android.util.Log;

final class H implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ G f6765a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ I f6766b;

    H(I i2, G g2) {
        this.f6766b = i2;
        this.f6765a = g2;
    }

    public final void run() {
        String str = "EnhancedIntentService";
        if (Log.isLoggable(str, 3)) {
            Log.d(str, "bg processing of the intent starting now");
        }
        this.f6766b.f6767a.zzd(this.f6765a.f6761a);
        this.f6765a.a();
    }
}
