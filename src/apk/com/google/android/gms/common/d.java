package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.C0321p;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class d extends a {
    public static final Creator<d> CREATOR = new l();

    /* renamed from: a reason: collision with root package name */
    private final String f4651a;
    @Deprecated

    /* renamed from: b reason: collision with root package name */
    private final int f4652b;

    /* renamed from: c reason: collision with root package name */
    private final long f4653c;

    public d(String str, int i2, long j2) {
        this.f4651a = str;
        this.f4652b = i2;
        this.f4653c = j2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (((f() != null && f().equals(dVar.f())) || (f() == null && dVar.f() == null)) && g() == dVar.g()) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        return this.f4651a;
    }

    public long g() {
        long j2 = this.f4653c;
        return j2 == -1 ? (long) this.f4652b : j2;
    }

    public int hashCode() {
        return C0321p.a(f(), Long.valueOf(g()));
    }

    public String toString() {
        C0321p.a a2 = C0321p.a((Object) this);
        a2.a("name", f());
        a2.a("version", Long.valueOf(g()));
        return a2.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, f(), false);
        b.a(parcel, 2, this.f4652b);
        b.a(parcel, 3, g());
        b.a(parcel, a2);
    }
}
