package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MediaMetadataCompat */
class h implements Creator<MediaMetadataCompat> {
    h() {
    }

    public MediaMetadataCompat createFromParcel(Parcel parcel) {
        return new MediaMetadataCompat(parcel);
    }

    public MediaMetadataCompat[] newArray(int i2) {
        return new MediaMetadataCompat[i2];
    }
}
