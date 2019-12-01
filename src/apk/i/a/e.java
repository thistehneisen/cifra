package i.a;

import i.A;
import i.A.a;
import i.B;
import i.L;
import i.O;
import j.f;
import j.i;
import j.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.AccessControlException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.http2.b;

/* compiled from: Util */
public final class e {

    /* renamed from: a reason: collision with root package name */
    public static final byte[] f8653a = new byte[0];

    /* renamed from: b reason: collision with root package name */
    public static final String[] f8654b = new String[0];

    /* renamed from: c reason: collision with root package name */
    public static final A f8655c = A.a(new String[0]);

    /* renamed from: d reason: collision with root package name */
    public static final O f8656d = O.a(null, f8653a);

    /* renamed from: e reason: collision with root package name */
    public static final L f8657e = L.a(null, f8653a);

    /* renamed from: f reason: collision with root package name */
    private static final s f8658f = s.a(i.b("efbbbf"), i.b("feff"), i.b("fffe"), i.b("0000ffff"), i.b("ffff0000"));

    /* renamed from: g reason: collision with root package name */
    private static final Charset f8659g = Charset.forName("UTF-32BE");

    /* renamed from: h reason: collision with root package name */
    private static final Charset f8660h = Charset.forName("UTF-32LE");

    /* renamed from: i reason: collision with root package name */
    public static final TimeZone f8661i = TimeZone.getTimeZone("GMT");

    /* renamed from: j reason: collision with root package name */
    public static final Comparator<String> f8662j = a.f8554a;

    /* renamed from: k reason: collision with root package name */
    private static final Method f8663k;

    /* renamed from: l reason: collision with root package name */
    private static final Pattern f8664l = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    static {
        Method method = null;
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        } catch (Exception unused) {
        }
        f8663k = method;
    }

    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = f8663k;
        if (method != null) {
            try {
                method.invoke(th, new Object[]{th2});
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static boolean b(j.A a2, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long c2 = a2.timeout().d() ? a2.timeout().c() - nanoTime : Long.MAX_VALUE;
        a2.timeout().a(Math.min(c2, timeUnit.toNanos((long) i2)) + nanoTime);
        try {
            f fVar = new f();
            while (a2.b(fVar, 8192) != -1) {
                fVar.a();
            }
            if (c2 == Long.MAX_VALUE) {
                a2.timeout().a();
            } else {
                a2.timeout().a(nanoTime + c2);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (c2 == Long.MAX_VALUE) {
                a2.timeout().a();
            } else {
                a2.timeout().a(nanoTime + c2);
            }
            return false;
        } catch (Throwable th) {
            if (c2 == Long.MAX_VALUE) {
                a2.timeout().a();
            } else {
                a2.timeout().a(nanoTime + c2);
            }
            throw th;
        }
    }

    public static String c(String str, int i2, int i3) {
        int a2 = a(str, i2, i3);
        return str.substring(a2, b(str, a2, i3));
    }

    private static boolean d(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(String str) {
        return f8664l.matcher(str).matches();
    }

    private static InetAddress d(String str, int i2, int i3) {
        byte[] bArr = new byte[16];
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        while (true) {
            if (i2 >= i3) {
                break;
            } else if (i4 == bArr.length) {
                return null;
            } else {
                int i7 = i2 + 2;
                if (i7 > i3 || !str.regionMatches(i2, "::", 0, 2)) {
                    if (i4 != 0) {
                        if (str.regionMatches(i2, ":", 0, 1)) {
                            i2++;
                        } else if (!str.regionMatches(i2, ".", 0, 1) || !a(str, i6, i3, bArr, i4 - 2)) {
                            return null;
                        } else {
                            i4 += 2;
                        }
                    }
                    i6 = i2;
                } else if (i5 != -1) {
                    return null;
                } else {
                    i4 += 2;
                    if (i7 == i3) {
                        i5 = i4;
                        break;
                    }
                    i5 = i4;
                    i6 = i7;
                }
                i2 = i6;
                int i8 = 0;
                while (i2 < i3) {
                    int a2 = a(str.charAt(i2));
                    if (a2 == -1) {
                        break;
                    }
                    i8 = (i8 << 4) + a2;
                    i2++;
                }
                int i9 = i2 - i6;
                if (i9 == 0 || i9 > 4) {
                    return null;
                }
                int i10 = i4 + 1;
                bArr[i4] = (byte) ((i8 >>> 8) & 255);
                i4 = i10 + 1;
                bArr[i10] = (byte) (i8 & 255);
            }
        }
        if (i4 != bArr.length) {
            if (i5 == -1) {
                return null;
            }
            int i11 = i4 - i5;
            System.arraycopy(bArr, i5, bArr, bArr.length - i11, i11);
            Arrays.fill(bArr, i5, (bArr.length - i4) + i5, 0);
        }
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException unused) {
            throw new AssertionError();
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(j.A a2, int i2, TimeUnit timeUnit) {
        try {
            return b(a2, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        if (map.isEmpty()) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    @SafeVarargs
    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String str : strArr) {
                for (String compare : strArr2) {
                    if (comparator.compare(str, compare) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static ThreadFactory a(String str, boolean z) {
        return new b(str, z);
    }

    static /* synthetic */ Thread a(String str, boolean z, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z);
        return thread;
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static int b(String str, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            char charAt = str.charAt(i4);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i4 + 1;
            }
        }
        return i2;
    }

    public static int b(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
        }
        return -1;
    }

    public static A b(List<b> list) {
        a aVar = new a();
        for (b bVar : list) {
            c.f8601a.a(aVar, bVar.f10546g.g(), bVar.f10547h.g());
        }
        return aVar.a();
    }

    public static String a(B b2, boolean z) {
        String str;
        String str2 = ":";
        if (b2.g().contains(str2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(b2.g());
            sb.append("]");
            str = sb.toString();
        } else {
            str = b2.g();
        }
        if (!z && b2.k() == B.a(b2.n())) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(str2);
        sb2.append(b2.k());
        return sb2.toString();
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static String[] a(String[] strArr, String str) {
        String[] strArr2 = new String[(strArr.length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static int a(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(String str) {
        InetAddress inetAddress;
        if (str.contains(":")) {
            if (!str.startsWith("[") || !str.endsWith("]")) {
                inetAddress = d(str, 0, str.length());
            } else {
                inetAddress = d(str, 1, str.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                return a(address);
            }
            if (address.length == 4) {
                return inetAddress.getHostAddress();
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid IPv6 address: '");
            sb.append(str);
            sb.append("'");
            throw new AssertionError(sb.toString());
        }
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (!lowerCase.isEmpty() && !d(lowerCase)) {
                return lowerCase;
            }
            return null;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" < 0");
            throw new IllegalArgumentException(sb.toString());
        } else if (timeUnit != null) {
            long millis = timeUnit.toMillis(j2);
            if (millis > 2147483647L) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" too large.");
                throw new IllegalArgumentException(sb2.toString());
            } else if (millis != 0 || i2 <= 0) {
                return (int) millis;
            } else {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" too small.");
                throw new IllegalArgumentException(sb3.toString());
            }
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    private static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if (i7 == 0 && i2 != i6) {
                    return false;
                } else {
                    i7 = ((i7 * 10) + charAt) - 48;
                    if (i7 > 255) {
                        return false;
                    }
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            int i8 = i5 + 1;
            bArr[i5] = (byte) i7;
            i5 = i8;
            i2 = i6;
        }
        if (i5 != i4 + 4) {
            return false;
        }
        return true;
    }

    private static String a(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        int i5 = 0;
        while (i3 < bArr.length) {
            int i6 = i3;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i3;
            if (i7 > i5 && i7 >= 4) {
                i4 = i3;
                i5 = i7;
            }
            i3 = i6 + 2;
        }
        f fVar = new f();
        while (i2 < bArr.length) {
            if (i2 == i4) {
                fVar.writeByte(58);
                i2 += i5;
                if (i2 == 16) {
                    fVar.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    fVar.writeByte(58);
                }
                fVar.f((long) (((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255)));
                i2 += 2;
            }
        }
        return fVar.e();
    }

    public static X509TrustManager a() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init(null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected default trust managers:");
            sb.append(Arrays.toString(trustManagers));
            throw new IllegalStateException(sb.toString());
        } catch (GeneralSecurityException e2) {
            throw new AssertionError("No System TLS", e2);
        }
    }

    public static List<b> a(A a2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < a2.b(); i2++) {
            arrayList.add(new b(a2.a(i2), a2.b(i2)));
        }
        return arrayList;
    }

    public static String a(String str, String str2) {
        try {
            String property = System.getProperty(str);
            if (property == null) {
                property = str2;
            }
            return property;
        } catch (AccessControlException unused) {
            return str2;
        }
    }

    public static boolean a(B b2, B b3) {
        return b2.g().equals(b3.g()) && b2.k() == b3.k() && b2.n().equals(b3.n());
    }
}
