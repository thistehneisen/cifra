package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager */
class q {

    /* renamed from: a reason: collision with root package name */
    private static q f6536a;

    /* renamed from: b reason: collision with root package name */
    private final Object f6537b = new Object();

    /* renamed from: c reason: collision with root package name */
    private final Handler f6538c = new Handler(Looper.getMainLooper(), new p(this));

    /* renamed from: d reason: collision with root package name */
    private b f6539d;

    /* renamed from: e reason: collision with root package name */
    private b f6540e;

    /* compiled from: SnackbarManager */
    interface a {
        void a(int i2);

        void b();
    }

    /* compiled from: SnackbarManager */
    private static class b {

        /* renamed from: a reason: collision with root package name */
        final WeakReference<a> f6541a;

        /* renamed from: b reason: collision with root package name */
        int f6542b;

        /* renamed from: c reason: collision with root package name */
        boolean f6543c;

        b(int i2, a aVar) {
            this.f6541a = new WeakReference<>(aVar);
            this.f6542b = i2;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(a aVar) {
            return aVar != null && this.f6541a.get() == aVar;
        }
    }

    private q() {
    }

    static q a() {
        if (f6536a == null) {
            f6536a = new q();
        }
        return f6536a;
    }

    private boolean f(a aVar) {
        b bVar = this.f6539d;
        return bVar != null && bVar.a(aVar);
    }

    private boolean g(a aVar) {
        b bVar = this.f6540e;
        return bVar != null && bVar.a(aVar);
    }

    public void b(a aVar) {
        synchronized (this.f6537b) {
            if (f(aVar)) {
                this.f6539d = null;
                if (this.f6540e != null) {
                    b();
                }
            }
        }
    }

    public void c(a aVar) {
        synchronized (this.f6537b) {
            if (f(aVar)) {
                b(this.f6539d);
            }
        }
    }

    public void d(a aVar) {
        synchronized (this.f6537b) {
            if (f(aVar) && !this.f6539d.f6543c) {
                this.f6539d.f6543c = true;
                this.f6538c.removeCallbacksAndMessages(this.f6539d);
            }
        }
    }

    public void e(a aVar) {
        synchronized (this.f6537b) {
            if (f(aVar) && this.f6539d.f6543c) {
                this.f6539d.f6543c = false;
                b(this.f6539d);
            }
        }
    }

    public void a(int i2, a aVar) {
        synchronized (this.f6537b) {
            if (f(aVar)) {
                this.f6539d.f6542b = i2;
                this.f6538c.removeCallbacksAndMessages(this.f6539d);
                b(this.f6539d);
                return;
            }
            if (g(aVar)) {
                this.f6540e.f6542b = i2;
            } else {
                this.f6540e = new b(i2, aVar);
            }
            if (this.f6539d == null || !a(this.f6539d, 4)) {
                this.f6539d = null;
                b();
            }
        }
    }

    private void b() {
        b bVar = this.f6540e;
        if (bVar != null) {
            this.f6539d = bVar;
            this.f6540e = null;
            a aVar = (a) this.f6539d.f6541a.get();
            if (aVar != null) {
                aVar.b();
            } else {
                this.f6539d = null;
            }
        }
    }

    private void b(b bVar) {
        int i2 = bVar.f6542b;
        if (i2 != -2) {
            if (i2 <= 0) {
                i2 = i2 == -1 ? 1500 : 2750;
            }
            this.f6538c.removeCallbacksAndMessages(bVar);
            Handler handler = this.f6538c;
            handler.sendMessageDelayed(Message.obtain(handler, 0, bVar), (long) i2);
        }
    }

    public void a(a aVar, int i2) {
        synchronized (this.f6537b) {
            if (f(aVar)) {
                a(this.f6539d, i2);
            } else if (g(aVar)) {
                a(this.f6540e, i2);
            }
        }
    }

    public boolean a(a aVar) {
        boolean z;
        synchronized (this.f6537b) {
            if (!f(aVar)) {
                if (!g(aVar)) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private boolean a(b bVar, int i2) {
        a aVar = (a) bVar.f6541a.get();
        if (aVar == null) {
            return false;
        }
        this.f6538c.removeCallbacksAndMessages(bVar);
        aVar.a(i2);
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar) {
        synchronized (this.f6537b) {
            if (this.f6539d == bVar || this.f6540e == bVar) {
                a(bVar, 2);
            }
        }
    }
}
