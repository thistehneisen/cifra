package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* renamed from: com.google.android.gms.measurement.internal.k reason: case insensitive filesystem */
public final class C0530k implements Creator<C0520i> {
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
        return new C0520i(bundle);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new C0520i[i2];
    }
}
