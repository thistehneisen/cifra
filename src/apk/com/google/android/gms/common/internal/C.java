package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class C implements Creator<B> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Bundle bundle = null;
        d[] dVarArr = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                bundle = SafeParcelReader.a(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.n(parcel, a2);
            } else {
                dVarArr = (d[]) SafeParcelReader.b(parcel, a2, d.CREATOR);
            }
        }
        SafeParcelReader.d(parcel, b2);
        return new B(bundle, dVarArr);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new B[i2];
    }
}
