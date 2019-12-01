package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.e.b.h;

/* compiled from: TaxesState.kt */
public final class m implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private final int f7475a;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            return new m(parcel.readInt());
        }

        public final Object[] newArray(int i2) {
            return new m[i2];
        }
    }

    public m(int i2) {
        this.f7475a = i2;
    }

    public int describeContents() {
        return 0;
    }

    public final int n() {
        return this.f7475a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeInt(this.f7475a);
    }
}
