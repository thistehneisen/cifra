package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import b.d.d;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.a.f;
import com.google.android.gms.common.api.internal.C0298a.C0062a;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.C0307b;
import com.google.android.gms.common.internal.C0315j;
import com.google.android.gms.common.internal.C0316k;
import com.google.android.gms.common.internal.C0321p;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.t;
import com.google.android.gms.common.util.k;
import com.google.android.gms.tasks.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.gms.common.api.internal.b reason: case insensitive filesystem */
public class C0299b implements Callback {

    /* renamed from: a reason: collision with root package name */
    public static final Status f4569a = new Status(4, "Sign-out occurred while this API call was in progress.");
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public static final Status f4570b = new Status(4, "The user must be signed in to make this API call.");
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public static final Object f4571c = new Object();

    /* renamed from: d reason: collision with root package name */
    private static C0299b f4572d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public long f4573e = 5000;
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public long f4574f = 120000;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public long f4575g = 10000;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public final Context f4576h;
    /* access modifiers changed from: private */

    /* renamed from: i reason: collision with root package name */
    public final e f4577i;
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public final C0315j f4578j;

    /* renamed from: k reason: collision with root package name */
    private final AtomicInteger f4579k = new AtomicInteger(1);

    /* renamed from: l reason: collision with root package name */
    private final AtomicInteger f4580l = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final Map<D<?>, a<?>> m = new ConcurrentHashMap(5, 0.75f, 1);
    /* access modifiers changed from: private */
    public j n = null;
    /* access modifiers changed from: private */
    public final Set<D<?>> o = new d();
    private final Set<D<?>> p = new d();
    /* access modifiers changed from: private */
    public final Handler q;

    /* renamed from: com.google.android.gms.common.api.internal.b$a */
    public class a<O extends com.google.android.gms.common.api.a.d> implements com.google.android.gms.common.api.d, com.google.android.gms.common.api.e, H {

        /* renamed from: a reason: collision with root package name */
        private final Queue<l> f4581a = new LinkedList();
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public final f f4582b;

        /* renamed from: c reason: collision with root package name */
        private final b f4583c;

        /* renamed from: d reason: collision with root package name */
        private final D<O> f4584d;

        /* renamed from: e reason: collision with root package name */
        private final i f4585e;

        /* renamed from: f reason: collision with root package name */
        private final Set<E> f4586f = new HashSet();

        /* renamed from: g reason: collision with root package name */
        private final Map<C0303f<?>, t> f4587g = new HashMap();

        /* renamed from: h reason: collision with root package name */
        private final int f4588h;

        /* renamed from: i reason: collision with root package name */
        private final v f4589i;

        /* renamed from: j reason: collision with root package name */
        private boolean f4590j;

        /* renamed from: k reason: collision with root package name */
        private final List<C0063b> f4591k = new ArrayList();

        /* renamed from: l reason: collision with root package name */
        private com.google.android.gms.common.b f4592l = null;

        public a(com.google.android.gms.common.api.c<O> cVar) {
            this.f4582b = cVar.a(C0299b.this.q.getLooper(), this);
            f fVar = this.f4582b;
            if (fVar instanceof t) {
                this.f4583c = ((t) fVar).w();
            } else {
                this.f4583c = fVar;
            }
            this.f4584d = cVar.c();
            this.f4585e = new i();
            this.f4588h = cVar.b();
            if (this.f4582b.g()) {
                this.f4589i = cVar.a(C0299b.this.f4576h, C0299b.this.q);
            } else {
                this.f4589i = null;
            }
        }

        private final void d(com.google.android.gms.common.b bVar) {
            for (E e2 : this.f4586f) {
                String str = null;
                if (C0321p.a(bVar, com.google.android.gms.common.b.f4639a)) {
                    str = this.f4582b.b();
                }
                e2.a(this.f4584d, bVar, str);
            }
            this.f4586f.clear();
        }

        /* access modifiers changed from: private */
        public final void m() {
            j();
            d(com.google.android.gms.common.b.f4639a);
            p();
            Iterator it = this.f4587g.values().iterator();
            while (it.hasNext()) {
                t tVar = (t) it.next();
                if (a(tVar.f4624a.b()) != null) {
                    it.remove();
                } else {
                    try {
                        tVar.f4624a.a(this.f4583c, new h());
                    } catch (DeadObjectException unused) {
                        c(1);
                        this.f4582b.c();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            o();
            q();
        }

        /* access modifiers changed from: private */
        public final void n() {
            j();
            this.f4590j = true;
            this.f4585e.c();
            C0299b.this.q.sendMessageDelayed(Message.obtain(C0299b.this.q, 9, this.f4584d), C0299b.this.f4573e);
            C0299b.this.q.sendMessageDelayed(Message.obtain(C0299b.this.q, 11, this.f4584d), C0299b.this.f4574f);
            C0299b.this.f4578j.a();
        }

        private final void o() {
            ArrayList arrayList = new ArrayList(this.f4581a);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                l lVar = (l) obj;
                if (!this.f4582b.isConnected()) {
                    return;
                }
                if (b(lVar)) {
                    this.f4581a.remove(lVar);
                }
            }
        }

        private final void p() {
            if (this.f4590j) {
                C0299b.this.q.removeMessages(11, this.f4584d);
                C0299b.this.q.removeMessages(9, this.f4584d);
                this.f4590j = false;
            }
        }

        private final void q() {
            C0299b.this.q.removeMessages(12, this.f4584d);
            C0299b.this.q.sendMessageDelayed(C0299b.this.q.obtainMessage(12, this.f4584d), C0299b.this.f4575g);
        }

        public final void a(com.google.android.gms.common.b bVar) {
            q.a(C0299b.this.q);
            v vVar = this.f4589i;
            if (vVar != null) {
                vVar.h();
            }
            j();
            C0299b.this.f4578j.a();
            d(bVar);
            if (bVar.f() == 4) {
                a(C0299b.f4570b);
            } else if (this.f4581a.isEmpty()) {
                this.f4592l = bVar;
            } else {
                if (!c(bVar) && !C0299b.this.b(bVar, this.f4588h)) {
                    if (bVar.f() == 18) {
                        this.f4590j = true;
                    }
                    if (this.f4590j) {
                        C0299b.this.q.sendMessageDelayed(Message.obtain(C0299b.this.q, 9, this.f4584d), C0299b.this.f4573e);
                        return;
                    }
                    String a2 = this.f4584d.a();
                    StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 38);
                    sb.append("API: ");
                    sb.append(a2);
                    sb.append(" is not available on this device.");
                    a(new Status(17, sb.toString()));
                }
            }
        }

        public final void b(com.google.android.gms.common.b bVar) {
            q.a(C0299b.this.q);
            this.f4582b.c();
            a(bVar);
        }

        public final void c(int i2) {
            if (Looper.myLooper() == C0299b.this.q.getLooper()) {
                n();
            } else {
                C0299b.this.q.post(new o(this));
            }
        }

        public final void e(Bundle bundle) {
            if (Looper.myLooper() == C0299b.this.q.getLooper()) {
                m();
            } else {
                C0299b.this.q.post(new n(this));
            }
        }

        public final f f() {
            return this.f4582b;
        }

        public final void g() {
            Status status;
            q.a(C0299b.this.q);
            if (this.f4590j) {
                p();
                if (C0299b.this.f4577i.b(C0299b.this.f4576h) == 18) {
                    status = new Status(8, "Connection timed out while waiting for Google Play services update to complete.");
                } else {
                    status = new Status(8, "API failed to connect while resuming due to an unknown error.");
                }
                a(status);
                this.f4582b.c();
            }
        }

        public final void h() {
            q.a(C0299b.this.q);
            a(C0299b.f4569a);
            this.f4585e.b();
            for (C0303f c2 : (C0303f[]) this.f4587g.keySet().toArray(new C0303f[this.f4587g.size()])) {
                a((l) new C(c2, new h()));
            }
            d(new com.google.android.gms.common.b(4));
            if (this.f4582b.isConnected()) {
                this.f4582b.a((C0307b.e) new p(this));
            }
        }

        public final Map<C0303f<?>, t> i() {
            return this.f4587g;
        }

        public final void j() {
            q.a(C0299b.this.q);
            this.f4592l = null;
        }

        public final com.google.android.gms.common.b k() {
            q.a(C0299b.this.q);
            return this.f4592l;
        }

        public final boolean l() {
            return a(true);
        }

        private final boolean b(l lVar) {
            if (!(lVar instanceof u)) {
                c(lVar);
                return true;
            }
            u uVar = (u) lVar;
            com.google.android.gms.common.d a2 = a(uVar.b(this));
            if (a2 == null) {
                c(lVar);
                return true;
            }
            if (uVar.c(this)) {
                C0063b bVar = new C0063b(this.f4584d, a2, null);
                int indexOf = this.f4591k.indexOf(bVar);
                if (indexOf >= 0) {
                    C0063b bVar2 = (C0063b) this.f4591k.get(indexOf);
                    C0299b.this.q.removeMessages(15, bVar2);
                    C0299b.this.q.sendMessageDelayed(Message.obtain(C0299b.this.q, 15, bVar2), C0299b.this.f4573e);
                } else {
                    this.f4591k.add(bVar);
                    C0299b.this.q.sendMessageDelayed(Message.obtain(C0299b.this.q, 15, bVar), C0299b.this.f4573e);
                    C0299b.this.q.sendMessageDelayed(Message.obtain(C0299b.this.q, 16, bVar), C0299b.this.f4574f);
                    com.google.android.gms.common.b bVar3 = new com.google.android.gms.common.b(2, null);
                    if (!c(bVar3)) {
                        C0299b.this.b(bVar3, this.f4588h);
                    }
                }
            } else {
                uVar.a((RuntimeException) new UnsupportedApiCallException(a2));
            }
            return false;
        }

        private final boolean c(com.google.android.gms.common.b bVar) {
            synchronized (C0299b.f4571c) {
                if (C0299b.this.n != null) {
                    if (C0299b.this.o.contains(this.f4584d)) {
                        C0299b.this.n.a(bVar, this.f4588h);
                        throw null;
                    }
                }
            }
            return false;
        }

        public final void e() {
            q.a(C0299b.this.q);
            if (this.f4590j) {
                a();
            }
        }

        public final boolean d() {
            return this.f4582b.g();
        }

        private final void c(l lVar) {
            lVar.a(this.f4585e, d());
            try {
                lVar.a(this);
            } catch (DeadObjectException unused) {
                c(1);
                this.f4582b.c();
            }
        }

        /* access modifiers changed from: 0000 */
        public final boolean c() {
            return this.f4582b.isConnected();
        }

        public final void a(l lVar) {
            q.a(C0299b.this.q);
            if (!this.f4582b.isConnected()) {
                this.f4581a.add(lVar);
                com.google.android.gms.common.b bVar = this.f4592l;
                if (bVar == null || !bVar.i()) {
                    a();
                } else {
                    a(this.f4592l);
                }
            } else if (b(lVar)) {
                q();
            } else {
                this.f4581a.add(lVar);
            }
        }

        public final int b() {
            return this.f4588h;
        }

        /* access modifiers changed from: private */
        public final void b(C0063b bVar) {
            if (this.f4591k.remove(bVar)) {
                C0299b.this.q.removeMessages(15, bVar);
                C0299b.this.q.removeMessages(16, bVar);
                com.google.android.gms.common.d b2 = bVar.f4594b;
                ArrayList arrayList = new ArrayList(this.f4581a.size());
                for (l lVar : this.f4581a) {
                    if (lVar instanceof u) {
                        com.google.android.gms.common.d[] b3 = ((u) lVar).b(this);
                        if (b3 != null && com.google.android.gms.common.util.b.a(b3, b2)) {
                            arrayList.add(lVar);
                        }
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    l lVar2 = (l) obj;
                    this.f4581a.remove(lVar2);
                    lVar2.a((RuntimeException) new UnsupportedApiCallException(b2));
                }
            }
        }

        public final void a(Status status) {
            q.a(C0299b.this.q);
            for (l a2 : this.f4581a) {
                a2.a(status);
            }
            this.f4581a.clear();
        }

        /* access modifiers changed from: private */
        public final boolean a(boolean z) {
            q.a(C0299b.this.q);
            if (!this.f4582b.isConnected() || this.f4587g.size() != 0) {
                return false;
            }
            if (this.f4585e.a()) {
                if (z) {
                    q();
                }
                return false;
            }
            this.f4582b.c();
            return true;
        }

        public final void a() {
            q.a(C0299b.this.q);
            if (!this.f4582b.isConnected() && !this.f4582b.a()) {
                int a2 = C0299b.this.f4578j.a(C0299b.this.f4576h, this.f4582b);
                if (a2 != 0) {
                    a(new com.google.android.gms.common.b(a2, null));
                    return;
                }
                c cVar = new c(this.f4582b, this.f4584d);
                if (this.f4582b.g()) {
                    this.f4589i.a((y) cVar);
                }
                this.f4582b.a((com.google.android.gms.common.internal.C0307b.c) cVar);
            }
        }

        public final void a(E e2) {
            q.a(C0299b.this.q);
            this.f4586f.add(e2);
        }

        private final com.google.android.gms.common.d a(com.google.android.gms.common.d[] dVarArr) {
            if (!(dVarArr == null || dVarArr.length == 0)) {
                com.google.android.gms.common.d[] f2 = this.f4582b.f();
                if (f2 == null) {
                    f2 = new com.google.android.gms.common.d[0];
                }
                b.d.b bVar = new b.d.b(f2.length);
                for (com.google.android.gms.common.d dVar : f2) {
                    bVar.put(dVar.f(), Long.valueOf(dVar.g()));
                }
                for (com.google.android.gms.common.d dVar2 : dVarArr) {
                    if (!bVar.containsKey(dVar2.f()) || ((Long) bVar.get(dVar2.f())).longValue() < dVar2.g()) {
                        return dVar2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final void a(C0063b bVar) {
            if (this.f4591k.contains(bVar) && !this.f4590j) {
                if (!this.f4582b.isConnected()) {
                    a();
                    return;
                }
                o();
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.b$b reason: collision with other inner class name */
    private static class C0063b {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public final D<?> f4593a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public final com.google.android.gms.common.d f4594b;

        private C0063b(D<?> d2, com.google.android.gms.common.d dVar) {
            this.f4593a = d2;
            this.f4594b = dVar;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof C0063b)) {
                C0063b bVar = (C0063b) obj;
                if (C0321p.a(this.f4593a, bVar.f4593a) && C0321p.a(this.f4594b, bVar.f4594b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return C0321p.a(this.f4593a, this.f4594b);
        }

        public final String toString() {
            com.google.android.gms.common.internal.C0321p.a a2 = C0321p.a((Object) this);
            a2.a("key", this.f4593a);
            a2.a("feature", this.f4594b);
            return a2.toString();
        }

        /* synthetic */ C0063b(D d2, com.google.android.gms.common.d dVar, m mVar) {
            this(d2, dVar);
        }
    }

    /* renamed from: com.google.android.gms.common.api.internal.b$c */
    private class c implements y, com.google.android.gms.common.internal.C0307b.c {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public final f f4595a;
        /* access modifiers changed from: private */

        /* renamed from: b reason: collision with root package name */
        public final D<?> f4596b;

        /* renamed from: c reason: collision with root package name */
        private C0316k f4597c = null;

        /* renamed from: d reason: collision with root package name */
        private Set<Scope> f4598d = null;
        /* access modifiers changed from: private */

        /* renamed from: e reason: collision with root package name */
        public boolean f4599e = false;

        public c(f fVar, D<?> d2) {
            this.f4595a = fVar;
            this.f4596b = d2;
        }

        public final void a(com.google.android.gms.common.b bVar) {
            C0299b.this.q.post(new r(this, bVar));
        }

        public final void b(com.google.android.gms.common.b bVar) {
            ((a) C0299b.this.m.get(this.f4596b)).b(bVar);
        }

        public final void a(C0316k kVar, Set<Scope> set) {
            if (kVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                b(new com.google.android.gms.common.b(4));
                return;
            }
            this.f4597c = kVar;
            this.f4598d = set;
            a();
        }

        /* access modifiers changed from: private */
        public final void a() {
            if (this.f4599e) {
                C0316k kVar = this.f4597c;
                if (kVar != null) {
                    this.f4595a.a(kVar, this.f4598d);
                }
            }
        }
    }

    private C0299b(Context context, Looper looper, e eVar) {
        this.f4576h = context;
        this.q = new c.b.a.b.b.b.d(looper, this);
        this.f4577i = eVar;
        this.f4578j = new C0315j(eVar);
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static C0299b a(Context context) {
        C0299b bVar;
        synchronized (f4571c) {
            if (f4572d == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f4572d = new C0299b(context.getApplicationContext(), handlerThread.getLooper(), e.a());
            }
            bVar = f4572d;
        }
        return bVar;
    }

    /* access modifiers changed from: 0000 */
    public final boolean b(com.google.android.gms.common.b bVar, int i2) {
        return this.f4577i.a(this.f4576h, bVar, i2);
    }

    public final void c() {
        Handler handler = this.q;
        handler.sendMessage(handler.obtainMessage(3));
    }

    public boolean handleMessage(Message message) {
        a aVar;
        int i2 = message.what;
        long j2 = 300000;
        String str = "GoogleApiManager";
        switch (i2) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.f4575g = j2;
                this.q.removeMessages(12);
                for (D d2 : this.m.keySet()) {
                    Handler handler = this.q;
                    handler.sendMessageDelayed(handler.obtainMessage(12, d2), this.f4575g);
                }
                break;
            case 2:
                E e2 = (E) message.obj;
                Iterator it = e2.a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        D d3 = (D) it.next();
                        a aVar2 = (a) this.m.get(d3);
                        if (aVar2 == null) {
                            e2.a(d3, new com.google.android.gms.common.b(13), null);
                            break;
                        } else if (aVar2.c()) {
                            e2.a(d3, com.google.android.gms.common.b.f4639a, aVar2.f().b());
                        } else if (aVar2.k() != null) {
                            e2.a(d3, aVar2.k(), null);
                        } else {
                            aVar2.a(e2);
                            aVar2.a();
                        }
                    }
                }
            case 3:
                for (a aVar3 : this.m.values()) {
                    aVar3.j();
                    aVar3.a();
                }
                break;
            case 4:
            case 8:
            case 13:
                s sVar = (s) message.obj;
                a aVar4 = (a) this.m.get(sVar.f4623c.c());
                if (aVar4 == null) {
                    a(sVar.f4623c);
                    aVar4 = (a) this.m.get(sVar.f4623c.c());
                }
                if (aVar4.d() && this.f4580l.get() != sVar.f4622b) {
                    sVar.f4621a.a(f4569a);
                    aVar4.h();
                    break;
                } else {
                    aVar4.a(sVar.f4621a);
                    break;
                }
                break;
            case 5:
                int i3 = message.arg1;
                com.google.android.gms.common.b bVar = (com.google.android.gms.common.b) message.obj;
                Iterator it2 = this.m.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        aVar = (a) it2.next();
                        if (aVar.b() == i3) {
                        }
                    } else {
                        aVar = null;
                    }
                }
                if (aVar == null) {
                    StringBuilder sb = new StringBuilder(76);
                    sb.append("Could not find API instance ");
                    sb.append(i3);
                    sb.append(" while trying to fail enqueued calls.");
                    Log.wtf(str, sb.toString(), new Exception());
                    break;
                } else {
                    String a2 = this.f4577i.a(bVar.f());
                    String g2 = bVar.g();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(a2).length() + 69 + String.valueOf(g2).length());
                    sb2.append("Error resolution was canceled by the user, original error message: ");
                    sb2.append(a2);
                    sb2.append(": ");
                    sb2.append(g2);
                    aVar.a(new Status(17, sb2.toString()));
                    break;
                }
            case 6:
                if (k.a() && (this.f4576h.getApplicationContext() instanceof Application)) {
                    C0298a.a((Application) this.f4576h.getApplicationContext());
                    C0298a.a().a((C0062a) new m(this));
                    if (!C0298a.a().a(true)) {
                        this.f4575g = 300000;
                        break;
                    }
                }
                break;
            case 7:
                a((com.google.android.gms.common.api.c) message.obj);
                break;
            case 9:
                if (this.m.containsKey(message.obj)) {
                    ((a) this.m.get(message.obj)).e();
                    break;
                }
                break;
            case 10:
                for (D remove : this.p) {
                    ((a) this.m.remove(remove)).h();
                }
                this.p.clear();
                break;
            case 11:
                if (this.m.containsKey(message.obj)) {
                    ((a) this.m.get(message.obj)).g();
                    break;
                }
                break;
            case 12:
                if (this.m.containsKey(message.obj)) {
                    ((a) this.m.get(message.obj)).l();
                    break;
                }
                break;
            case 14:
                k kVar = (k) message.obj;
                D b2 = kVar.b();
                if (this.m.containsKey(b2)) {
                    kVar.a().a(Boolean.valueOf(((a) this.m.get(b2)).a(false)));
                    break;
                } else {
                    kVar.a().a(Boolean.valueOf(false));
                    break;
                }
            case 15:
                C0063b bVar2 = (C0063b) message.obj;
                if (this.m.containsKey(bVar2.f4593a)) {
                    ((a) this.m.get(bVar2.f4593a)).a(bVar2);
                    break;
                }
                break;
            case 16:
                C0063b bVar3 = (C0063b) message.obj;
                if (this.m.containsKey(bVar3.f4593a)) {
                    ((a) this.m.get(bVar3.f4593a)).b(bVar3);
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i2);
                Log.w(str, sb3.toString());
                return false;
        }
        return true;
    }

    private final void a(com.google.android.gms.common.api.c<?> cVar) {
        D c2 = cVar.c();
        a aVar = (a) this.m.get(c2);
        if (aVar == null) {
            aVar = new a(cVar);
            this.m.put(c2, aVar);
        }
        if (aVar.d()) {
            this.p.add(c2);
        }
        aVar.a();
    }

    public final void a(com.google.android.gms.common.b bVar, int i2) {
        if (!b(bVar, i2)) {
            Handler handler = this.q;
            handler.sendMessage(handler.obtainMessage(5, i2, 0, bVar));
        }
    }
}
