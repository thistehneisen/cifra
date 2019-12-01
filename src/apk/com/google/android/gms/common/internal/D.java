package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.d;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class D implements Creator<C0311f> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        d[] dVarArr = null;
        d[] dVarArr2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i2 = SafeParcelReader.j(parcel2, a2);
                    break;
                case 2:
                    i3 = SafeParcelReader.j(parcel2, a2);
                    break;
                case 3:
                    i4 = SafeParcelReader.j(parcel2, a2);
                    break;
                case 4:
                    str = SafeParcelReader.b(parcel2, a2);
                    break;
                case 5:
                    iBinder = SafeParcelReader.i(parcel2, a2);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.b(parcel2, a2, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.a(parcel2, a2);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.a(parcel2, a2, Account.CREATOR);
                    break;
                case 10:
                    dVarArr = (d[]) SafeParcelReader.b(parcel2, a2, d.CREATOR);
                    break;
                case 11:
                    dVarArr2 = (d[]) SafeParcelReader.b(parcel2, a2, d.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.e(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.n(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.d(parcel2, b2);
        C0311f fVar = new C0311f(i2, i3, i4, str, iBinder, scopeArr, bundle, account, dVarArr, dVarArr2, z);
        return fVar;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new C0311f[i2];
    }
}
