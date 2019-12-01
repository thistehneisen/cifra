package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* compiled from: CoordinatorLayout */
class b implements ClassLoaderCreator<g> {
    b() {
    }

    public g[] newArray(int i2) {
        return new g[i2];
    }

    public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new g(parcel, classLoader);
    }

    public g createFromParcel(Parcel parcel) {
        return new g(parcel, null);
    }
}
