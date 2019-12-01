package io.fabric.sdk.android;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import io.fabric.sdk.android.b.C0097b;

/* compiled from: ActivityLifecycleManager */
class a implements ActivityLifecycleCallbacks {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ C0097b f8780a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f8781b;

    a(a aVar, C0097b bVar) {
        this.f8781b = aVar;
        this.f8780a = bVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        this.f8780a.onActivityCreated(activity, bundle);
    }

    public void onActivityDestroyed(Activity activity) {
        this.f8780a.onActivityDestroyed(activity);
    }

    public void onActivityPaused(Activity activity) {
        this.f8780a.onActivityPaused(activity);
    }

    public void onActivityResumed(Activity activity) {
        this.f8780a.onActivityResumed(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f8780a.onActivitySaveInstanceState(activity, bundle);
    }

    public void onActivityStarted(Activity activity) {
        this.f8780a.onActivityStarted(activity);
    }

    public void onActivityStopped(Activity activity) {
        this.f8780a.onActivityStopped(activity);
    }
}
