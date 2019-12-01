package com.bumptech.glide.load.engine.c;

import com.bumptech.glide.load.engine.c.b.C0057b;

/* compiled from: GlideExecutor */
class e implements C0057b {
    e() {
    }

    public void a(Throwable th) {
        if (th != null) {
            throw new RuntimeException("Request threw uncaught throwable", th);
        }
    }
}
