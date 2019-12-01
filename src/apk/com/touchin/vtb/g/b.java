package com.touchin.vtb.g;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.touchin.vtb.api.BankType;
import java.util.ArrayList;
import java.util.List;
import kotlin.e.b.h;

/* compiled from: ConnectBankState.kt */
public final class b implements Parcelable {
    public static final Creator CREATOR = new a();

    /* renamed from: a reason: collision with root package name */
    private BankType f7422a;

    /* renamed from: b reason: collision with root package name */
    private final int f7423b;

    /* renamed from: c reason: collision with root package name */
    private final boolean f7424c;

    /* renamed from: d reason: collision with root package name */
    private final List<BankType> f7425d;

    public static class a implements Creator {
        public final Object createFromParcel(Parcel parcel) {
            h.b(parcel, "in");
            BankType bankType = parcel.readInt() != 0 ? (BankType) Enum.valueOf(BankType.class, parcel.readString()) : null;
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() != 0;
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add((BankType) Enum.valueOf(BankType.class, parcel.readString()));
                readInt2--;
            }
            return new b(bankType, readInt, z, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new b[i2];
        }
    }

    public b(BankType bankType, int i2, boolean z, List<? extends BankType> list) {
        h.b(list, "connectedBanks");
        this.f7422a = bankType;
        this.f7423b = i2;
        this.f7424c = z;
        this.f7425d = list;
    }

    public final void a(BankType bankType) {
        this.f7422a = bankType;
    }

    public int describeContents() {
        return 0;
    }

    public final BankType n() {
        return this.f7422a;
    }

    public final List<BankType> o() {
        return this.f7425d;
    }

    public final int p() {
        return this.f7423b;
    }

    public final boolean q() {
        return this.f7424c;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        h.b(parcel, "parcel");
        BankType bankType = this.f7422a;
        if (bankType != null) {
            parcel.writeInt(1);
            parcel.writeString(bankType.name());
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f7423b);
        parcel.writeInt(this.f7424c ? 1 : 0);
        List<BankType> list = this.f7425d;
        parcel.writeInt(list.size());
        for (BankType name : list) {
            parcel.writeString(name.name());
        }
    }

    public /* synthetic */ b(BankType bankType, int i2, boolean z, List list, int i3, e eVar) {
        if ((i3 & 1) != 0) {
            bankType = null;
        }
        if ((i3 & 4) != 0) {
            z = true;
        }
        if ((i3 & 8) != 0) {
            list = i.a();
        }
        this(bankType, i2, z, list);
    }
}
