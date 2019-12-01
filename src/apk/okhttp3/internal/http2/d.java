package okhttp3.internal.http2;

import i.a.e;
import j.i;
import java.io.IOException;

/* compiled from: Http2 */
public final class d {

    /* renamed from: a reason: collision with root package name */
    static final i f10569a = i.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b reason: collision with root package name */
    private static final String[] f10570b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* renamed from: c reason: collision with root package name */
    static final String[] f10571c = new String[64];

    /* renamed from: d reason: collision with root package name */
    static final String[] f10572d = new String[256];

    static {
        String str;
        int[] iArr;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f10572d;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = e.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f10571c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr2 = {1};
        strArr2[8] = "PADDED";
        int length = iArr2.length;
        int i4 = 0;
        while (true) {
            str = "|PADDED";
            if (i4 >= length) {
                break;
            }
            int i5 = iArr2[i4];
            String[] strArr3 = f10571c;
            int i6 = i5 | 8;
            StringBuilder sb = new StringBuilder();
            sb.append(f10571c[i5]);
            sb.append(str);
            strArr3[i6] = sb.toString();
            i4++;
        }
        String[] strArr4 = f10571c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        for (int i7 : new int[]{4, 32, 36}) {
            for (int i8 : iArr2) {
                String[] strArr5 = f10571c;
                int i9 = i8 | i7;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(f10571c[i8]);
                sb2.append('|');
                sb2.append(f10571c[i7]);
                strArr5[i9] = sb2.toString();
                String[] strArr6 = f10571c;
                int i10 = i9 | 8;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(f10571c[i8]);
                sb3.append('|');
                sb3.append(f10571c[i7]);
                sb3.append(str);
                strArr6[i10] = sb3.toString();
            }
        }
        while (true) {
            String[] strArr7 = f10571c;
            if (i2 < strArr7.length) {
                if (strArr7[i2] == null) {
                    strArr7[i2] = f10572d[i2];
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private d() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(e.a(str, objArr));
    }

    static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(e.a(str, objArr));
    }

    static String a(boolean z, int i2, int i3, byte b2, byte b3) {
        String[] strArr = f10570b;
        String a2 = b2 < strArr.length ? strArr[b2] : e.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = a2;
        objArr[4] = a3;
        return e.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b2, byte b3) {
        String str;
        if (b3 == 0) {
            return "";
        }
        if (!(b2 == 2 || b2 == 3)) {
            if (b2 == 4 || b2 == 6) {
                if (b3 == 1) {
                    str = "ACK";
                } else {
                    str = f10572d[b3];
                }
                return str;
            } else if (!(b2 == 7 || b2 == 8)) {
                String[] strArr = f10571c;
                String str2 = b3 < strArr.length ? strArr[b3] : f10572d[b3];
                if (b2 != 5 || (b3 & 4) == 0) {
                    return (b2 != 0 || (b3 & 32) == 0) ? str2 : str2.replace("PRIORITY", "COMPRESSED");
                }
                return str2.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f10572d[b3];
    }
}
