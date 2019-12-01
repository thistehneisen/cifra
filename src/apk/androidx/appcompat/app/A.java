package androidx.appcompat.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: AppCompatDelegateImpl */
class A extends BroadcastReceiver {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ e f380a;

    A(e eVar) {
        this.f380a = eVar;
    }

    public void onReceive(Context context, Intent intent) {
        this.f380a.b();
    }
}
