package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.d;

/* compiled from: StaggeredGridLayoutManager */
class ca implements Creator<d> {
    ca() {
    }

    public d createFromParcel(Parcel parcel) {
        return new d(parcel);
    }

    public d[] newArray(int i2) {
        return new d[i2];
    }
}
