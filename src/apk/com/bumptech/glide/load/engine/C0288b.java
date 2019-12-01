package com.bumptech.glide.load.engine;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.bumptech.glide.load.engine.b reason: case insensitive filesystem */
/* compiled from: ActiveResources */
class C0288b implements ThreadFactory {
    C0288b() {
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(new C0287a(this, runnable), "glide-active-resources");
    }
}
