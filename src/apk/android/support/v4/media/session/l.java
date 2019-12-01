package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PlaybackStateCompat */
class l implements Creator<PlaybackStateCompat> {
    l() {
    }

    public PlaybackStateCompat createFromParcel(Parcel parcel) {
        return new PlaybackStateCompat(parcel);
    }

    public PlaybackStateCompat[] newArray(int i2) {
        return new PlaybackStateCompat[i2];
    }
}
