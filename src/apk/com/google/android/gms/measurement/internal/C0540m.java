package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.measurement.internal.m reason: case insensitive filesystem */
public final class C0540m implements Creator<C0525j> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        C0520i iVar = null;
        String str2 = null;
        long j2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 2) {
                str = SafeParcelReader.b(parcel, a2);
            } else if (a3 == 3) {
                iVar = (C0520i) SafeParcelReader.a(parcel, a2, C0520i.CREATOR);
            } else if (a3 == 4) {
                str2 = SafeParcelReader.b(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.n(parcel, a2);
            } else {
                j2 = SafeParcelReader.k(parcel, a2);
            }
        }
        SafeParcelReader.d(parcel, b2);
        C0525j jVar = new C0525j(str, iVar, str2, j2);
        return jVar;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new C0525j[i2];
    }
}
