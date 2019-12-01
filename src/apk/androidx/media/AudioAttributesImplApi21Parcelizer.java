package androidx.media;

import android.media.AudioAttributes;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplApi21Parcelizer {
    public static b read(VersionedParcel versionedParcel) {
        b bVar = new b();
        bVar.f1675a = (AudioAttributes) versionedParcel.a(bVar.f1675a, 1);
        bVar.f1676b = versionedParcel.a(bVar.f1676b, 2);
        return bVar;
    }

    public static void write(b bVar, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b((Parcelable) bVar.f1675a, 1);
        versionedParcel.b(bVar.f1676b, 2);
    }
}
