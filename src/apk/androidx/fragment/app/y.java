package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* compiled from: FragmentManagerState */
final class y implements Parcelable {
    public static final Creator<y> CREATOR = new x();

    /* renamed from: a reason: collision with root package name */
    ArrayList<D> f1588a;

    /* renamed from: b reason: collision with root package name */
    ArrayList<String> f1589b;

    /* renamed from: c reason: collision with root package name */
    C0188c[] f1590c;

    /* renamed from: d reason: collision with root package name */
    String f1591d = null;

    /* renamed from: e reason: collision with root package name */
    int f1592e;

    public y() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.f1588a);
        parcel.writeStringList(this.f1589b);
        parcel.writeTypedArray(this.f1590c, i2);
        parcel.writeString(this.f1591d);
        parcel.writeInt(this.f1592e);
    }

    public y(Parcel parcel) {
        this.f1588a = parcel.createTypedArrayList(D.CREATOR);
        this.f1589b = parcel.createStringArrayList();
        this.f1590c = (C0188c[]) parcel.createTypedArray(C0188c.CREATOR);
        this.f1591d = parcel.readString();
        this.f1592e = parcel.readInt();
    }
}
