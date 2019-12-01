package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.e.b.h;

/* compiled from: TaskInfoState.kt */
public final class j implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private String f7467a;

    /* renamed from: b reason: collision with root package name */
    private String f7468b;

    /* renamed from: c reason: collision with root package name */
    private String f7469c;

    /* renamed from: d reason: collision with root package name */
    private String f7470d;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            return new j(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new j[i2];
        }
    }

    public j(String str, String str2, String str3, String str4) {
        h.b(str, "id");
        h.b(str2, "title");
        h.b(str3, "description");
        h.b(str4, "duration");
        this.f7467a = str;
        this.f7468b = str2;
        this.f7469c = str3;
        this.f7470d = str4;
    }

    public int describeContents() {
        return 0;
    }

    public final String n() {
        return this.f7469c;
    }

    public final String o() {
        return this.f7468b;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeString(this.f7467a);
        parcel.writeString(this.f7468b);
        parcel.writeString(this.f7469c);
        parcel.writeString(this.f7470d);
    }

    public /* synthetic */ j(String str, String str2, String str3, String str4, int i2, e eVar) {
        if ((i2 & 8) != 0) {
            str4 = "";
        }
        this(str, str2, str3, str4);
    }
}
