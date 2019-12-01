package androidx.media;

import android.util.SparseIntArray;
import androidx.versionedparcelable.c;

public class AudioAttributesCompat implements c {

    /* renamed from: a reason: collision with root package name */
    private static final SparseIntArray f1672a = new SparseIntArray();

    /* renamed from: b reason: collision with root package name */
    private static final int[] f1673b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};

    /* renamed from: c reason: collision with root package name */
    a f1674c;

    static {
        f1672a.put(5, 1);
        f1672a.put(6, 2);
        f1672a.put(7, 2);
        f1672a.put(8, 1);
        f1672a.put(9, 1);
        f1672a.put(10, 1);
    }

    AudioAttributesCompat() {
    }

    static String a(int i2) {
        switch (i2) {
            case 0:
                return "USAGE_UNKNOWN";
            case 1:
                return "USAGE_MEDIA";
            case 2:
                return "USAGE_VOICE_COMMUNICATION";
            case 3:
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            case 4:
                return "USAGE_ALARM";
            case 5:
                return "USAGE_NOTIFICATION";
            case 6:
                return "USAGE_NOTIFICATION_RINGTONE";
            case 7:
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            case 8:
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            case 9:
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            case 10:
                return "USAGE_NOTIFICATION_EVENT";
            case 11:
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            case 12:
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            case 13:
                return "USAGE_ASSISTANCE_SONIFICATION";
            case 14:
                return "USAGE_GAME";
            case 16:
                return "USAGE_ASSISTANT";
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("unknown usage ");
                sb.append(i2);
                return sb.toString();
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        a aVar = this.f1674c;
        if (aVar != null) {
            return aVar.equals(audioAttributesCompat.f1674c);
        }
        if (audioAttributesCompat.f1674c == null) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return this.f1674c.hashCode();
    }

    public String toString() {
        return this.f1674c.toString();
    }

    static int a(boolean z, int i2, int i3) {
        int i4 = 1;
        if ((i2 & 1) == 1) {
            if (!z) {
                i4 = 7;
            }
            return i4;
        }
        int i5 = 0;
        if ((i2 & 4) == 4) {
            if (!z) {
                i5 = 6;
            }
            return i5;
        }
        int i6 = 3;
        switch (i3) {
            case 0:
                if (z) {
                    i6 = Integer.MIN_VALUE;
                }
                return i6;
            case 1:
            case 12:
            case 14:
            case 16:
                return 3;
            case 2:
                break;
            case 3:
                if (!z) {
                    i5 = 8;
                    break;
                }
                break;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 11:
                return 10;
            case 13:
                return 1;
            default:
                if (!z) {
                    return 3;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Unknown usage value ");
                sb.append(i3);
                sb.append(" in audio attributes");
                throw new IllegalArgumentException(sb.toString());
        }
        return i5;
    }
}
