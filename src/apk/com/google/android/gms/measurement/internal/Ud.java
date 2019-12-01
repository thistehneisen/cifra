package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class Ud implements Creator<Rd> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        Long l2 = null;
        Float f2 = null;
        String str2 = null;
        String str3 = null;
        Double d2 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i2 = SafeParcelReader.j(parcel2, a2);
                    break;
                case 2:
                    str = SafeParcelReader.b(parcel2, a2);
                    break;
                case 3:
                    j2 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 4:
                    l2 = SafeParcelReader.l(parcel2, a2);
                    break;
                case 5:
                    f2 = SafeParcelReader.h(parcel2, a2);
                    break;
                case 6:
                    str2 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 7:
                    str3 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 8:
                    d2 = SafeParcelReader.g(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.n(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.d(parcel2, b2);
        Rd rd = new Rd(i2, str, j2, l2, f2, str2, str3, d2);
        return rd;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new Rd[i2];
    }
}
