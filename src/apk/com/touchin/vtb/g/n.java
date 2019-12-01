package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.e.b.h;

/* compiled from: UpdateState.kt */
public final class n implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private final Throwable f7476a;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            return new n((Throwable) parcel.readSerializable());
        }

        public final Object[] newArray(int i2) {
            return new n[i2];
        }
    }

    public n(Throwable th) {
        h.b(th, "throwable");
        this.f7476a = th;
    }

    public int describeContents() {
        return 0;
    }

    public final Throwable n() {
        return this.f7476a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeSerializable(this.f7476a);
    }
}
