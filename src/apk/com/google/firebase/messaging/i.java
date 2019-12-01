package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class i implements Creator<c> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            if (SafeParcelReader.a(a2) != 2) {
                SafeParcelReader.n(parcel, a2);
            } else {
                bundle = SafeParcelReader.a(parcel, a2);
            }
        }
        SafeParcelReader.d(parcel, b2);
        return new c(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new c[i2];
    }
}
