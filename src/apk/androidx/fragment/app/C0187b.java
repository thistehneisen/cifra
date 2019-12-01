package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: androidx.fragment.app.b reason: case insensitive filesystem */
/* compiled from: BackStackState */
class C0187b implements Creator<C0188c> {
    C0187b() {
    }

    public C0188c createFromParcel(Parcel parcel) {
        return new C0188c(parcel);
    }

    public C0188c[] newArray(int i2) {
        return new C0188c[i2];
    }
}
