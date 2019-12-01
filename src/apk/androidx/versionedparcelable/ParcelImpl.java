package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

@SuppressLint({"BanParcelableUsage"})
public class ParcelImpl implements Parcelable {
    public static final Creator<ParcelImpl> CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private final c f2114a;

    protected ParcelImpl(Parcel parcel) {
        this.f2114a = new b(parcel).j();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        new b(parcel).a(this.f2114a);
    }
}
