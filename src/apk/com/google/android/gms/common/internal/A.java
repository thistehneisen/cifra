package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class A implements Creator<s> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        IBinder iBinder = null;
        b bVar = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.j(parcel, a2);
            } else if (a3 == 2) {
                iBinder = SafeParcelReader.i(parcel, a2);
            } else if (a3 == 3) {
                bVar = (b) SafeParcelReader.a(parcel, a2, b.CREATOR);
            } else if (a3 == 4) {
                z = SafeParcelReader.e(parcel, a2);
            } else if (a3 != 5) {
                SafeParcelReader.n(parcel, a2);
            } else {
                z2 = SafeParcelReader.e(parcel, a2);
            }
        }
        SafeParcelReader.d(parcel, b2);
        s sVar = new s(i2, iBinder, bVar, z, z2);
        return sVar;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new s[i2];
    }
}
