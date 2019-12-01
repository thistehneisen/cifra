package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ActivityLifecycleManager */
public class b {

    /* renamed from: a reason: collision with root package name */
    private final Application f8991a;

    /* renamed from: b reason: collision with root package name */
    private a f8992b;

    /* compiled from: ActivityLifecycleManager */
    private static class a {

        /* renamed from: a reason: collision with root package name */
        private final Set<ActivityLifecycleCallbacks> f8993a = new HashSet();

        /* renamed from: b reason: collision with root package name */
        private final Application f8994b;

        a(Application application) {
            this.f8994b = application;
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        public void a() {
            for (ActivityLifecycleCallbacks unregisterActivityLifecycleCallbacks : this.f8993a) {
                this.f8994b.unregisterActivityLifecycleCallbacks(unregisterActivityLifecycleCallbacks);
            }
        }

        /* access modifiers changed from: private */
        @TargetApi(14)
        public boolean a(C0097b bVar) {
            if (this.f8994b == null) {
                return false;
            }
            a aVar = new a(this, bVar);
            this.f8994b.registerActivityLifecycleCallbacks(aVar);
            this.f8993a.add(aVar);
            return true;
        }
    }

    /* renamed from: io.fabric.sdk.android.b$b reason: collision with other inner class name */
    /* compiled from: ActivityLifecycleManager */
    public static abstract class C0097b {
        public abstract void onActivityCreated(Activity activity, Bundle bundle);

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public abstract void onActivityResumed(Activity activity);

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public abstract void onActivityStarted(Activity activity);

        public void onActivityStopped(Activity activity) {
        }
    }

    public b(Context context) {
        this.f8991a = (Application) context.getApplicationContext();
        if (VERSION.SDK_INT >= 14) {
            this.f8992b = new a(this.f8991a);
        }
    }

    public boolean a(C0097b bVar) {
        a aVar = this.f8992b;
        return aVar != null && aVar.a(bVar);
    }

    public void a() {
        a aVar = this.f8992b;
        if (aVar != null) {
            aVar.a();
        }
    }
}
