package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.e.b.h;

/* compiled from: BankState.kt */
public final class a implements Parcelable {
    public static final Creator CREATOR = new C0077a();

    /* renamed from: a reason: collision with root package name */
    private String f7421a;

    /* renamed from: com.touchin.vtb.g.a$a reason: collision with other inner class name */
    public static class C0077a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            return new a(parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new a[i2];
        }
    }

    public a() {
        this(null, 1, null);
    }

    public a(String str) {
        this.f7421a = str;
    }

    public final void a(String str) {
        this.f7421a = str;
    }

    public int describeContents() {
        return 0;
    }

    public final String n() {
        return this.f7421a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeString(this.f7421a);
    }

    public /* synthetic */ a(String str, int i2, e eVar) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        this(str);
    }
}
