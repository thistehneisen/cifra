package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import c.b.a.b.b.d.a;
import c.b.a.b.b.d.f;
import com.google.android.gms.tasks.g;
import java.util.concurrent.ScheduledExecutorService;

/* renamed from: com.google.firebase.iid.f reason: case insensitive filesystem */
public final class C0617f {

    /* renamed from: a reason: collision with root package name */
    private static C0617f f6807a;
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public final Context f6808b;
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public final ScheduledExecutorService f6809c;

    /* renamed from: d reason: collision with root package name */
    private C0619h f6810d = new C0619h(this);

    /* renamed from: e reason: collision with root package name */
    private int f6811e = 1;

    private C0617f(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f6809c = scheduledExecutorService;
        this.f6808b = context.getApplicationContext();
    }

    public static synchronized C0617f a(Context context) {
        C0617f fVar;
        synchronized (C0617f.class) {
            if (f6807a == null) {
                f6807a = new C0617f(context, a.a().a(1, new com.google.android.gms.common.util.a.a("MessengerIpcClient"), f.f3053a));
            }
            fVar = f6807a;
        }
        return fVar;
    }

    public final g<Bundle> b(int i2, Bundle bundle) {
        return a((C0624m<T>) new C0626o<T>(a(), 1, bundle));
    }

    public final g<Void> a(int i2, Bundle bundle) {
        return a((C0624m<T>) new C0625n<T>(a(), 2, bundle));
    }

    private final synchronized <T> g<T> a(C0624m<T> mVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(mVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f6810d.a((C0624m) mVar)) {
            this.f6810d = new C0619h(this);
            this.f6810d.a((C0624m) mVar);
        }
        return mVar.f6826b.a();
    }

    private final synchronized int a() {
        int i2;
        i2 = this.f6811e;
        this.f6811e = i2 + 1;
        return i2;
    }
}
