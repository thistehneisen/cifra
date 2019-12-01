package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import io.intercom.android.sdk.views.holder.AttributeType;

/* compiled from: RegistrationConfirmSmsState.kt */
public class h implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private String f7457a;

    /* renamed from: b reason: collision with root package name */
    private String f7458b;

    /* renamed from: c reason: collision with root package name */
    private String f7459c;

    /* renamed from: d reason: collision with root package name */
    private long f7460d;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            kotlin.e.b.h.b(parcel, "in");
            h hVar = new h(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong());
            return hVar;
        }

        public final Object[] newArray(int i2) {
            return new h[i2];
        }
    }

    public h(String str, String str2, String str3, long j2) {
        kotlin.e.b.h.b(str, "smsOperationId");
        kotlin.e.b.h.b(str2, AttributeType.PHONE);
        kotlin.e.b.h.b(str3, "maskedPhone");
        this.f7457a = str;
        this.f7458b = str2;
        this.f7459c = str3;
        this.f7460d = j2;
    }

    public final void a(String str) {
        kotlin.e.b.h.b(str, "<set-?>");
        this.f7457a = str;
    }

    public int describeContents() {
        return 0;
    }

    public final long n() {
        return this.f7460d;
    }

    public final String o() {
        return this.f7459c;
    }

    public final String p() {
        return this.f7458b;
    }

    public final String q() {
        return this.f7457a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.e.b.h.b(parcel, "parcel");
        parcel.writeString(this.f7457a);
        parcel.writeString(this.f7458b);
        parcel.writeString(this.f7459c);
        parcel.writeLong(this.f7460d);
    }

    public /* synthetic */ h(String str, String str2, String str3, long j2, int i2, e eVar) {
        if ((i2 & 8) != 0) {
            j2 = System.currentTimeMillis();
        }
        this(str, str2, str3, j2);
    }

    public final void a(long j2) {
        this.f7460d = j2;
    }
}
