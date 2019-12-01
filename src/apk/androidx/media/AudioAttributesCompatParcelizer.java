package androidx.media;

import androidx.versionedparcelable.VersionedParcel;
import androidx.versionedparcelable.c;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f1674c = (a) versionedParcel.a(audioAttributesCompat.f1674c, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.a(false, false);
        versionedParcel.b((c) audioAttributesCompat.f1674c, 1);
    }
}
