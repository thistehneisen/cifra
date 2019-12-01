package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.q;

public final class Qd {

    /* renamed from: a reason: collision with root package name */
    final Context f5694a;

    public Qd(Context context) {
        q.a(context);
        Context applicationContext = context.getApplicationContext();
        q.a(applicationContext);
        this.f5694a = applicationContext;
    }
}
