package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: FragmentManagerState */
class x implements Creator<y> {
    x() {
    }

    public y createFromParcel(Parcel parcel) {
        return new y(parcel);
    }

    public y[] newArray(int i2) {
        return new y[i2];
    }
}
