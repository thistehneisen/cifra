package io.intercom.com.bumptech.glide.load.engine;

import android.os.Handler.Callback;
import android.os.Message;

/* renamed from: io.intercom.com.bumptech.glide.load.engine.a reason: case insensitive filesystem */
/* compiled from: ActiveResources */
class C0742a implements Callback {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0744c f9760a;

    C0742a(C0744c cVar) {
        this.f9760a = cVar;
    }

    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        this.f9760a.a((b) message.obj);
        return true;
    }
}
