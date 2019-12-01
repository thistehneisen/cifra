package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.e.b.h;

/* compiled from: TasksTabsState.kt */
public final class l implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private final int f7472a;

    /* renamed from: b reason: collision with root package name */
    private final String f7473b;

    /* renamed from: c reason: collision with root package name */
    private Boolean f7474c;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            Boolean bool;
            h.b(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new l(readInt, readString, bool);
        }

        public final Object[] newArray(int i2) {
            return new l[i2];
        }
    }

    public l() {
        this(0, null, null, 7, null);
    }

    public l(int i2, String str, Boolean bool) {
        this.f7472a = i2;
        this.f7473b = str;
        this.f7474c = bool;
    }

    public final void a(Boolean bool) {
        this.f7474c = bool;
    }

    public int describeContents() {
        return 0;
    }

    public final String n() {
        return this.f7473b;
    }

    public final int o() {
        return this.f7472a;
    }

    public final Boolean p() {
        return this.f7474c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        boolean z;
        h.b(parcel, "parcel");
        parcel.writeInt(this.f7472a);
        parcel.writeString(this.f7473b);
        Boolean bool = this.f7474c;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        parcel.writeInt(z ? 1 : 0);
    }

    public /* synthetic */ l(int i2, String str, Boolean bool, int i3, e eVar) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            bool = Boolean.valueOf(false);
        }
        this(i2, str, bool);
    }
}
