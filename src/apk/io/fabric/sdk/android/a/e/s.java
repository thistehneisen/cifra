package io.fabric.sdk.android.a.e;

import android.content.Context;
import io.fabric.sdk.android.a.b.E;
import io.fabric.sdk.android.a.b.i;
import io.fabric.sdk.android.a.b.o;
import io.fabric.sdk.android.a.b.p;
import io.fabric.sdk.android.a.b.y;
import io.fabric.sdk.android.f;
import io.fabric.sdk.android.l;
import io.fabric.sdk.android.services.network.g;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Settings */
public class s {

    /* renamed from: a reason: collision with root package name */
    private final AtomicReference<v> f8962a;

    /* renamed from: b reason: collision with root package name */
    private final CountDownLatch f8963b;

    /* renamed from: c reason: collision with root package name */
    private u f8964c;

    /* renamed from: d reason: collision with root package name */
    private boolean f8965d;

    /* compiled from: Settings */
    static class a {
        /* access modifiers changed from: private */

        /* renamed from: a reason: collision with root package name */
        public static final s f8966a = new s();
    }

    public static s b() {
        return a.f8966a;
    }

    public synchronized s a(l lVar, y yVar, g gVar, String str, String str2, String str3, o oVar) {
        l lVar2 = lVar;
        synchronized (this) {
            if (this.f8965d) {
                return this;
            }
            if (this.f8964c == null) {
                Context context = lVar.getContext();
                String c2 = yVar.c();
                String d2 = new i().d(context);
                String f2 = yVar.f();
                E e2 = new E();
                l lVar3 = new l();
                j jVar = new j(lVar2);
                String c3 = io.fabric.sdk.android.a.b.l.c(context);
                String str4 = str3;
                m mVar = new m(lVar2, str4, String.format(Locale.US, "https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", new Object[]{c2}), gVar);
                String g2 = yVar.g();
                String str5 = g2;
                String str6 = str2;
                String str7 = str;
                y yVar2 = new y(d2, str5, yVar.h(), yVar.i(), yVar.d(), io.fabric.sdk.android.a.b.l.a(io.fabric.sdk.android.a.b.l.n(context)), str6, str7, p.a(f2).getId(), c3);
                k kVar = new k(lVar, yVar2, e2, lVar3, jVar, mVar, oVar);
                this.f8964c = kVar;
            }
            this.f8965d = true;
            return this;
        }
    }

    public synchronized boolean c() {
        v a2;
        a2 = this.f8964c.a();
        a(a2);
        return a2 != null;
    }

    public synchronized boolean d() {
        v a2;
        a2 = this.f8964c.a(t.SKIP_CACHE_LOOKUP);
        a(a2);
        if (a2 == null) {
            f.e().b("Fabric", "Failed to force reload of settings from Crashlytics.", null);
        }
        return a2 != null;
    }

    private s() {
        this.f8962a = new AtomicReference<>();
        this.f8963b = new CountDownLatch(1);
        this.f8965d = false;
    }

    public v a() {
        try {
            this.f8963b.await();
            return (v) this.f8962a.get();
        } catch (InterruptedException unused) {
            f.e().b("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    private void a(v vVar) {
        this.f8962a.set(vVar);
        this.f8963b.countDown();
    }
}
