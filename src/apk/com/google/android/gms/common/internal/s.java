package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.a;

public class s extends a {
    public static final Creator<s> CREATOR = new A();

    /* renamed from: a reason: collision with root package name */
    private final int f4762a;

    /* renamed from: b reason: collision with root package name */
    private IBinder f4763b;

    /* renamed from: c reason: collision with root package name */
    private b f4764c;

    /* renamed from: d reason: collision with root package name */
    private boolean f4765d;

    /* renamed from: e reason: collision with root package name */
    private boolean f4766e;

    s(int i2, IBinder iBinder, b bVar, boolean z, boolean z2) {
        this.f4762a = i2;
        this.f4763b = iBinder;
        this.f4764c = bVar;
        this.f4765d = z;
        this.f4766e = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f4764c.equals(sVar.f4764c) && f().equals(sVar.f());
    }

    public C0316k f() {
        return C0316k.a.a(this.f4763b);
    }

    public b g() {
        return this.f4764c;
    }

    public boolean h() {
        return this.f4765d;
    }

    public boolean i() {
        return this.f4766e;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.b.a(parcel);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 1, this.f4762a);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 2, this.f4763b, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 3, (Parcelable) g(), i2, false);
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 4, h());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, 5, i());
        com.google.android.gms.common.internal.safeparcel.b.a(parcel, a2);
    }
}
