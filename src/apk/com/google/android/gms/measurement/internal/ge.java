package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class ge implements Creator<de> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        String str2 = null;
        Rd rd = null;
        String str3 = null;
        C0525j jVar = null;
        C0525j jVar2 = null;
        C0525j jVar3 = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 2:
                    str = SafeParcelReader.b(parcel2, a2);
                    break;
                case 3:
                    str2 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 4:
                    rd = (Rd) SafeParcelReader.a(parcel2, a2, Rd.CREATOR);
                    break;
                case 5:
                    j2 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 6:
                    z = SafeParcelReader.e(parcel2, a2);
                    break;
                case 7:
                    str3 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 8:
                    jVar = (C0525j) SafeParcelReader.a(parcel2, a2, C0525j.CREATOR);
                    break;
                case 9:
                    j3 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 10:
                    jVar2 = (C0525j) SafeParcelReader.a(parcel2, a2, C0525j.CREATOR);
                    break;
                case 11:
                    j4 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 12:
                    jVar3 = (C0525j) SafeParcelReader.a(parcel2, a2, C0525j.CREATOR);
                    break;
                default:
                    SafeParcelReader.n(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.d(parcel2, b2);
        de deVar = new de(str, str2, rd, j2, z, str3, jVar, j3, jVar2, j4, jVar3);
        return deVar;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new de[i2];
    }
}
