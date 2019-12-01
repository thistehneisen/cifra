package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class z implements Creator<r> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        Account account = null;
        int i2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.j(parcel, a2);
            } else if (a3 == 2) {
                account = (Account) SafeParcelReader.a(parcel, a2, Account.CREATOR);
            } else if (a3 == 3) {
                i3 = SafeParcelReader.j(parcel, a2);
            } else if (a3 != 4) {
                SafeParcelReader.n(parcel, a2);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.a(parcel, a2, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.d(parcel, b2);
        return new r(i2, account, i3, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new r[i2];
    }
}
