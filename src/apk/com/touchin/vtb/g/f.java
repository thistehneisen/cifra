package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.touchin.vtb.api.BankConnectResponse;
import com.touchin.vtb.api.BankType;
import java.util.ArrayList;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: GetAccessState.kt */
public final class f implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private BankType f7449a;

    /* renamed from: b reason: collision with root package name */
    private final Integer f7450b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f7451c;

    /* renamed from: d reason: collision with root package name */
    private final String f7452d;

    /* renamed from: e reason: collision with root package name */
    private final boolean f7453e;

    /* renamed from: f reason: collision with root package name */
    private final String f7454f;

    /* renamed from: g reason: collision with root package name */
    private final List<BankConnectResponse> f7455g;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            BankType bankType = (BankType) Enum.valueOf(BankType.class, parcel.readString());
            Integer valueOf = parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null;
            boolean z = parcel.readInt() != 0;
            String readString = parcel.readString();
            boolean z2 = parcel.readInt() != 0;
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((BankConnectResponse) parcel.readSerializable());
                readInt--;
            }
            f fVar = new f(bankType, valueOf, z, readString, z2, readString2, arrayList);
            return fVar;
        }

        public final Object[] newArray(int i2) {
            return new f[i2];
        }
    }

    public f(BankType bankType, Integer num, boolean z, String str, boolean z2, String str2, List<BankConnectResponse> list) {
        h.b(bankType, "connectedBankType");
        h.b(list, "banksToRestoreSession");
        this.f7449a = bankType;
        this.f7450b = num;
        this.f7451c = z;
        this.f7452d = str;
        this.f7453e = z2;
        this.f7454f = str2;
        this.f7455g = list;
    }

    public int describeContents() {
        return 0;
    }

    public final boolean n() {
        return this.f7453e;
    }

    public final List<BankConnectResponse> o() {
        return this.f7455g;
    }

    public final String p() {
        return this.f7454f;
    }

    public final BankType q() {
        return this.f7449a;
    }

    public final String r() {
        return this.f7452d;
    }

    public final Integer s() {
        return this.f7450b;
    }

    public final boolean t() {
        return this.f7451c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int i3;
        h.b(parcel, "parcel");
        parcel.writeString(this.f7449a.name());
        Integer num = this.f7450b;
        if (num != null) {
            parcel.writeInt(1);
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.f7451c ? 1 : 0);
        parcel.writeString(this.f7452d);
        parcel.writeInt(this.f7453e ? 1 : 0);
        parcel.writeString(this.f7454f);
        List<BankConnectResponse> list = this.f7455g;
        parcel.writeInt(list.size());
        for (BankConnectResponse writeSerializable : list) {
            parcel.writeSerializable(writeSerializable);
        }
    }

    public /* synthetic */ f(BankType bankType, Integer num, boolean z, String str, boolean z2, String str2, List list, int i2, e eVar) {
        String str3 = null;
        Integer num2 = (i2 & 2) != 0 ? null : num;
        boolean z3 = false;
        boolean z4 = (i2 & 4) != 0 ? false : z;
        String str4 = (i2 & 8) != 0 ? null : str;
        if ((i2 & 16) == 0) {
            z3 = z2;
        }
        if ((i2 & 32) == 0) {
            str3 = str2;
        }
        this(bankType, num2, z4, str4, z3, str3, (i2 & 64) != 0 ? new ArrayList() : list);
    }
}
