package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import androidx.recyclerview.widget.RecyclerView.s;

/* compiled from: RecyclerView */
class U implements ClassLoaderCreator<s> {
    U() {
    }

    public s[] newArray(int i2) {
        return new s[i2];
    }

    public s createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new s(parcel, classLoader);
    }

    public s createFromParcel(Parcel parcel) {
        return new s(parcel, null);
    }
}
