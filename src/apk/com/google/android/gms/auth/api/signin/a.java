package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class a implements Creator<GoogleSignInAccount> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int b2 = SafeParcelReader.b(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            switch (SafeParcelReader.a(a2)) {
                case 1:
                    i2 = SafeParcelReader.j(parcel2, a2);
                    break;
                case 2:
                    str = SafeParcelReader.b(parcel2, a2);
                    break;
                case 3:
                    str2 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 4:
                    str3 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 5:
                    str4 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.a(parcel2, a2, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 8:
                    j2 = SafeParcelReader.k(parcel2, a2);
                    break;
                case 9:
                    str6 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 10:
                    list = SafeParcelReader.c(parcel2, a2, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.b(parcel2, a2);
                    break;
                case 12:
                    str8 = SafeParcelReader.b(parcel2, a2);
                    break;
                default:
                    SafeParcelReader.n(parcel2, a2);
                    break;
            }
        }
        SafeParcelReader.d(parcel2, b2);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(i2, str, str2, str3, str4, uri, str5, j2, str6, list, str7, str8);
        return googleSignInAccount;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}
