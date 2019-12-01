package b.g.f;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: SelfDestructiveThread */
class g implements Callback {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ k f2553a;

    g(k kVar) {
        this.f2553a = kVar;
    }

    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            this.f2553a.a();
            return true;
        } else if (i2 != 1) {
            return true;
        } else {
            this.f2553a.a((Runnable) message.obj);
            return true;
        }
    }
}
