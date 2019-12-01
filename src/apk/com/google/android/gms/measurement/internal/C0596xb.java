package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.q;

/* renamed from: com.google.android.gms.measurement.internal.xb reason: case insensitive filesystem */
public final class C0596xb {

    /* renamed from: a reason: collision with root package name */
    private final String f6154a;

    /* renamed from: b reason: collision with root package name */
    private final String f6155b;

    /* renamed from: c reason: collision with root package name */
    private final String f6156c;

    /* renamed from: d reason: collision with root package name */
    private final long f6157d;

    /* renamed from: e reason: collision with root package name */
    private final /* synthetic */ C0576tb f6158e;

    private C0596xb(C0576tb tbVar, String str, long j2) {
        this.f6158e = tbVar;
        q.b(str);
        q.a(j2 > 0);
        this.f6154a = String.valueOf(str).concat(":start");
        this.f6155b = String.valueOf(str).concat(":count");
        this.f6156c = String.valueOf(str).concat(":value");
        this.f6157d = j2;
    }

    private final void b() {
        this.f6158e.j();
        long currentTimeMillis = this.f6158e.c().currentTimeMillis();
        Editor edit = this.f6158e.B().edit();
        edit.remove(this.f6155b);
        edit.remove(this.f6156c);
        edit.putLong(this.f6154a, currentTimeMillis);
        edit.apply();
    }

    private final long c() {
        return this.f6158e.B().getLong(this.f6154a, 0);
    }

    public final void a(String str, long j2) {
        this.f6158e.j();
        if (c() == 0) {
            b();
        }
        if (str == null) {
            str = "";
        }
        long j3 = this.f6158e.B().getLong(this.f6155b, 0);
        if (j3 <= 0) {
            Editor edit = this.f6158e.B().edit();
            edit.putString(this.f6156c, str);
            edit.putLong(this.f6155b, 1);
            edit.apply();
            return;
        }
        long j4 = j3 + 1;
        boolean z = (this.f6158e.m().v().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j4;
        Editor edit2 = this.f6158e.B().edit();
        if (z) {
            edit2.putString(this.f6156c, str);
        }
        edit2.putLong(this.f6155b, j4);
        edit2.apply();
    }

    public final Pair<String, Long> a() {
        long j2;
        this.f6158e.j();
        this.f6158e.j();
        long c2 = c();
        if (c2 == 0) {
            b();
            j2 = 0;
        } else {
            j2 = Math.abs(c2 - this.f6158e.c().currentTimeMillis());
        }
        long j3 = this.f6157d;
        if (j2 < j3) {
            return null;
        }
        if (j2 > (j3 << 1)) {
            b();
            return null;
        }
        String string = this.f6158e.B().getString(this.f6156c, null);
        long j4 = this.f6158e.B().getLong(this.f6155b, 0);
        b();
        if (string == null || j4 <= 0) {
            return C0576tb.f6100c;
        }
        return new Pair<>(string, Long.valueOf(j4));
    }
}
