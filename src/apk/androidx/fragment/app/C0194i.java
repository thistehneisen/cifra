package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;
import androidx.fragment.app.Fragment.c;

/* renamed from: androidx.fragment.app.i reason: case insensitive filesystem */
/* compiled from: Fragment */
class C0194i implements ClassLoaderCreator<c> {
    C0194i() {
    }

    public c[] newArray(int i2) {
        return new c[i2];
    }

    public c createFromParcel(Parcel parcel) {
        return new c(parcel, null);
    }

    public c createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return new c(parcel, classLoader);
    }
}
