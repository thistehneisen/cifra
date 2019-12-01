package com.google.android.material.appbar;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: AppBarLayout */
class c implements ClassLoaderCreator<b> {
    c() {
    }

    public b[] newArray(int i2) {
        return new b[i2];
    }

    public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new b(parcel, classLoader);
    }

    public b createFromParcel(Parcel parcel) {
        return new b(parcel, null);
    }
}
