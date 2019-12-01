package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class k implements Creator<b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        PendingIntent pendingIntent = null;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.j(parcel, a2);
            } else if (a3 == 2) {
                i3 = SafeParcelReader.j(parcel, a2);
            } else if (a3 == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.a(parcel, a2, PendingIntent.CREATOR);
            } else if (a3 != 4) {
                SafeParcelReader.n(parcel, a2);
            } else {
                str = SafeParcelReader.b(parcel, a2);
            }
        }
        SafeParcelReader.d(parcel, b2);
        return new b(i2, i3, pendingIntent, str);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new b[i2];
    }
}
