package c.b.a.b.c.a;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class j implements Creator<i> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        r rVar = null;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.j(parcel, a2);
            } else if (a3 != 2) {
                SafeParcelReader.n(parcel, a2);
            } else {
                rVar = (r) SafeParcelReader.a(parcel, a2, r.CREATOR);
            }
        }
        SafeParcelReader.d(parcel, b2);
        return new i(i2, rVar);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new i[i2];
    }
}
