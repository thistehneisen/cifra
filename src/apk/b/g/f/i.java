package b.g.f;

import android.os.Handler;
import b.g.f.k.a;
import java.util.concurrent.Callable;

/* compiled from: SelfDestructiveThread */
class i implements Runnable {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ Callable f2556a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ Handler f2557b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ a f2558c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ k f2559d;

    i(k kVar, Callable callable, Handler handler, a aVar) {
        this.f2559d = kVar;
        this.f2556a = callable;
        this.f2557b = handler;
        this.f2558c = aVar;
    }

    public void run() {
        Object obj;
        try {
            obj = this.f2556a.call();
        } catch (Exception unused) {
            obj = null;
        }
        this.f2557b.post(new h(this, obj));
    }
}
