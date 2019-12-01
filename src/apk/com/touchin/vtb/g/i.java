package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.math.BigDecimal;
import kotlin.e.b.h;

/* compiled from: SearchCompanyState.kt */
public final class i implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private String f7461a;

    /* renamed from: b reason: collision with root package name */
    private String f7462b;

    /* renamed from: c reason: collision with root package name */
    private String f7463c;

    /* renamed from: d reason: collision with root package name */
    private String f7464d;

    /* renamed from: e reason: collision with root package name */
    private BigDecimal f7465e;

    /* renamed from: f reason: collision with root package name */
    private String f7466f;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            i iVar = new i(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (BigDecimal) parcel.readSerializable(), parcel.readString());
            return iVar;
        }

        public final Object[] newArray(int i2) {
            return new i[i2];
        }
    }

    public i() {
        this(null, null, null, null, null, null, 63, null);
    }

    public i(String str, String str2, String str3, String str4, BigDecimal bigDecimal, String str5) {
        h.b(str, "companyName");
        h.b(str2, "inn");
        h.b(str3, "city");
        h.b(str4, "ogrn");
        this.f7461a = str;
        this.f7462b = str2;
        this.f7463c = str3;
        this.f7464d = str4;
        this.f7465e = bigDecimal;
        this.f7466f = str5;
    }

    public final void a(BigDecimal bigDecimal) {
        this.f7465e = bigDecimal;
    }

    public final void b(String str) {
        h.b(str, "<set-?>");
        this.f7463c = str;
    }

    public final void c(String str) {
        h.b(str, "<set-?>");
        this.f7461a = str;
    }

    public final void d(String str) {
        h.b(str, "<set-?>");
        this.f7462b = str;
    }

    public int describeContents() {
        return 0;
    }

    public final void e(String str) {
        h.b(str, "<set-?>");
        this.f7464d = str;
    }

    public final String n() {
        return this.f7466f;
    }

    public final String o() {
        return this.f7463c;
    }

    public final String p() {
        return this.f7461a;
    }

    public final String q() {
        return this.f7462b;
    }

    public final String r() {
        return this.f7464d;
    }

    public final BigDecimal s() {
        return this.f7465e;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeString(this.f7461a);
        parcel.writeString(this.f7462b);
        parcel.writeString(this.f7463c);
        parcel.writeString(this.f7464d);
        parcel.writeSerializable(this.f7465e);
        parcel.writeString(this.f7466f);
    }

    public /* synthetic */ i(String str, String str2, String str3, String str4, BigDecimal bigDecimal, String str5, int i2, e eVar) {
        String str6 = "";
        String str7 = (i2 & 1) != 0 ? str6 : str;
        String str8 = (i2 & 2) != 0 ? str6 : str2;
        String str9 = (i2 & 4) != 0 ? str6 : str3;
        if ((i2 & 8) == 0) {
            str6 = str4;
        }
        this(str7, str8, str9, str6, (i2 & 16) != 0 ? null : bigDecimal, (i2 & 32) != 0 ? null : str5);
    }

    public final void a(String str) {
        this.f7466f = str;
    }
}
