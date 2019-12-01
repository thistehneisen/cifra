package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.recyclerview.widget.LinearLayoutManager.d;

/* compiled from: LinearLayoutManager */
class C implements Creator<d> {
    C() {
    }

    public d createFromParcel(Parcel parcel) {
        return new d(parcel);
    }

    public d[] newArray(int i2) {
        return new d[i2];
    }
}
