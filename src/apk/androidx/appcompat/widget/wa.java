package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import androidx.appcompat.widget.Toolbar.d;

/* compiled from: Toolbar */
class wa implements ClassLoaderCreator<d> {
    wa() {
    }

    public d[] newArray(int i2) {
        return new d[i2];
    }

    public d createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new d(parcel, classLoader);
    }

    public d createFromParcel(Parcel parcel) {
        return new d(parcel, null);
    }
}
