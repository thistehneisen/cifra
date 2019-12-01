package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import c.b.a.b.b.b.d;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.api.i;
import com.google.android.gms.common.internal.C0317l;
import com.google.android.gms.common.internal.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
public abstract class BasePendingResult<R extends h> extends f<R> {

    /* renamed from: a reason: collision with root package name */
    static final ThreadLocal<Boolean> f4541a = new G();

    /* renamed from: b reason: collision with root package name */
    private final Object f4542b = new Object();

    /* renamed from: c reason: collision with root package name */
    private final a<R> f4543c = new a<>(Looper.getMainLooper());

    /* renamed from: d reason: collision with root package name */
    private final WeakReference<Object> f4544d = new WeakReference<>(null);

    /* renamed from: e reason: collision with root package name */
    private final CountDownLatch f4545e = new CountDownLatch(1);

    /* renamed from: f reason: collision with root package name */
    private final ArrayList<com.google.android.gms.common.api.f.a> f4546f = new ArrayList<>();

    /* renamed from: g reason: collision with root package name */
    private i<? super R> f4547g;

    /* renamed from: h reason: collision with root package name */
    private final AtomicReference<A> f4548h = new AtomicReference<>();
    /* access modifiers changed from: private */

    /* renamed from: i reason: collision with root package name */
    public R f4549i;

    /* renamed from: j reason: collision with root package name */
    private Status f4550j;

    /* renamed from: k reason: collision with root package name */
    private volatile boolean f4551k;

    /* renamed from: l reason: collision with root package name */
    private boolean f4552l;
    private boolean m;
    @KeepName
    private b mResultGuardian;
    private C0317l n;
    private boolean o = false;

    public static class a<R extends h> extends d {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(i<? super R> iVar, R r) {
            sendMessage(obtainMessage(1, new Pair(iVar, r)));
        }

        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                Pair pair = (Pair) message.obj;
                i iVar = (i) pair.first;
                h hVar = (h) pair.second;
                try {
                    iVar.a(hVar);
                } catch (RuntimeException e2) {
                    BasePendingResult.b(hVar);
                    throw e2;
                }
            } else if (i2 != 2) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i2);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).b(Status.f4522d);
            }
        }
    }

    private final class b {
        private b() {
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            BasePendingResult.b(BasePendingResult.this.f4549i);
            super.finalize();
        }

        /* synthetic */ b(BasePendingResult basePendingResult, G g2) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
    }

    private final void c(R r) {
        this.f4549i = r;
        this.n = null;
        this.f4545e.countDown();
        this.f4550j = this.f4549i.e();
        if (this.f4552l) {
            this.f4547g = null;
        } else if (this.f4547g != null) {
            this.f4543c.removeMessages(2);
            this.f4543c.a(this.f4547g, b());
        } else if (this.f4549i instanceof g) {
            this.mResultGuardian = new b(this, null);
        }
        ArrayList<com.google.android.gms.common.api.f.a> arrayList = this.f4546f;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((com.google.android.gms.common.api.f.a) obj).a(this.f4550j);
        }
        this.f4546f.clear();
    }

    /* access modifiers changed from: protected */
    public abstract R a(Status status);

    public final boolean a() {
        return this.f4545e.getCount() == 0;
    }

    public final void b(Status status) {
        synchronized (this.f4542b) {
            if (!a()) {
                a((R) a(status));
                this.m = true;
            }
        }
    }

    public final void a(R r) {
        synchronized (this.f4542b) {
            if (this.m || this.f4552l) {
                b((h) r);
                return;
            }
            a();
            boolean z = true;
            q.b(!a(), "Results have already been set");
            if (this.f4551k) {
                z = false;
            }
            q.b(z, "Result has already been consumed");
            c(r);
        }
    }

    private final R b() {
        R r;
        synchronized (this.f4542b) {
            q.b(!this.f4551k, "Result has already been consumed.");
            q.b(a(), "Result is not ready.");
            r = this.f4549i;
            this.f4549i = null;
            this.f4547g = null;
            this.f4551k = true;
        }
        A a2 = (A) this.f4548h.getAndSet(null);
        if (a2 != null) {
            a2.a(this);
        }
        return r;
    }

    public static void b(h hVar) {
        if (hVar instanceof g) {
            try {
                ((g) hVar).a();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(hVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }
}
