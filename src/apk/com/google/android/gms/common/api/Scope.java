package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

public final class Scope extends a implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new j();

    /* renamed from: a reason: collision with root package name */
    private final int f4517a;

    /* renamed from: b reason: collision with root package name */
    private final String f4518b;

    Scope(int i2, String str) {
        q.a(str, (Object) "scopeUri must not be null or empty");
        this.f4517a = i2;
        this.f4518b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f4518b.equals(((Scope) obj).f4518b);
    }

    public final String f() {
        return this.f4518b;
    }

    public final int hashCode() {
        return this.f4518b.hashCode();
    }

    public final String toString() {
        return this.f4518b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel);
        b.a(parcel, 1, this.f4517a);
        b.a(parcel, 2, f(), false);
        b.a(parcel, a2);
    }

    public Scope(String str) {
        this(1, str);
    }
}
