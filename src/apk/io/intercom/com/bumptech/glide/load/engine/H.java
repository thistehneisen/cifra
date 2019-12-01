package io.intercom.com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import io.intercom.com.bumptech.glide.h.j;

/* compiled from: ResourceRecycler */
class H {

    /* renamed from: a reason: collision with root package name */
    private boolean f9751a;

    /* renamed from: b reason: collision with root package name */
    private final Handler f9752b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler */
    private static final class a implements Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((E) message.obj).a();
            return true;
        }
    }

    H() {
    }

    /* access modifiers changed from: 0000 */
    public void a(E<?> e2) {
        j.b();
        if (this.f9751a) {
            this.f9752b.obtainMessage(1, e2).sendToTarget();
            return;
        }
        this.f9751a = true;
        e2.a();
        this.f9751a = false;
    }
}
