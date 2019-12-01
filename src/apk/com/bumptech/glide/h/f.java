package com.bumptech.glide.h;

import java.util.concurrent.Executor;

/* compiled from: Executors */
class f implements Executor {
    f() {
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
