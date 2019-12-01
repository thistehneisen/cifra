package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.q;

public final class Ab {

    /* renamed from: a reason: collision with root package name */
    private final String f5497a;

    /* renamed from: b reason: collision with root package name */
    private final String f5498b = null;

    /* renamed from: c reason: collision with root package name */
    private boolean f5499c;

    /* renamed from: d reason: collision with root package name */
    private String f5500d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ C0576tb f5501e;

    public Ab(C0576tb tbVar, String str, String str2) {
        this.f5501e = tbVar;
        q.b(str);
        this.f5497a = str;
    }

    public final String a() {
        if (!this.f5499c) {
            this.f5499c = true;
            this.f5500d = this.f5501e.B().getString(this.f5497a, null);
        }
        return this.f5500d;
    }

    public final void a(String str) {
        if (!Wd.e(str, this.f5500d)) {
            Editor edit = this.f5501e.B().edit();
            edit.putString(this.f5497a, str);
            edit.apply();
            this.f5500d = str;
        }
    }
}
