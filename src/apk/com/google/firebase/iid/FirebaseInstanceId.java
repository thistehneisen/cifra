package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import com.google.android.gms.tasks.f;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import com.google.firebase.a.b;
import com.google.firebase.a.d;
import com.google.firebase.c.g;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseInstanceId {

    /* renamed from: a reason: collision with root package name */
    private static final long f6744a = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: b reason: collision with root package name */
    private static C0634x f6745b;

    /* renamed from: c reason: collision with root package name */
    private static ScheduledExecutorService f6746c;

    /* renamed from: d reason: collision with root package name */
    private final Executor f6747d;
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public final FirebaseApp f6748e;

    /* renamed from: f reason: collision with root package name */
    private final C0627p f6749f;

    /* renamed from: g reason: collision with root package name */
    private C0613b f6750g;

    /* renamed from: h reason: collision with root package name */
    private final C0629s f6751h;

    /* renamed from: i reason: collision with root package name */
    private final B f6752i;

    /* renamed from: j reason: collision with root package name */
    private boolean f6753j;

    /* renamed from: k reason: collision with root package name */
    private final a f6754k;

    private class a {

        /* renamed from: a reason: collision with root package name */
        private final boolean f6755a = c();

        /* renamed from: b reason: collision with root package name */
        private final d f6756b;

        /* renamed from: c reason: collision with root package name */
        private b<com.google.firebase.a> f6757c;

        /* renamed from: d reason: collision with root package name */
        private Boolean f6758d = b();

        a(d dVar) {
            this.f6756b = dVar;
            if (this.f6758d == null && this.f6755a) {
                this.f6757c = new T(this);
                dVar.a(com.google.firebase.a.class, this.f6757c);
            }
        }

        private final Boolean b() {
            String str = "firebase_messaging_auto_init_enabled";
            Context b2 = FirebaseInstanceId.this.f6748e.b();
            SharedPreferences sharedPreferences = b2.getSharedPreferences("com.google.firebase.messaging", 0);
            String str2 = "auto_init";
            if (sharedPreferences.contains(str2)) {
                return Boolean.valueOf(sharedPreferences.getBoolean(str2, false));
            }
            try {
                PackageManager packageManager = b2.getPackageManager();
                if (packageManager != null) {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(b2.getPackageName(), 128);
                    if (!(applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(str))) {
                        return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
                    }
                }
            } catch (NameNotFoundException unused) {
            }
            return null;
        }

        private final boolean c() {
            try {
                Class.forName("com.google.firebase.messaging.a");
                return true;
            } catch (ClassNotFoundException unused) {
                Context b2 = FirebaseInstanceId.this.f6748e.b();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(b2.getPackageName());
                ResolveInfo resolveService = b2.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || resolveService.serviceInfo == null) {
                    return false;
                }
                return true;
            }
        }

        /* access modifiers changed from: 0000 */
        public final synchronized boolean a() {
            if (this.f6758d == null) {
                return this.f6755a && FirebaseInstanceId.this.f6748e.isDataCollectionDefaultEnabled();
            }
            return this.f6758d.booleanValue();
        }
    }

    FirebaseInstanceId(FirebaseApp firebaseApp, d dVar, g gVar) {
        this(firebaseApp, new C0627p(firebaseApp.b()), J.b(), J.b(), dVar, gVar);
    }

    public static FirebaseInstanceId b() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static FirebaseInstanceId getInstance(FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.a(FirebaseInstanceId.class);
    }

    static boolean h() {
        String str = "FirebaseInstanceId";
        return Log.isLoggable(str, 3) || (VERSION.SDK_INT == 23 && Log.isLoggable(str, 3));
    }

    private final synchronized void m() {
        if (!this.f6753j) {
            a(0);
        }
    }

    /* access modifiers changed from: private */
    public final void n() {
        A f2 = f();
        if (l() || a(f2) || this.f6752i.a()) {
            m();
        }
    }

    private static String o() {
        return C0627p.a(f6745b.b("").a());
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void a(boolean z) {
        this.f6753j = z;
    }

    public com.google.android.gms.tasks.g<C0612a> c() {
        return b(C0627p.a(this.f6748e), "*");
    }

    @Deprecated
    public String d() {
        A f2 = f();
        if (this.f6750g.a() || a(f2)) {
            m();
        }
        return A.a(f2);
    }

    /* access modifiers changed from: 0000 */
    public final FirebaseApp e() {
        return this.f6748e;
    }

    /* access modifiers changed from: 0000 */
    public final A f() {
        return c(C0627p.a(this.f6748e), "*");
    }

    /* access modifiers changed from: 0000 */
    public final String g() throws IOException {
        return a(C0627p.a(this.f6748e), "*");
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void i() {
        f6745b.b();
        if (this.f6754k.a()) {
            m();
        }
    }

    /* access modifiers changed from: 0000 */
    public final boolean j() {
        return this.f6750g.b();
    }

    /* access modifiers changed from: 0000 */
    public final void k() {
        f6745b.c("");
        m();
    }

    /* access modifiers changed from: 0000 */
    public final boolean l() {
        return this.f6750g.a();
    }

    private final com.google.android.gms.tasks.g<C0612a> b(String str, String str2) {
        return j.a(null).b(this.f6747d, new Q(this, str, c(str2)));
    }

    private static A c(String str, String str2) {
        return f6745b.a("", str, str2);
    }

    private static String c(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    /* access modifiers changed from: 0000 */
    public final synchronized void a(long j2) {
        C0636z zVar = new C0636z(this, this.f6749f, this.f6752i, Math.min(Math.max(30, j2 << 1), f6744a));
        a((Runnable) zVar, j2);
        this.f6753j = true;
    }

    private FirebaseInstanceId(FirebaseApp firebaseApp, C0627p pVar, Executor executor, Executor executor2, d dVar, g gVar) {
        this.f6753j = false;
        if (C0627p.a(firebaseApp) != null) {
            synchronized (FirebaseInstanceId.class) {
                if (f6745b == null) {
                    f6745b = new C0634x(firebaseApp.b());
                }
            }
            this.f6748e = firebaseApp;
            this.f6749f = pVar;
            if (this.f6750g == null) {
                C0613b bVar = (C0613b) firebaseApp.a(C0613b.class);
                if (bVar == null || !bVar.b()) {
                    this.f6750g = new V(firebaseApp, pVar, executor, gVar);
                } else {
                    this.f6750g = bVar;
                }
            }
            this.f6750g = this.f6750g;
            this.f6747d = executor2;
            this.f6752i = new B(f6745b);
            this.f6754k = new a(dVar);
            this.f6751h = new C0629s(executor);
            if (this.f6754k.a()) {
                n();
                return;
            }
            return;
        }
        throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    }

    /* access modifiers changed from: 0000 */
    public final void b(String str) throws IOException {
        A f2 = f();
        if (!a(f2)) {
            a(this.f6750g.a(o(), f2.f6732b, str));
            return;
        }
        throw new IOException("token not available");
    }

    static void a(Runnable runnable, long j2) {
        synchronized (FirebaseInstanceId.class) {
            if (f6746c == null) {
                f6746c = new ScheduledThreadPoolExecutor(1, new com.google.android.gms.common.util.a.a("FirebaseInstanceId"));
            }
            f6746c.schedule(runnable, j2, TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ com.google.android.gms.tasks.g b(String str, String str2, String str3, String str4) throws Exception {
        f6745b.a("", str, str2, str4, this.f6749f.b());
        return j.a(new aa(str3, str4));
    }

    public String a() {
        n();
        return o();
    }

    public String a(String str, String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((C0612a) a(b(str, str2))).a();
        }
        throw new IOException("MAIN_THREAD");
    }

    private final <T> T a(com.google.android.gms.tasks.g<T> gVar) throws IOException {
        try {
            return j.a(gVar, 30000, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    i();
                }
                throw ((IOException) cause);
            } else if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else {
                throw new IOException(e2);
            }
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
    }

    /* access modifiers changed from: 0000 */
    public final void a(String str) throws IOException {
        A f2 = f();
        if (!a(f2)) {
            a(this.f6750g.b(o(), f2.f6732b, str));
            return;
        }
        throw new IOException("token not available");
    }

    /* access modifiers changed from: 0000 */
    public final boolean a(A a2) {
        return a2 == null || a2.b(this.f6749f.b());
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ com.google.android.gms.tasks.g a(String str, String str2, com.google.android.gms.tasks.g gVar) throws Exception {
        String o = o();
        A c2 = c(str, str2);
        if (!this.f6750g.a() && !a(c2)) {
            return j.a(new aa(o, c2.f6732b));
        }
        String a2 = A.a(c2);
        C0629s sVar = this.f6751h;
        P p = new P(this, o, a2, str, str2);
        return sVar.a(str, str2, p);
    }

    /* access modifiers changed from: 0000 */
    public final /* synthetic */ com.google.android.gms.tasks.g a(String str, String str2, String str3, String str4) {
        return this.f6750g.a(str, str2, str3, str4).a(this.f6747d, (f<TResult, TContinuationResult>) new S<TResult,TContinuationResult>(this, str3, str4, str));
    }
}
