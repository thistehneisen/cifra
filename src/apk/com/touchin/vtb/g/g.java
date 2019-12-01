package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.touchin.vtb.api.OperationInfo;
import kotlin.e.b.h;

/* compiled from: PaymentDetailsState.kt */
public final class g implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private final OperationInfo f7456a;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            return new g((OperationInfo) parcel.readSerializable());
        }

        public final Object[] newArray(int i2) {
            return new g[i2];
        }
    }

    public g(OperationInfo operationInfo) {
        h.b(operationInfo, "operationInfo");
        this.f7456a = operationInfo;
    }

    public int describeContents() {
        return 0;
    }

    public final OperationInfo n() {
        return this.f7456a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeSerializable(this.f7456a);
    }
}
