package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.internal.b reason: case insensitive filesystem */
public abstract class C0307b<T extends IInterface> {

    /* renamed from: a reason: collision with root package name */
    private static final com.google.android.gms.common.d[] f4689a = new com.google.android.gms.common.d[0];

    /* renamed from: b reason: collision with root package name */
    public static final String[] f4690b = {"service_esmobile", "service_googleme"};
    /* access modifiers changed from: private */
    public boolean A;
    private volatile B B;
    protected AtomicInteger C;

    /* renamed from: c reason: collision with root package name */
    private int f4691c;

    /* renamed from: d reason: collision with root package name */
    private long f4692d;

    /* renamed from: e reason: collision with root package name */
    private long f4693e;

    /* renamed from: f reason: collision with root package name */
    private int f4694f;

    /* renamed from: g reason: collision with root package name */
    private long f4695g;

    /* renamed from: h reason: collision with root package name */
    private H f4696h;

    /* renamed from: i reason: collision with root package name */
    private final Context f4697i;

    /* renamed from: j reason: collision with root package name */
    private final Looper f4698j;

    /* renamed from: k reason: collision with root package name */
    private final C0314i f4699k;

    /* renamed from: l reason: collision with root package name */
    private final com.google.android.gms.common.f f4700l;
    final Handler m;
    private final Object n;
    /* access modifiers changed from: private */
    public final Object o;
    /* access modifiers changed from: private */
    public C0320o p;
    protected c q;
    private T r;
    /* access modifiers changed from: private */
    public final ArrayList<h<?>> s;
    private j t;
    private int u;
    /* access modifiers changed from: private */
    public final a v;
    /* access modifiers changed from: private */
    public final C0064b w;
    private final int x;
    private final String y;
    /* access modifiers changed from: private */
    public b z;

    /* renamed from: com.google.android.gms.common.internal.b$a */
    public interface a {
        void c(int i2);

        void e(Bundle bundle);
    }

    /* renamed from: com.google.android.gms.common.internal.b$b reason: collision with other inner class name */
    public interface C0064b {
        void a(b bVar);
    }

    /* renamed from: com.google.android.gms.common.internal.b$c */
    public interface c {
        void a(b bVar);
    }

    /* renamed from: com.google.android.gms.common.internal.b$d */
    protected class d implements c {
        public d() {
        }

        public void a(b bVar) {
            if (bVar.j()) {
                C0307b bVar2 = C0307b.this;
                bVar2.a((C0316k) null, bVar2.q());
                return;
            }
            if (C0307b.this.w != null) {
                C0307b.this.w.a(bVar);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.b$e */
    public interface e {
        void a();
    }

    /* renamed from: com.google.android.gms.common.internal.b$f */
    private abstract class f extends h<Boolean> {

        /* renamed from: d reason: collision with root package name */
        private final int f4702d;

        /* renamed from: e reason: collision with root package name */
        private final Bundle f4703e;

        protected f(int i2, Bundle bundle) {
            super(Boolean.valueOf(true));
            this.f4702d = i2;
            this.f4703e = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract void a(b bVar);

        /* access modifiers changed from: protected */
        public final /* synthetic */ void a(Object obj) {
            PendingIntent pendingIntent = null;
            if (((Boolean) obj) == null) {
                C0307b.this.b(1, null);
                return;
            }
            int i2 = this.f4702d;
            if (i2 != 0) {
                if (i2 != 10) {
                    C0307b.this.b(1, null);
                    Bundle bundle = this.f4703e;
                    if (bundle != null) {
                        pendingIntent = (PendingIntent) bundle.getParcelable("pendingIntent");
                    }
                    a(new b(this.f4702d, pendingIntent));
                } else {
                    C0307b.this.b(1, null);
                    throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", new Object[]{getClass().getSimpleName(), C0307b.this.t(), C0307b.this.s()}));
                }
            } else if (!e()) {
                C0307b.this.b(1, null);
                a(new b(8, null));
            }
        }

        /* access modifiers changed from: protected */
        public final void c() {
        }

        /* access modifiers changed from: protected */
        public abstract boolean e();
    }

    /* renamed from: com.google.android.gms.common.internal.b$g */
    final class g extends c.b.a.b.b.c.d {
        public g(Looper looper) {
            super(looper);
        }

        private static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.c();
            hVar.b();
        }

        private static boolean b(Message message) {
            int i2 = message.what;
            return i2 == 2 || i2 == 1 || i2 == 7;
        }

        public final void handleMessage(Message message) {
            b bVar;
            b bVar2;
            if (C0307b.this.C.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                }
                return;
            }
            int i2 = message.what;
            if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !C0307b.this.j()) || message.what == 5)) && !C0307b.this.a()) {
                a(message);
                return;
            }
            int i3 = message.what;
            PendingIntent pendingIntent = null;
            if (i3 == 4) {
                C0307b.this.z = new b(message.arg2);
                if (!C0307b.this.y() || C0307b.this.A) {
                    if (C0307b.this.z != null) {
                        bVar2 = C0307b.this.z;
                    } else {
                        bVar2 = new b(8);
                    }
                    C0307b.this.q.a(bVar2);
                    C0307b.this.a(bVar2);
                    return;
                }
                C0307b.this.b(3, null);
            } else if (i3 == 5) {
                if (C0307b.this.z != null) {
                    bVar = C0307b.this.z;
                } else {
                    bVar = new b(8);
                }
                C0307b.this.q.a(bVar);
                C0307b.this.a(bVar);
            } else if (i3 == 3) {
                Object obj = message.obj;
                if (obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) obj;
                }
                b bVar3 = new b(message.arg2, pendingIntent);
                C0307b.this.q.a(bVar3);
                C0307b.this.a(bVar3);
            } else if (i3 == 6) {
                C0307b.this.b(5, null);
                if (C0307b.this.v != null) {
                    C0307b.this.v.c(message.arg2);
                }
                C0307b.this.a(message.arg2);
                C0307b.this.a(5, 1, null);
            } else if (i3 == 2 && !C0307b.this.isConnected()) {
                a(message);
            } else if (b(message)) {
                ((h) message.obj).d();
            } else {
                int i4 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i4);
                Log.wtf("GmsClient", sb.toString(), new Exception());
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.b$h */
    protected abstract class h<TListener> {

        /* renamed from: a reason: collision with root package name */
        private TListener f4706a;

        /* renamed from: b reason: collision with root package name */
        private boolean f4707b = false;

        public h(TListener tlistener) {
            this.f4706a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.f4706a = null;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void a(TListener tlistener);

        public final void b() {
            a();
            synchronized (C0307b.this.s) {
                C0307b.this.s.remove(this);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void c();

        public final void d() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f4706a;
                if (this.f4707b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e2) {
                    c();
                    throw e2;
                }
            } else {
                c();
            }
            synchronized (this) {
                this.f4707b = true;
            }
            b();
        }
    }

    /* renamed from: com.google.android.gms.common.internal.b$i */
    public static final class i extends com.google.android.gms.common.internal.C0318m.a {

        /* renamed from: a reason: collision with root package name */
        private C0307b f4709a;

        /* renamed from: b reason: collision with root package name */
        private final int f4710b;

        public i(C0307b bVar, int i2) {
            this.f4709a = bVar;
            this.f4710b = i2;
        }

        public final void a(int i2, IBinder iBinder, Bundle bundle) {
            q.a(this.f4709a, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f4709a.a(i2, iBinder, bundle, this.f4710b);
            this.f4709a = null;
        }

        public final void b(int i2, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        public final void a(int i2, IBinder iBinder, B b2) {
            q.a(this.f4709a, (Object) "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            q.a(b2);
            this.f4709a.a(b2);
            a(i2, iBinder, b2.f4664a);
        }
    }

    /* renamed from: com.google.android.gms.common.internal.b$j */
    public final class j implements ServiceConnection {

        /* renamed from: a reason: collision with root package name */
        private final int f4711a;

        public j(int i2) {
            this.f4711a = i2;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            C0320o oVar;
            if (iBinder == null) {
                C0307b.this.c(16);
                return;
            }
            synchronized (C0307b.this.o) {
                C0307b bVar = C0307b.this;
                if (iBinder == null) {
                    oVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof C0320o)) {
                        oVar = new C0319n(iBinder);
                    } else {
                        oVar = (C0320o) queryLocalInterface;
                    }
                }
                bVar.p = oVar;
            }
            C0307b.this.a(0, (Bundle) null, this.f4711a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (C0307b.this.o) {
                C0307b.this.p = null;
            }
            Handler handler = C0307b.this.m;
            handler.sendMessage(handler.obtainMessage(6, this.f4711a, 1));
        }
    }

    /* renamed from: com.google.android.gms.common.internal.b$k */
    protected final class k extends f {

        /* renamed from: g reason: collision with root package name */
        private final IBinder f4713g;

        public k(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            this.f4713g = iBinder;
        }

        /* access modifiers changed from: protected */
        public final void a(b bVar) {
            if (C0307b.this.w != null) {
                C0307b.this.w.a(bVar);
            }
            C0307b.this.a(bVar);
        }

        /* access modifiers changed from: protected */
        public final boolean e() {
            String str = "GmsClient";
            try {
                String interfaceDescriptor = this.f4713g.getInterfaceDescriptor();
                if (!C0307b.this.s().equals(interfaceDescriptor)) {
                    String s = C0307b.this.s();
                    StringBuilder sb = new StringBuilder(String.valueOf(s).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(s);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e(str, sb.toString());
                    return false;
                }
                IInterface a2 = C0307b.this.a(this.f4713g);
                if (a2 == null || (!C0307b.this.a(2, 4, a2) && !C0307b.this.a(3, 4, a2))) {
                    return false;
                }
                C0307b.this.z = null;
                Bundle m = C0307b.this.m();
                if (C0307b.this.v != null) {
                    C0307b.this.v.e(m);
                }
                return true;
            } catch (RemoteException unused) {
                Log.w(str, "service probably died");
                return false;
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.b$l */
    protected final class l extends f {
        public l(int i2, Bundle bundle) {
            super(i2, null);
        }

        /* access modifiers changed from: protected */
        public final void a(b bVar) {
            if (!C0307b.this.j() || !C0307b.this.y()) {
                C0307b.this.q.a(bVar);
                C0307b.this.a(bVar);
                return;
            }
            C0307b.this.c(16);
        }

        /* access modifiers changed from: protected */
        public final boolean e() {
            C0307b.this.q.a(b.f4639a);
            return true;
        }
    }

    protected C0307b(Context context, Looper looper, int i2, a aVar, C0064b bVar, String str) {
        C0314i a2 = C0314i.a(context);
        com.google.android.gms.common.f a3 = com.google.android.gms.common.f.a();
        q.a(aVar);
        a aVar2 = aVar;
        q.a(bVar);
        this(context, looper, a2, a3, i2, aVar2, bVar, str);
    }

    /* access modifiers changed from: private */
    public final void a(B b2) {
        this.B = b2;
    }

    /* access modifiers changed from: private */
    public final void b(int i2, T t2) {
        H h2;
        q.a((i2 == 4) == (t2 != null));
        synchronized (this.n) {
            this.u = i2;
            this.r = t2;
            a(i2, t2);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (!(this.t == null || this.f4696h == null)) {
                        String c2 = this.f4696h.c();
                        String a2 = this.f4696h.a();
                        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 70 + String.valueOf(a2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(c2);
                        sb.append(" on ");
                        sb.append(a2);
                        Log.e("GmsClient", sb.toString());
                        this.f4699k.a(this.f4696h.c(), this.f4696h.a(), this.f4696h.b(), this.t, w());
                        this.C.incrementAndGet();
                    }
                    this.t = new j(this.C.get());
                    if (this.u != 3 || p() == null) {
                        h2 = new H(u(), t(), false, 129);
                    } else {
                        h2 = new H(n().getPackageName(), p(), true, 129);
                    }
                    this.f4696h = h2;
                    if (!this.f4699k.a(new a(this.f4696h.c(), this.f4696h.a(), this.f4696h.b()), this.t, w())) {
                        String c3 = this.f4696h.c();
                        String a3 = this.f4696h.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c3).length() + 34 + String.valueOf(a3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(c3);
                        sb2.append(" on ");
                        sb2.append(a3);
                        Log.e("GmsClient", sb2.toString());
                        a(16, (Bundle) null, this.C.get());
                    }
                } else if (i2 == 4) {
                    a(t2);
                }
            } else if (this.t != null) {
                this.f4699k.a(this.f4696h.c(), this.f4696h.a(), this.f4696h.b(), this.t, w());
                this.t = null;
            }
        }
    }

    private final String w() {
        String str = this.y;
        return str == null ? this.f4697i.getClass().getName() : str;
    }

    private final boolean x() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.u == 3;
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public final boolean y() {
        if (this.A || TextUtils.isEmpty(s()) || TextUtils.isEmpty(p())) {
            return false;
        }
        try {
            Class.forName(s());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public abstract T a(IBinder iBinder);

    /* access modifiers changed from: 0000 */
    public void a(int i2, T t2) {
    }

    public void c() {
        this.C.incrementAndGet();
        synchronized (this.s) {
            int size = this.s.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((h) this.s.get(i2)).a();
            }
            this.s.clear();
        }
        synchronized (this.o) {
            this.p = null;
        }
        b(1, null);
    }

    public boolean d() {
        return true;
    }

    public int e() {
        return com.google.android.gms.common.f.f4660a;
    }

    public final com.google.android.gms.common.d[] f() {
        B b2 = this.B;
        if (b2 == null) {
            return null;
        }
        return b2.f4665b;
    }

    public boolean g() {
        return false;
    }

    public void h() {
        int a2 = this.f4700l.a(this.f4697i, e());
        if (a2 != 0) {
            b(1, null);
            a((c) new d(), a2, (PendingIntent) null);
            return;
        }
        a((c) new d());
    }

    /* access modifiers changed from: protected */
    public final void i() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public boolean isConnected() {
        boolean z2;
        synchronized (this.n) {
            z2 = this.u == 4;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public boolean j() {
        return false;
    }

    public Account k() {
        return null;
    }

    public com.google.android.gms.common.d[] l() {
        return f4689a;
    }

    public Bundle m() {
        return null;
    }

    public final Context n() {
        return this.f4697i;
    }

    /* access modifiers changed from: protected */
    public Bundle o() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    public String p() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> q() {
        return Collections.EMPTY_SET;
    }

    public final T r() throws DeadObjectException {
        T t2;
        synchronized (this.n) {
            if (this.u != 5) {
                i();
                q.b(this.r != null, "Client is connected but service is null");
                t2 = this.r;
            } else {
                throw new DeadObjectException();
            }
        }
        return t2;
    }

    /* access modifiers changed from: protected */
    public abstract String s();

    /* access modifiers changed from: protected */
    public abstract String t();

    /* access modifiers changed from: protected */
    public String u() {
        return "com.google.android.gms";
    }

    public boolean v() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void a(T t2) {
        this.f4693e = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        this.f4691c = i2;
        this.f4692d = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        this.f4694f = bVar.f();
        this.f4695g = System.currentTimeMillis();
    }

    protected C0307b(Context context, Looper looper, C0314i iVar, com.google.android.gms.common.f fVar, int i2, a aVar, C0064b bVar, String str) {
        this.n = new Object();
        this.o = new Object();
        this.s = new ArrayList<>();
        this.u = 1;
        this.z = null;
        this.A = false;
        this.B = null;
        this.C = new AtomicInteger(0);
        q.a(context, (Object) "Context must not be null");
        this.f4697i = context;
        q.a(looper, (Object) "Looper must not be null");
        this.f4698j = looper;
        q.a(iVar, (Object) "Supervisor must not be null");
        this.f4699k = iVar;
        q.a(fVar, (Object) "API availability must not be null");
        this.f4700l = fVar;
        this.m = new g(looper);
        this.x = i2;
        this.v = aVar;
        this.w = bVar;
        this.y = str;
    }

    /* access modifiers changed from: private */
    public final boolean a(int i2, int i3, T t2) {
        synchronized (this.n) {
            if (this.u != i2) {
                return false;
            }
            b(i3, t2);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final void c(int i2) {
        int i3;
        if (x()) {
            i3 = 5;
            this.A = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(i3, this.C.get(), 16));
    }

    public void a(c cVar) {
        q.a(cVar, (Object) "Connection progress callbacks cannot be null.");
        this.q = cVar;
        b(2, null);
    }

    public boolean a() {
        boolean z2;
        synchronized (this.n) {
            if (this.u != 2) {
                if (this.u != 3) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* access modifiers changed from: protected */
    public void a(c cVar, int i2, PendingIntent pendingIntent) {
        q.a(cVar, (Object) "Connection progress callbacks cannot be null.");
        this.q = cVar;
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(3, this.C.get(), i2, pendingIntent));
    }

    /* access modifiers changed from: protected */
    public void a(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public final void a(int i2, Bundle bundle, int i3) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2, null)));
    }

    public void a(C0316k kVar, Set<Scope> set) {
        Bundle o2 = o();
        C0311f fVar = new C0311f(this.x);
        fVar.f4739d = this.f4697i.getPackageName();
        fVar.f4742g = o2;
        if (set != null) {
            fVar.f4741f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (g()) {
            fVar.f4743h = k() != null ? k() : new Account("<<default account>>", "com.google");
            if (kVar != null) {
                fVar.f4740e = kVar.asBinder();
            }
        } else if (v()) {
            fVar.f4743h = k();
        }
        fVar.f4744i = f4689a;
        fVar.f4745j = l();
        try {
            synchronized (this.o) {
                if (this.p != null) {
                    this.p.a(new i(this, this.C.get()), fVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            b(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e4);
            a(8, (IBinder) null, (Bundle) null, this.C.get());
        }
    }

    public void b(int i2) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(6, this.C.get(), i2));
    }

    public String b() {
        if (isConnected()) {
            H h2 = this.f4696h;
            if (h2 != null) {
                return h2.a();
            }
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public void a(e eVar) {
        eVar.a();
    }
}
