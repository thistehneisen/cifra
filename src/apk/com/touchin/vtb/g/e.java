package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankType;
import java.util.ArrayList;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: GetAccessConfirmSmsState.kt */
public class e implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private String f7441a;

    /* renamed from: b reason: collision with root package name */
    private final BankType f7442b;

    /* renamed from: c reason: collision with root package name */
    private final String f7443c;

    /* renamed from: d reason: collision with root package name */
    private final String f7444d;

    /* renamed from: e reason: collision with root package name */
    private long f7445e;

    /* renamed from: f reason: collision with root package name */
    private final String f7446f;

    /* renamed from: g reason: collision with root package name */
    private final boolean f7447g;

    /* renamed from: h reason: collision with root package name */
    private final List<BankConnectResponse> f7448h;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            String readString = parcel.readString();
            BankType bankType = (BankType) Enum.valueOf(BankType.class, parcel.readString());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            long readLong = parcel.readLong();
            String readString4 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((BankConnectResponse) parcel.readSerializable());
                readInt--;
            }
            e eVar = new e(readString, bankType, readString2, readString3, readLong, readString4, z, arrayList);
            return eVar;
        }

        public final Object[] newArray(int i2) {
            return new e[i2];
        }
    }

    public e(String str, BankType bankType, String str2, String str3, long j2, String str4, boolean z, List<BankConnectResponse> list) {
        h.b(bankType, "bankType");
        h.b(str2, "login");
        h.b(str3, "password");
        h.b(list, "banksToRestoreSession");
        this.f7441a = str;
        this.f7442b = bankType;
        this.f7443c = str2;
        this.f7444d = str3;
        this.f7445e = j2;
        this.f7446f = str4;
        this.f7447g = z;
        this.f7448h = list;
    }

    public final void a(String str) {
        this.f7441a = str;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean n() {
        return this.f7447g;
    }

    public final BankType o() {
        return this.f7442b;
    }

    public final List<BankConnectResponse> p() {
        return this.f7448h;
    }

    public final String q() {
        return this.f7441a;
    }

    public final long r() {
        return this.f7445e;
    }

    public final String s() {
        return this.f7443c;
    }

    public final String t() {
        return this.f7446f;
    }

    public final String u() {
        return this.f7444d;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        parcel.writeString(this.f7441a);
        parcel.writeString(this.f7442b.name());
        parcel.writeString(this.f7443c);
        parcel.writeString(this.f7444d);
        parcel.writeLong(this.f7445e);
        parcel.writeString(this.f7446f);
        parcel.writeInt(this.f7447g ? 1 : 0);
        List<BankConnectResponse> list = this.f7448h;
        parcel.writeInt(list.size());
        for (BankConnectResponse writeSerializable : list) {
            parcel.writeSerializable(writeSerializable);
        }
    }

    public /* synthetic */ e(String str, BankType bankType, String str2, String str3, long j2, String str4, boolean z, List list, int i2, e eVar) {
        int i3 = i2;
        String str5 = (i3 & 1) != 0 ? null : str;
        String str6 = "";
        String str7 = (i3 & 4) != 0 ? str6 : str2;
        String str8 = (i3 & 8) != 0 ? str6 : str3;
        this(str5, bankType, str7, str8, (i3 & 16) != 0 ? System.currentTimeMillis() : j2, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? false : z, (i3 & 128) != 0 ? new ArrayList() : list);
    }

    public final void a(long j2) {
        this.f7445e = j2;
    }
}
