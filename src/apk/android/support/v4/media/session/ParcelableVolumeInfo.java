package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Creator<ParcelableVolumeInfo> CREATOR = new k();

    /* renamed from: a reason: collision with root package name */
    public int f326a;

    /* renamed from: b reason: collision with root package name */
    public int f327b;

    /* renamed from: c reason: collision with root package name */
    public int f328c;

    /* renamed from: d reason: collision with root package name */
    public int f329d;

    /* renamed from: e reason: collision with root package name */
    public int f330e;

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f326a = parcel.readInt();
        this.f328c = parcel.readInt();
        this.f329d = parcel.readInt();
        this.f330e = parcel.readInt();
        this.f327b = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f326a);
        parcel.writeInt(this.f328c);
        parcel.writeInt(this.f329d);
        parcel.writeInt(this.f330e);
        parcel.writeInt(this.f327b);
    }
}
