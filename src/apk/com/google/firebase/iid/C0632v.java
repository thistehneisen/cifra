package com.google.firebase.iid;

import android.os.Looper;
import android.os.Message;
import c.b.a.b.b.d.e;

/* renamed from: com.google.firebase.iid.v reason: case insensitive filesystem */
final class C0632v extends e {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ C0633w f6840a;

    C0632v(C0633w wVar, Looper looper) {
        this.f6840a = wVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        this.f6840a.a(message);
    }
}
