package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.k;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.api.internal.a reason: case insensitive filesystem */
public final class C0298a implements ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: a reason: collision with root package name */
    private static final C0298a f4564a = new C0298a();

    /* renamed from: b reason: collision with root package name */
    private final AtomicBoolean f4565b = new AtomicBoolean();

    /* renamed from: c reason: collision with root package name */
    private final AtomicBoolean f4566c = new AtomicBoolean();

    /* renamed from: d reason: collision with root package name */
    private final ArrayList<C0062a> f4567d = new ArrayList<>();

    /* renamed from: e reason: collision with root package name */
    private boolean f4568e = false;

    /* renamed from: com.google.android.gms.common.api.internal.a$a reason: collision with other inner class name */
    public interface C0062a {
        void a(boolean z);
    }

    private C0298a() {
    }

    public static C0298a a() {
        return f4564a;
    }

    public final boolean b() {
        return this.f4565b.get();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f4565b.compareAndSet(true, false);
        this.f4566c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f4565b.compareAndSet(true, false);
        this.f4566c.set(true);
        if (compareAndSet) {
            b(false);
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f4565b.compareAndSet(false, true)) {
            this.f4566c.set(true);
            b(true);
        }
    }

    public static void a(Application application) {
        synchronized (f4564a) {
            if (!f4564a.f4568e) {
                application.registerActivityLifecycleCallbacks(f4564a);
                application.registerComponentCallbacks(f4564a);
                f4564a.f4568e = true;
            }
        }
    }

    private final void b(boolean z) {
        synchronized (f4564a) {
            ArrayList<C0062a> arrayList = this.f4567d;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((C0062a) obj).a(z);
            }
        }
    }

    @TargetApi(16)
    public final boolean a(boolean z) {
        if (!this.f4566c.get()) {
            if (!k.c()) {
                return z;
            }
            RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f4566c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f4565b.set(true);
            }
        }
        return b();
    }

    public final void a(C0062a aVar) {
        synchronized (f4564a) {
            this.f4567d.add(aVar);
        }
    }
}
