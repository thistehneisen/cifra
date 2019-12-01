package org.joda.time.b;

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.d;
import org.joda.time.e;

/* compiled from: GJLocaleSymbols */
class q {

    /* renamed from: a reason: collision with root package name */
    private static ConcurrentMap<Locale, q> f10743a = new ConcurrentHashMap();

    /* renamed from: b reason: collision with root package name */
    private final String[] f10744b;

    /* renamed from: c reason: collision with root package name */
    private final String[] f10745c;

    /* renamed from: d reason: collision with root package name */
    private final String[] f10746d;

    /* renamed from: e reason: collision with root package name */
    private final String[] f10747e;

    /* renamed from: f reason: collision with root package name */
    private final String[] f10748f;

    /* renamed from: g reason: collision with root package name */
    private final String[] f10749g;

    /* renamed from: h reason: collision with root package name */
    private final TreeMap<String, Integer> f10750h;

    /* renamed from: i reason: collision with root package name */
    private final TreeMap<String, Integer> f10751i;

    /* renamed from: j reason: collision with root package name */
    private final TreeMap<String, Integer> f10752j;

    /* renamed from: k reason: collision with root package name */
    private final int f10753k;

    /* renamed from: l reason: collision with root package name */
    private final int f10754l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;

    private q(Locale locale) {
        DateFormatSymbols a2 = e.a(locale);
        this.f10744b = a2.getEras();
        this.f10745c = b(a2.getWeekdays());
        this.f10746d = b(a2.getShortWeekdays());
        this.f10747e = c(a2.getMonths());
        this.f10748f = c(a2.getShortMonths());
        this.f10749g = a2.getAmPmStrings();
        Integer[] numArr = new Integer[13];
        for (int i2 = 0; i2 < 13; i2++) {
            numArr[i2] = Integer.valueOf(i2);
        }
        this.f10750h = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        a(this.f10750h, this.f10744b, numArr);
        if ("en".equals(locale.getLanguage())) {
            this.f10750h.put("BCE", numArr[0]);
            this.f10750h.put("CE", numArr[1]);
        }
        this.f10751i = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        a(this.f10751i, this.f10745c, numArr);
        a(this.f10751i, this.f10746d, numArr);
        a(this.f10751i, 1, 7, numArr);
        this.f10752j = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        a(this.f10752j, this.f10747e, numArr);
        a(this.f10752j, this.f10748f, numArr);
        a(this.f10752j, 1, 12, numArr);
        this.f10753k = a(this.f10744b);
        this.f10754l = a(this.f10745c);
        this.m = a(this.f10746d);
        this.n = a(this.f10747e);
        this.o = a(this.f10748f);
        this.p = a(this.f10749g);
    }

    static q a(Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        q qVar = (q) f10743a.get(locale);
        if (qVar != null) {
            return qVar;
        }
        q qVar2 = new q(locale);
        q qVar3 = (q) f10743a.putIfAbsent(locale, qVar2);
        return qVar3 != null ? qVar3 : qVar2;
    }

    private static String[] b(String[] strArr) {
        String[] strArr2 = new String[8];
        int i2 = 1;
        while (i2 < 8) {
            strArr2[i2] = strArr[i2 < 7 ? i2 + 1 : 1];
            i2++;
        }
        return strArr2;
    }

    private static String[] c(String[] strArr) {
        String[] strArr2 = new String[13];
        for (int i2 = 1; i2 < 13; i2++) {
            strArr2[i2] = strArr[i2 - 1];
        }
        return strArr2;
    }

    public int d(String str) {
        Integer num = (Integer) this.f10752j.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(d.N(), str);
    }

    public String e(int i2) {
        return this.f10748f[i2];
    }

    public String f(int i2) {
        return this.f10747e[i2];
    }

    public int b(String str) {
        Integer num = (Integer) this.f10750h.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(d.D(), str);
    }

    public String c(int i2) {
        return this.f10744b[i2];
    }

    public int c(String str) {
        String[] strArr = this.f10749g;
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                throw new IllegalFieldValueException(d.G(), str);
            }
        } while (!strArr[length].equalsIgnoreCase(str));
        return length;
    }

    public int d() {
        return this.n;
    }

    private static void a(TreeMap<String, Integer> treeMap, String[] strArr, Integer[] numArr) {
        int length = strArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                String str = strArr[length];
                if (str != null) {
                    treeMap.put(str, numArr[length]);
                }
            } else {
                return;
            }
        }
    }

    public String d(int i2) {
        return this.f10749g[i2];
    }

    public int b() {
        return this.f10753k;
    }

    public String b(int i2) {
        return this.f10745c[i2];
    }

    private static void a(TreeMap<String, Integer> treeMap, int i2, int i3, Integer[] numArr) {
        while (i2 <= i3) {
            treeMap.put(String.valueOf(i2).intern(), numArr[i2]);
            i2++;
        }
    }

    public int c() {
        return this.p;
    }

    private static int a(String[] strArr) {
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i2;
            }
            String str = strArr[length];
            if (str != null) {
                int length2 = str.length();
                if (length2 > i2) {
                    i2 = length2;
                }
            }
        }
    }

    public String a(int i2) {
        return this.f10746d[i2];
    }

    public int a(String str) {
        Integer num = (Integer) this.f10751i.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalFieldValueException(d.B(), str);
    }

    public int a() {
        return this.f10754l;
    }
}
