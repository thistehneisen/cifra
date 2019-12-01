package io.intercom.android.sdk;

import android.os.Handler;
import android.os.Looper;
import e.a.a.a.a.d;
import e.a.a.a.a.n;

class MainThreadBus extends d {
    private final Handler mainThread = new Handler(Looper.getMainLooper());

    MainThreadBus(n nVar) {
        super(nVar);
    }

    public void post(final Object obj) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(obj);
        } else {
            this.mainThread.post(new Runnable() {
                public void run() {
                    MainThreadBus.super.post(obj);
                }
            });
        }
    }

    public void register(Object obj) {
        try {
            super.register(obj);
        } catch (Exception unused) {
        }
    }

    public void unregister(Object obj) {
        try {
            super.unregister(obj);
        } catch (Exception unused) {
        }
    }
}
