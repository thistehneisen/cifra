package com.google.android.material.bottomappbar;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: BottomAppBar */
class d implements ClassLoaderCreator<a> {
    d() {
    }

    public a[] newArray(int i2) {
        return new a[i2];
    }

    public a createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new a(parcel, classLoader);
    }

    public a createFromParcel(Parcel parcel) {
        return new a(parcel, null);
    }
}
