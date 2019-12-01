package com.google.android.material.snackbar;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: SnackbarManager */
class p implements Callback {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ q f6535a;

    p(q qVar) {
        this.f6535a = qVar;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        this.f6535a.a((b) message.obj);
        return true;
    }
}
