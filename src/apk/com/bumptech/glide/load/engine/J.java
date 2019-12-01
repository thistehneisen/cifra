package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler */
class J {

    /* renamed from: a reason: collision with root package name */
    private boolean f3889a;

    /* renamed from: b reason: collision with root package name */
    private final Handler f3890b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler */
    private static final class a implements Callback {
        a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((G) message.obj).a();
            return true;
        }
    }

    J() {
    }

    /* access modifiers changed from: 0000 */
    public synchronized void a(G<?> g2) {
        if (this.f3889a) {
            this.f3890b.obtainMessage(1, g2).sendToTarget();
        } else {
            this.f3889a = true;
            g2.a();
            this.f3889a = false;
        }
    }
}
