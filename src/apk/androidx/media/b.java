package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* compiled from: AudioAttributesImplApi21 */
class b implements a {

    /* renamed from: a reason: collision with root package name */
    AudioAttributes f1675a;

    /* renamed from: b reason: collision with root package name */
    int f1676b = -1;

    b() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f1675a.equals(((b) obj).f1675a);
    }

    public int hashCode() {
        return this.f1675a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioAttributesCompat: audioattributes=");
        sb.append(this.f1675a);
        return sb.toString();
    }
}
