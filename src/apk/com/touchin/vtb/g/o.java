package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.e.b.h;

/* compiled from: WelcomeState.kt */
public final class o implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private final boolean f7477a;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            return new o(parcel.readInt() != 0);
        }

        public final Object[] newArray(int i2) {
            return new o[i2];
        }
    }

    public o() {
        this(false, 1, null);
    }

    public o(boolean z) {
        this.f7477a = z;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean n() {
        return this.f7477a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeInt(this.f7477a ? 1 : 0);
    }

    public /* synthetic */ o(boolean z, int i2, e eVar) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        this(z);
    }
}
