package com.google.android.gms.common.internal;

import android.content.Intent;
import androidx.fragment.app.Fragment;

final class w extends C0310e {

    /* renamed from: a reason: collision with root package name */
    private final /* synthetic */ Intent f4772a;

    /* renamed from: b reason: collision with root package name */
    private final /* synthetic */ Fragment f4773b;

    /* renamed from: c reason: collision with root package name */
    private final /* synthetic */ int f4774c;

    w(Intent intent, Fragment fragment, int i2) {
        this.f4772a = intent;
        this.f4773b = fragment;
        this.f4774c = i2;
    }

    public final void a() {
        Intent intent = this.f4772a;
        if (intent != null) {
            this.f4773b.startActivityForResult(intent, this.f4774c);
        }
    }
}
