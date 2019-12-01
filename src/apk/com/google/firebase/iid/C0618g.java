package com.google.firebase.iid;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: com.google.firebase.iid.g reason: case insensitive filesystem */
final /* synthetic */ class C0618g implements Callback {

    /* renamed from: a reason: collision with root package name */
    private final C0619h f6812a;

    C0618g(C0619h hVar) {
        this.f6812a = hVar;
    }

    public final boolean handleMessage(Message message) {
        return this.f6812a.a(message);
    }
}
