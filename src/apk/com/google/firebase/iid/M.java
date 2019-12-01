package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class M implements ThreadFactory {

    /* renamed from: a reason: collision with root package name */
    static final ThreadFactory f6776a = new M();

    private M() {
    }

    public final Thread newThread(Runnable runnable) {
        return J.a(runnable);
    }
}
