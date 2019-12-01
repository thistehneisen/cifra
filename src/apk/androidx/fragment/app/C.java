package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: FragmentState */
class C implements Creator<D> {
    C() {
    }

    public D createFromParcel(Parcel parcel) {
        return new D(parcel);
    }

    public D[] newArray(int i2) {
        return new D[i2];
    }
}
