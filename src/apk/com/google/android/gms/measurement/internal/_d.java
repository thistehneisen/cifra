package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class _d implements Creator<ae> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        List list = null;
        long j7 = -2147483648L;
        boolean z = true;
        boolean z2 = false;
        int i2 = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = false;
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
                    str3 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 5:
                    str4 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 6:
                    j2 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 7:
                    j3 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 8:
                    str5 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 9:
                    z = SafeParcelReader.e(parcel2, a2);
                    break;
                case 10:
                    z2 = SafeParcelReader.e(parcel2, a2);
                    break;
                case 11:
                    j7 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 12:
                    str6 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 13:
                    j4 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 14:
                    j5 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 15:
                    i2 = SafeParcelReader.j(parcel2, a2);
                    break;
                case 16:
                    z3 = SafeParcelReader.e(parcel2, a2);
                    break;
                case 17:
                    z4 = SafeParcelReader.e(parcel2, a2);
                    break;
                case 18:
                    z5 = SafeParcelReader.e(parcel2, a2);
                    break;
                case 19:
                    str7 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 21:
                    bool = SafeParcelReader.f(parcel2, a2);
                    break;
                case 22:
                    j6 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 23:
                    list = SafeParcelReader.c(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.n(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.d(parcel2, b2);
        ae aeVar = new ae(str, str2, str3, str4, j2, j3, str5, z, z2, j7, str6, j4, j5, i2, z3, z4, z5, str7, bool, j6, list);
        return aeVar;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new ae[i2];
    }
}
