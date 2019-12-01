package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.q;

/* renamed from: com.google.android.gms.measurement.internal.vb reason: case insensitive filesystem */
public final class C0586vb {

    /* renamed from: a reason: collision with root package name */
    private final String f6126a;

    /* renamed from: b reason: collision with root package name */
    private final boolean f6127b;

    /* renamed from: c reason: collision with root package name */
    private boolean f6128c;

    /* renamed from: d reason: collision with root package name */
    private boolean f6129d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ C0576tb f6130e;

    public C0586vb(C0576tb tbVar, String str, boolean z) {
        this.f6130e = tbVar;
        q.b(str);
        this.f6126a = str;
        this.f6127b = z;
    }

    public final boolean a() {
        if (!this.f6128c) {
            this.f6128c = true;
            this.f6129d = this.f6130e.B().getBoolean(this.f6126a, this.f6127b);
        }
        return this.f6129d;
    }

    public final void a(boolean z) {
        Editor edit = this.f6130e.B().edit();
        edit.putBoolean(this.f6126a, z);
        edit.apply();
        this.f6129d = z;
    }
}
