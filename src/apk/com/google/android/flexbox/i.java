package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: FlexboxLayoutManager */
class i implements Creator<d> {
    i() {
    }

    public d createFromParcel(Parcel parcel) {
        return new d(parcel);
    }

    public d[] newArray(int i2) {
        return new d[i2];
    }
}
