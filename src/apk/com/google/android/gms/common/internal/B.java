package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class B extends a {
    public static final Creator<B> CREATOR = new C();

    /* renamed from: a reason: collision with root package name */
    Bundle f4664a;

    /* renamed from: b reason: collision with root package name */
    d[] f4665b;

    B(Bundle bundle, d[] dVarArr) {
        this.f4664a = bundle;
        this.f4665b = dVarArr;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f4664a, false);
        b.a(parcel, 2, (T[]) this.f4665b, i2, false);
        b.a(parcel, a2);
    }

    public B() {
    }
}
