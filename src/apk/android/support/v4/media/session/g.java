package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;

/* compiled from: MediaSessionCompat */
class g implements Creator<QueueItem> {
    g() {
    }

    public QueueItem createFromParcel(Parcel parcel) {
        return new QueueItem(parcel);
    }

    public QueueItem[] newArray(int i2) {
        return new QueueItem[i2];
    }
}
