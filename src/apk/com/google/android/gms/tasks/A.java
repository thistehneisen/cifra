package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class A implements Executor {
    A() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
