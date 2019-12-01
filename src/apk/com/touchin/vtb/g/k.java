package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.e.b.h;

/* compiled from: TaskTaxState.kt */
public final class k implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private String f7471a;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            return new k(parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new k[i2];
        }
    }

    public k(String str) {
        h.b(str, "id");
        this.f7471a = str;
    }

    public int describeContents() {
        return 0;
    }

    public final String n() {
        return this.f7471a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeString(this.f7471a);
    }
}
