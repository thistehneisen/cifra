package b.i.a;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: AbsSavedState */
class b implements ClassLoaderCreator<c> {
    b() {
    }

    public c[] newArray(int i2) {
        return new c[i2];
    }

    public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
        if (parcel.readParcelable(classLoader) == null) {
            return c.f2742a;
        }
        throw new IllegalStateException("superState must be null");
    }

    public c createFromParcel(Parcel parcel) {
        return createFromParcel(parcel, (ClassLoader) null);
    }
}
