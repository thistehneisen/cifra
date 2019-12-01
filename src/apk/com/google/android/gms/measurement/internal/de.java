package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class de extends a {
    public static final Creator<de> CREATOR = new ge();

    /* renamed from: a reason: collision with root package name */
    public String f5877a;

    /* renamed from: b reason: collision with root package name */
    public String f5878b;

    /* renamed from: c reason: collision with root package name */
    public Rd f5879c;

    /* renamed from: d reason: collision with root package name */
    public long f5880d;

    /* renamed from: e reason: collision with root package name */
    public boolean f5881e;

    /* renamed from: f reason: collision with root package name */
    public String f5882f;

    /* renamed from: g reason: collision with root package name */
    public C0525j f5883g;

    /* renamed from: h reason: collision with root package name */
    public long f5884h;

    /* renamed from: i reason: collision with root package name */
    public C0525j f5885i;

    /* renamed from: j reason: collision with root package name */
    public long f5886j;

    /* renamed from: k reason: collision with root package name */
    public C0525j f5887k;

    de(de deVar) {
        q.a(deVar);
        this.f5877a = deVar.f5877a;
        this.f5878b = deVar.f5878b;
        this.f5879c = deVar.f5879c;
        this.f5880d = deVar.f5880d;
        this.f5881e = deVar.f5881e;
        this.f5882f = deVar.f5882f;
        this.f5883g = deVar.f5883g;
        this.f5884h = deVar.f5884h;
        this.f5885i = deVar.f5885i;
        this.f5886j = deVar.f5886j;
        this.f5887k = deVar.f5887k;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 2, this.f5877a, false);
        b.a(parcel, 3, this.f5878b, false);
        b.a(parcel, 4, (Parcelable) this.f5879c, i2, false);
        b.a(parcel, 5, this.f5880d);
        b.a(parcel, 6, this.f5881e);
        b.a(parcel, 7, this.f5882f, false);
        b.a(parcel, 8, (Parcelable) this.f5883g, i2, false);
        b.a(parcel, 9, this.f5884h);
        b.a(parcel, 10, (Parcelable) this.f5885i, i2, false);
        b.a(parcel, 11, this.f5886j);
        b.a(parcel, 12, (Parcelable) this.f5887k, i2, false);
        b.a(parcel, a2);
    }

    de(String str, String str2, Rd rd, long j2, boolean z, String str3, C0525j jVar, long j3, C0525j jVar2, long j4, C0525j jVar3) {
        this.f5877a = str;
        this.f5878b = str2;
        this.f5879c = rd;
        this.f5880d = j2;
        this.f5881e = z;
        this.f5882f = str3;
        this.f5883g = jVar;
        this.f5884h = j3;
        this.f5885i = jVar2;
        this.f5886j = j4;
        this.f5887k = jVar3;
    }
}
