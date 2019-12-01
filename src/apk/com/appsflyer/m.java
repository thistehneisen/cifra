package com.appsflyer;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.concurrent.RejectedExecutionException;

final class m implements ActivityLifecycleCallbacks {

    /* renamed from: ॱ reason: contains not printable characters */
    private static m f187;
    /* access modifiers changed from: private */

    /* renamed from: ˋ reason: contains not printable characters */
    public d f188 = null;
    /* access modifiers changed from: private */

    /* renamed from: ˎ reason: contains not printable characters */
    public boolean f189 = false;
    /* access modifiers changed from: private */

    /* renamed from: ˏ reason: contains not printable characters */
    public boolean f190 = true;

    class c extends AsyncTask<Void, Void, Void> {

        /* renamed from: ॱ reason: contains not printable characters */
        private WeakReference<Context> f192;

        public c(WeakReference<Context> weakReference) {
            this.f192 = weakReference;
        }

        /* renamed from: ˋ reason: contains not printable characters */
        private Void m165() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e2) {
                AFLogger.afErrorLog("Sleeping attempt failed (essential for background state verification)\n", e2);
            }
            if (m.this.f189 && m.this.f190) {
                m.this.f189 = false;
                try {
                    m.this.f188.m167(this.f192);
                } catch (Exception e3) {
                    AFLogger.afErrorLog("Listener threw exception! ", e3);
                    cancel(true);
                }
            }
            this.f192.clear();
            return null;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return m165();
        }
    }

    interface d {
        /* renamed from: ˊ reason: contains not printable characters */
        void m166(Activity activity);

        /* renamed from: ˊ reason: contains not printable characters */
        void m167(WeakReference<Context> weakReference);
    }

    m() {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AFDeepLinkManager.getInstance().collectIntentsFromActivities(activity.getIntent());
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
        this.f190 = true;
        try {
            new c(new WeakReference(activity.getApplicationContext())).executeOnExecutor(AFExecutor.getInstance().getThreadPoolExecutor(), new Void[0]);
        } catch (RejectedExecutionException e2) {
            AFLogger.afErrorLog("backgroundTask.executeOnExecutor failed with RejectedExecutionException Exception", e2);
        } catch (Throwable th) {
            AFLogger.afErrorLog("backgroundTask.executeOnExecutor failed with Exception", th);
        }
    }

    public final void onActivityResumed(Activity activity) {
        this.f190 = false;
        boolean z = !this.f189;
        this.f189 = true;
        if (z) {
            try {
                this.f188.m166(activity);
            } catch (Exception e2) {
                AFLogger.afErrorLog("Listener threw exception! ", e2);
            }
        }
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    /* renamed from: ˎ reason: contains not printable characters */
    static m m161() {
        if (f187 == null) {
            f187 = new m();
        }
        return f187;
    }

    /* renamed from: ˏ reason: contains not printable characters */
    public static m m162() {
        m mVar = f187;
        if (mVar != null) {
            return mVar;
        }
        throw new IllegalStateException("Foreground is not initialised - invoke at least once with parameter init/get");
    }

    /* renamed from: ˊ reason: contains not printable characters */
    public final void m164(Application application, d dVar) {
        this.f188 = dVar;
        if (VERSION.SDK_INT >= 14) {
            application.registerActivityLifecycleCallbacks(f187);
        }
    }
}
