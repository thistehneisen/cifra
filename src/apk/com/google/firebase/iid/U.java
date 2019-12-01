package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.h;

final /* synthetic */ class U implements Runnable {

    /* renamed from: a reason: collision with root package name */
    private final V f6793a;

    /* renamed from: b reason: collision with root package name */
    private final Bundle f6794b;

    /* renamed from: c reason: collision with root package name */
    private final h f6795c;

    U(V v, Bundle bundle, h hVar) {
        this.f6793a = v;
        this.f6794b = bundle;
        this.f6795c = hVar;
    }

    public final void run() {
        this.f6793a.a(this.f6794b, this.f6795c);
    }
}
