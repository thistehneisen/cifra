package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class ae extends a {
    public static final Creator<ae> CREATOR = new _d();

    /* renamed from: a reason: collision with root package name */
    public final String f5819a;

    /* renamed from: b reason: collision with root package name */
    public final String f5820b;

    /* renamed from: c reason: collision with root package name */
    public final String f5821c;

    /* renamed from: d reason: collision with root package name */
    public final String f5822d;

    /* renamed from: e reason: collision with root package name */
    public final long f5823e;

    /* renamed from: f reason: collision with root package name */
    public final long f5824f;

    /* renamed from: g reason: collision with root package name */
    public final String f5825g;

    /* renamed from: h reason: collision with root package name */
    public final boolean f5826h;

    /* renamed from: i reason: collision with root package name */
    public final boolean f5827i;

    /* renamed from: j reason: collision with root package name */
    public final long f5828j;

    /* renamed from: k reason: collision with root package name */
    public final String f5829k;

    /* renamed from: l reason: collision with root package name */
    public final long f5830l;
    public final long m;
    public final int n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final String r;
    public final Boolean s;
    public final long t;
    public final List<String> u;

    ae(String str, String str2, String str3, long j2, String str4, long j3, long j4, String str5, boolean z, boolean z2, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j7, List<String> list) {
        q.b(str);
        this.f5819a = str;
        this.f5820b = TextUtils.isEmpty(str2) ? null : str2;
        this.f5821c = str3;
        this.f5828j = j2;
        this.f5822d = str4;
        this.f5823e = j3;
        this.f5824f = j4;
        this.f5825g = str5;
        this.f5826h = z;
        this.f5827i = z2;
        this.f5829k = str6;
        this.f5830l = j5;
        this.m = j6;
        this.n = i2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
        this.s = bool;
        this.t = j7;
        this.u = list;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, this.f5819a, false);
        b.a(parcel, 3, this.f5820b, false);
        b.a(parcel, 4, this.f5821c, false);
        b.a(parcel, 5, this.f5822d, false);
        b.a(parcel, 6, this.f5823e);
        b.a(parcel, 7, this.f5824f);
        b.a(parcel, 8, this.f5825g, false);
        b.a(parcel, 9, this.f5826h);
        b.a(parcel, 10, this.f5827i);
        b.a(parcel, 11, this.f5828j);
        b.a(parcel, 12, this.f5829k, false);
        b.a(parcel, 13, this.f5830l);
        b.a(parcel, 14, this.m);
        b.a(parcel, 15, this.n);
        b.a(parcel, 16, this.o);
        b.a(parcel, 17, this.p);
        b.a(parcel, 18, this.q);
        b.a(parcel, 19, this.r, false);
        b.a(parcel, 21, this.s, false);
        b.a(parcel, 22, this.t);
        b.a(parcel, 23, this.u, false);
        b.a(parcel, a2);
    }

    ae(String str, String str2, String str3, String str4, long j2, long j3, String str5, boolean z, boolean z2, long j4, String str6, long j5, long j6, int i2, boolean z3, boolean z4, boolean z5, String str7, Boolean bool, long j7, List<String> list) {
        this.f5819a = str;
        this.f5820b = str2;
        this.f5821c = str3;
        this.f5828j = j4;
        this.f5822d = str4;
        this.f5823e = j2;
        this.f5824f = j3;
        this.f5825g = str5;
        this.f5826h = z;
        this.f5827i = z2;
        this.f5829k = str6;
        this.f5830l = j5;
        this.m = j6;
        this.n = i2;
        this.o = z3;
        this.p = z4;
        this.q = z5;
        this.r = str7;
        this.s = bool;
        this.t = j7;
        this.u = list;
    }
}
