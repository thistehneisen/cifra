package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class N implements Creator<O> {
    N() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new O(readStrongBinder);
        }
        return null;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new O[i2];
    }
}
