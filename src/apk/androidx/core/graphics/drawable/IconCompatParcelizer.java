package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1303b = versionedParcel.a(iconCompat.f1303b, 1);
        iconCompat.f1305d = versionedParcel.a(iconCompat.f1305d, 2);
        iconCompat.f1306e = versionedParcel.a(iconCompat.f1306e, 3);
        iconCompat.f1307f = versionedParcel.a(iconCompat.f1307f, 4);
        iconCompat.f1308g = versionedParcel.a(iconCompat.f1308g, 5);
        iconCompat.f1309h = (ColorStateList) versionedParcel.a(iconCompat.f1309h, 6);
        iconCompat.f1311j = versionedParcel.a(iconCompat.f1311j, 7);
        iconCompat.c();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.a(true, true);
        iconCompat.a(versionedParcel.c());
        int i2 = iconCompat.f1303b;
        if (-1 != i2) {
            versionedParcel.b(i2, 1);
        }
        byte[] bArr = iconCompat.f1305d;
        if (bArr != null) {
            versionedParcel.b(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f1306e;
        if (parcelable != null) {
            versionedParcel.b(parcelable, 3);
        }
        int i3 = iconCompat.f1307f;
        if (i3 != 0) {
            versionedParcel.b(i3, 4);
        }
        int i4 = iconCompat.f1308g;
        if (i4 != 0) {
            versionedParcel.b(i4, 5);
        }
        ColorStateList colorStateList = iconCompat.f1309h;
        if (colorStateList != null) {
            versionedParcel.b((Parcelable) colorStateList, 6);
        }
        String str = iconCompat.f1311j;
        if (str != null) {
            versionedParcel.b(str, 7);
        }
    }
}
