package c.b.a.b.c.a;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class c implements Creator<b> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int b2 = SafeParcelReader.b(parcel);
        int i2 = 0;
        Intent intent = null;
        int i3 = 0;
        while (parcel.dataPosition() < b2) {
            int a2 = SafeParcelReader.a(parcel);
            int a3 = SafeParcelReader.a(a2);
            if (a3 == 1) {
                i2 = SafeParcelReader.j(parcel, a2);
            } else if (a3 == 2) {
                i3 = SafeParcelReader.j(parcel, a2);
            } else if (a3 != 3) {
                SafeParcelReader.n(parcel, a2);
            } else {
                intent = (Intent) SafeParcelReader.a(parcel, a2, Intent.CREATOR);
            }
        }
        SafeParcelReader.d(parcel, b2);
        return new b(i2, i3, intent);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new b[i2];
    }
}
