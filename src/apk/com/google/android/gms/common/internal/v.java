package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class v extends C0310e {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Intent f4769a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Activity f4770b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ int f4771c;

    v(Intent intent, Activity activity, int i2) {
        this.f4769a = intent;
        this.f4770b = activity;
        this.f4771c = i2;
    }

    public final void a() {
        Intent intent = this.f4769a;
        if (intent != null) {
            this.f4770b.startActivityForResult(intent, this.f4771c);
        }
    }
}
