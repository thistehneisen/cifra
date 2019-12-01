package android.support.v4.media;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MediaDescriptionCompat */
class e implements Creator<MediaDescriptionCompat> {
    e() {
    }

    public MediaDescriptionCompat createFromParcel(Parcel parcel) {
        if (VERSION.SDK_INT < 21) {
            return new MediaDescriptionCompat(parcel);
        }
        return MediaDescriptionCompat.a(f.a(parcel));
    }

    public MediaDescriptionCompat[] newArray(int i2) {
        return new MediaDescriptionCompat[i2];
    }
}
