package io.intercom.com.bumptech.glide.load.engine.c;

import android.util.Log;
import io.intercom.com.bumptech.glide.load.engine.c.b.C0113b;

/* compiled from: GlideExecutor */
class d implements C0113b {
    d() {
    }

    public void a(Throwable th) {
        if (th != null) {
            String str = "GlideExecutor";
            if (Log.isLoggable(str, 6)) {
                Log.e(str, "Request threw uncaught throwable", th);
            }
        }
    }
}
