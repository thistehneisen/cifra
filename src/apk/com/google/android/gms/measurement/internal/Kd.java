package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Pair;
import b.d.b;
import com.google.android.gms.common.b.c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.util.d;
import com.google.android.gms.internal.measurement.Af;
import com.google.android.gms.internal.measurement.C0344da;
import com.google.android.gms.internal.measurement.C0428rb;
import com.google.android.gms.internal.measurement.Eb;
import com.google.android.gms.internal.measurement.O;
import com.google.android.gms.internal.measurement.Q;
import com.google.android.gms.internal.measurement.T;
import com.google.android.gms.internal.measurement.U;
import com.google.android.gms.internal.measurement.V;
import com.google.android.gms.internal.measurement.Z;
import io.fabric.sdk.android.a.b.C0730a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Kd implements C0543mc {

    /* renamed from: a reason: collision with root package name */
    private static volatile Kd f5622a;

    /* renamed from: b reason: collision with root package name */
    private Jb f5623b;

    /* renamed from: c reason: collision with root package name */
    private C0552ob f5624c;

    /* renamed from: d reason: collision with root package name */
    private ke f5625d;

    /* renamed from: e reason: collision with root package name */
    private C0566rb f5626e;

    /* renamed from: f reason: collision with root package name */
    private Gd f5627f;

    /* renamed from: g reason: collision with root package name */
    private ce f5628g;

    /* renamed from: h reason: collision with root package name */
    private final Sd f5629h;

    /* renamed from: i reason: collision with root package name */
    private Tc f5630i;

    /* renamed from: j reason: collision with root package name */
    private final Ob f5631j;

    /* renamed from: k reason: collision with root package name */
    private boolean f5632k;

    /* renamed from: l reason: collision with root package name */
    private boolean f5633l;
    private boolean m;
    private long n;
    private List<Runnable> o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private FileLock u;
    private FileChannel v;
    private List<Long> w;
    private List<Long> x;
    private long y;

    class a implements me {

        /* renamed from: a reason: collision with root package name */
        V f5634a;

        /* renamed from: b reason: collision with root package name */
        List<Long> f5635b;

        /* renamed from: c reason: collision with root package name */
        List<Q> f5636c;

        /* renamed from: d reason: collision with root package name */
        private long f5637d;

        private a() {
        }

        public final void a(V v) {
            q.a(v);
            this.f5634a = v;
        }

        /* synthetic */ a(Kd kd, Nd nd) {
            this();
        }

        public final boolean a(long j2, Q q) {
            q.a(q);
            if (this.f5636c == null) {
                this.f5636c = new ArrayList();
            }
            if (this.f5635b == null) {
                this.f5635b = new ArrayList();
            }
            if (this.f5636c.size() > 0 && a((Q) this.f5636c.get(0)) != a(q)) {
                return false;
            }
            long c2 = this.f5637d + ((long) q.c());
            if (c2 >= ((long) Math.max(0, ((Integer) C0535l.t.a(null)).intValue()))) {
                return false;
            }
            this.f5637d = c2;
            this.f5636c.add(q);
            this.f5635b.add(Long.valueOf(j2));
            if (this.f5636c.size() >= Math.max(1, ((Integer) C0535l.u.a(null)).intValue())) {
                return false;
            }
            return true;
        }

        private static long a(Q q) {
            return ((q.q() / 1000) / 60) / 60;
        }
    }

    private Kd(Qd qd) {
        this(qd, null);
    }

    private final boolean A() {
        C();
        String str = "Storage concurrent access okay";
        if (this.f5631j.i().a(C0535l.Na)) {
            FileLock fileLock = this.u;
            if (fileLock != null && fileLock.isValid()) {
                this.f5631j.e().B().a(str);
                return true;
            }
        }
        try {
            this.v = new RandomAccessFile(new File(this.f5631j.a().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.u = this.v.tryLock();
            if (this.u != null) {
                this.f5631j.e().B().a(str);
                return true;
            }
            this.f5631j.e().t().a("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e2) {
            this.f5631j.e().t().a("Failed to acquire storage lock", e2);
        } catch (IOException e3) {
            this.f5631j.e().t().a("Failed to access storage lock file", e3);
        } catch (OverlappingFileLockException e4) {
            this.f5631j.e().w().a("Storage lock already acquired", e4);
        }
    }

    private final boolean B() {
        C();
        n();
        return this.f5633l;
    }

    private final void C() {
        this.f5631j.d().j();
    }

    public static Kd a(Context context) {
        q.a(context);
        q.a(context.getApplicationContext());
        if (f5622a == null) {
            synchronized (Kd.class) {
                if (f5622a == null) {
                    f5622a = new Kd(new Qd(context));
                }
            }
        }
        return f5622a;
    }

    private final C0566rb u() {
        C0566rb rbVar = this.f5626e;
        if (rbVar != null) {
            return rbVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final Gd v() {
        b((Ld) this.f5627f);
        return this.f5627f;
    }

    private final long w() {
        long currentTimeMillis = this.f5631j.c().currentTimeMillis();
        C0576tb h2 = this.f5631j.h();
        h2.p();
        h2.j();
        long a2 = h2.f6107j.a();
        if (a2 == 0) {
            a2 = 1 + ((long) h2.m().v().nextInt(86400000));
            h2.f6107j.a(a2);
        }
        return ((((currentTimeMillis + a2) / 1000) / 60) / 60) / 24;
    }

    private final boolean x() {
        C();
        n();
        return j().E() || !TextUtils.isEmpty(j().z());
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c0  */
    private final void y() {
        long j2;
        long j3;
        C();
        n();
        if (B() || this.f5631j.i().a(C0535l.sa)) {
            if (this.n > 0) {
                long abs = 3600000 - Math.abs(this.f5631j.c().a() - this.n);
                if (abs > 0) {
                    this.f5631j.e().B().a("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    u().a();
                    v().v();
                    return;
                }
                this.n = 0;
            }
            if (!this.f5631j.u() || !x()) {
                this.f5631j.e().B().a("Nothing to upload or uploading impossible");
                u().a();
                v().v();
                return;
            }
            long currentTimeMillis = this.f5631j.c().currentTimeMillis();
            long max = Math.max(0, ((Long) C0535l.L.a(null)).longValue());
            boolean z = j().F() || j().A();
            if (z) {
                String v2 = this.f5631j.i().v();
                if (TextUtils.isEmpty(v2) || ".none.".equals(v2)) {
                    j2 = Math.max(0, ((Long) C0535l.F.a(null)).longValue());
                } else {
                    j2 = Math.max(0, ((Long) C0535l.G.a(null)).longValue());
                }
            } else {
                j2 = Math.max(0, ((Long) C0535l.E.a(null)).longValue());
            }
            long a2 = this.f5631j.h().f6103f.a();
            long a3 = this.f5631j.h().f6104g.a();
            long j4 = j2;
            long j5 = max;
            long max2 = Math.max(j().C(), j().D());
            if (max2 != 0) {
                long abs2 = currentTimeMillis - Math.abs(max2 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(a2 - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(a3 - currentTimeMillis);
                long max3 = Math.max(abs3, abs4);
                long j6 = abs2 + j5;
                if (z && max3 > 0) {
                    j6 = Math.min(abs2, max3) + j4;
                }
                long j7 = j4;
                j3 = !h().a(max3, j7) ? max3 + j7 : j6;
                if (abs4 != 0 && abs4 >= abs2) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= Math.min(20, Math.max(0, ((Integer) C0535l.N.a(null)).intValue()))) {
                            break;
                        }
                        j3 += Math.max(0, ((Long) C0535l.M.a(null)).longValue()) * (1 << i2);
                        if (j3 > abs4) {
                            break;
                        }
                        i2++;
                    }
                }
                if (j3 != 0) {
                    this.f5631j.e().B().a("Next upload time is 0");
                    u().a();
                    v().v();
                    return;
                } else if (!l().v()) {
                    this.f5631j.e().B().a("No network");
                    u().b();
                    v().v();
                    return;
                } else {
                    long a4 = this.f5631j.h().f6105h.a();
                    long max4 = Math.max(0, ((Long) C0535l.C.a(null)).longValue());
                    if (!h().a(a4, max4)) {
                        j3 = Math.max(j3, a4 + max4);
                    }
                    u().a();
                    long currentTimeMillis2 = j3 - this.f5631j.c().currentTimeMillis();
                    if (currentTimeMillis2 <= 0) {
                        currentTimeMillis2 = Math.max(0, ((Long) C0535l.H.a(null)).longValue());
                        this.f5631j.h().f6103f.a(this.f5631j.c().currentTimeMillis());
                    }
                    this.f5631j.e().B().a("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                    v().a(currentTimeMillis2);
                    return;
                }
            }
            j3 = 0;
            if (j3 != 0) {
            }
        }
    }

    private final void z() {
        C();
        if (this.r || this.s || this.t) {
            this.f5631j.e().B().a("Not stopping services. fetch, network, upload", Boolean.valueOf(this.r), Boolean.valueOf(this.s), Boolean.valueOf(this.t));
            return;
        }
        this.f5631j.e().B().a("Stopping uploading service(s)");
        List<Runnable> list = this.o;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.o.clear();
        }
    }

    public final ee b() {
        return this.f5631j.b();
    }

    public final d c() {
        return this.f5631j.c();
    }

    public final Ib d() {
        return this.f5631j.d();
    }

    public final C0532kb e() {
        return this.f5631j.e();
    }

    /* access modifiers changed from: protected */
    public final void f() {
        this.f5631j.d().j();
        j().B();
        if (this.f5631j.h().f6103f.a() == 0) {
            this.f5631j.h().f6103f.a(this.f5631j.c().currentTimeMillis());
        }
        y();
    }

    public final fe g() {
        return this.f5631j.i();
    }

    public final Sd h() {
        b((Ld) this.f5629h);
        return this.f5629h;
    }

    public final ce i() {
        b((Ld) this.f5628g);
        return this.f5628g;
    }

    public final ke j() {
        b((Ld) this.f5625d);
        return this.f5625d;
    }

    public final Jb k() {
        b((Ld) this.f5623b);
        return this.f5623b;
    }

    public final C0552ob l() {
        b((Ld) this.f5624c);
        return this.f5624c;
    }

    public final Tc m() {
        b((Ld) this.f5630i);
        return this.f5630i;
    }

    /* access modifiers changed from: 0000 */
    public final void n() {
        if (!this.f5632k) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:95|96) */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r1.f5631j.e().t().a("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.C0532kb.a(r5), r9);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x02c2 */
    public final void o() {
        String str;
        C();
        n();
        this.t = true;
        try {
            this.f5631j.b();
            Boolean H = this.f5631j.A().H();
            if (H == null) {
                this.f5631j.e().w().a("Upload data called on the client side before use of service was decided");
            } else if (H.booleanValue()) {
                this.f5631j.e().t().a("Upload called in the client side when service should be used");
                this.t = false;
                z();
            } else if (this.n > 0) {
                y();
                this.t = false;
                z();
            } else {
                C();
                if (this.w != null) {
                    this.f5631j.e().B().a("Uploading requested multiple times");
                    this.t = false;
                    z();
                } else if (!l().v()) {
                    this.f5631j.e().B().a("Network not connected, ignoring upload request");
                    y();
                    this.t = false;
                    z();
                } else {
                    long currentTimeMillis = this.f5631j.c().currentTimeMillis();
                    a((String) null, currentTimeMillis - fe.u());
                    long a2 = this.f5631j.h().f6103f.a();
                    if (a2 != 0) {
                        this.f5631j.e().A().a("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - a2)));
                    }
                    String z = j().z();
                    if (!TextUtils.isEmpty(z)) {
                        if (this.y == -1) {
                            this.y = j().G();
                        }
                        List a3 = j().a(z, this.f5631j.i().b(z, C0535l.r), Math.max(0, this.f5631j.i().b(z, C0535l.s)));
                        if (!a3.isEmpty()) {
                            Iterator it = a3.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                V v2 = (V) ((Pair) it.next()).first;
                                if (!TextUtils.isEmpty(v2.aa())) {
                                    str = v2.aa();
                                    break;
                                }
                            }
                            if (str != null) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= a3.size()) {
                                        break;
                                    }
                                    V v3 = (V) ((Pair) a3.get(i2)).first;
                                    if (!TextUtils.isEmpty(v3.aa()) && !v3.aa().equals(str)) {
                                        a3 = a3.subList(0, i2);
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            com.google.android.gms.internal.measurement.U.a p2 = U.p();
                            int size = a3.size();
                            ArrayList arrayList = new ArrayList(a3.size());
                            boolean z2 = fe.w() && this.f5631j.i().d(z);
                            for (int i3 = 0; i3 < size; i3++) {
                                com.google.android.gms.internal.measurement.V.a aVar = (com.google.android.gms.internal.measurement.V.a) ((V) ((Pair) a3.get(i3)).first).k();
                                arrayList.add((Long) ((Pair) a3.get(i3)).second);
                                aVar.g(this.f5631j.i().n());
                                aVar.a(currentTimeMillis);
                                this.f5631j.b();
                                aVar.b(false);
                                if (!z2) {
                                    aVar.w();
                                }
                                if (this.f5631j.i().e(z, C0535l.ya)) {
                                    aVar.l(h().a(((V) ((Eb) aVar.A())).g()));
                                }
                                p2.a(aVar);
                            }
                            Object a4 = this.f5631j.e().a(2) ? h().a((U) ((Eb) p2.A())) : null;
                            h();
                            byte[] g2 = ((U) ((Eb) p2.A())).g();
                            String str2 = (String) C0535l.B.a(null);
                            URL url = new URL(str2);
                            q.a(!arrayList.isEmpty());
                            if (this.w != null) {
                                this.f5631j.e().t().a("Set uploading progress before finishing the previous upload");
                            } else {
                                this.w = new ArrayList(arrayList);
                            }
                            this.f5631j.h().f6104g.a(currentTimeMillis);
                            String str3 = "?";
                            if (size > 0) {
                                str3 = p2.a(0).s();
                            }
                            this.f5631j.e().B().a("Uploading data. app, uncompressed size, data", str3, Integer.valueOf(g2.length), a4);
                            this.s = true;
                            C0552ob l2 = l();
                            Md md = new Md(this, z);
                            l2.j();
                            l2.t();
                            q.a(url);
                            q.a(g2);
                            q.a(md);
                            Ib d2 = l2.d();
                            C0571sb sbVar = new C0571sb(l2, z, url, g2, null, md);
                            d2.b((Runnable) sbVar);
                        }
                    } else {
                        this.y = -1;
                        String a5 = j().a(currentTimeMillis - fe.u());
                        if (!TextUtils.isEmpty(a5)) {
                            Fb b2 = j().b(a5);
                            if (b2 != null) {
                                a(b2);
                            }
                        }
                    }
                    this.t = false;
                    z();
                }
            }
        } finally {
            this.t = false;
            z();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void p() {
        C();
        n();
        if (!this.m) {
            this.m = true;
            C();
            n();
            if ((this.f5631j.i().a(C0535l.sa) || B()) && A()) {
                int a2 = a(this.v);
                int F = this.f5631j.z().F();
                C();
                if (a2 > F) {
                    this.f5631j.e().t().a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a2), Integer.valueOf(F));
                } else if (a2 < F) {
                    if (a(F, this.v)) {
                        this.f5631j.e().B().a("Storage version upgraded. Previous, current version", Integer.valueOf(a2), Integer.valueOf(F));
                    } else {
                        this.f5631j.e().t().a("Storage version upgrade failed. Previous, current version", Integer.valueOf(a2), Integer.valueOf(F));
                    }
                }
            }
        }
        if (!this.f5633l && !this.f5631j.i().a(C0535l.sa)) {
            this.f5631j.e().z().a("This instance being marked as an uploader");
            this.f5633l = true;
            y();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void q() {
        this.q++;
    }

    /* access modifiers changed from: 0000 */
    public final Ob r() {
        return this.f5631j;
    }

    public final C0522ib s() {
        return this.f5631j.F();
    }

    public final Wd t() {
        return this.f5631j.G();
    }

    private Kd(Qd qd, Ob ob) {
        this.f5632k = false;
        q.a(qd);
        this.f5631j = Ob.a(qd.f5694a, (Af) null);
        this.y = -1;
        Sd sd = new Sd(this);
        sd.r();
        this.f5629h = sd;
        C0552ob obVar = new C0552ob(this);
        obVar.r();
        this.f5624c = obVar;
        Jb jb = new Jb(this);
        jb.r();
        this.f5623b = jb;
        this.f5631j.d().a((Runnable) new Nd(this, qd));
    }

    private static void b(Ld ld) {
        if (ld == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!ld.s()) {
            String valueOf = String.valueOf(ld.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0188  */
    public final Fb e(ae aeVar) {
        boolean z;
        C();
        n();
        q.a(aeVar);
        q.b(aeVar.f5819a);
        Fb b2 = j().b(aeVar.f5819a);
        String b3 = this.f5631j.h().b(aeVar.f5819a);
        if (b2 == null) {
            b2 = new Fb(this.f5631j, aeVar.f5819a);
            b2.a(this.f5631j.G().x());
            b2.d(b3);
        } else if (!b3.equals(b2.h())) {
            b2.d(b3);
            b2.a(this.f5631j.G().x());
        } else {
            z = false;
            if (!TextUtils.equals(aeVar.f5820b, b2.c())) {
                b2.b(aeVar.f5820b);
                z = true;
            }
            if (!TextUtils.equals(aeVar.r, b2.g())) {
                b2.c(aeVar.r);
                z = true;
            }
            if (!TextUtils.isEmpty(aeVar.f5829k) && !aeVar.f5829k.equals(b2.b())) {
                b2.e(aeVar.f5829k);
                z = true;
            }
            long j2 = aeVar.f5823e;
            if (!(j2 == 0 || j2 == b2.n())) {
                b2.d(aeVar.f5823e);
                z = true;
            }
            if (!TextUtils.isEmpty(aeVar.f5821c) && !aeVar.f5821c.equals(b2.k())) {
                b2.f(aeVar.f5821c);
                z = true;
            }
            if (aeVar.f5828j != b2.l()) {
                b2.c(aeVar.f5828j);
                z = true;
            }
            String str = aeVar.f5822d;
            if (str != null && !str.equals(b2.m())) {
                b2.g(aeVar.f5822d);
                z = true;
            }
            if (aeVar.f5824f != b2.o()) {
                b2.e(aeVar.f5824f);
                z = true;
            }
            if (aeVar.f5826h != b2.d()) {
                b2.a(aeVar.f5826h);
                z = true;
            }
            if (!TextUtils.isEmpty(aeVar.f5825g) && !aeVar.f5825g.equals(b2.A())) {
                b2.h(aeVar.f5825g);
                z = true;
            }
            if (aeVar.f5830l != b2.C()) {
                b2.p(aeVar.f5830l);
                z = true;
            }
            if (aeVar.o != b2.D()) {
                b2.b(aeVar.o);
                z = true;
            }
            if (aeVar.p != b2.E()) {
                b2.c(aeVar.p);
                z = true;
            }
            if (this.f5631j.i().e(aeVar.f5819a, C0535l.pa) && aeVar.s != b2.F()) {
                b2.a(aeVar.s);
                z = true;
            }
            long j3 = aeVar.t;
            if (!(j3 == 0 || j3 == b2.p())) {
                b2.f(aeVar.t);
                z = true;
            }
            if (z) {
                j().a(b2);
            }
            return b2;
        }
        z = true;
        if (!TextUtils.equals(aeVar.f5820b, b2.c())) {
        }
        if (!TextUtils.equals(aeVar.r, b2.g())) {
        }
        b2.e(aeVar.f5829k);
        z = true;
        long j22 = aeVar.f5823e;
        b2.d(aeVar.f5823e);
        z = true;
        b2.f(aeVar.f5821c);
        z = true;
        if (aeVar.f5828j != b2.l()) {
        }
        String str2 = aeVar.f5822d;
        b2.g(aeVar.f5822d);
        z = true;
        if (aeVar.f5824f != b2.o()) {
        }
        if (aeVar.f5826h != b2.d()) {
        }
        b2.h(aeVar.f5825g);
        z = true;
        if (aeVar.f5830l != b2.C()) {
        }
        if (aeVar.o != b2.D()) {
        }
        if (aeVar.p != b2.E()) {
        }
        b2.a(aeVar.s);
        z = true;
        long j32 = aeVar.t;
        b2.f(aeVar.t);
        z = true;
        if (z) {
        }
        return b2;
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x04a7 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0140 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f5 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0266 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0273 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0285 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    public final void c(ae aeVar) {
        String str;
        int i2;
        Fb b2;
        C0505f fVar;
        String str2;
        long j2;
        long j3;
        PackageInfo packageInfo;
        String str3;
        ApplicationInfo applicationInfo;
        boolean z;
        ae aeVar2 = aeVar;
        String str4 = "_sys";
        String str5 = "_pfo";
        String str6 = "_uwa";
        String str7 = "app_id=?";
        C();
        n();
        q.a(aeVar);
        q.b(aeVar2.f5819a);
        if (!TextUtils.isEmpty(aeVar2.f5820b) || !TextUtils.isEmpty(aeVar2.r)) {
            Fb b3 = j().b(aeVar2.f5819a);
            if (b3 != null && TextUtils.isEmpty(b3.c()) && !TextUtils.isEmpty(aeVar2.f5820b)) {
                b3.h(0);
                j().a(b3);
                k().d(aeVar2.f5819a);
            }
            if (!aeVar2.f5826h) {
                e(aeVar);
                return;
            }
            long j4 = aeVar2.m;
            if (j4 == 0) {
                j4 = this.f5631j.c().currentTimeMillis();
            }
            if (this.f5631j.i().e(aeVar2.f5819a, C0535l.pa)) {
                this.f5631j.E().w();
            }
            int i3 = aeVar2.n;
            if (!(i3 == 0 || i3 == 1)) {
                this.f5631j.e().w().a("Incorrect app type, assuming installed app. appId, appType", C0532kb.a(aeVar2.f5819a), Integer.valueOf(i3));
                i3 = 0;
            }
            j().v();
            try {
                if (this.f5631j.i().e(aeVar2.f5819a, C0535l.pa)) {
                    Td d2 = j().d(aeVar2.f5819a, "_npa");
                    if (d2 == null || "auto".equals(d2.f5722b)) {
                        if (aeVar2.s != null) {
                            Rd rd = r11;
                            str = str4;
                            Td td = d2;
                            i2 = 1;
                            Rd rd2 = new Rd("_npa", j4, Long.valueOf(aeVar2.s.booleanValue() ? 1 : 0), "auto");
                            if (td == null || !td.f5725e.equals(rd.f5708d)) {
                                a(rd, aeVar2);
                            }
                        } else {
                            str = str4;
                            i2 = 1;
                            if (d2 != null) {
                                Rd rd3 = new Rd("_npa", j4, null, "auto");
                                b(rd3, aeVar2);
                            }
                        }
                        b2 = j().b(aeVar2.f5819a);
                        if (b2 != null) {
                            this.f5631j.G();
                            if (Wd.a(aeVar2.f5820b, b2.c(), aeVar2.r, b2.g())) {
                                this.f5631j.e().w().a("New GMP App Id passed in. Removing cached database data. appId", C0532kb.a(b2.f()));
                                ke j5 = j();
                                String f2 = b2.f();
                                j5.t();
                                j5.j();
                                q.b(f2);
                                try {
                                    SQLiteDatabase x2 = j5.x();
                                    String[] strArr = new String[i2];
                                    try {
                                        strArr[0] = f2;
                                        int delete = x2.delete("events", str7, strArr) + 0 + x2.delete("user_attributes", str7, strArr) + x2.delete("conditional_properties", str7, strArr) + x2.delete("apps", str7, strArr) + x2.delete("raw_events", str7, strArr) + x2.delete("raw_events_metadata", str7, strArr) + x2.delete("event_filters", str7, strArr) + x2.delete("property_filters", str7, strArr) + x2.delete("audience_filter_values", str7, strArr);
                                        if (delete > 0) {
                                            j5.e().B().a("Deleted application data. app, records", f2, Integer.valueOf(delete));
                                        }
                                    } catch (SQLiteException e2) {
                                        e = e2;
                                        j5.e().t().a("Error deleting application data. appId, error", C0532kb.a(f2), e);
                                        b2 = null;
                                        if (b2 != null) {
                                        }
                                        e(aeVar);
                                        if (i3 != 0) {
                                        }
                                        if (fVar != null) {
                                        }
                                        j().y();
                                        j().w();
                                    }
                                } catch (SQLiteException e3) {
                                    e = e3;
                                    j5.e().t().a("Error deleting application data. appId, error", C0532kb.a(f2), e);
                                    b2 = null;
                                    if (b2 != null) {
                                    }
                                    e(aeVar);
                                    if (i3 != 0) {
                                    }
                                    if (fVar != null) {
                                    }
                                    j().y();
                                    j().w();
                                }
                                b2 = null;
                                if (b2 != null) {
                                    String str8 = "_pv";
                                    if (b2.l() != -2147483648L) {
                                        if (b2.l() != aeVar2.f5828j) {
                                            Bundle bundle = new Bundle();
                                            bundle.putString(str8, b2.k());
                                            C0525j jVar = new C0525j("_au", new C0520i(bundle), "auto", j4);
                                            a(jVar, aeVar2);
                                        }
                                    } else if (b2.k() != null && !b2.k().equals(aeVar2.f5821c)) {
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putString(str8, b2.k());
                                        C0525j jVar2 = new C0525j("_au", new C0520i(bundle2), "auto", j4);
                                        a(jVar2, aeVar2);
                                    }
                                    e(aeVar);
                                    fVar = i3 != 0 ? j().b(aeVar2.f5819a, "_f") : i3 == i2 ? j().b(aeVar2.f5819a, "_v") : null;
                                    if (fVar != null) {
                                        long j6 = ((j4 / 3600000) + 1) * 3600000;
                                        String str9 = "_dac";
                                        String str10 = "_r";
                                        String str11 = "_c";
                                        String str12 = "_et";
                                        if (i3 == 0) {
                                            str2 = str12;
                                            String str13 = str11;
                                            Rd rd4 = new Rd("_fot", j4, Long.valueOf(j6), "auto");
                                            a(rd4, aeVar2);
                                            if (this.f5631j.i().l(aeVar2.f5820b)) {
                                                C();
                                                this.f5631j.k().a(aeVar2.f5819a);
                                            }
                                            C();
                                            n();
                                            Bundle bundle3 = new Bundle();
                                            bundle3.putLong(str13, 1);
                                            bundle3.putLong(str10, 1);
                                            bundle3.putLong(str6, 0);
                                            bundle3.putLong(str5, 0);
                                            String str14 = str;
                                            bundle3.putLong(str14, 0);
                                            bundle3.putLong("_sysu", 0);
                                            if (this.f5631j.i().r(aeVar2.f5819a)) {
                                                j3 = 1;
                                                bundle3.putLong(str2, 1);
                                            } else {
                                                j3 = 1;
                                            }
                                            if (aeVar2.q) {
                                                bundle3.putLong(str9, j3);
                                            }
                                            if (this.f5631j.a().getPackageManager() == null) {
                                                this.f5631j.e().t().a("PackageManager is null, first open report might be inaccurate. appId", C0532kb.a(aeVar2.f5819a));
                                            } else {
                                                packageInfo = c.a(this.f5631j.a()).b(aeVar2.f5819a, 0);
                                                if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                                                    str3 = str14;
                                                } else {
                                                    if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                                        bundle3.putLong(str6, 1);
                                                        z = false;
                                                    } else {
                                                        z = true;
                                                    }
                                                    String str15 = "_fi";
                                                    str3 = str14;
                                                    Rd rd5 = new Rd(str15, j4, Long.valueOf(z ? 1 : 0), "auto");
                                                    a(rd5, aeVar2);
                                                }
                                                try {
                                                    applicationInfo = c.a(this.f5631j.a()).a(aeVar2.f5819a, 0);
                                                } catch (NameNotFoundException e4) {
                                                    this.f5631j.e().t().a("Application info is null, first open report might be inaccurate. appId", C0532kb.a(aeVar2.f5819a), e4);
                                                    applicationInfo = null;
                                                }
                                                if (applicationInfo != null) {
                                                    if ((applicationInfo.flags & 1) != 0) {
                                                        bundle3.putLong(str3, 1);
                                                    }
                                                    if ((applicationInfo.flags & 128) != 0) {
                                                        bundle3.putLong("_sysu", 1);
                                                    }
                                                }
                                            }
                                            ke j7 = j();
                                            String str16 = aeVar2.f5819a;
                                            q.b(str16);
                                            j7.j();
                                            j7.t();
                                            long i4 = j7.i(str16, "first_open_count");
                                            if (i4 >= 0) {
                                                bundle3.putLong(str5, i4);
                                            }
                                            C0525j jVar3 = new C0525j("_f", new C0520i(bundle3), "auto", j4);
                                            a(jVar3, aeVar2);
                                        } else {
                                            str2 = str12;
                                            String str17 = str11;
                                            if (i3 == 1) {
                                                Rd rd6 = new Rd("_fvt", j4, Long.valueOf(j6), "auto");
                                                a(rd6, aeVar2);
                                                C();
                                                n();
                                                Bundle bundle4 = new Bundle();
                                                bundle4.putLong(str17, 1);
                                                bundle4.putLong(str10, 1);
                                                if (this.f5631j.i().r(aeVar2.f5819a)) {
                                                    j2 = 1;
                                                    bundle4.putLong(str2, 1);
                                                } else {
                                                    j2 = 1;
                                                }
                                                if (aeVar2.q) {
                                                    bundle4.putLong(str9, j2);
                                                }
                                                C0525j jVar4 = new C0525j("_v", new C0520i(bundle4), "auto", j4);
                                                a(jVar4, aeVar2);
                                            }
                                        }
                                        if (!this.f5631j.i().e(aeVar2.f5819a, C0535l.oa)) {
                                            Bundle bundle5 = new Bundle();
                                            bundle5.putLong(str2, 1);
                                            if (this.f5631j.i().r(aeVar2.f5819a)) {
                                                bundle5.putLong("_fr", 1);
                                            }
                                            C0525j jVar5 = new C0525j("_e", new C0520i(bundle5), "auto", j4);
                                            a(jVar5, aeVar2);
                                        }
                                    } else if (aeVar2.f5827i) {
                                        C0525j jVar6 = new C0525j("_cd", new C0520i(new Bundle()), "auto", j4);
                                        a(jVar6, aeVar2);
                                    }
                                    j().y();
                                    j().w();
                                }
                                e(aeVar);
                                if (i3 != 0) {
                                }
                                if (fVar != null) {
                                }
                                j().y();
                                j().w();
                            }
                        }
                        if (b2 != null) {
                        }
                        e(aeVar);
                        if (i3 != 0) {
                        }
                        if (fVar != null) {
                        }
                        j().y();
                        j().w();
                    }
                }
                str = str4;
                i2 = 1;
                b2 = j().b(aeVar2.f5819a);
                if (b2 != null) {
                }
                if (b2 != null) {
                }
                e(aeVar);
                if (i3 != 0) {
                }
                if (fVar != null) {
                }
            } catch (NameNotFoundException e5) {
                this.f5631j.e().t().a("Package info is null, first open report might be inaccurate. appId", C0532kb.a(aeVar2.f5819a), e5);
                packageInfo = null;
            } catch (Throwable th) {
                j().w();
                throw th;
            }
            j().y();
            j().w();
        }
    }

    /* access modifiers changed from: 0000 */
    public final String d(ae aeVar) {
        try {
            return (String) this.f5631j.d().a((Callable<V>) new Od<V>(this, aeVar)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            this.f5631j.e().t().a("Failed to get app instance id. appId", C0532kb.a(aeVar.f5819a), e2);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void b(ae aeVar) {
        C();
        n();
        q.b(aeVar.f5819a);
        e(aeVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:247:0x0848 A[Catch:{ SQLiteException -> 0x0237, all -> 0x08bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0878 A[Catch:{ SQLiteException -> 0x0237, all -> 0x08bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x026f A[Catch:{ SQLiteException -> 0x0237, all -> 0x08bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02a6 A[Catch:{ SQLiteException -> 0x0237, all -> 0x08bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02f4 A[Catch:{ SQLiteException -> 0x0237, all -> 0x08bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0321  */
    private final void b(C0525j jVar, ae aeVar) {
        long j2;
        long intValue;
        String str;
        C0505f fVar;
        boolean z;
        long j3;
        Td td;
        C0525j jVar2 = jVar;
        ae aeVar2 = aeVar;
        String str2 = "_s";
        q.a(aeVar);
        q.b(aeVar2.f5819a);
        long nanoTime = System.nanoTime();
        C();
        n();
        String str3 = aeVar2.f5819a;
        if (h().a(jVar2, aeVar2)) {
            if (!aeVar2.f5826h) {
                e(aeVar2);
                return;
            }
            String str4 = "_err";
            if (k().b(str3, jVar2.f5953a)) {
                this.f5631j.e().w().a("Dropping blacklisted event. appId", C0532kb.a(str3), this.f5631j.F().a(jVar2.f5953a));
                boolean z2 = k().g(str3) || k().h(str3);
                if (!z2 && !str4.equals(jVar2.f5953a)) {
                    this.f5631j.G().a(str3, 11, "_ev", jVar2.f5953a, 0);
                }
                if (z2) {
                    Fb b2 = j().b(str3);
                    if (b2 != null) {
                        if (Math.abs(this.f5631j.c().currentTimeMillis() - Math.max(b2.s(), b2.r())) > ((Long) C0535l.K.a(null)).longValue()) {
                            this.f5631j.e().A().a("Fetching config for blacklisted app");
                            a(b2);
                        }
                    }
                }
                return;
            }
            if (this.f5631j.e().a(2)) {
                this.f5631j.e().B().a("Logging event", this.f5631j.F().a(jVar2));
            }
            j().v();
            e(aeVar2);
            String str5 = "ecommerce_purchase";
            if (!"_iap".equals(jVar2.f5953a)) {
                if (!str5.equals(jVar2.f5953a)) {
                    j2 = nanoTime;
                    boolean a2 = Wd.a(jVar2.f5953a);
                    boolean equals = str4.equals(jVar2.f5953a);
                    String str6 = str3;
                    je a3 = j().a(w(), str3, true, a2, false, equals, false);
                    intValue = a3.f5972b - ((long) ((Integer) C0535l.v.a(null)).intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            this.f5631j.e().t().a("Data loss. Too many events logged. appId, count", C0532kb.a(str6), Long.valueOf(a3.f5972b));
                        }
                        j().y();
                        j().w();
                        return;
                    }
                    if (a2) {
                        long intValue2 = a3.f5971a - ((long) ((Integer) C0535l.x.a(null)).intValue());
                        if (intValue2 > 0) {
                            if (intValue2 % 1000 == 1) {
                                this.f5631j.e().t().a("Data loss. Too many public events logged. appId, count", C0532kb.a(str6), Long.valueOf(a3.f5971a));
                            }
                            this.f5631j.G().a(str6, 16, "_ev", jVar2.f5953a, 0);
                            j().y();
                            j().w();
                            return;
                        }
                    }
                    if (equals) {
                        long max = a3.f5974d - ((long) Math.max(0, Math.min(1000000, this.f5631j.i().b(aeVar2.f5819a, C0535l.w))));
                        if (max > 0) {
                            if (max == 1) {
                                this.f5631j.e().t().a("Too many error events logged. appId, count", C0532kb.a(str6), Long.valueOf(a3.f5974d));
                            }
                            j().y();
                            j().w();
                            return;
                        }
                    }
                    Bundle f2 = jVar2.f5954b.f();
                    this.f5631j.G().a(f2, "_o", (Object) jVar2.f5955c);
                    String str7 = str6;
                    String str8 = "_r";
                    if (this.f5631j.G().f(str7)) {
                        this.f5631j.G().a(f2, "_dbg", (Object) Long.valueOf(1));
                        this.f5631j.G().a(f2, str8, (Object) Long.valueOf(1));
                    }
                    String str9 = "_sno";
                    if (str2.equals(jVar2.f5953a)) {
                        if (this.f5631j.i().o(aeVar2.f5819a)) {
                            Td d2 = j().d(aeVar2.f5819a, str9);
                            if (d2 != null && (d2.f5725e instanceof Long)) {
                                this.f5631j.G().a(f2, str9, d2.f5725e);
                            }
                        }
                    }
                    if (!str2.equals(jVar2.f5953a) || !this.f5631j.i().e(aeVar2.f5819a, C0535l.la) || this.f5631j.i().o(aeVar2.f5819a)) {
                        str = null;
                    } else {
                        str = null;
                        b(new Rd(str9, 0, null), aeVar2);
                    }
                    long c2 = j().c(str7);
                    if (c2 > 0) {
                        this.f5631j.e().w().a("Data lost. Too many events stored on disk, deleted. appId", C0532kb.a(str7), Long.valueOf(c2));
                    }
                    Ob ob = this.f5631j;
                    String str10 = jVar2.f5955c;
                    String str11 = jVar2.f5953a;
                    long j4 = jVar2.f5956d;
                    String str12 = str8;
                    String str13 = str7;
                    String str14 = str;
                    C0510g gVar = new C0510g(ob, str10, str7, str11, j4, 0, f2);
                    C0505f b3 = j().b(str13, gVar.f5921b);
                    if (b3 != null) {
                        gVar = gVar.a(this.f5631j, b3.f5903f);
                        fVar = b3.a(gVar.f5923d);
                    } else if (j().g(str13) < 500 || !a2) {
                        fVar = new C0505f(str13, gVar.f5921b, 0, 0, gVar.f5923d, 0, null, null, null, null);
                    } else {
                        this.f5631j.e().t().a("Too many event names used, ignoring event. appId, name, supported count", C0532kb.a(str13), this.f5631j.F().a(gVar.f5921b), Integer.valueOf(500));
                        this.f5631j.G().a(str13, 8, (String) null, (String) null, 0);
                        j().w();
                        return;
                    }
                    j().a(fVar);
                    C();
                    n();
                    q.a(gVar);
                    q.a(aeVar);
                    q.b(gVar.f5920a);
                    q.a(gVar.f5920a.equals(aeVar2.f5819a));
                    com.google.android.gms.internal.measurement.V.a va = V.va();
                    boolean z3 = true;
                    va.a(1);
                    va.a(C0730a.ANDROID_CLIENT_TYPE);
                    if (!TextUtils.isEmpty(aeVar2.f5819a)) {
                        va.f(aeVar2.f5819a);
                    }
                    if (!TextUtils.isEmpty(aeVar2.f5822d)) {
                        va.e(aeVar2.f5822d);
                    }
                    if (!TextUtils.isEmpty(aeVar2.f5821c)) {
                        va.g(aeVar2.f5821c);
                    }
                    if (aeVar2.f5828j != -2147483648L) {
                        va.g((int) aeVar2.f5828j);
                    }
                    va.f(aeVar2.f5823e);
                    if (!TextUtils.isEmpty(aeVar2.f5820b)) {
                        va.k(aeVar2.f5820b);
                    }
                    if (this.f5631j.i().a(C0535l.za)) {
                        if (TextUtils.isEmpty(va.j()) && !TextUtils.isEmpty(aeVar2.r)) {
                            va.o(aeVar2.r);
                        }
                    } else if (!TextUtils.isEmpty(aeVar2.r)) {
                        va.o(aeVar2.r);
                    }
                    if (aeVar2.f5824f != 0) {
                        va.h(aeVar2.f5824f);
                    }
                    va.k(aeVar2.t);
                    if (this.f5631j.i().e(aeVar2.f5819a, C0535l.ta)) {
                        List v2 = h().v();
                        if (v2 != null) {
                            va.c((Iterable<? extends Integer>) v2);
                        }
                    }
                    Pair a4 = this.f5631j.h().a(aeVar2.f5819a);
                    if (a4 == null || TextUtils.isEmpty((CharSequence) a4.first)) {
                        if (!this.f5631j.E().a(this.f5631j.a()) && aeVar2.p) {
                            String string = Secure.getString(this.f5631j.a().getContentResolver(), "android_id");
                            if (string == null) {
                                this.f5631j.e().w().a("null secure ID. appId", C0532kb.a(va.k()));
                                string = "null";
                            } else if (string.isEmpty()) {
                                this.f5631j.e().w().a("empty secure ID. appId", C0532kb.a(va.k()));
                            }
                            va.m(string);
                        }
                    } else if (aeVar2.o) {
                        va.h((String) a4.first);
                        if (a4.second != null) {
                            va.a(((Boolean) a4.second).booleanValue());
                        }
                    }
                    this.f5631j.E().p();
                    va.c(Build.MODEL);
                    this.f5631j.E().p();
                    va.b(VERSION.RELEASE);
                    va.e((int) this.f5631j.E().t());
                    va.d(this.f5631j.E().u());
                    va.j(aeVar2.f5830l);
                    if (this.f5631j.f() && fe.w()) {
                        va.k();
                        if (!TextUtils.isEmpty(str14)) {
                            va.n(str14);
                        }
                    }
                    Fb b4 = j().b(aeVar2.f5819a);
                    if (b4 == null) {
                        b4 = new Fb(this.f5631j, aeVar2.f5819a);
                        b4.a(this.f5631j.G().x());
                        b4.e(aeVar2.f5829k);
                        b4.b(aeVar2.f5820b);
                        b4.d(this.f5631j.h().b(aeVar2.f5819a));
                        b4.g(0);
                        b4.a(0);
                        b4.b(0);
                        b4.f(aeVar2.f5821c);
                        b4.c(aeVar2.f5828j);
                        b4.g(aeVar2.f5822d);
                        b4.d(aeVar2.f5823e);
                        b4.e(aeVar2.f5824f);
                        b4.a(aeVar2.f5826h);
                        b4.p(aeVar2.f5830l);
                        b4.f(aeVar2.t);
                        j().a(b4);
                    }
                    if (!TextUtils.isEmpty(b4.a())) {
                        va.i(b4.a());
                    }
                    if (!TextUtils.isEmpty(b4.b())) {
                        va.l(b4.b());
                    }
                    List a5 = j().a(aeVar2.f5819a);
                    for (int i2 = 0; i2 < a5.size(); i2++) {
                        com.google.android.gms.internal.measurement.Z.a x2 = Z.x();
                        x2.a(((Td) a5.get(i2)).f5723c);
                        x2.a(((Td) a5.get(i2)).f5724d);
                        h().a(x2, ((Td) a5.get(i2)).f5725e);
                        va.a(x2);
                    }
                    try {
                        long a6 = j().a((V) ((Eb) va.A()));
                        ke j5 = j();
                        if (gVar.f5925f != null) {
                            Iterator it = gVar.f5925f.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    String str15 = str12;
                                    if (str15.equals((String) it.next())) {
                                        break;
                                    }
                                    str12 = str15;
                                } else {
                                    boolean c3 = k().c(gVar.f5920a, gVar.f5921b);
                                    je a7 = j().a(w(), gVar.f5920a, false, false, false, false, false);
                                    if (c3 && a7.f5975e < ((long) this.f5631j.i().a(gVar.f5920a))) {
                                    }
                                }
                            }
                            if (j5.a(gVar, a6, z3)) {
                                this.n = 0;
                            }
                            j().y();
                            if (this.f5631j.e().a(2)) {
                                this.f5631j.e().B().a("Event recorded", this.f5631j.F().a(gVar));
                            }
                            j().w();
                            y();
                            this.f5631j.e().B().a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j2) + 500000) / 1000000));
                            return;
                        }
                        z3 = false;
                        if (j5.a(gVar, a6, z3)) {
                        }
                    } catch (IOException e2) {
                        this.f5631j.e().t().a("Data loss. Failed to insert raw event metadata. appId", C0532kb.a(va.k()), e2);
                    }
                    j().y();
                    if (this.f5631j.e().a(2)) {
                    }
                    j().w();
                    y();
                    this.f5631j.e().B().a("Background event processing time, ms", Long.valueOf(((System.nanoTime() - j2) + 500000) / 1000000));
                    return;
                }
            }
            String c4 = jVar2.f5954b.c("currency");
            String str16 = "value";
            if (str5.equals(jVar2.f5953a)) {
                double doubleValue = jVar2.f5954b.d(str16).doubleValue() * 1000000.0d;
                if (doubleValue == 0.0d) {
                    doubleValue = ((double) jVar2.f5954b.b(str16).longValue()) * 1000000.0d;
                }
                if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                    this.f5631j.e().w().a("Data lost. Currency value is too big. appId", C0532kb.a(str3), Double.valueOf(doubleValue));
                    j2 = nanoTime;
                    z = false;
                    if (!z) {
                        j().y();
                        j().w();
                        return;
                    }
                    boolean a22 = Wd.a(jVar2.f5953a);
                    boolean equals2 = str4.equals(jVar2.f5953a);
                    String str62 = str3;
                    je a32 = j().a(w(), str3, true, a22, false, equals2, false);
                    intValue = a32.f5972b - ((long) ((Integer) C0535l.v.a(null)).intValue());
                    if (intValue > 0) {
                    }
                } else {
                    j3 = Math.round(doubleValue);
                }
            } else {
                j3 = jVar2.f5954b.b(str16).longValue();
            }
            if (!TextUtils.isEmpty(c4)) {
                String upperCase = c4.toUpperCase(Locale.US);
                if (upperCase.matches("[A-Z]{3}")) {
                    String str17 = "_ltv_";
                    String valueOf = String.valueOf(upperCase);
                    String concat = valueOf.length() != 0 ? str17.concat(valueOf) : new String(str17);
                    Td d3 = j().d(str3, concat);
                    if (d3 != null) {
                        if (d3.f5725e instanceof Long) {
                            j2 = nanoTime;
                            Td td2 = new Td(str3, jVar2.f5955c, concat, this.f5631j.c().currentTimeMillis(), Long.valueOf(((Long) d3.f5725e).longValue() + j3));
                            td = td2;
                            if (!j().a(td)) {
                                this.f5631j.e().t().a("Too many unique user properties are set. Ignoring user property. appId", C0532kb.a(str3), this.f5631j.F().c(td.f5723c), td.f5725e);
                                this.f5631j.G().a(str3, 9, (String) null, (String) null, 0);
                            }
                            z = true;
                            if (!z) {
                            }
                            boolean a222 = Wd.a(jVar2.f5953a);
                            boolean equals22 = str4.equals(jVar2.f5953a);
                            String str622 = str3;
                            je a322 = j().a(w(), str3, true, a222, false, equals22, false);
                            intValue = a322.f5972b - ((long) ((Integer) C0535l.v.a(null)).intValue());
                            if (intValue > 0) {
                            }
                        }
                    }
                    j2 = nanoTime;
                    ke j6 = j();
                    int b5 = this.f5631j.i().b(str3, C0535l.P) - 1;
                    q.b(str3);
                    j6.j();
                    j6.t();
                    try {
                        j6.x().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str3, str3, String.valueOf(b5)});
                    } catch (SQLiteException e3) {
                        j6.e().t().a("Error pruning currencies. appId", C0532kb.a(str3), e3);
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        j().w();
                        throw th2;
                    }
                    td = new Td(str3, jVar2.f5955c, concat, this.f5631j.c().currentTimeMillis(), Long.valueOf(j3));
                    if (!j().a(td)) {
                    }
                    z = true;
                    if (!z) {
                    }
                    boolean a2222 = Wd.a(jVar2.f5953a);
                    boolean equals222 = str4.equals(jVar2.f5953a);
                    String str6222 = str3;
                    je a3222 = j().a(w(), str3, true, a2222, false, equals222, false);
                    intValue = a3222.f5972b - ((long) ((Integer) C0535l.v.a(null)).intValue());
                    if (intValue > 0) {
                    }
                }
            }
            j2 = nanoTime;
            z = true;
            if (!z) {
            }
            boolean a22222 = Wd.a(jVar2.f5953a);
            boolean equals2222 = str4.equals(jVar2.f5953a);
            String str62222 = str3;
            je a32222 = j().a(w(), str3, true, a22222, false, equals2222, false);
            intValue = a32222.f5972b - ((long) ((Integer) C0535l.v.a(null)).intValue());
            if (intValue > 0) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(Qd qd) {
        this.f5631j.d().j();
        ke keVar = new ke(this);
        keVar.r();
        this.f5625d = keVar;
        this.f5631j.i().a((he) this.f5623b);
        ce ceVar = new ce(this);
        ceVar.r();
        this.f5628g = ceVar;
        Tc tc = new Tc(this);
        tc.r();
        this.f5630i = tc;
        Gd gd = new Gd(this);
        gd.r();
        this.f5627f = gd;
        this.f5626e = new C0566rb(this);
        if (this.p != this.q) {
            this.f5631j.e().t().a("Not all upload components initialized", Integer.valueOf(this.p), Integer.valueOf(this.q));
        }
        this.f5632k = true;
    }

    public final Context a() {
        return this.f5631j.a();
    }

    /* access modifiers changed from: 0000 */
    public final void a(C0525j jVar, String str) {
        C0525j jVar2 = jVar;
        String str2 = str;
        Fb b2 = j().b(str2);
        if (b2 == null || TextUtils.isEmpty(b2.k())) {
            this.f5631j.e().A().a("No app data available; dropping event", str2);
            return;
        }
        Boolean b3 = b(b2);
        if (b3 == null) {
            if (!"_ui".equals(jVar2.f5953a)) {
                this.f5631j.e().w().a("Could not find package. appId", C0532kb.a(str));
            }
        } else if (!b3.booleanValue()) {
            this.f5631j.e().t().a("App version does not match; dropping event. appId", C0532kb.a(str));
            return;
        }
        ae aeVar = r2;
        Fb fb = b2;
        ae aeVar2 = new ae(str, b2.c(), b2.k(), b2.l(), b2.m(), b2.n(), b2.o(), (String) null, b2.d(), false, fb.b(), fb.C(), 0, 0, fb.D(), fb.E(), false, fb.g(), fb.F(), fb.p(), fb.G());
        a(jVar2, aeVar);
    }

    /* access modifiers changed from: 0000 */
    public final void a(C0525j jVar, ae aeVar) {
        List<de> list;
        List<de> list2;
        List<de> list3;
        C0525j jVar2 = jVar;
        ae aeVar2 = aeVar;
        q.a(aeVar);
        q.b(aeVar2.f5819a);
        C();
        n();
        String str = aeVar2.f5819a;
        long j2 = jVar2.f5956d;
        if (h().a(jVar2, aeVar2)) {
            if (!aeVar2.f5826h) {
                e(aeVar2);
                return;
            }
            if (this.f5631j.i().e(str, C0535l.Da)) {
                List<String> list4 = aeVar2.u;
                if (list4 != null) {
                    if (list4.contains(jVar2.f5953a)) {
                        Bundle f2 = jVar2.f5954b.f();
                        f2.putLong("ga_safelisted", 1);
                        C0525j jVar3 = new C0525j(jVar2.f5953a, new C0520i(f2), jVar2.f5955c, jVar2.f5956d);
                        jVar2 = jVar3;
                    } else {
                        this.f5631j.e().A().a("Dropping non-safelisted event. appId, event name, origin", str, jVar2.f5953a, jVar2.f5955c);
                        return;
                    }
                }
            }
            j().v();
            try {
                ke j3 = j();
                q.b(str);
                j3.j();
                j3.t();
                int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i2 < 0) {
                    j3.e().w().a("Invalid time querying timed out conditional properties", C0532kb.a(str), Long.valueOf(j2));
                    list = Collections.emptyList();
                } else {
                    list = j3.a("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j2)});
                }
                for (de deVar : list) {
                    if (deVar != null) {
                        this.f5631j.e().A().a("User property timed out", deVar.f5877a, this.f5631j.F().c(deVar.f5879c.f5706b), deVar.f5879c.f());
                        if (deVar.f5883g != null) {
                            b(new C0525j(deVar.f5883g, j2), aeVar2);
                        }
                        j().f(str, deVar.f5879c.f5706b);
                    }
                }
                ke j4 = j();
                q.b(str);
                j4.j();
                j4.t();
                if (i2 < 0) {
                    j4.e().w().a("Invalid time querying expired conditional properties", C0532kb.a(str), Long.valueOf(j2));
                    list2 = Collections.emptyList();
                } else {
                    list2 = j4.a("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j2)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (de deVar2 : list2) {
                    if (deVar2 != null) {
                        this.f5631j.e().A().a("User property expired", deVar2.f5877a, this.f5631j.F().c(deVar2.f5879c.f5706b), deVar2.f5879c.f());
                        j().c(str, deVar2.f5879c.f5706b);
                        if (deVar2.f5887k != null) {
                            arrayList.add(deVar2.f5887k);
                        }
                        j().f(str, deVar2.f5879c.f5706b);
                    }
                }
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    b(new C0525j((C0525j) obj, j2), aeVar2);
                }
                ke j5 = j();
                String str2 = jVar2.f5953a;
                q.b(str);
                q.b(str2);
                j5.j();
                j5.t();
                if (i2 < 0) {
                    j5.e().w().a("Invalid time querying triggered conditional properties", C0532kb.a(str), j5.l().a(str2), Long.valueOf(j2));
                    list3 = Collections.emptyList();
                } else {
                    list3 = j5.a("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j2)});
                }
                ArrayList arrayList2 = new ArrayList(list3.size());
                for (de deVar3 : list3) {
                    if (deVar3 != null) {
                        Rd rd = deVar3.f5879c;
                        Td td = r4;
                        Td td2 = new Td(deVar3.f5877a, deVar3.f5878b, rd.f5706b, j2, rd.f());
                        if (j().a(td)) {
                            this.f5631j.e().A().a("User property triggered", deVar3.f5877a, this.f5631j.F().c(td.f5723c), td.f5725e);
                        } else {
                            this.f5631j.e().t().a("Too many active user properties, ignoring", C0532kb.a(deVar3.f5877a), this.f5631j.F().c(td.f5723c), td.f5725e);
                        }
                        if (deVar3.f5885i != null) {
                            arrayList2.add(deVar3.f5885i);
                        }
                        deVar3.f5879c = new Rd(td);
                        deVar3.f5881e = true;
                        j().a(deVar3);
                    }
                }
                b(jVar2, aeVar2);
                int size2 = arrayList2.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    b(new C0525j((C0525j) obj2, j2), aeVar2);
                }
                j().y();
            } finally {
                j().w();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r6 = r1;
        r22 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0266, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0267, code lost:
        r5 = r3;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r5 = null;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:502:0x0c4d, code lost:
        if (r26 != r14) goto L_0x0c4f;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[ExcHandler: all (th java.lang.Throwable), PHI: r3 
      PHI: (r3v50 android.database.Cursor) = (r3v45 android.database.Cursor), (r3v45 android.database.Cursor), (r3v45 android.database.Cursor), (r3v53 android.database.Cursor), (r3v53 android.database.Cursor), (r3v53 android.database.Cursor), (r3v53 android.database.Cursor), (r3v0 android.database.Cursor), (r3v0 android.database.Cursor) binds: [B:45:0x00d8, B:51:0x00e5, B:52:?, B:23:0x007b, B:29:0x0088, B:31:0x008c, B:32:?, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0289 A[SYNTHETIC, Splitter:B:153:0x0289] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0290 A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x029e A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x03cf A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x03da A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x03db A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x05e1 A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x060e A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x06aa A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:325:0x0752 A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0768 A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:332:0x0782 A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:447:0x0aa9 A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:448:0x0abc A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:450:0x0abf A[Catch:{ IOException -> 0x0231, all -> 0x0f02 }] */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x0ae6 A[SYNTHETIC, Splitter:B:451:0x0ae6] */
    /* JADX WARNING: Removed duplicated region for block: B:465:0x0b96 A[Catch:{ all -> 0x0ee0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:466:0x0b98 A[Catch:{ all -> 0x0ee0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x0ba0 A[SYNTHETIC, Splitter:B:470:0x0ba0] */
    /* JADX WARNING: Removed duplicated region for block: B:481:0x0bce A[SYNTHETIC, Splitter:B:481:0x0bce] */
    /* JADX WARNING: Removed duplicated region for block: B:509:0x0c6b A[Catch:{ all -> 0x0ee0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:513:0x0cb3 A[Catch:{ all -> 0x0ee0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0ee4  */
    /* JADX WARNING: Removed duplicated region for block: B:604:0x0efc A[SYNTHETIC, Splitter:B:604:0x0efc] */
    private final boolean a(String str, long j2) {
        ke j3;
        Cursor cursor;
        Throwable th;
        boolean z;
        String str2;
        String str3;
        boolean z2;
        long j4;
        long j5;
        a aVar;
        com.google.android.gms.internal.measurement.V.a aVar2;
        Kd kd;
        ke j6;
        SecureRandom secureRandom;
        a aVar3;
        int i2;
        com.google.android.gms.internal.measurement.V.a aVar4;
        boolean z3;
        int d2;
        long j7;
        int i3;
        boolean z4;
        long j8;
        boolean z5;
        boolean z6;
        boolean z7;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        String str4;
        String str5;
        ArrayList arrayList;
        int i10;
        int i11;
        boolean z8;
        String str6;
        int i12;
        char c2;
        boolean z9;
        String str7;
        Cursor cursor2;
        Object obj;
        Cursor cursor3;
        String str8;
        String str9;
        Cursor query;
        Cursor cursor4;
        String[] strArr;
        String str10;
        String[] strArr2;
        Kd kd2 = this;
        j().v();
        try {
            Cursor cursor5 = null;
            a aVar5 = new a(kd2, null);
            j3 = j();
            long j9 = kd2.y;
            q.a(aVar5);
            j3.j();
            j3.t();
            try {
                SQLiteDatabase x2 = j3.x();
                if (TextUtils.isEmpty(null)) {
                    int i13 = (j9 > -1 ? 1 : (j9 == -1 ? 0 : -1));
                    if (i13 != 0) {
                        try {
                            strArr2 = new String[]{String.valueOf(j9), String.valueOf(j2)};
                        } catch (SQLiteException e2) {
                            e = e2;
                            cursor2 = cursor5;
                        } catch (Throwable th2) {
                        }
                    } else {
                        strArr2 = new String[]{String.valueOf(j2)};
                    }
                    String str11 = i13 != 0 ? "rowid <= ? and " : "";
                    StringBuilder sb = new StringBuilder(str11.length() + 148);
                    sb.append("select app_id, metadata_fingerprint from raw_events where ");
                    sb.append(str11);
                    sb.append("app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;");
                    cursor5 = x2.rawQuery(sb.toString(), strArr2);
                    if (!cursor5.moveToFirst()) {
                        if (cursor5 != null) {
                            cursor5.close();
                        }
                        if (aVar5.f5636c != null) {
                            if (!aVar5.f5636c.isEmpty()) {
                                z = false;
                                if (!z) {
                                    com.google.android.gms.internal.measurement.V.a aVar6 = (com.google.android.gms.internal.measurement.V.a) aVar5.f5634a.k();
                                    aVar6.n();
                                    boolean e3 = kd2.f5631j.i().e(aVar5.f5634a.s(), C0535l.oa);
                                    int i14 = 0;
                                    int i15 = -1;
                                    int i16 = -1;
                                    boolean z10 = false;
                                    long j10 = 0;
                                    int i17 = 0;
                                    com.google.android.gms.internal.measurement.Q.a aVar7 = null;
                                    com.google.android.gms.internal.measurement.Q.a aVar8 = null;
                                    while (true) {
                                        str2 = "_et";
                                        str3 = "_e";
                                        z2 = z10;
                                        j4 = j10;
                                        if (i14 >= aVar5.f5636c.size()) {
                                            break;
                                        }
                                        com.google.android.gms.internal.measurement.Q.a aVar9 = (com.google.android.gms.internal.measurement.Q.a) ((Q) aVar5.f5636c.get(i14)).k();
                                        String str12 = "_err";
                                        if (k().b(aVar5.f5634a.s(), aVar9.j())) {
                                            kd2.f5631j.e().w().a("Dropping blacklisted raw event. appId", C0532kb.a(aVar5.f5634a.s()), kd2.f5631j.F().a(aVar9.j()));
                                            if (!k().g(aVar5.f5634a.s())) {
                                                if (!k().h(aVar5.f5634a.s())) {
                                                    z9 = false;
                                                    if (!z9 && !str12.equals(aVar9.j())) {
                                                        kd2.f5631j.G().a(aVar5.f5634a.s(), 11, "_ev", aVar9.j(), 0);
                                                    }
                                                    z7 = e3;
                                                    i5 = i16;
                                                    z10 = z2;
                                                    j10 = j4;
                                                    i4 = i14;
                                                }
                                            }
                                            z9 = true;
                                            kd2.f5631j.G().a(aVar5.f5634a.s(), 11, "_ev", aVar9.j(), 0);
                                            z7 = e3;
                                            i5 = i16;
                                            z10 = z2;
                                            j10 = j4;
                                            i4 = i14;
                                        } else {
                                            boolean c3 = k().c(aVar5.f5634a.s(), aVar9.j());
                                            String str13 = "_c";
                                            if (!c3) {
                                                h();
                                                String j11 = aVar9.j();
                                                q.b(j11);
                                                i9 = i17;
                                                int hashCode = j11.hashCode();
                                                i8 = i14;
                                                if (hashCode != 94660) {
                                                    if (hashCode != 95025) {
                                                        if (hashCode == 95027) {
                                                            if (j11.equals("_ui")) {
                                                                c2 = 1;
                                                                if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                                    z7 = e3;
                                                                    str5 = str2;
                                                                    i7 = i15;
                                                                    i6 = i16;
                                                                    str4 = str3;
                                                                    if (kd2.f5631j.i().k(aVar5.f5634a.s()) && c3) {
                                                                        arrayList = new ArrayList(aVar9.l());
                                                                        i11 = -1;
                                                                        int i18 = -1;
                                                                        for (i10 = 0; i10 < arrayList.size(); i10++) {
                                                                            if ("value".equals(((T) arrayList.get(i10)).o())) {
                                                                                i11 = i10;
                                                                            } else if ("currency".equals(((T) arrayList.get(i10)).o())) {
                                                                                i18 = i10;
                                                                            }
                                                                        }
                                                                        if (i11 != -1) {
                                                                            if (((T) arrayList.get(i11)).r() || ((T) arrayList.get(i11)).t()) {
                                                                                if (i18 != -1) {
                                                                                    String q2 = ((T) arrayList.get(i18)).q();
                                                                                    if (q2.length() == 3) {
                                                                                        int i19 = 0;
                                                                                        while (i19 < q2.length()) {
                                                                                            int codePointAt = q2.codePointAt(i19);
                                                                                            if (Character.isLetter(codePointAt)) {
                                                                                                i19 += Character.charCount(codePointAt);
                                                                                            }
                                                                                        }
                                                                                        z8 = false;
                                                                                    }
                                                                                    z8 = true;
                                                                                    break;
                                                                                }
                                                                                z8 = true;
                                                                                if (z8) {
                                                                                    kd2.f5631j.e().y().a("Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter.");
                                                                                    aVar9.b(i11);
                                                                                    a(aVar9, str13);
                                                                                    a(aVar9, 19, "currency");
                                                                                }
                                                                                if (!kd2.f5631j.i().e(aVar5.f5634a.s(), C0535l.na)) {
                                                                                    if (str4.equals(aVar9.j())) {
                                                                                        h();
                                                                                        if (Sd.a((Q) ((Eb) aVar9.A()), "_fr") == null) {
                                                                                            if (aVar8 != null && Math.abs(aVar8.k() - aVar9.k()) <= 1000) {
                                                                                                com.google.android.gms.internal.measurement.Q.a aVar10 = (com.google.android.gms.internal.measurement.Q.a) ((com.google.android.gms.internal.measurement.Eb.a) aVar8.clone());
                                                                                                if (kd2.a(aVar9, aVar10)) {
                                                                                                    i5 = i6;
                                                                                                    aVar6.a(i5, aVar10);
                                                                                                    i15 = i7;
                                                                                                }
                                                                                            }
                                                                                            i5 = i6;
                                                                                            aVar7 = aVar9;
                                                                                            i15 = i9;
                                                                                        } else {
                                                                                            i5 = i6;
                                                                                            i15 = i7;
                                                                                        }
                                                                                    } else {
                                                                                        i5 = i6;
                                                                                        if ("_vs".equals(aVar9.j())) {
                                                                                            h();
                                                                                            if (Sd.a((Q) ((Eb) aVar9.A()), str5) == null) {
                                                                                                if (aVar7 != null && Math.abs(aVar7.k() - aVar9.k()) <= 1000) {
                                                                                                    com.google.android.gms.internal.measurement.Q.a aVar11 = (com.google.android.gms.internal.measurement.Q.a) ((com.google.android.gms.internal.measurement.Eb.a) aVar7.clone());
                                                                                                    if (kd2.a(aVar11, aVar9)) {
                                                                                                        i15 = i7;
                                                                                                        aVar6.a(i15, aVar11);
                                                                                                    }
                                                                                                }
                                                                                                i15 = i7;
                                                                                                aVar8 = aVar9;
                                                                                                i5 = i9;
                                                                                            }
                                                                                        }
                                                                                        i15 = i7;
                                                                                    }
                                                                                    aVar7 = null;
                                                                                    aVar8 = null;
                                                                                } else {
                                                                                    i15 = i7;
                                                                                    i5 = i6;
                                                                                }
                                                                                if (!z7 && str4.equals(aVar9.j())) {
                                                                                    if (aVar9.m() != 0) {
                                                                                        kd2.f5631j.e().w().a("Engagement event does not contain any parameters. appId", C0532kb.a(aVar5.f5634a.s()));
                                                                                    } else {
                                                                                        h();
                                                                                        Long l2 = (Long) Sd.b((Q) ((Eb) aVar9.A()), str5);
                                                                                        if (l2 == null) {
                                                                                            kd2.f5631j.e().w().a("Engagement event does not include duration. appId", C0532kb.a(aVar5.f5634a.s()));
                                                                                        } else {
                                                                                            j10 = j4 + l2.longValue();
                                                                                            i4 = i8;
                                                                                            aVar5.f5636c.set(i4, (Q) ((Eb) aVar9.A()));
                                                                                            i17 = i9 + 1;
                                                                                            aVar6.a(aVar9);
                                                                                            z10 = z2;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                j10 = j4;
                                                                                i4 = i8;
                                                                                aVar5.f5636c.set(i4, (Q) ((Eb) aVar9.A()));
                                                                                i17 = i9 + 1;
                                                                                aVar6.a(aVar9);
                                                                                z10 = z2;
                                                                            } else {
                                                                                kd2.f5631j.e().y().a("Value must be specified with a numeric type.");
                                                                                aVar9.b(i11);
                                                                                a(aVar9, str13);
                                                                                a(aVar9, 18, "value");
                                                                            }
                                                                        }
                                                                        if (!kd2.f5631j.i().e(aVar5.f5634a.s(), C0535l.na)) {
                                                                        }
                                                                        if (aVar9.m() != 0) {
                                                                        }
                                                                        j10 = j4;
                                                                        i4 = i8;
                                                                        aVar5.f5636c.set(i4, (Q) ((Eb) aVar9.A()));
                                                                        i17 = i9 + 1;
                                                                        aVar6.a(aVar9);
                                                                        z10 = z2;
                                                                    }
                                                                    if (!kd2.f5631j.i().e(aVar5.f5634a.s(), C0535l.na)) {
                                                                    }
                                                                    if (aVar9.m() != 0) {
                                                                    }
                                                                    j10 = j4;
                                                                    i4 = i8;
                                                                    aVar5.f5636c.set(i4, (Q) ((Eb) aVar9.A()));
                                                                    i17 = i9 + 1;
                                                                    aVar6.a(aVar9);
                                                                    z10 = z2;
                                                                }
                                                            }
                                                        }
                                                    } else if (j11.equals("_ug")) {
                                                        c2 = 2;
                                                        if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                        }
                                                    }
                                                } else if (j11.equals("_in")) {
                                                    c2 = 0;
                                                    if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                    }
                                                }
                                                c2 = 65535;
                                                if (c2 != 0 || c2 == 1 || c2 == 2) {
                                                }
                                            } else {
                                                i8 = i14;
                                                i9 = i17;
                                            }
                                            z7 = e3;
                                            int i20 = 0;
                                            boolean z11 = false;
                                            boolean z12 = false;
                                            while (true) {
                                                i7 = i15;
                                                str6 = "_r";
                                                if (i20 >= aVar9.m()) {
                                                    break;
                                                }
                                                if (str13.equals(aVar9.a(i20).o())) {
                                                    com.google.android.gms.internal.measurement.T.a aVar12 = (com.google.android.gms.internal.measurement.T.a) aVar9.a(i20).k();
                                                    i12 = i16;
                                                    aVar12.a(1);
                                                    aVar9.a(i20, (T) ((Eb) aVar12.A()));
                                                    z11 = true;
                                                } else {
                                                    i12 = i16;
                                                    if (str6.equals(aVar9.a(i20).o())) {
                                                        com.google.android.gms.internal.measurement.T.a aVar13 = (com.google.android.gms.internal.measurement.T.a) aVar9.a(i20).k();
                                                        aVar13.a(1);
                                                        aVar9.a(i20, (T) ((Eb) aVar13.A()));
                                                        z12 = true;
                                                    }
                                                }
                                                i20++;
                                                i15 = i7;
                                                i16 = i12;
                                            }
                                            i6 = i16;
                                            if (z11 || !c3) {
                                                str5 = str2;
                                                str4 = str3;
                                            } else {
                                                kd2.f5631j.e().B().a("Marking event as conversion", kd2.f5631j.F().a(aVar9.j()));
                                                com.google.android.gms.internal.measurement.T.a v2 = T.v();
                                                v2.a(str13);
                                                str5 = str2;
                                                str4 = str3;
                                                v2.a(1);
                                                aVar9.a(v2);
                                            }
                                            if (!z12) {
                                                kd2.f5631j.e().B().a("Marking event as real-time", kd2.f5631j.F().a(aVar9.j()));
                                                com.google.android.gms.internal.measurement.T.a v3 = T.v();
                                                v3.a(str6);
                                                v3.a(1);
                                                aVar9.a(v3);
                                            }
                                            if (j().a(w(), aVar5.f5634a.s(), false, false, false, false, true).f5975e > ((long) kd2.f5631j.i().a(aVar5.f5634a.s()))) {
                                                a(aVar9, str6);
                                            } else {
                                                z2 = true;
                                            }
                                            if (Wd.a(aVar9.j()) && c3 && j().a(w(), aVar5.f5634a.s(), false, false, true, false, false).f5973c > ((long) kd2.f5631j.i().b(aVar5.f5634a.s(), C0535l.y))) {
                                                kd2.f5631j.e().w().a("Too many conversions. Not logging as conversion. appId", C0532kb.a(aVar5.f5634a.s()));
                                                boolean z13 = false;
                                                com.google.android.gms.internal.measurement.T.a aVar14 = null;
                                                int i21 = -1;
                                                for (int i22 = 0; i22 < aVar9.m(); i22++) {
                                                    T a2 = aVar9.a(i22);
                                                    if (str13.equals(a2.o())) {
                                                        aVar14 = (com.google.android.gms.internal.measurement.T.a) a2.k();
                                                        i21 = i22;
                                                    } else if (str12.equals(a2.o())) {
                                                        z13 = true;
                                                    }
                                                }
                                                if (z13 && aVar14 != null) {
                                                    aVar9.b(i21);
                                                } else if (aVar14 != null) {
                                                    com.google.android.gms.internal.measurement.T.a aVar15 = (com.google.android.gms.internal.measurement.T.a) ((com.google.android.gms.internal.measurement.Eb.a) aVar14.clone());
                                                    aVar15.a(str12);
                                                    aVar15.a(10);
                                                    aVar9.a(i21, (T) ((Eb) aVar15.A()));
                                                } else {
                                                    kd2.f5631j.e().t().a("Did not find conversion parameter. appId", C0532kb.a(aVar5.f5634a.s()));
                                                }
                                            }
                                            arrayList = new ArrayList(aVar9.l());
                                            i11 = -1;
                                            int i182 = -1;
                                            while (i10 < arrayList.size()) {
                                            }
                                            if (i11 != -1) {
                                            }
                                            if (!kd2.f5631j.i().e(aVar5.f5634a.s(), C0535l.na)) {
                                            }
                                            if (aVar9.m() != 0) {
                                            }
                                            j10 = j4;
                                            i4 = i8;
                                            aVar5.f5636c.set(i4, (Q) ((Eb) aVar9.A()));
                                            i17 = i9 + 1;
                                            aVar6.a(aVar9);
                                            z10 = z2;
                                        }
                                        i14 = i4 + 1;
                                        i16 = i5;
                                        e3 = z7;
                                    }
                                    String str14 = str2;
                                    String str15 = str3;
                                    int i23 = i17;
                                    if (e3) {
                                        int i24 = i23;
                                        j5 = j4;
                                        int i25 = 0;
                                        while (i25 < i24) {
                                            Q b2 = aVar6.b(i25);
                                            if (str15.equals(b2.p())) {
                                                h();
                                                if (Sd.a(b2, "_fr") != null) {
                                                    aVar6.c(i25);
                                                    i24--;
                                                    i25--;
                                                    i25++;
                                                }
                                            }
                                            h();
                                            T a3 = Sd.a(b2, str14);
                                            if (a3 != null) {
                                                Long valueOf = a3.r() ? Long.valueOf(a3.s()) : null;
                                                if (valueOf != null && valueOf.longValue() > 0) {
                                                    j5 += valueOf.longValue();
                                                }
                                            }
                                            i25++;
                                        }
                                    } else {
                                        j5 = j4;
                                    }
                                    kd2.a(aVar6, j5, false);
                                    if (kd2.f5631j.i().e(aVar6.k(), C0535l.Ga)) {
                                        Iterator it = aVar6.l().iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                if ("_s".equals(((Q) it.next()).p())) {
                                                    z6 = true;
                                                    break;
                                                }
                                            } else {
                                                z6 = false;
                                                break;
                                            }
                                        }
                                        if (z6) {
                                            j().c(aVar6.k(), "_se");
                                        }
                                        kd2.a(aVar6, j5, true);
                                    } else if (kd2.f5631j.i().e(aVar6.k(), C0535l.Ha)) {
                                        j().c(aVar6.k(), "_se");
                                    }
                                    if (kd2.f5631j.i().e(aVar6.k(), C0535l.pa)) {
                                        Sd h2 = h();
                                        h2.e().B().a("Checking account type status for ad personalization signals");
                                        if (h2.q().e(aVar6.k())) {
                                            Fb b3 = h2.p().b(aVar6.k());
                                            if (b3 != null && b3.D() && h2.k().x()) {
                                                h2.e().A().a("Turning off ad personalization due to account type");
                                                com.google.android.gms.internal.measurement.Z.a x3 = Z.x();
                                                x3.a("_npa");
                                                x3.a(h2.k().v());
                                                x3.b(1);
                                                Z z14 = (Z) ((Eb) x3.A());
                                                int i26 = 0;
                                                while (true) {
                                                    if (i26 >= aVar6.p()) {
                                                        z5 = false;
                                                        break;
                                                    } else if ("_npa".equals(aVar6.d(i26).o())) {
                                                        aVar6.a(i26, z14);
                                                        z5 = true;
                                                        break;
                                                    } else {
                                                        i26++;
                                                    }
                                                }
                                                if (!z5) {
                                                    aVar6.a(z14);
                                                }
                                            }
                                        }
                                    }
                                    aVar6.v();
                                    String k2 = aVar6.k();
                                    List o2 = aVar6.o();
                                    List l3 = aVar6.l();
                                    q.b(k2);
                                    aVar6.b((Iterable<? extends O>) i().a(k2, l3, o2));
                                    if (kd2.f5631j.i().e(aVar5.f5634a.s())) {
                                        try {
                                            HashMap hashMap = new HashMap();
                                            ArrayList arrayList2 = new ArrayList();
                                            SecureRandom v4 = kd2.f5631j.G().v();
                                            int i27 = 0;
                                            while (i27 < aVar6.m()) {
                                                com.google.android.gms.internal.measurement.Q.a aVar16 = (com.google.android.gms.internal.measurement.Q.a) aVar6.b(i27).k();
                                                String str16 = "_sr";
                                                if (aVar16.j().equals("_ep")) {
                                                    h();
                                                    String str17 = (String) Sd.b((Q) ((Eb) aVar16.A()), "_en");
                                                    C0505f fVar = (C0505f) hashMap.get(str17);
                                                    if (fVar == null) {
                                                        fVar = j().b(aVar5.f5634a.s(), str17);
                                                        hashMap.put(str17, fVar);
                                                    }
                                                    if (fVar.f5906i == null) {
                                                        if (fVar.f5907j.longValue() > 1) {
                                                            h();
                                                            Sd.a(aVar16, str16, (Object) fVar.f5907j);
                                                        }
                                                        if (fVar.f5908k != null && fVar.f5908k.booleanValue()) {
                                                            h();
                                                            Sd.a(aVar16, "_efs", (Object) Long.valueOf(1));
                                                        }
                                                        arrayList2.add((Q) ((Eb) aVar16.A()));
                                                    }
                                                    aVar6.a(i27, aVar16);
                                                } else {
                                                    long f2 = k().f(aVar5.f5634a.s());
                                                    kd2.f5631j.G();
                                                    long a4 = Wd.a(aVar16.k(), f2);
                                                    Q q3 = (Q) ((Eb) aVar16.A());
                                                    String str18 = "_dbg";
                                                    long j12 = f2;
                                                    Long valueOf2 = Long.valueOf(1);
                                                    if (!TextUtils.isEmpty(str18) && valueOf2 != null) {
                                                        Iterator it2 = q3.r().iterator();
                                                        while (true) {
                                                            if (!it2.hasNext()) {
                                                                break;
                                                            }
                                                            T t2 = (T) it2.next();
                                                            Iterator it3 = it2;
                                                            if (!str18.equals(t2.o())) {
                                                                it2 = it3;
                                                            } else if (((valueOf2 instanceof Long) && valueOf2.equals(Long.valueOf(t2.s()))) || (((valueOf2 instanceof String) && valueOf2.equals(t2.q())) || ((valueOf2 instanceof Double) && valueOf2.equals(Double.valueOf(t2.u()))))) {
                                                                z3 = true;
                                                            }
                                                        }
                                                        d2 = z3 ? k().d(aVar5.f5634a.s(), aVar16.j()) : 1;
                                                        if (d2 > 0) {
                                                            kd2.f5631j.e().w().a("Sample rate must be positive. event, rate", aVar16.j(), Integer.valueOf(d2));
                                                            arrayList2.add((Q) ((Eb) aVar16.A()));
                                                            aVar6.a(i27, aVar16);
                                                        } else {
                                                            C0505f fVar2 = (C0505f) hashMap.get(aVar16.j());
                                                            if (fVar2 == null) {
                                                                fVar2 = j().b(aVar5.f5634a.s(), aVar16.j());
                                                                if (fVar2 == null) {
                                                                    j7 = a4;
                                                                    kd2.f5631j.e().w().a("Event being bundled has no eventAggregate. appId, eventName", aVar5.f5634a.s(), aVar16.j());
                                                                    if (kd2.f5631j.i().e(aVar5.f5634a.s(), C0535l.Fa)) {
                                                                        fVar2 = new C0505f(aVar5.f5634a.s(), aVar16.j(), 1, 1, 1, aVar16.k(), 0, null, null, null, null);
                                                                    } else {
                                                                        fVar2 = new C0505f(aVar5.f5634a.s(), aVar16.j(), 1, 1, aVar16.k(), 0, null, null, null, null);
                                                                    }
                                                                    h();
                                                                    Long l4 = (Long) Sd.b((Q) ((Eb) aVar16.A()), "_eid");
                                                                    Boolean valueOf3 = Boolean.valueOf(l4 == null);
                                                                    if (d2 != 1) {
                                                                        arrayList2.add((Q) ((Eb) aVar16.A()));
                                                                        if (valueOf3.booleanValue() && !(fVar2.f5906i == null && fVar2.f5907j == null && fVar2.f5908k == null)) {
                                                                            hashMap.put(aVar16.j(), fVar2.a(null, null, null));
                                                                        }
                                                                        aVar6.a(i27, aVar16);
                                                                    } else {
                                                                        if (v4.nextInt(d2) == 0) {
                                                                            h();
                                                                            long j13 = (long) d2;
                                                                            Sd.a(aVar16, str16, (Object) Long.valueOf(j13));
                                                                            arrayList2.add((Q) ((Eb) aVar16.A()));
                                                                            if (valueOf3.booleanValue()) {
                                                                                fVar2 = fVar2.a(null, Long.valueOf(j13), null);
                                                                            }
                                                                            hashMap.put(aVar16.j(), fVar2.a(aVar16.k(), j7));
                                                                            aVar4 = aVar6;
                                                                            secureRandom = v4;
                                                                            aVar3 = aVar5;
                                                                            i2 = i27;
                                                                        } else {
                                                                            secureRandom = v4;
                                                                            long j14 = j7;
                                                                            com.google.android.gms.internal.measurement.V.a aVar17 = aVar6;
                                                                            if (!kd2.f5631j.i().m(aVar5.f5634a.s())) {
                                                                                aVar3 = aVar5;
                                                                                i3 = i27;
                                                                                if (Math.abs(aVar16.k() - fVar2.f5904g) >= 86400000) {
                                                                                }
                                                                                z4 = false;
                                                                                if (!z4) {
                                                                                    h();
                                                                                    Sd.a(aVar16, "_efs", (Object) Long.valueOf(1));
                                                                                    h();
                                                                                    long j15 = (long) d2;
                                                                                    Sd.a(aVar16, str16, (Object) Long.valueOf(j15));
                                                                                    arrayList2.add((Q) ((Eb) aVar16.A()));
                                                                                    if (valueOf3.booleanValue()) {
                                                                                        fVar2 = fVar2.a(null, Long.valueOf(j15), Boolean.valueOf(true));
                                                                                    }
                                                                                    hashMap.put(aVar16.j(), fVar2.a(aVar16.k(), j14));
                                                                                } else if (valueOf3.booleanValue()) {
                                                                                    hashMap.put(aVar16.j(), fVar2.a(l4, null, null));
                                                                                }
                                                                                aVar4 = aVar17;
                                                                                i2 = i3;
                                                                            } else if (fVar2.f5905h != null) {
                                                                                j8 = fVar2.f5905h.longValue();
                                                                                aVar3 = aVar5;
                                                                                i3 = i27;
                                                                            } else {
                                                                                kd2.f5631j.G();
                                                                                aVar3 = aVar5;
                                                                                i3 = i27;
                                                                                j8 = Wd.a(aVar16.n(), j12);
                                                                            }
                                                                            z4 = true;
                                                                            if (!z4) {
                                                                            }
                                                                            aVar4 = aVar17;
                                                                            i2 = i3;
                                                                        }
                                                                        aVar4.a(i2, aVar16);
                                                                        v4 = secureRandom;
                                                                        i27 = i2 + 1;
                                                                        aVar5 = aVar3;
                                                                        aVar6 = aVar4;
                                                                        kd2 = this;
                                                                    }
                                                                }
                                                            }
                                                            j7 = a4;
                                                            h();
                                                            Long l42 = (Long) Sd.b((Q) ((Eb) aVar16.A()), "_eid");
                                                            Boolean valueOf32 = Boolean.valueOf(l42 == null);
                                                            if (d2 != 1) {
                                                            }
                                                        }
                                                    }
                                                    z3 = false;
                                                    if (z3) {
                                                    }
                                                    if (d2 > 0) {
                                                    }
                                                }
                                                aVar4 = aVar6;
                                                secureRandom = v4;
                                                aVar3 = aVar5;
                                                i2 = i27;
                                                v4 = secureRandom;
                                                i27 = i2 + 1;
                                                aVar5 = aVar3;
                                                aVar6 = aVar4;
                                                kd2 = this;
                                            }
                                            aVar2 = aVar6;
                                            aVar = aVar5;
                                            if (arrayList2.size() < aVar2.m()) {
                                                aVar2.n();
                                                aVar2.a((Iterable<? extends Q>) arrayList2);
                                            }
                                            for (Entry value : hashMap.entrySet()) {
                                                j().a((C0505f) value.getValue());
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            Throwable th4 = th;
                                            j().w();
                                            throw th4;
                                        }
                                    } else {
                                        aVar2 = aVar6;
                                        aVar = aVar5;
                                    }
                                    aVar2.b(Long.MAX_VALUE);
                                    aVar2.c(Long.MIN_VALUE);
                                    for (int i28 = 0; i28 < aVar2.m(); i28++) {
                                        Q b4 = aVar2.b(i28);
                                        if (b4.q() < aVar2.q()) {
                                            aVar2.b(b4.q());
                                        }
                                        if (b4.q() > aVar2.r()) {
                                            aVar2.c(b4.q());
                                        }
                                    }
                                    String s2 = aVar.f5634a.s();
                                    Fb b5 = j().b(s2);
                                    if (b5 == null) {
                                        kd = this;
                                        try {
                                            kd.f5631j.e().t().a("Bundling raw events w/o app info. appId", C0532kb.a(aVar.f5634a.s()));
                                        } catch (SQLiteException e4) {
                                            j6.e().t().a("Failed to remove unused event metadata. appId", C0532kb.a(s2), e4);
                                        } catch (Throwable th5) {
                                            th = th5;
                                            Throwable th42 = th;
                                            j().w();
                                            throw th42;
                                        }
                                    } else {
                                        kd = this;
                                        if (aVar2.m() > 0) {
                                            long j16 = b5.j();
                                            if (j16 != 0) {
                                                aVar2.e(j16);
                                            } else {
                                                aVar2.t();
                                            }
                                            long i29 = b5.i();
                                            if (i29 != 0) {
                                                j16 = i29;
                                            }
                                            if (j16 != 0) {
                                                aVar2.d(j16);
                                            } else {
                                                aVar2.s();
                                            }
                                            b5.t();
                                            aVar2.f((int) b5.q());
                                            b5.a(aVar2.q());
                                            b5.b(aVar2.r());
                                            String B = b5.B();
                                            if (B != null) {
                                                aVar2.j(B);
                                            } else {
                                                aVar2.u();
                                            }
                                            j().a(b5);
                                        }
                                    }
                                    if (aVar2.m() > 0) {
                                        kd.f5631j.b();
                                        C0344da a5 = k().a(aVar.f5634a.s());
                                        if (a5 != null) {
                                            if (a5.f5154c != null) {
                                                aVar2.i(a5.f5154c.longValue());
                                                j().a((V) ((Eb) aVar2.A()), z2);
                                            }
                                        }
                                        if (TextUtils.isEmpty(aVar.f5634a.q())) {
                                            aVar2.i(-1);
                                        } else {
                                            kd.f5631j.e().w().a("Did not find measurement config or missing version info. appId", C0532kb.a(aVar.f5634a.s()));
                                        }
                                        j().a((V) ((Eb) aVar2.A()), z2);
                                    }
                                    ke j17 = j();
                                    List<Long> list = aVar.f5635b;
                                    q.a(list);
                                    j17.j();
                                    j17.t();
                                    StringBuilder sb2 = new StringBuilder("rowid in (");
                                    for (int i30 = 0; i30 < list.size(); i30++) {
                                        if (i30 != 0) {
                                            sb2.append(",");
                                        }
                                        sb2.append(((Long) list.get(i30)).longValue());
                                    }
                                    sb2.append(")");
                                    int delete = j17.x().delete("raw_events", sb2.toString(), null);
                                    if (delete != list.size()) {
                                        j17.e().t().a("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
                                    }
                                    j6 = j();
                                    j6.x().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{s2, s2});
                                    j().y();
                                    j().w();
                                    return true;
                                }
                                Kd kd3 = kd2;
                                j().y();
                                j().w();
                                return false;
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                    } else {
                        str7 = cursor5.getString(0);
                        String string = cursor5.getString(1);
                        cursor5.close();
                        cursor3 = cursor5;
                        str9 = str7;
                        str8 = string;
                    }
                } else {
                    int i31 = (j9 > -1 ? 1 : (j9 == -1 ? 0 : -1));
                    String[] strArr3 = i31 != 0 ? new String[]{null, String.valueOf(j9)} : new String[]{null};
                    String str19 = i31 != 0 ? " and rowid <= ?" : "";
                    StringBuilder sb3 = new StringBuilder(str19.length() + 84);
                    sb3.append("select metadata_fingerprint from raw_events where app_id = ?");
                    sb3.append(str19);
                    sb3.append(" order by rowid limit 1;");
                    cursor5 = x2.rawQuery(sb3.toString(), strArr3);
                    if (!cursor5.moveToFirst()) {
                        if (cursor5 != null) {
                            cursor5.close();
                        }
                        if (aVar5.f5636c != null) {
                        }
                        z = true;
                        if (!z) {
                        }
                    } else {
                        String string2 = cursor5.getString(0);
                        cursor5.close();
                        cursor3 = cursor5;
                        str8 = string2;
                        str9 = null;
                    }
                }
                try {
                    SQLiteDatabase sQLiteDatabase = x2;
                    query = x2.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{str9, str8}, null, null, "rowid", "2");
                    try {
                        if (!query.moveToFirst()) {
                            try {
                                j3.e().t().a("Raw event metadata record is missing. appId", C0532kb.a(str9));
                                if (query != null) {
                                    query.close();
                                }
                            } catch (SQLiteException e5) {
                                e = e5;
                                str7 = str9;
                                cursor2 = query;
                                obj = e;
                                try {
                                    j3.e().t().a("Data loss. Error selecting raw event. appId", C0532kb.a(str7), obj);
                                    if (cursor2 != null) {
                                    }
                                    if (aVar5.f5636c != null) {
                                    }
                                    z = true;
                                    if (!z) {
                                    }
                                } catch (Throwable th6) {
                                    Kd kd4 = kd2;
                                    th = th6;
                                    cursor = cursor2;
                                    if (cursor != null) {
                                    }
                                    throw th;
                                }
                            } catch (Throwable th7) {
                                th = th7;
                                Kd kd5 = kd2;
                                cursor = query;
                                th = th;
                                if (cursor != null) {
                                }
                                throw th;
                            }
                            if (aVar5.f5636c != null) {
                            }
                            z = true;
                            if (!z) {
                            }
                        } else {
                            V a6 = V.a(query.getBlob(0), C0428rb.c());
                            if (query.moveToNext()) {
                                j3.e().w().a("Get multiple raw event metadata records, expected one. appId", C0532kb.a(str9));
                            }
                            query.close();
                            aVar5.a(a6);
                            if (j9 != -1) {
                                str10 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                strArr = new String[]{str9, str8, String.valueOf(j9)};
                            } else {
                                str10 = "app_id = ? and metadata_fingerprint = ?";
                                strArr = new String[]{str9, str8};
                            }
                            cursor4 = query;
                            try {
                                cursor2 = sQLiteDatabase.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str10, strArr, null, null, "rowid", null);
                                try {
                                    if (!cursor2.moveToFirst()) {
                                        j3.e().w().a("Raw event data disappeared while in transaction. appId", C0532kb.a(str9));
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        if (aVar5.f5636c != null) {
                                        }
                                        z = true;
                                        if (!z) {
                                        }
                                    } else {
                                        do {
                                            long j18 = cursor2.getLong(0);
                                            byte[] blob = cursor2.getBlob(3);
                                            try {
                                                com.google.android.gms.internal.measurement.Q.a x4 = Q.x();
                                                x4.a(blob, C0428rb.c());
                                                com.google.android.gms.internal.measurement.Q.a aVar18 = x4;
                                                aVar18.a(cursor2.getString(1));
                                                aVar18.a(cursor2.getLong(2));
                                                if (!aVar5.a(j18, (Q) ((Eb) aVar18.A()))) {
                                                    if (cursor2 != null) {
                                                        cursor2.close();
                                                    }
                                                    if (aVar5.f5636c != null) {
                                                    }
                                                    z = true;
                                                    if (!z) {
                                                    }
                                                }
                                            } catch (IOException e6) {
                                                j3.e().t().a("Data loss. Failed to merge raw event. appId", C0532kb.a(str9), e6);
                                            }
                                        } while (cursor2.moveToNext());
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                        if (aVar5.f5636c != null) {
                                        }
                                        z = true;
                                        if (!z) {
                                        }
                                    }
                                } catch (SQLiteException e7) {
                                    e = e7;
                                    str7 = str9;
                                    obj = e;
                                    j3.e().t().a("Data loss. Error selecting raw event. appId", C0532kb.a(str7), obj);
                                    if (cursor2 != null) {
                                    }
                                    if (aVar5.f5636c != null) {
                                    }
                                    z = true;
                                    if (!z) {
                                    }
                                } catch (Throwable th8) {
                                    th = th8;
                                    Kd kd6 = kd2;
                                    cursor = cursor2;
                                    th = th;
                                    if (cursor != null) {
                                    }
                                    throw th;
                                }
                            } catch (SQLiteException e8) {
                                e = e8;
                                str7 = str9;
                                cursor2 = cursor4;
                                obj = e;
                                j3.e().t().a("Data loss. Error selecting raw event. appId", C0532kb.a(str7), obj);
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                if (aVar5.f5636c != null) {
                                }
                                z = true;
                                if (!z) {
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                cursor = cursor4;
                                Kd kd7 = kd2;
                                th = th;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                    } catch (SQLiteException e9) {
                        e = e9;
                        cursor4 = query;
                        str7 = str9;
                        cursor2 = cursor4;
                        obj = e;
                        j3.e().t().a("Data loss. Error selecting raw event. appId", C0532kb.a(str7), obj);
                        if (cursor2 != null) {
                        }
                        if (aVar5.f5636c != null) {
                        }
                        z = true;
                        if (!z) {
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        cursor4 = query;
                        cursor = cursor4;
                        Kd kd72 = kd2;
                        th = th;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                } catch (SQLiteException e10) {
                    e = e10;
                    str7 = str9;
                    cursor2 = cursor3;
                    obj = e;
                    j3.e().t().a("Data loss. Error selecting raw event. appId", C0532kb.a(str7), obj);
                    if (cursor2 != null) {
                    }
                    if (aVar5.f5636c != null) {
                    }
                    z = true;
                    if (!z) {
                    }
                } catch (Throwable th11) {
                    th = th11;
                    Kd kd8 = kd2;
                    cursor = cursor3;
                    th = th;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e11) {
                obj = e11;
                cursor2 = null;
                str7 = null;
                j3.e().t().a("Data loss. Error selecting raw event. appId", C0532kb.a(str7), obj);
                if (cursor2 != null) {
                }
                if (aVar5.f5636c != null) {
                }
                z = true;
                if (!z) {
                }
            } catch (Throwable th12) {
                th = th12;
                Kd kd9 = kd2;
                cursor = null;
                th = th;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (IOException e12) {
            cursor4 = query;
            j3.e().t().a("Data loss. Failed to merge raw event metadata. appId", C0532kb.a(str9), e12);
            if (cursor4 != null) {
                cursor4.close();
            }
        } catch (Throwable th13) {
            th = th13;
            Kd kd10 = kd2;
        }
    }

    private final Boolean b(Fb fb) {
        try {
            if (fb.l() != -2147483648L) {
                if (fb.l() == ((long) c.a(this.f5631j.a()).b(fb.f(), 0).versionCode)) {
                    return Boolean.valueOf(true);
                }
            } else {
                String str = c.a(this.f5631j.a()).b(fb.f(), 0).versionName;
                if (fb.k() != null && fb.k().equals(str)) {
                    return Boolean.valueOf(true);
                }
            }
            return Boolean.valueOf(false);
        } catch (NameNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void b(Rd rd, ae aeVar) {
        C();
        n();
        if (TextUtils.isEmpty(aeVar.f5820b) && TextUtils.isEmpty(aeVar.r)) {
            return;
        }
        if (!aeVar.f5826h) {
            e(aeVar);
            return;
        }
        String str = "User property removed";
        String str2 = "Removing user property";
        if (this.f5631j.i().e(aeVar.f5819a, C0535l.pa)) {
            if (!"_npa".equals(rd.f5706b) || aeVar.s == null) {
                this.f5631j.e().A().a(str2, this.f5631j.F().c(rd.f5706b));
                j().v();
                try {
                    e(aeVar);
                    j().c(aeVar.f5819a, rd.f5706b);
                    j().y();
                    this.f5631j.e().A().a(str, this.f5631j.F().c(rd.f5706b));
                } finally {
                    j().w();
                }
            } else {
                this.f5631j.e().A().a("Falling back to manifest metadata value for ad personalization");
                Rd rd2 = new Rd("_npa", this.f5631j.c().currentTimeMillis(), Long.valueOf(aeVar.s.booleanValue() ? 1 : 0), "auto");
                a(rd2, aeVar);
            }
        } else {
            this.f5631j.e().A().a(str2, this.f5631j.F().c(rd.f5706b));
            j().v();
            try {
                e(aeVar);
                j().c(aeVar.f5819a, rd.f5706b);
                j().y();
                this.f5631j.e().A().a(str, this.f5631j.F().c(rd.f5706b));
            } finally {
                j().w();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void b(de deVar) {
        ae a2 = a(deVar.f5877a);
        if (a2 != null) {
            b(deVar, a2);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void b(de deVar, ae aeVar) {
        q.a(deVar);
        q.b(deVar.f5877a);
        q.a(deVar.f5879c);
        q.b(deVar.f5879c.f5706b);
        C();
        n();
        if (TextUtils.isEmpty(aeVar.f5820b) && TextUtils.isEmpty(aeVar.r)) {
            return;
        }
        if (!aeVar.f5826h) {
            e(aeVar);
            return;
        }
        j().v();
        try {
            e(aeVar);
            de e2 = j().e(deVar.f5877a, deVar.f5879c.f5706b);
            if (e2 != null) {
                this.f5631j.e().A().a("Removing conditional user property", deVar.f5877a, this.f5631j.F().c(deVar.f5879c.f5706b));
                j().f(deVar.f5877a, deVar.f5879c.f5706b);
                if (e2.f5881e) {
                    j().c(deVar.f5877a, deVar.f5879c.f5706b);
                }
                if (deVar.f5887k != null) {
                    Bundle bundle = null;
                    if (deVar.f5887k.f5954b != null) {
                        bundle = deVar.f5887k.f5954b.f();
                    }
                    Bundle bundle2 = bundle;
                    b(this.f5631j.G().a(deVar.f5877a, deVar.f5887k.f5953a, bundle2, e2.f5878b, deVar.f5887k.f5956d, true, false), aeVar);
                }
            } else {
                this.f5631j.e().w().a("Conditional user property doesn't exist", C0532kb.a(deVar.f5877a), this.f5631j.F().c(deVar.f5879c.f5706b));
            }
            j().y();
        } finally {
            j().w();
        }
    }

    private final void a(com.google.android.gms.internal.measurement.V.a aVar, long j2, boolean z) {
        Td td;
        String str = z ? "_se" : "_lte";
        Td d2 = j().d(aVar.k(), str);
        if (d2 == null || d2.f5725e == null) {
            td = new Td(aVar.k(), "auto", str, this.f5631j.c().currentTimeMillis(), Long.valueOf(j2));
        } else {
            td = new Td(aVar.k(), "auto", str, this.f5631j.c().currentTimeMillis(), Long.valueOf(((Long) d2.f5725e).longValue() + j2));
        }
        com.google.android.gms.internal.measurement.Z.a x2 = Z.x();
        x2.a(str);
        x2.a(this.f5631j.c().currentTimeMillis());
        x2.b(((Long) td.f5725e).longValue());
        Z z2 = (Z) x2.A();
        boolean z3 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= aVar.p()) {
                break;
            } else if (str.equals(aVar.d(i2).o())) {
                aVar.a(i2, z2);
                z3 = true;
                break;
            } else {
                i2++;
            }
        }
        if (!z3) {
            aVar.a(z2);
        }
        if (j2 > 0) {
            j().a(td);
            this.f5631j.e().A().a("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", td.f5725e);
        }
    }

    private final boolean a(com.google.android.gms.internal.measurement.Q.a aVar, com.google.android.gms.internal.measurement.Q.a aVar2) {
        Object obj;
        q.a("_e".equals(aVar.j()));
        h();
        T a2 = Sd.a((Q) aVar.A(), "_sc");
        String str = null;
        if (a2 == null) {
            obj = null;
        } else {
            obj = a2.q();
        }
        h();
        T a3 = Sd.a((Q) aVar2.A(), "_pc");
        if (a3 != null) {
            str = a3.q();
        }
        if (str == null || !str.equals(obj)) {
            return false;
        }
        h();
        String str2 = "_et";
        T a4 = Sd.a((Q) aVar.A(), str2);
        if (a4.r() && a4.s() > 0) {
            long s2 = a4.s();
            h();
            T a5 = Sd.a((Q) aVar2.A(), str2);
            if (a5 != null && a5.s() > 0) {
                s2 += a5.s();
            }
            h();
            Sd.a(aVar2, str2, (Object) Long.valueOf(s2));
            h();
            Sd.a(aVar, "_fr", (Object) Long.valueOf(1));
        }
        return true;
    }

    private static void a(com.google.android.gms.internal.measurement.Q.a aVar, String str) {
        List l2 = aVar.l();
        for (int i2 = 0; i2 < l2.size(); i2++) {
            if (str.equals(((T) l2.get(i2)).o())) {
                aVar.b(i2);
                return;
            }
        }
    }

    private static void a(com.google.android.gms.internal.measurement.Q.a aVar, int i2, String str) {
        List l2 = aVar.l();
        int i3 = 0;
        while (true) {
            String str2 = "_err";
            if (i3 >= l2.size()) {
                com.google.android.gms.internal.measurement.T.a v2 = T.v();
                v2.a(str2);
                v2.a(Long.valueOf((long) i2).longValue());
                T t2 = (T) v2.A();
                com.google.android.gms.internal.measurement.T.a v3 = T.v();
                v3.a("_ev");
                v3.b(str);
                T t3 = (T) v3.A();
                aVar.a(t2);
                aVar.a(t3);
                return;
            } else if (!str2.equals(((T) l2.get(i3)).o())) {
                i3++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: 0000 */
    public final void a(int i2, Throwable th, byte[] bArr, String str) {
        ke j2;
        C();
        n();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.s = false;
                z();
                throw th2;
            }
        }
        List<Long> list = this.w;
        this.w = null;
        boolean z = true;
        if ((i2 == 200 || i2 == 204) && th == null) {
            try {
                this.f5631j.h().f6103f.a(this.f5631j.c().currentTimeMillis());
                this.f5631j.h().f6104g.a(0);
                y();
                this.f5631j.e().B().a("Successful upload. Got network response. code, size", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                j().v();
                try {
                    for (Long l2 : list) {
                        try {
                            j2 = j();
                            long longValue = l2.longValue();
                            j2.j();
                            j2.t();
                            if (j2.x().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e2) {
                            j2.e().t().a("Failed to delete a bundle in a queue table", e2);
                            throw e2;
                        } catch (SQLiteException e3) {
                            if (this.x == null || !this.x.contains(l2)) {
                                throw e3;
                            }
                        }
                    }
                    j().y();
                    j().w();
                    this.x = null;
                    if (!l().v() || !x()) {
                        this.y = -1;
                        y();
                    } else {
                        o();
                    }
                    this.n = 0;
                } catch (Throwable th3) {
                    j().w();
                    throw th3;
                }
            } catch (SQLiteException e4) {
                this.f5631j.e().t().a("Database error while trying to delete uploaded bundles", e4);
                this.n = this.f5631j.c().a();
                this.f5631j.e().B().a("Disable upload, time", Long.valueOf(this.n));
            }
        } else {
            this.f5631j.e().B().a("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th);
            this.f5631j.h().f6104g.a(this.f5631j.c().currentTimeMillis());
            if (i2 != 503) {
                if (i2 != 429) {
                    z = false;
                }
            }
            if (z) {
                this.f5631j.h().f6105h.a(this.f5631j.c().currentTimeMillis());
            }
            j().a(list);
            y();
        }
        this.s = false;
        z();
    }

    private final void a(Fb fb) {
        C();
        if (!TextUtils.isEmpty(fb.c()) || (fe.y() && !TextUtils.isEmpty(fb.g()))) {
            fe i2 = this.f5631j.i();
            Builder builder = new Builder();
            String c2 = fb.c();
            if (TextUtils.isEmpty(c2) && fe.y()) {
                c2 = fb.g();
            }
            b bVar = null;
            Builder encodedAuthority = builder.scheme((String) C0535l.p.a(null)).encodedAuthority((String) C0535l.q.a(null));
            String str = "config/app/";
            String valueOf = String.valueOf(c2);
            encodedAuthority.path(valueOf.length() != 0 ? str.concat(valueOf) : new String(str)).appendQueryParameter("app_instance_id", fb.a()).appendQueryParameter("platform", C0730a.ANDROID_CLIENT_TYPE).appendQueryParameter("gmp_version", String.valueOf(i2.n()));
            String uri = builder.build().toString();
            try {
                URL url = new URL(uri);
                this.f5631j.e().B().a("Fetching remote configuration", fb.f());
                C0344da a2 = k().a(fb.f());
                String b2 = k().b(fb.f());
                if (a2 != null && !TextUtils.isEmpty(b2)) {
                    bVar = new b();
                    bVar.put("If-Modified-Since", b2);
                }
                b bVar2 = bVar;
                this.r = true;
                C0552ob l2 = l();
                String f2 = fb.f();
                Pd pd = new Pd(this);
                l2.j();
                l2.t();
                q.a(url);
                q.a(pd);
                Ib d2 = l2.d();
                C0571sb sbVar = new C0571sb(l2, f2, url, null, bVar2, pd);
                d2.b((Runnable) sbVar);
            } catch (MalformedURLException unused) {
                this.f5631j.e().t().a("Failed to parse config URL. Not fetching. appId", C0532kb.a(fb.f()), uri);
            }
        } else {
            a(fb.f(), 204, null, null, null);
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    public final void a(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        C();
        n();
        q.b(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.r = false;
                z();
                throw th2;
            }
        }
        this.f5631j.e().B().a("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        j().v();
        Fb b2 = j().b(str);
        boolean z = true;
        boolean z2 = (i2 == 200 || i2 == 204 || i2 == 304) && th == null;
        if (b2 == null) {
            this.f5631j.e().w().a("App does not exist in onConfigFetched. appId", C0532kb.a(str));
        } else {
            if (!z2) {
                if (i2 != 404) {
                    b2.i(this.f5631j.c().currentTimeMillis());
                    j().a(b2);
                    this.f5631j.e().B().a("Fetching config failed. code, error", Integer.valueOf(i2), th);
                    k().c(str);
                    this.f5631j.h().f6104g.a(this.f5631j.c().currentTimeMillis());
                    if (i2 != 503) {
                        if (i2 != 429) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.f5631j.h().f6105h.a(this.f5631j.c().currentTimeMillis());
                    }
                    y();
                }
            }
            List list = map != null ? (List) map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i2 != 404) {
                if (i2 != 304) {
                    if (!k().a(str, bArr, str2)) {
                        j().w();
                        this.r = false;
                        z();
                        return;
                    }
                    b2.h(this.f5631j.c().currentTimeMillis());
                    j().a(b2);
                    if (i2 != 404) {
                        this.f5631j.e().y().a("Config not found. Using empty config. appId", str);
                    } else {
                        this.f5631j.e().B().a("Successfully fetched config. Got network response. code, size", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                    }
                    if (l().v() || !x()) {
                        y();
                    } else {
                        o();
                    }
                }
            }
            if (k().a(str) == null && !k().a(str, null, null)) {
                j().w();
                this.r = false;
                z();
                return;
            }
            b2.h(this.f5631j.c().currentTimeMillis());
            j().a(b2);
            if (i2 != 404) {
            }
            if (l().v()) {
            }
            y();
        }
        j().y();
        j().w();
        this.r = false;
        z();
    }

    /* access modifiers changed from: 0000 */
    public final void a(Runnable runnable) {
        C();
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.add(runnable);
    }

    private final int a(FileChannel fileChannel) {
        C();
        int i2 = 0;
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f5631j.e().t().a("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.f5631j.e().w().a("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            i2 = allocate.getInt();
            return i2;
        } catch (IOException e2) {
            this.f5631j.e().t().a("Failed to read from channel", e2);
        }
    }

    private final boolean a(int i2, FileChannel fileChannel) {
        C();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f5631j.e().t().a("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i2);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.f5631j.e().t().a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e2) {
            this.f5631j.e().t().a("Failed to write to channel", e2);
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(ae aeVar) {
        String str = "app_id=?";
        if (this.w != null) {
            this.x = new ArrayList();
            this.x.addAll(this.w);
        }
        ke j2 = j();
        String str2 = aeVar.f5819a;
        q.b(str2);
        j2.j();
        j2.t();
        try {
            SQLiteDatabase x2 = j2.x();
            String[] strArr = {str2};
            int delete = x2.delete("apps", str, strArr) + 0 + x2.delete("events", str, strArr) + x2.delete("user_attributes", str, strArr) + x2.delete("conditional_properties", str, strArr) + x2.delete("raw_events", str, strArr) + x2.delete("raw_events_metadata", str, strArr) + x2.delete("queue", str, strArr) + x2.delete("audience_filter_values", str, strArr) + x2.delete("main_event_params", str, strArr);
            if (delete > 0) {
                j2.e().B().a("Reset analytics data. app, records", str2, Integer.valueOf(delete));
            }
        } catch (SQLiteException e2) {
            j2.e().t().a("Error resetting analytics data. appId, error", C0532kb.a(str2), e2);
        }
        ae a2 = a(this.f5631j.a(), aeVar.f5819a, aeVar.f5820b, aeVar.f5826h, aeVar.o, aeVar.p, aeVar.m, aeVar.r);
        if (aeVar.f5826h) {
            c(a2);
        }
    }

    private final ae a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j2, String str3) {
        String str4;
        String str5;
        int i2;
        String str6 = str;
        String str7 = "Unknown";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.f5631j.e().t().a("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str6);
        } catch (IllegalArgumentException unused) {
            this.f5631j.e().t().a("Error retrieving installer package name. appId", C0532kb.a(str));
            str4 = str7;
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        String str8 = str4;
        try {
            PackageInfo b2 = c.a(context).b(str6, 0);
            if (b2 != null) {
                CharSequence b3 = c.a(context).b(str6);
                if (!TextUtils.isEmpty(b3)) {
                    String charSequence = b3.toString();
                }
                String str9 = b2.versionName;
                i2 = b2.versionCode;
                str5 = str9;
            } else {
                i2 = Integer.MIN_VALUE;
                str5 = str7;
            }
            this.f5631j.b();
            ae aeVar = new ae(str, str2, str5, (long) i2, str8, this.f5631j.i().n(), this.f5631j.G().a(context, str6), (String) null, z, false, "", 0, this.f5631j.i().j(str6) ? j2 : 0, 0, z2, z3, false, str3, (Boolean) null, 0, null);
            return aeVar;
        } catch (NameNotFoundException unused2) {
            this.f5631j.e().t().a("Error retrieving newly installed package info. appId, appName", C0532kb.a(str), str7);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(Rd rd, ae aeVar) {
        C();
        n();
        if (TextUtils.isEmpty(aeVar.f5820b) && TextUtils.isEmpty(aeVar.r)) {
            return;
        }
        if (!aeVar.f5826h) {
            e(aeVar);
            return;
        }
        int c2 = this.f5631j.G().c(rd.f5706b);
        if (c2 != 0) {
            this.f5631j.G();
            String a2 = Wd.a(rd.f5706b, 24, true);
            String str = rd.f5706b;
            this.f5631j.G().a(aeVar.f5819a, c2, "_ev", a2, str != null ? str.length() : 0);
            return;
        }
        int b2 = this.f5631j.G().b(rd.f5706b, rd.f());
        if (b2 != 0) {
            this.f5631j.G();
            String a3 = Wd.a(rd.f5706b, 24, true);
            Object f2 = rd.f();
            this.f5631j.G().a(aeVar.f5819a, b2, "_ev", a3, (f2 == null || (!(f2 instanceof String) && !(f2 instanceof CharSequence))) ? 0 : String.valueOf(f2).length());
            return;
        }
        Object c3 = this.f5631j.G().c(rd.f5706b, rd.f());
        if (c3 != null) {
            if ("_sid".equals(rd.f5706b) && this.f5631j.i().o(aeVar.f5819a)) {
                long j2 = rd.f5707c;
                String str2 = rd.f5711g;
                long j3 = 0;
                Td d2 = j().d(aeVar.f5819a, "_sno");
                if (d2 != null) {
                    Object obj = d2.f5725e;
                    if (obj instanceof Long) {
                        j3 = ((Long) obj).longValue();
                        Rd rd2 = new Rd("_sno", j2, Long.valueOf(j3 + 1), str2);
                        a(rd2, aeVar);
                    }
                }
                if (d2 != null) {
                    this.f5631j.e().w().a("Retrieved last session number from database does not contain a valid (long) value", d2.f5725e);
                }
                if (this.f5631j.i().e(aeVar.f5819a, C0535l.ka)) {
                    C0505f b3 = j().b(aeVar.f5819a, "_s");
                    if (b3 != null) {
                        j3 = b3.f5900c;
                        this.f5631j.e().B().a("Backfill the session number. Last used session number", Long.valueOf(j3));
                    }
                }
                Rd rd22 = new Rd("_sno", j2, Long.valueOf(j3 + 1), str2);
                a(rd22, aeVar);
            }
            Td td = new Td(aeVar.f5819a, rd.f5711g, rd.f5706b, rd.f5707c, c3);
            this.f5631j.e().A().a("Setting user property", this.f5631j.F().c(td.f5723c), c3);
            j().v();
            try {
                e(aeVar);
                boolean a4 = j().a(td);
                j().y();
                if (a4) {
                    this.f5631j.e().A().a("User property set", this.f5631j.F().c(td.f5723c), td.f5725e);
                } else {
                    this.f5631j.e().t().a("Too many unique user properties are set. Ignoring user property", this.f5631j.F().c(td.f5723c), td.f5725e);
                    this.f5631j.G().a(aeVar.f5819a, 9, (String) null, (String) null, 0);
                }
            } finally {
                j().w();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(Ld ld) {
        this.p++;
    }

    private final ae a(String str) {
        String str2 = str;
        Fb b2 = j().b(str2);
        if (b2 == null || TextUtils.isEmpty(b2.k())) {
            this.f5631j.e().A().a("No app data available; dropping", str2);
            return null;
        }
        Boolean b3 = b(b2);
        if (b3 == null || b3.booleanValue()) {
            Fb fb = b2;
            ae aeVar = new ae(str, b2.c(), b2.k(), b2.l(), b2.m(), b2.n(), b2.o(), (String) null, b2.d(), false, b2.b(), fb.C(), 0, 0, fb.D(), fb.E(), false, fb.g(), fb.F(), fb.p(), fb.G());
            return aeVar;
        }
        this.f5631j.e().t().a("App version does not match; dropping. appId", C0532kb.a(str));
        return null;
    }

    /* access modifiers changed from: 0000 */
    public final void a(de deVar) {
        ae a2 = a(deVar.f5877a);
        if (a2 != null) {
            a(deVar, a2);
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(de deVar, ae aeVar) {
        q.a(deVar);
        q.b(deVar.f5877a);
        q.a(deVar.f5878b);
        q.a(deVar.f5879c);
        q.b(deVar.f5879c.f5706b);
        C();
        n();
        if (TextUtils.isEmpty(aeVar.f5820b) && TextUtils.isEmpty(aeVar.r)) {
            return;
        }
        if (!aeVar.f5826h) {
            e(aeVar);
            return;
        }
        de deVar2 = new de(deVar);
        boolean z = false;
        deVar2.f5881e = false;
        j().v();
        try {
            de e2 = j().e(deVar2.f5877a, deVar2.f5879c.f5706b);
            if (e2 != null && !e2.f5878b.equals(deVar2.f5878b)) {
                this.f5631j.e().w().a("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f5631j.F().c(deVar2.f5879c.f5706b), deVar2.f5878b, e2.f5878b);
            }
            if (e2 != null && e2.f5881e) {
                deVar2.f5878b = e2.f5878b;
                deVar2.f5880d = e2.f5880d;
                deVar2.f5884h = e2.f5884h;
                deVar2.f5882f = e2.f5882f;
                deVar2.f5885i = e2.f5885i;
                deVar2.f5881e = e2.f5881e;
                Rd rd = new Rd(deVar2.f5879c.f5706b, e2.f5879c.f5707c, deVar2.f5879c.f(), e2.f5879c.f5711g);
                deVar2.f5879c = rd;
            } else if (TextUtils.isEmpty(deVar2.f5882f)) {
                Rd rd2 = new Rd(deVar2.f5879c.f5706b, deVar2.f5880d, deVar2.f5879c.f(), deVar2.f5879c.f5711g);
                deVar2.f5879c = rd2;
                deVar2.f5881e = true;
                z = true;
            }
            if (deVar2.f5881e) {
                Rd rd3 = deVar2.f5879c;
                Td td = new Td(deVar2.f5877a, deVar2.f5878b, rd3.f5706b, rd3.f5707c, rd3.f());
                if (j().a(td)) {
                    this.f5631j.e().A().a("User property updated immediately", deVar2.f5877a, this.f5631j.F().c(td.f5723c), td.f5725e);
                } else {
                    this.f5631j.e().t().a("(2)Too many active user properties, ignoring", C0532kb.a(deVar2.f5877a), this.f5631j.F().c(td.f5723c), td.f5725e);
                }
                if (z && deVar2.f5885i != null) {
                    b(new C0525j(deVar2.f5885i, deVar2.f5880d), aeVar);
                }
            }
            if (j().a(deVar2)) {
                this.f5631j.e().A().a("Conditional property added", deVar2.f5877a, this.f5631j.F().c(deVar2.f5879c.f5706b), deVar2.f5879c.f());
            } else {
                this.f5631j.e().t().a("Too many conditional properties, ignoring", C0532kb.a(deVar2.f5877a), this.f5631j.F().c(deVar2.f5879c.f5706b), deVar2.f5879c.f());
            }
            j().y();
        } finally {
            j().w();
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(boolean z) {
        y();
    }
}
