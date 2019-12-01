package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplBaseParcelizer {
    public static c read(VersionedParcel versionedParcel) {
        c cVar = new c();
        cVar.f1677a = versionedParcel.a(cVar.f1677a, 1);
        cVar.f1678b = versionedParcel.a(cVar.f1678b, 2);
        cVar.f1679c = versionedParcel.a(cVar.f1679c, 3);
        cVar.f1680d = versionedParcel.a(cVar.f1680d, 4);
        return cVar;
    }

    public static void write(c cVar, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b(cVar.f1677a, 1);
        versionedParcel.b(cVar.f1678b, 2);
        versionedParcel.b(cVar.f1679c, 3);
        versionedParcel.b(cVar.f1680d, 4);
    }
}
