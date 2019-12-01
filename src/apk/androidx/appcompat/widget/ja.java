package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: SearchView */
class ja implements ClassLoaderCreator<e> {
    ja() {
    }

    public e[] newArray(int i2) {
        return new e[i2];
    }

    public e createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new e(parcel, classLoader);
    }

    public e createFromParcel(Parcel parcel) {
        return new e(parcel, null);
    }
}
