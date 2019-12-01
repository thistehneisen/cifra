package c.b.a.b.c.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class l implements Creator<k> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        b bVar = null;
        int i2 = 0;
        s sVar = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.j(parcel, a2);
            } else if (a3 == 2) {
                bVar = (b) SafeParcelReader.a(parcel, a2, b.CREATOR);
            } else if (a3 != 3) {
                SafeParcelReader.n(parcel, a2);
            } else {
                sVar = (s) SafeParcelReader.a(parcel, a2, s.CREATOR);
            }
        }
        SafeParcelReader.d(parcel, b2);
        return new k(i2, bVar, sVar);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new k[i2];
    }
}
