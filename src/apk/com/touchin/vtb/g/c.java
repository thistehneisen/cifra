package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.touchin.vtb.f.e;
import kotlin.e.b.h;

/* compiled from: CreatePinState.kt */
public final class c implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private e f7426a;

    /* renamed from: b reason: collision with root package name */
    private String f7427b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f7428c;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            return new c((e) Enum.valueOf(e.class, parcel.readString()), parcel.readString(), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i2) {
            return new c[i2];
        }
    }

    public c() {
        this(null, null, false, 7, null);
    }

    public c(e eVar, String str, boolean z) {
        h.b(eVar, "viewState");
        h.b(str, "pin");
        this.f7426a = eVar;
        this.f7427b = str;
        this.f7428c = z;
    }

    public final void a(e eVar) {
        h.b(eVar, "<set-?>");
        this.f7426a = eVar;
    }

    public int describeContents() {
        return 0;
    }

    public final String n() {
        return this.f7427b;
    }

    public final e o() {
        return this.f7426a;
    }

    public final boolean p() {
        return this.f7428c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeString(this.f7426a.name());
        parcel.writeString(this.f7427b);
        parcel.writeInt(this.f7428c ? 1 : 0);
    }

    public /* synthetic */ c(e eVar, String str, boolean z, int i2, e eVar2) {
        if ((i2 & 1) != 0) {
            eVar = e.FIRST_PASSWORD;
        }
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        this(eVar, str, z);
    }

    public final void a(String str) {
        h.b(str, "<set-?>");
        this.f7427b = str;
    }
}
