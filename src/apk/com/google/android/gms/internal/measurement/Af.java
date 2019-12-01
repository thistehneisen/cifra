package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class Af extends a {
    public static final Creator<Af> CREATOR = new zf();

    /* renamed from: a reason: collision with root package name */
    public final long f4852a;

    /* renamed from: b reason: collision with root package name */
    public final long f4853b;

    /* renamed from: c reason: collision with root package name */
    public final boolean f4854c;

    /* renamed from: d reason: collision with root package name */
    public final String f4855d;

    /* renamed from: e reason: collision with root package name */
    public final String f4856e;

    /* renamed from: f reason: collision with root package name */
    public final String f4857f;

    /* renamed from: g reason: collision with root package name */
    public final Bundle f4858g;

    public Af(long j2, long j3, boolean z, String str, String str2, String str3, Bundle bundle) {
        this.f4852a = j2;
        this.f4853b = j3;
        this.f4854c = z;
        this.f4855d = str;
        this.f4856e = str2;
        this.f4857f = str3;
        this.f4858g = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f4852a);
        b.a(parcel, 2, this.f4853b);
        b.a(parcel, 3, this.f4854c);
        b.a(parcel, 4, this.f4855d, false);
        b.a(parcel, 5, this.f4856e, false);
        b.a(parcel, 6, this.f4857f, false);
        b.a(parcel, 7, this.f4858g, false);
        b.a(parcel, a2);
    }
}
