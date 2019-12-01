package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.q;

/* renamed from: com.google.android.gms.measurement.internal.yb reason: case insensitive filesystem */
public final class C0601yb {

    /* renamed from: a reason: collision with root package name */
    private final String f6165a;

    /* renamed from: b reason: collision with root package name */
    private final long f6166b;

    /* renamed from: c reason: collision with root package name */
    private boolean f6167c;

    /* renamed from: d reason: collision with root package name */
    private long f6168d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ C0576tb f6169e;

    public C0601yb(C0576tb tbVar, String str, long j2) {
        this.f6169e = tbVar;
        q.b(str);
        this.f6165a = str;
        this.f6166b = j2;
    }

    public final long a() {
        if (!this.f6167c) {
            this.f6167c = true;
            this.f6168d = this.f6169e.B().getLong(this.f6165a, this.f6166b);
        }
        return this.f6168d;
    }

    public final void a(long j2) {
        Editor edit = this.f6169e.B().edit();
        edit.putLong(this.f6165a, j2);
        edit.apply();
        this.f6168d = j2;
    }
}
