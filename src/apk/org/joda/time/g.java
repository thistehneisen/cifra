package org.joda.time;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.e.c;
import org.joda.time.f.d;
import org.joda.time.f.e;
import org.joda.time.f.f;
import org.joda.time.f.i;

/* compiled from: DateTimeZone */
public abstract class g implements Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final g f10938a = v.f10960e;

    /* renamed from: b reason: collision with root package name */
    private static final AtomicReference<f> f10939b = new AtomicReference<>();

    /* renamed from: c reason: collision with root package name */
    private static final AtomicReference<e> f10940c = new AtomicReference<>();

    /* renamed from: d reason: collision with root package name */
    private static final AtomicReference<g> f10941d = new AtomicReference<>();
    private static final long serialVersionUID = 5546345482340108586L;
    private final String iID;

    /* compiled from: DateTimeZone */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        static final Map<String, String> f10942a = b();

        /* renamed from: b reason: collision with root package name */
        static final org.joda.time.e.b f10943b = a();

        private static org.joda.time.e.b a() {
            f fVar = new f();
            c cVar = new c();
            cVar.a(null, true, 2, 4);
            return cVar.i().a((a) fVar);
        }

        private static Map<String, String> b() {
            HashMap hashMap = new HashMap();
            hashMap.put("GMT", "UTC");
            String str = "WET";
            hashMap.put(str, str);
            String str2 = "CET";
            hashMap.put(str2, str2);
            hashMap.put("MET", str2);
            hashMap.put("ECT", str2);
            String str3 = "EET";
            hashMap.put(str3, str3);
            hashMap.put("MIT", "Pacific/Apia");
            hashMap.put("HST", "Pacific/Honolulu");
            hashMap.put("AST", "America/Anchorage");
            hashMap.put("PST", "America/Los_Angeles");
            hashMap.put("MST", "America/Denver");
            hashMap.put("PNT", "America/Phoenix");
            hashMap.put("CST", "America/Chicago");
            hashMap.put("EST", "America/New_York");
            hashMap.put("IET", "America/Indiana/Indianapolis");
            hashMap.put("PRT", "America/Puerto_Rico");
            hashMap.put("CNT", "America/St_Johns");
            hashMap.put("AGT", "America/Argentina/Buenos_Aires");
            hashMap.put("BET", "America/Sao_Paulo");
            hashMap.put("ART", "Africa/Cairo");
            hashMap.put("CAT", "Africa/Harare");
            hashMap.put("EAT", "Africa/Addis_Ababa");
            hashMap.put("NET", "Asia/Yerevan");
            hashMap.put("PLT", "Asia/Karachi");
            hashMap.put("IST", "Asia/Kolkata");
            hashMap.put("BST", "Asia/Dhaka");
            hashMap.put("VST", "Asia/Ho_Chi_Minh");
            hashMap.put("CTT", "Asia/Shanghai");
            hashMap.put("JST", "Asia/Tokyo");
            hashMap.put("ACT", "Australia/Darwin");
            hashMap.put("AET", "Australia/Sydney");
            hashMap.put("SST", "Pacific/Guadalcanal");
            hashMap.put("NST", "Pacific/Auckland");
            return Collections.unmodifiableMap(hashMap);
        }
    }

    /* compiled from: DateTimeZone */
    private static final class b implements Serializable {
        private static final long serialVersionUID = -6471952376487863581L;

        /* renamed from: a reason: collision with root package name */
        private transient String f10944a;

        b(String str) {
            this.f10944a = str;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            this.f10944a = objectInputStream.readUTF();
        }

        private Object readResolve() throws ObjectStreamException {
            return g.a(this.f10944a);
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeUTF(this.f10944a);
        }
    }

    protected g(String str) {
        if (str != null) {
            this.iID = str;
            return;
        }
        throw new IllegalArgumentException("Id must not be null");
    }

    public static void a(g gVar) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new k("DateTimeZone.setDefault"));
        }
        if (gVar != null) {
            f10941d.set(gVar);
            return;
        }
        throw new IllegalArgumentException("The datetime zone must not be null");
    }

    public static g b() {
        g gVar = (g) f10941d.get();
        if (gVar != null) {
            return gVar;
        }
        try {
            String property = System.getProperty("user.timezone");
            if (property != null) {
                gVar = a(property);
            }
        } catch (RuntimeException unused) {
        }
        if (gVar == null) {
            try {
                gVar = a(TimeZone.getDefault());
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (gVar == null) {
            gVar = f10938a;
        }
        return !f10941d.compareAndSet(null, gVar) ? (g) f10941d.get() : gVar;
    }

    private static String c(String str) {
        return (String) a.f10942a.get(str);
    }

    public static e d() {
        e eVar = (e) f10940c.get();
        if (eVar != null) {
            return eVar;
        }
        e g2 = g();
        return !f10940c.compareAndSet(null, g2) ? (e) f10940c.get() : g2;
    }

    public static f e() {
        f fVar = (f) f10939b.get();
        if (fVar != null) {
            return fVar;
        }
        f h2 = h();
        return !f10939b.compareAndSet(null, h2) ? (f) f10939b.get() : h2;
    }

    private static e g() {
        e eVar = null;
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.NameProvider");
            if (property != null) {
                Class cls = Class.forName(property, false, g.class.getClassLoader());
                if (e.class.isAssignableFrom(cls)) {
                    eVar = (e) cls.asSubclass(e.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("System property referred to class that does not implement ");
                    sb.append(e.class);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        } catch (SecurityException unused) {
        }
        return eVar == null ? new org.joda.time.f.c() : eVar;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x0070 */
    private static f h() {
        try {
            String property = System.getProperty("org.joda.time.DateTimeZone.Provider");
            if (property != null) {
                Class cls = Class.forName(property, false, g.class.getClassLoader());
                if (f.class.isAssignableFrom(cls)) {
                    f fVar = (f) cls.asSubclass(f.class).getConstructor(new Class[0]).newInstance(new Object[0]);
                    b(fVar);
                    return fVar;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("System property referred to class that does not implement ");
                sb.append(f.class);
                throw new IllegalArgumentException(sb.toString());
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        } catch (SecurityException unused) {
        }
        String property2 = System.getProperty("org.joda.time.DateTimeZone.Folder");
        if (property2 != null) {
            try {
                i iVar = new i(new File(property2));
                b((f) iVar);
                return iVar;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            } catch (SecurityException ) {
            }
        }
        try {
            i iVar2 = new i("org/joda/time/tz/data");
            b((f) iVar2);
            return iVar2;
        } catch (Exception e4) {
            e4.printStackTrace();
            return new org.joda.time.f.g();
        }
    }

    public abstract String b(long j2);

    public abstract int c(long j2);

    public abstract int e(long j2);

    public abstract boolean equals(Object obj);

    public abstract boolean f();

    public boolean f(long j2) {
        return c(j2) == e(j2);
    }

    public abstract long g(long j2);

    public abstract long h(long j2);

    public int hashCode() {
        return c().hashCode() + 57;
    }

    public String toString() {
        return c();
    }

    /* access modifiers changed from: protected */
    public Object writeReplace() throws ObjectStreamException {
        return new b(this.iID);
    }

    public final String c() {
        return this.iID;
    }

    public static g a(String str) {
        if (str == null) {
            return b();
        }
        if (str.equals("UTC")) {
            return f10938a;
        }
        g a2 = e().a(str);
        if (a2 != null) {
            return a2;
        }
        if (str.startsWith("+") || str.startsWith("-")) {
            int d2 = d(str);
            if (((long) d2) == 0) {
                return f10938a;
            }
            return a(b(d2), d2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The datetime zone id '");
        sb.append(str);
        sb.append("' is not recognised");
        throw new IllegalArgumentException(sb.toString());
    }

    private static int d(String str) {
        return -((int) a.f10943b.b(str));
    }

    public int d(long j2) {
        int c2 = c(j2);
        long j3 = j2 - ((long) c2);
        int c3 = c(j3);
        if (c2 != c3) {
            if (c2 - c3 < 0) {
                long g2 = g(j3);
                if (g2 == j3) {
                    g2 = Long.MAX_VALUE;
                }
                long j4 = j2 - ((long) c3);
                long g3 = g(j4);
                if (g3 == j4) {
                    g3 = Long.MAX_VALUE;
                }
                if (g2 != g3) {
                    return c2;
                }
            }
        } else if (c2 >= 0) {
            long h2 = h(j3);
            if (h2 < j3) {
                int c4 = c(h2);
                if (j3 - h2 <= ((long) (c4 - c2))) {
                    return c4;
                }
            }
        }
        return c3;
    }

    private static String b(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i2 = 0; i2 < sb.length(); i2++) {
            int digit = Character.digit(sb.charAt(i2), 10);
            if (digit >= 0) {
                sb.setCharAt(i2, (char) (digit + 48));
            }
        }
        return sb.toString();
    }

    private static f b(f fVar) {
        Set a2 = fVar.a();
        if (a2 == null || a2.size() == 0) {
            throw new IllegalArgumentException("The provider doesn't have any available ids");
        }
        String str = "UTC";
        if (!a2.contains(str)) {
            throw new IllegalArgumentException("The provider doesn't support UTC");
        } else if (f10938a.equals(fVar.a(str))) {
            return fVar;
        } else {
            throw new IllegalArgumentException("Invalid UTC zone provided");
        }
    }

    public static g a(int i2) {
        if (i2 >= -86399999 && i2 <= 86399999) {
            return a(b(i2), i2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Millis out of range: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static g a(TimeZone timeZone) {
        if (timeZone == null) {
            return b();
        }
        String id = timeZone.getID();
        if (id == null) {
            throw new IllegalArgumentException("The TimeZone id must not be null");
        } else if (id.equals("UTC")) {
            return f10938a;
        } else {
            g gVar = null;
            String c2 = c(id);
            f e2 = e();
            if (c2 != null) {
                gVar = e2.a(c2);
            }
            if (gVar == null) {
                gVar = e2.a(id);
            }
            if (gVar != null) {
                return gVar;
            }
            if (c2 != null || (!id.startsWith("GMT+") && !id.startsWith("GMT-"))) {
                StringBuilder sb = new StringBuilder();
                sb.append("The datetime zone id '");
                sb.append(id);
                sb.append("' is not recognised");
                throw new IllegalArgumentException(sb.toString());
            }
            String substring = id.substring(3);
            if (substring.length() > 2) {
                char charAt = substring.charAt(1);
                if (charAt > '9' && Character.isDigit(charAt)) {
                    substring = b(substring);
                }
            }
            int d2 = d(substring);
            if (((long) d2) == 0) {
                return f10938a;
            }
            return a(b(d2), d2);
        }
    }

    private static String b(int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (i2 >= 0) {
            stringBuffer.append('+');
        } else {
            stringBuffer.append('-');
            i2 = -i2;
        }
        int i3 = i2 / 3600000;
        org.joda.time.e.i.a(stringBuffer, i3, 2);
        int i4 = i2 - (i3 * 3600000);
        int i5 = i4 / 60000;
        stringBuffer.append(':');
        org.joda.time.e.i.a(stringBuffer, i5, 2);
        int i6 = i4 - (i5 * 60000);
        if (i6 == 0) {
            return stringBuffer.toString();
        }
        int i7 = i6 / 1000;
        stringBuffer.append(':');
        org.joda.time.e.i.a(stringBuffer, i7, 2);
        int i8 = i6 - (i7 * 1000);
        if (i8 == 0) {
            return stringBuffer.toString();
        }
        stringBuffer.append('.');
        org.joda.time.e.i.a(stringBuffer, i8, 3);
        return stringBuffer.toString();
    }

    public String b(long j2, Locale locale) {
        String str;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String b2 = b(j2);
        if (b2 == null) {
            return this.iID;
        }
        e d2 = d();
        if (d2 instanceof org.joda.time.f.c) {
            str = ((org.joda.time.f.c) d2).b(locale, this.iID, b2, f(j2));
        } else {
            str = d2.b(locale, this.iID, b2);
        }
        if (str != null) {
            return str;
        }
        return b(c(j2));
    }

    private static g a(String str, int i2) {
        if (i2 == 0) {
            return f10938a;
        }
        return new d(str, null, i2, i2);
    }

    public static Set<String> a() {
        return e().a();
    }

    public static void a(f fVar) throws SecurityException {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new k("DateTimeZone.setProvider"));
        }
        if (fVar == null) {
            fVar = h();
        } else {
            b(fVar);
        }
        f10939b.set(fVar);
    }

    public String a(long j2, Locale locale) {
        String str;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        String b2 = b(j2);
        if (b2 == null) {
            return this.iID;
        }
        e d2 = d();
        if (d2 instanceof org.joda.time.f.c) {
            str = ((org.joda.time.f.c) d2).a(locale, this.iID, b2, f(j2));
        } else {
            str = d2.a(locale, this.iID, b2);
        }
        if (str != null) {
            return str;
        }
        return b(c(j2));
    }

    public long a(long j2) {
        long c2 = (long) c(j2);
        long j3 = j2 + c2;
        if ((j2 ^ j3) >= 0 || (j2 ^ c2) < 0) {
            return j3;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public long a(long j2, boolean z, long j3) {
        int c2 = c(j3);
        long j4 = j2 - ((long) c2);
        if (c(j4) == c2) {
            return j4;
        }
        return a(j2, z);
    }

    public long a(long j2, boolean z) {
        long j3;
        int c2 = c(j2);
        long j4 = j2 - ((long) c2);
        int c3 = c(j4);
        if (c2 != c3 && (z || c2 < 0)) {
            long g2 = g(j4);
            long j5 = Long.MAX_VALUE;
            if (g2 == j4) {
                g2 = Long.MAX_VALUE;
            }
            long j6 = j2 - ((long) c3);
            long g3 = g(j6);
            if (g3 != j6) {
                j5 = g3;
            }
            if (g2 != j5) {
                if (z) {
                    throw new IllegalInstantException(j2, c());
                }
                long j7 = (long) c2;
                j3 = j2 - j7;
                if ((j2 ^ j3) < 0 || (j2 ^ j7) >= 0) {
                    return j3;
                }
                throw new ArithmeticException("Subtracting time zone offset caused overflow");
            }
        }
        c2 = c3;
        long j72 = (long) c2;
        j3 = j2 - j72;
        if ((j2 ^ j3) < 0) {
        }
        return j3;
    }

    public long a(g gVar, long j2) {
        if (gVar == null) {
            gVar = b();
        }
        g gVar2 = gVar;
        if (gVar2 == this) {
            return j2;
        }
        return gVar2.a(a(j2), false, j2);
    }
}
