package i.a.b;

import i.A;
import i.B;
import i.C0728q;
import i.C0729s;
import i.M;
import j.i;
import java.util.List;

/* compiled from: HttpHeaders */
public final class f {

    /* renamed from: a reason: collision with root package name */
    private static final i f8582a = i.c("\"\\");

    /* renamed from: b reason: collision with root package name */
    private static final i f8583b = i.c("\t ,=");

    public static long a(M m) {
        return a(m.e());
    }

    public static boolean b(M m) {
        if (m.k().e().equals("HEAD")) {
            return false;
        }
        int c2 = m.c();
        if (((c2 >= 100 && c2 < 200) || c2 == 204 || c2 == 304) && a(m) == -1) {
            if ("chunked".equalsIgnoreCase(m.b("Transfer-Encoding"))) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static long a(A a2) {
        return a(a2.b("Content-Length"));
    }

    private static long a(String str) {
        long j2 = -1;
        if (str == null) {
            return -1;
        }
        try {
            j2 = Long.parseLong(str);
        } catch (NumberFormatException unused) {
        }
        return j2;
    }

    public static void a(C0729s sVar, B b2, A a2) {
        if (sVar != C0729s.f8760a) {
            List a3 = C0728q.a(b2, a2);
            if (!a3.isEmpty()) {
                sVar.a(b2, a3);
            }
        }
    }

    public static int b(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt != ' ' && charAt != 9) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public static int a(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static int a(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            i2 = (int) parseLong;
            return i2;
        } catch (NumberFormatException unused) {
        }
    }
}
