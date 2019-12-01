package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.flexbox.FlexboxLayout.a;

/* compiled from: FlexboxLayout */
class f implements Creator<a> {
    f() {
    }

    public a createFromParcel(Parcel parcel) {
        return new a(parcel);
    }

    public a[] newArray(int i2) {
        return new a[i2];
    }
}
