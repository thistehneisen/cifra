package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class I extends Binder {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final E f6767a;

    I(E e2) {
        this.f6767a = e2;
    }

    public final void a(G g2) {
        if (Binder.getCallingUid() == Process.myUid()) {
            String str = "EnhancedIntentService";
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "service received new intent via bind strategy");
            }
            if (this.f6767a.zzc(g2.f6761a)) {
                g2.a();
                return;
            }
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "intent being queued for bg execution");
            }
            this.f6767a.zzt.execute(new H(this, g2));
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
