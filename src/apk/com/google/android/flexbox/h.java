package com.google.android.flexbox;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.flexbox.FlexboxLayoutManager.b;

/* compiled from: FlexboxLayoutManager */
class h implements Creator<b> {
    h() {
    }

    public b createFromParcel(Parcel parcel) {
        return new b(parcel);
    }

    public b[] newArray(int i2) {
        return new b[i2];
    }
}
