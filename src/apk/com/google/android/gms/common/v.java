package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class v implements Creator<u> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        IBinder iBinder = null;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                str = SafeParcelReader.b(parcel, a2);
            } else if (a3 == 2) {
                iBinder = SafeParcelReader.i(parcel, a2);
            } else if (a3 == 3) {
                z = SafeParcelReader.e(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.n(parcel, a2);
            } else {
                z2 = SafeParcelReader.e(parcel, a2);
            }
        }
        SafeParcelReader.d(parcel, b2);
        return new u(str, iBinder, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new u[i2];
    }
}
