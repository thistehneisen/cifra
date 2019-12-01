package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zf implements Creator<Af> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        Bundle bundle = null;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    j2 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 2:
                    j3 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 3:
                    z = SafeParcelReader.e(parcel2, a2);
                    break;
                case 4:
                    str = SafeParcelReader.b(parcel2, a2);
                    break;
                case 5:
                    str2 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 6:
                    str3 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 7:
                    bundle = SafeParcelReader.a(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.n(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.d(parcel2, b2);
        Af af = new Af(j2, j3, z, str, str2, str3, bundle);
        return af;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new Af[i2];
    }
}
