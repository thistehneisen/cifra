package androidx.viewpager.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import androidx.viewpager.widget.ViewPager.i;

/* compiled from: ViewPager */
class f implements ClassLoaderCreator<i> {
    f() {
    }

    public i[] newArray(int i2) {
        return new i[i2];
    }

    public i createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new i(parcel, classLoader);
    }

    public i createFromParcel(Parcel parcel) {
        return new i(parcel, null);
    }
}
