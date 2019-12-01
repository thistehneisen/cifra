package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper;

/* compiled from: MediaSessionCompat */
class h implements Creator<ResultReceiverWrapper> {
    h() {
    }

    public ResultReceiverWrapper createFromParcel(Parcel parcel) {
        return new ResultReceiverWrapper(parcel);
    }

    public ResultReceiverWrapper[] newArray(int i2) {
        return new ResultReceiverWrapper[i2];
    }
}
