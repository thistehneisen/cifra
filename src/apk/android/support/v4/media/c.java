package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MediaBrowserCompat */
class c implements Creator<MediaBrowserCompat$MediaItem> {
    c() {
    }

    public MediaBrowserCompat$MediaItem createFromParcel(Parcel parcel) {
        return new MediaBrowserCompat$MediaItem(parcel);
    }

    public MediaBrowserCompat$MediaItem[] newArray(int i2) {
        return new MediaBrowserCompat$MediaItem[i2];
    }
}
