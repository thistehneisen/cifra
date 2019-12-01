package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import com.google.android.gms.common.g;
import com.google.android.gms.common.h;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public final class Pb extends C0482ab {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public final Kd f5680a;

    /* renamed from: b reason: collision with root package name */
    private Boolean f5681b;

    /* renamed from: c reason: collision with root package name */
    private String f5682c;

    public Pb(Kd kd) {
        this(kd, null);
    }

    public final void a(C0525j jVar, ae aeVar) {
        q.a(jVar);
        b(aeVar, false);
        a((Runnable) new C0488bc(this, jVar, aeVar));
    }

    /* access modifiers changed from: 0000 */
    public final C0525j b(C0525j jVar, ae aeVar) {
        boolean z = false;
        if ("_cmp".equals(jVar.f5953a)) {
            C0520i iVar = jVar.f5954b;
            if (!(iVar == null || iVar.size() == 0)) {
                String c2 = jVar.f5954b.c("_cis");
                if (!TextUtils.isEmpty(c2) && (("referrer broadcast".equals(c2) || "referrer API".equals(c2)) && this.f5680a.g().l(aeVar.f5819a))) {
                    z = true;
                }
            }
        }
        if (!z) {
            return jVar;
        }
        this.f5680a.e().z().a("Event has been filtered ", jVar.toString());
        C0525j jVar2 = new C0525j("_cmpx", jVar.f5954b, jVar.f5955c, jVar.f5956d);
        return jVar2;
    }

    public final void c(ae aeVar) {
        b(aeVar, false);
        a((Runnable) new C0523ic(this, aeVar));
    }

    public final void d(ae aeVar) {
        b(aeVar, false);
        a((Runnable) new Sb(this, aeVar));
    }

    private Pb(Kd kd, String str) {
        q.a(kd);
        this.f5680a = kd;
        this.f5682c = null;
    }

    public final void a(C0525j jVar, String str, String str2) {
        q.a(jVar);
        q.b(str);
        a(str, true);
        a((Runnable) new C0483ac(this, jVar, str));
    }

    public final byte[] a(C0525j jVar, String str) {
        q.b(str);
        q.a(jVar);
        a(str, true);
        this.f5680a.e().A().a("Log and bundle. event", this.f5680a.s().a(jVar.f5953a));
        long b2 = this.f5680a.c().b() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f5680a.d().b((Callable<V>) new C0498dc<V>(this, jVar, str)).get();
            if (bArr == null) {
                this.f5680a.e().t().a("Log and bundle returned null. appId", C0532kb.a(str));
                bArr = new byte[0];
            }
            this.f5680a.e().A().a("Log and bundle processed. event, size, time_ms", this.f5680a.s().a(jVar.f5953a), Integer.valueOf(bArr.length), Long.valueOf((this.f5680a.c().b() / 1000000) - b2));
            return bArr;
        } catch (InterruptedException | ExecutionException e2) {
            this.f5680a.e().t().a("Failed to log and bundle. appId, event, error", C0532kb.a(str), this.f5680a.s().a(jVar.f5953a), e2);
            return null;
        }
    }

    private final void b(ae aeVar, boolean z) {
        q.a(aeVar);
        a(aeVar.f5819a, false);
        this.f5680a.t().d(aeVar.f5820b, aeVar.r);
    }

    public final void b(ae aeVar) {
        a(aeVar.f5819a, false);
        a((Runnable) new Zb(this, aeVar));
    }

    public final void a(Rd rd, ae aeVar) {
        q.a(rd);
        b(aeVar, false);
        if (rd.f() == null) {
            a((Runnable) new C0493cc(this, rd, aeVar));
        } else {
            a((Runnable) new C0513gc(this, rd, aeVar));
        }
    }

    public final List<Rd> a(ae aeVar, boolean z) {
        b(aeVar, false);
        try {
            List<Td> list = (List) this.f5680a.d().a((Callable<V>) new C0508fc<V>(this, aeVar)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (Td td : list) {
                if (z || !Wd.e(td.f5723c)) {
                    arrayList.add(new Rd(td));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f5680a.e().t().a("Failed to get user attributes. appId", C0532kb.a(aeVar.f5819a), e2);
            return null;
        }
    }

    private final void a(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.f5681b == null) {
                        if (!"com.google.android.gms".equals(this.f5682c) && !n.a(this.f5680a.a(), Binder.getCallingUid())) {
                            if (!h.a(this.f5680a.a()).a(Binder.getCallingUid())) {
                                z2 = false;
                                this.f5681b = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.f5681b = Boolean.valueOf(z2);
                    }
                    if (this.f5681b.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e2) {
                    this.f5680a.e().t().a("Measurement Service called with invalid calling package. appId", C0532kb.a(str));
                    throw e2;
                }
            }
            if (this.f5682c == null && g.uidHasPackageName(this.f5680a.a(), Binder.getCallingUid(), str)) {
                this.f5682c = str;
            }
            if (!str.equals(this.f5682c)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        String str2 = "Measurement Service called without app package";
        this.f5680a.e().t().a(str2);
        throw new SecurityException(str2);
    }

    public final void a(long j2, String str, String str2, String str3) {
        C0518hc hcVar = new C0518hc(this, str2, str3, str, j2);
        a((Runnable) hcVar);
    }

    public final String a(ae aeVar) {
        b(aeVar, false);
        return this.f5680a.d(aeVar);
    }

    public final void a(de deVar, ae aeVar) {
        q.a(deVar);
        q.a(deVar.f5879c);
        b(aeVar, false);
        de deVar2 = new de(deVar);
        deVar2.f5877a = aeVar.f5819a;
        if (deVar.f5879c.f() == null) {
            a((Runnable) new Rb(this, deVar2, aeVar));
        } else {
            a((Runnable) new Ub(this, deVar2, aeVar));
        }
    }

    public final void a(de deVar) {
        q.a(deVar);
        q.a(deVar.f5879c);
        a(deVar.f5877a, true);
        de deVar2 = new de(deVar);
        if (deVar.f5879c.f() == null) {
            a((Runnable) new Tb(this, deVar2));
        } else {
            a((Runnable) new Wb(this, deVar2));
        }
    }

    public final List<Rd> a(String str, String str2, boolean z, ae aeVar) {
        b(aeVar, false);
        try {
            List<Td> list = (List) this.f5680a.d().a((Callable<V>) new Vb<V>(this, aeVar, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (Td td : list) {
                if (z || !Wd.e(td.f5723c)) {
                    arrayList.add(new Rd(td));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f5680a.e().t().a("Failed to get user attributes. appId", C0532kb.a(aeVar.f5819a), e2);
            return Collections.emptyList();
        }
    }

    public final List<Rd> a(String str, String str2, String str3, boolean z) {
        a(str, true);
        try {
            List<Td> list = (List) this.f5680a.d().a((Callable<V>) new Yb<V>(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (Td td : list) {
                if (z || !Wd.e(td.f5723c)) {
                    arrayList.add(new Rd(td));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e2) {
            this.f5680a.e().t().a("Failed to get user attributes. appId", C0532kb.a(str), e2);
            return Collections.emptyList();
        }
    }

    public final List<de> a(String str, String str2, ae aeVar) {
        b(aeVar, false);
        try {
            return (List) this.f5680a.d().a((Callable<V>) new Xb<V>(this, aeVar, str, str2)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f5680a.e().t().a("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    public final List<de> a(String str, String str2, String str3) {
        a(str, true);
        try {
            return (List) this.f5680a.d().a((Callable<V>) new _b<V>(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e2) {
            this.f5680a.e().t().a("Failed to get conditional user properties", e2);
            return Collections.emptyList();
        }
    }

    private final void a(Runnable runnable) {
        q.a(runnable);
        if (this.f5680a.d().t()) {
            runnable.run();
        } else {
            this.f5680a.d().a(runnable);
        }
    }
}
