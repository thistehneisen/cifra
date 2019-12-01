package c.b.a.c.l;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: ExtendableSavedState */
class a implements ClassLoaderCreator<b> {
    a() {
    }

    public b[] newArray(int i2) {
        return new b[i2];
    }

    public b createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new b(parcel, classLoader, null);
    }

    public b createFromParcel(Parcel parcel) {
        return new b(parcel, null, null);
    }
}
