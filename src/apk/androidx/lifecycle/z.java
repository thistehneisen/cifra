package androidx.lifecycle;

import android.app.Activity;
import android.os.Bundle;

/* compiled from: ProcessLifecycleOwner */
class z extends C0210c {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ A f1671a;

    z(A a2) {
        this.f1671a = a2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        B.a(activity).a(this.f1671a.f1601i);
    }

    public void onActivityPaused(Activity activity) {
        this.f1671a.a();
    }

    public void onActivityStopped(Activity activity) {
        this.f1671a.d();
    }
}
