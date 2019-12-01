package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.q;

/* renamed from: com.google.android.gms.measurement.internal.f reason: case insensitive filesystem */
final class C0505f {

    /* renamed from: a reason: collision with root package name */
    final String f5898a;

    /* renamed from: b reason: collision with root package name */
    final String f5899b;

    /* renamed from: c reason: collision with root package name */
    final long f5900c;

    /* renamed from: d reason: collision with root package name */
    final long f5901d;

    /* renamed from: e reason: collision with root package name */
    final long f5902e;

    /* renamed from: f reason: collision with root package name */
    final long f5903f;

    /* renamed from: g reason: collision with root package name */
    final long f5904g;

    /* renamed from: h reason: collision with root package name */
    final Long f5905h;

    /* renamed from: i reason: collision with root package name */
    final Long f5906i;

    /* renamed from: j reason: collision with root package name */
    final Long f5907j;

    /* renamed from: k reason: collision with root package name */
    final Boolean f5908k;

    C0505f(String str, String str2, long j2, long j3, long j4, long j5, long j6, Long l2, Long l3, Long l4, Boolean bool) {
        long j7 = j2;
        long j8 = j3;
        long j9 = j4;
        long j10 = j6;
        q.b(str);
        q.b(str2);
        boolean z = true;
        q.a(j7 >= 0);
        q.a(j8 >= 0);
        q.a(j9 >= 0);
        if (j10 < 0) {
            z = false;
        }
        q.a(z);
        this.f5898a = str;
        this.f5899b = str2;
        this.f5900c = j7;
        this.f5901d = j8;
        this.f5902e = j9;
        this.f5903f = j5;
        this.f5904g = j10;
        this.f5905h = l2;
        this.f5906i = l3;
        this.f5907j = l4;
        this.f5908k = bool;
    }

    /* access modifiers changed from: 0000 */
    public final C0505f a(long j2) {
        C0505f fVar = new C0505f(this.f5898a, this.f5899b, this.f5900c, this.f5901d, this.f5902e, j2, this.f5904g, this.f5905h, this.f5906i, this.f5907j, this.f5908k);
        return fVar;
    }

    /* access modifiers changed from: 0000 */
    public final C0505f a(long j2, long j3) {
        C0505f fVar = new C0505f(this.f5898a, this.f5899b, this.f5900c, this.f5901d, this.f5902e, this.f5903f, j2, Long.valueOf(j3), this.f5906i, this.f5907j, this.f5908k);
        return fVar;
    }

    /* access modifiers changed from: 0000 */
    public final C0505f a(Long l2, Long l3, Boolean bool) {
        C0505f fVar = new C0505f(this.f5898a, this.f5899b, this.f5900c, this.f5901d, this.f5902e, this.f5903f, this.f5904g, this.f5905h, l2, l3, (bool == null || bool.booleanValue()) ? bool : null);
        return fVar;
    }

    C0505f(String str, String str2, long j2, long j3, long j4, long j5, Long l2, Long l3, Long l4, Boolean bool) {
        this(str, str2, j2, j3, 0, j4, 0, null, null, null, null);
    }
}
