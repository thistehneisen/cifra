package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Creator<MediaBrowserCompat$MediaItem> CREATOR = new c();

    /* renamed from: a reason: collision with root package name */
    private final int f284a;

    /* renamed from: b reason: collision with root package name */
    private final MediaDescriptionCompat f285b;

    MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f284a = parcel.readInt();
        this.f285b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MediaItem{");
        sb.append("mFlags=");
        sb.append(this.f284a);
        sb.append(", mDescription=");
        sb.append(this.f285b);
        sb.append('}');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f284a);
        this.f285b.writeToParcel(parcel, i2);
    }
}
