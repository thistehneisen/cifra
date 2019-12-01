package io.intercom.com.bumptech.glide.load.engine.c;

import io.intercom.com.bumptech.glide.load.engine.c.b.C0113b;

/* compiled from: GlideExecutor */
class e implements C0113b {
    e() {
    }

    public void a(Throwable th) {
        if (th != null) {
            throw new RuntimeException("Request threw uncaught throwable", th);
        }
    }
}
