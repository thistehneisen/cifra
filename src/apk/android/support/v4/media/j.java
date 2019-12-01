package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RatingCompat */
class j implements Creator<RatingCompat> {
    j() {
    }

    public RatingCompat createFromParcel(Parcel parcel) {
        return new RatingCompat(parcel.readInt(), parcel.readFloat());
    }

    public RatingCompat[] newArray(int i2) {
        return new RatingCompat[i2];
    }
}
