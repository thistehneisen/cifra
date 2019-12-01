package b.i.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: AbsSavedState */
public abstract class c implements Parcelable {
    public static final Creator<c> CREATOR = new b();

    /* renamed from: a reason: collision with root package name */
    public static final c f2742a = new a();

    /* renamed from: b reason: collision with root package name */
    private final Parcelable f2743b;

    /* synthetic */ c(a aVar) {
        this();
    }

    public int describeContents() {
        return 0;
    }

    public final Parcelable n() {
        return this.f2743b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f2743b, i2);
    }

    private c() {
        this.f2743b = null;
    }

    protected c(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable == f2742a) {
                parcelable = null;
            }
            this.f2743b = parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    protected c(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = f2742a;
        }
        this.f2743b = readParcelable;
    }
}
