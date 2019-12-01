package com.bumptech.glide.load.engine.c;

import android.util.Log;
import com.bumptech.glide.load.engine.c.b.C0057b;

/* compiled from: GlideExecutor */
class d implements C0057b {
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
