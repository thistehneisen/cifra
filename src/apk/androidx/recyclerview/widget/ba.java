package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: StaggeredGridLayoutManager */
class ba implements Creator<a> {
    ba() {
    }

    public a createFromParcel(Parcel parcel) {
        return new a(parcel);
    }

    public a[] newArray(int i2) {
        return new a[i2];
    }
}
