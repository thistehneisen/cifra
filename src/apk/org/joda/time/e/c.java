package org.joda.time.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.t;

/* compiled from: DateTimeFormatterBuilder */
public class c {

    /* renamed from: a reason: collision with root package name */
    private ArrayList<Object> f10837a = new ArrayList<>();

    /* renamed from: b reason: collision with root package name */
    private Object f10838b;

    /* compiled from: DateTimeFormatterBuilder */
    static class a implements m, k {

        /* renamed from: a reason: collision with root package name */
        private final char f10839a;

        a(char c2) {
            this.f10839a = c2;
        }

        public int a() {
            return 1;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            appendable.append(this.f10839a);
        }

        public int b() {
            return 1;
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
            appendable.append(this.f10839a);
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            if (i2 >= charSequence.length()) {
                return ~i2;
            }
            char charAt = charSequence.charAt(i2);
            char c2 = this.f10839a;
            if (charAt != c2) {
                char upperCase = Character.toUpperCase(charAt);
                char upperCase2 = Character.toUpperCase(c2);
                if (!(upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2))) {
                    return ~i2;
                }
            }
            return i2 + 1;
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class b implements m, k {

        /* renamed from: a reason: collision with root package name */
        private final m[] f10840a;

        /* renamed from: b reason: collision with root package name */
        private final k[] f10841b;

        /* renamed from: c reason: collision with root package name */
        private final int f10842c;

        /* renamed from: d reason: collision with root package name */
        private final int f10843d;

        b(List<Object> list) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            a(list, (List<Object>) arrayList, (List<Object>) arrayList2);
            if (arrayList.contains(null) || arrayList.isEmpty()) {
                this.f10840a = null;
                this.f10842c = 0;
            } else {
                int size = arrayList.size();
                this.f10840a = new m[size];
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    m mVar = (m) arrayList.get(i3);
                    i2 += mVar.b();
                    this.f10840a[i3] = mVar;
                }
                this.f10842c = i2;
            }
            if (arrayList2.contains(null) || arrayList2.isEmpty()) {
                this.f10841b = null;
                this.f10843d = 0;
                return;
            }
            int size2 = arrayList2.size();
            this.f10841b = new k[size2];
            int i4 = 0;
            for (int i5 = 0; i5 < size2; i5++) {
                k kVar = (k) arrayList2.get(i5);
                i4 += kVar.a();
                this.f10841b[i5] = kVar;
            }
            this.f10843d = i4;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            m[] mVarArr = this.f10840a;
            if (mVarArr != null) {
                Locale locale2 = locale == null ? Locale.getDefault() : locale;
                for (m a2 : mVarArr) {
                    a2.a(appendable, j2, aVar, i2, gVar, locale2);
                }
                return;
            }
            throw new UnsupportedOperationException();
        }

        public int b() {
            return this.f10842c;
        }

        /* access modifiers changed from: 0000 */
        public boolean c() {
            return this.f10841b != null;
        }

        /* access modifiers changed from: 0000 */
        public boolean d() {
            return this.f10840a != null;
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
            m[] mVarArr = this.f10840a;
            if (mVarArr != null) {
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                for (m a2 : mVarArr) {
                    a2.a(appendable, tVar, locale);
                }
                return;
            }
            throw new UnsupportedOperationException();
        }

        public int a() {
            return this.f10843d;
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            k[] kVarArr = this.f10841b;
            if (kVarArr != null) {
                int length = kVarArr.length;
                for (int i3 = 0; i3 < length && i2 >= 0; i3++) {
                    i2 = kVarArr[i3].a(eVar, charSequence, i2);
                }
                return i2;
            }
            throw new UnsupportedOperationException();
        }

        private void a(List<Object> list, List<Object> list2, List<Object> list3) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2 += 2) {
                Object obj = list.get(i2);
                if (obj instanceof b) {
                    a(list2, ((b) obj).f10840a);
                } else {
                    list2.add(obj);
                }
                Object obj2 = list.get(i2 + 1);
                if (obj2 instanceof b) {
                    a(list3, ((b) obj2).f10841b);
                } else {
                    list3.add(obj2);
                }
            }
        }

        private void a(List<Object> list, Object[] objArr) {
            if (objArr != null) {
                for (Object add : objArr) {
                    list.add(add);
                }
            }
        }
    }

    /* renamed from: org.joda.time.e.c$c reason: collision with other inner class name */
    /* compiled from: DateTimeFormatterBuilder */
    static class C0125c extends g {
        protected C0125c(org.joda.time.d dVar, int i2, boolean z) {
            super(dVar, i2, z, i2);
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            int a2 = super.a(eVar, charSequence, i2);
            if (a2 < 0) {
                return a2;
            }
            int i3 = this.f10850b + i2;
            if (a2 != i3) {
                if (this.f10851c) {
                    char charAt = charSequence.charAt(i2);
                    if (charAt == '-' || charAt == '+') {
                        i3++;
                    }
                }
                if (a2 > i3) {
                    return ~(i3 + 1);
                }
                if (a2 < i3) {
                    a2 = ~a2;
                }
            }
            return a2;
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class d implements m, k {

        /* renamed from: a reason: collision with root package name */
        private final org.joda.time.d f10844a;

        /* renamed from: b reason: collision with root package name */
        protected int f10845b;

        /* renamed from: c reason: collision with root package name */
        protected int f10846c;

        protected d(org.joda.time.d dVar, int i2, int i3) {
            this.f10844a = dVar;
            int i4 = 18;
            if (i3 <= 18) {
                i4 = i3;
            }
            this.f10845b = i2;
            this.f10846c = i4;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            a(appendable, j2, aVar);
        }

        public int b() {
            return this.f10846c;
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
            a(appendable, tVar.getChronology().a(tVar, 0), tVar.getChronology());
        }

        /* access modifiers changed from: protected */
        public void a(Appendable appendable, long j2, org.joda.time.a aVar) throws IOException {
            String str;
            org.joda.time.c a2 = this.f10844a.a(aVar);
            int i2 = this.f10845b;
            try {
                long c2 = a2.c(j2);
                if (c2 == 0) {
                    while (true) {
                        i2--;
                        if (i2 >= 0) {
                            appendable.append('0');
                        } else {
                            return;
                        }
                    }
                } else {
                    long[] a3 = a(c2, a2);
                    long j3 = a3[0];
                    int i3 = (int) a3[1];
                    if ((2147483647L & j3) == j3) {
                        str = Integer.toString((int) j3);
                    } else {
                        str = Long.toString(j3);
                    }
                    int length = str.length();
                    while (length < i3) {
                        appendable.append('0');
                        i2--;
                        i3--;
                    }
                    if (i2 < i3) {
                        while (i2 < i3 && length > 1 && str.charAt(length - 1) == '0') {
                            i3--;
                            length--;
                        }
                        if (length < str.length()) {
                            for (int i4 = 0; i4 < length; i4++) {
                                appendable.append(str.charAt(i4));
                            }
                            return;
                        }
                    }
                    appendable.append(str);
                }
            } catch (RuntimeException unused) {
                c.a(appendable, i2);
            }
        }

        private long[] a(long j2, org.joda.time.c cVar) {
            long j3;
            long b2 = cVar.a().b();
            int i2 = this.f10846c;
            while (true) {
                switch (i2) {
                    case 1:
                        j3 = 10;
                        break;
                    case 2:
                        j3 = 100;
                        break;
                    case 3:
                        j3 = 1000;
                        break;
                    case 4:
                        j3 = 10000;
                        break;
                    case 5:
                        j3 = 100000;
                        break;
                    case 6:
                        j3 = 1000000;
                        break;
                    case 7:
                        j3 = 10000000;
                        break;
                    case 8:
                        j3 = 100000000;
                        break;
                    case 9:
                        j3 = 1000000000;
                        break;
                    case 10:
                        j3 = 10000000000L;
                        break;
                    case 11:
                        j3 = 100000000000L;
                        break;
                    case 12:
                        j3 = 1000000000000L;
                        break;
                    case 13:
                        j3 = 10000000000000L;
                        break;
                    case 14:
                        j3 = 100000000000000L;
                        break;
                    case 15:
                        j3 = 1000000000000000L;
                        break;
                    case 16:
                        j3 = 10000000000000000L;
                        break;
                    case 17:
                        j3 = 100000000000000000L;
                        break;
                    case 18:
                        j3 = 1000000000000000000L;
                        break;
                    default:
                        j3 = 1;
                        break;
                }
                if ((b2 * j3) / j3 == b2) {
                    return new long[]{(j2 * j3) / b2, (long) i2};
                }
                i2--;
            }
        }

        public int a() {
            return this.f10846c;
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            org.joda.time.c a2 = this.f10844a.a(eVar.a());
            int min = Math.min(this.f10846c, charSequence.length() - i2);
            long b2 = a2.a().b() * 10;
            long j2 = 0;
            int i3 = 0;
            while (i3 < min) {
                char charAt = charSequence.charAt(i2 + i3);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i3++;
                b2 /= 10;
                j2 += ((long) (charAt - '0')) * b2;
            }
            long j3 = j2 / 10;
            if (i3 == 0) {
                return ~i2;
            }
            if (j3 > 2147483647L) {
                return ~i2;
            }
            eVar.a((org.joda.time.c) new org.joda.time.d.l(org.joda.time.d.K(), org.joda.time.d.j.f10809a, a2.a()), (int) j3);
            return i2 + i3;
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class e implements k {

        /* renamed from: a reason: collision with root package name */
        private final k[] f10847a;

        /* renamed from: b reason: collision with root package name */
        private final int f10848b;

        e(k[] kVarArr) {
            this.f10847a = kVarArr;
            int length = kVarArr.length;
            int i2 = 0;
            while (true) {
                length--;
                if (length >= 0) {
                    k kVar = kVarArr[length];
                    if (kVar != null) {
                        int a2 = kVar.a();
                        if (a2 > i2) {
                            i2 = a2;
                        }
                    }
                } else {
                    this.f10848b = i2;
                    return;
                }
            }
        }

        public int a() {
            return this.f10848b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
            return r8;
         */
        public int a(e eVar, CharSequence charSequence, int i2) {
            k[] kVarArr = this.f10847a;
            int length = kVarArr.length;
            Object f2 = eVar.f();
            boolean z = false;
            int i3 = i2;
            int i4 = i3;
            Object obj = null;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                k kVar = kVarArr[i5];
                if (kVar != null) {
                    int a2 = kVar.a(eVar, charSequence, i2);
                    if (a2 >= i2) {
                        if (a2 > i3) {
                            if (a2 >= charSequence.length()) {
                                break;
                            }
                            int i6 = i5 + 1;
                            if (i6 >= length || kVarArr[i6] == null) {
                                break;
                            }
                            obj = eVar.f();
                            i3 = a2;
                        } else {
                            continue;
                        }
                    } else if (a2 < 0) {
                        int i7 = ~a2;
                        if (i7 > i4) {
                            i4 = i7;
                        }
                    }
                    eVar.a(f2);
                    i5++;
                } else if (i3 <= i2) {
                    return i2;
                } else {
                    z = true;
                }
            }
            if (i3 <= i2 && (i3 != i2 || !z)) {
                return ~i4;
            }
            if (obj != null) {
                eVar.a(obj);
            }
            return i3;
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static abstract class f implements m, k {

        /* renamed from: a reason: collision with root package name */
        protected final org.joda.time.d f10849a;

        /* renamed from: b reason: collision with root package name */
        protected final int f10850b;

        /* renamed from: c reason: collision with root package name */
        protected final boolean f10851c;

        f(org.joda.time.d dVar, int i2, boolean z) {
            this.f10849a = dVar;
            this.f10850b = i2;
            this.f10851c = z;
        }

        public int a() {
            return this.f10850b;
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            int i3;
            int i4;
            boolean z;
            boolean z2;
            CharSequence charSequence2 = charSequence;
            int i5 = i2;
            int min = Math.min(this.f10850b, charSequence.length() - i5);
            int i6 = 0;
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                if (i6 >= min) {
                    break;
                }
                int i7 = i5 + i6;
                char charAt = charSequence2.charAt(i7);
                if (i6 != 0 || ((charAt != '-' && charAt != '+') || !this.f10851c)) {
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i6++;
                } else {
                    z = true;
                    z2 = charAt == '-';
                    if (charAt != '+') {
                        z = false;
                    }
                    int i8 = i6 + 1;
                    if (i8 >= min) {
                        break;
                    }
                    char charAt2 = charSequence2.charAt(i7 + 1);
                    if (charAt2 < '0' || charAt2 > '9') {
                        break;
                    }
                    min = Math.min(min + 1, charSequence.length() - i5);
                    i6 = i8;
                    boolean z5 = z2;
                    z4 = z;
                    z3 = z5;
                }
            }
            boolean z6 = z2;
            z4 = z;
            z3 = z6;
            if (i6 == 0) {
                return ~i5;
            }
            if (i6 < 9) {
                int i9 = (z3 || z4) ? i5 + 1 : i5;
                int i10 = i9 + 1;
                try {
                    int charAt3 = charSequence2.charAt(i9) - '0';
                    i3 = i5 + i6;
                    while (i10 < i3) {
                        i10++;
                        charAt3 = (((charAt3 << 3) + (charAt3 << 1)) + charSequence2.charAt(i10)) - 48;
                    }
                    i4 = z3 ? -charAt3 : charAt3;
                } catch (StringIndexOutOfBoundsException unused) {
                    return ~i5;
                }
            } else if (z4) {
                int i11 = i5 + 1;
                i3 = i5 + i6;
                i4 = Integer.parseInt(charSequence2.subSequence(i11, i3).toString());
            } else {
                int i12 = i6 + i5;
                i4 = Integer.parseInt(charSequence2.subSequence(i5, i12).toString());
                i3 = i12;
            }
            eVar.a(this.f10849a, i4);
            return i3;
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class g extends f {

        /* renamed from: d reason: collision with root package name */
        protected final int f10852d;

        protected g(org.joda.time.d dVar, int i2, boolean z, int i3) {
            super(dVar, i2, z);
            this.f10852d = i3;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            try {
                i.a(appendable, this.f10849a.a(aVar).a(j2), this.f10852d);
            } catch (RuntimeException unused) {
                c.a(appendable, this.f10852d);
            }
        }

        public int b() {
            return this.f10850b;
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
            if (tVar.a(this.f10849a)) {
                try {
                    i.a(appendable, tVar.b(this.f10849a), this.f10852d);
                } catch (RuntimeException unused) {
                    c.a(appendable, this.f10852d);
                }
            } else {
                c.a(appendable, this.f10852d);
            }
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class h implements m, k {

        /* renamed from: a reason: collision with root package name */
        private final String f10853a;

        h(String str) {
            this.f10853a = str;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            appendable.append(this.f10853a);
        }

        public int b() {
            return this.f10853a.length();
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
            appendable.append(this.f10853a);
        }

        public int a() {
            return this.f10853a.length();
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            return c.b(charSequence, i2, this.f10853a) ? i2 + this.f10853a.length() : ~i2;
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class i implements m, k {

        /* renamed from: a reason: collision with root package name */
        private static Map<Locale, Map<org.joda.time.d, Object[]>> f10854a = new ConcurrentHashMap();

        /* renamed from: b reason: collision with root package name */
        private final org.joda.time.d f10855b;

        /* renamed from: c reason: collision with root package name */
        private final boolean f10856c;

        i(org.joda.time.d dVar, boolean z) {
            this.f10855b = dVar;
            this.f10856c = z;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            try {
                appendable.append(a(j2, aVar, locale));
            } catch (RuntimeException unused) {
                appendable.append(65533);
            }
        }

        public int b() {
            return this.f10856c ? 6 : 20;
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
            try {
                appendable.append(a(tVar, locale));
            } catch (RuntimeException unused) {
                appendable.append(65533);
            }
        }

        private String a(long j2, org.joda.time.a aVar, Locale locale) {
            org.joda.time.c a2 = this.f10855b.a(aVar);
            if (this.f10856c) {
                return a2.a(j2, locale);
            }
            return a2.b(j2, locale);
        }

        private String a(t tVar, Locale locale) {
            if (!tVar.a(this.f10855b)) {
                return "�";
            }
            org.joda.time.c a2 = this.f10855b.a(tVar.getChronology());
            if (this.f10856c) {
                return a2.a(tVar, locale);
            }
            return a2.b(tVar, locale);
        }

        public int a() {
            return b();
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            int i3;
            Map map;
            Locale b2 = eVar.b();
            Map map2 = (Map) f10854a.get(b2);
            if (map2 == null) {
                map2 = new ConcurrentHashMap();
                f10854a.put(b2, map2);
            }
            Object[] objArr = (Object[]) map2.get(this.f10855b);
            if (objArr == null) {
                Map concurrentHashMap = new ConcurrentHashMap(32);
                org.joda.time.m.a a2 = new org.joda.time.m(0, org.joda.time.g.f10938a).a(this.f10855b);
                int g2 = a2.g();
                int e2 = a2.e();
                if (e2 - g2 > 32) {
                    return ~i2;
                }
                i3 = a2.c(b2);
                while (g2 <= e2) {
                    a2.a(g2);
                    concurrentHashMap.put(a2.a(b2), Boolean.TRUE);
                    concurrentHashMap.put(a2.a(b2).toLowerCase(b2), Boolean.TRUE);
                    concurrentHashMap.put(a2.a(b2).toUpperCase(b2), Boolean.TRUE);
                    concurrentHashMap.put(a2.b(b2), Boolean.TRUE);
                    concurrentHashMap.put(a2.b(b2).toLowerCase(b2), Boolean.TRUE);
                    concurrentHashMap.put(a2.b(b2).toUpperCase(b2), Boolean.TRUE);
                    g2++;
                }
                if ("en".equals(b2.getLanguage()) && this.f10855b == org.joda.time.d.D()) {
                    concurrentHashMap.put("BCE", Boolean.TRUE);
                    concurrentHashMap.put("bce", Boolean.TRUE);
                    concurrentHashMap.put("CE", Boolean.TRUE);
                    concurrentHashMap.put("ce", Boolean.TRUE);
                    i3 = 3;
                }
                map2.put(this.f10855b, new Object[]{concurrentHashMap, Integer.valueOf(i3)});
                map = concurrentHashMap;
            } else {
                map = (Map) objArr[0];
                i3 = ((Integer) objArr[1]).intValue();
            }
            for (int min = Math.min(charSequence.length(), i3 + i2); min > i2; min--) {
                String charSequence2 = charSequence.subSequence(i2, min).toString();
                if (map.containsKey(charSequence2)) {
                    eVar.a(this.f10855b, charSequence2, b2);
                    return min;
                }
            }
            return ~i2;
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    enum j implements m, k {
        INSTANCE;
        

        /* renamed from: b reason: collision with root package name */
        private static final List<String> f10858b = null;

        /* renamed from: c reason: collision with root package name */
        private static final Map<String, List<String>> f10859c = null;

        /* renamed from: d reason: collision with root package name */
        private static final List<String> f10860d = null;

        /* renamed from: e reason: collision with root package name */
        static final int f10861e = 0;

        /* renamed from: f reason: collision with root package name */
        static final int f10862f = 0;

        static {
            f10860d = new ArrayList();
            f10858b = new ArrayList(org.joda.time.g.a());
            Collections.sort(f10858b);
            f10859c = new HashMap();
            int i2 = 0;
            int i3 = 0;
            for (String str : f10858b) {
                int indexOf = str.indexOf(47);
                if (indexOf >= 0) {
                    if (indexOf < str.length()) {
                        indexOf++;
                    }
                    i3 = Math.max(i3, indexOf);
                    String substring = str.substring(0, indexOf + 1);
                    String substring2 = str.substring(indexOf);
                    if (!f10859c.containsKey(substring)) {
                        f10859c.put(substring, new ArrayList());
                    }
                    ((List) f10859c.get(substring)).add(substring2);
                } else {
                    f10860d.add(str);
                }
                i2 = Math.max(i2, str.length());
            }
            f10861e = i2;
            f10862f = i3;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            appendable.append(gVar != null ? gVar.c() : "");
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
        }

        public int b() {
            return f10861e;
        }

        public int a() {
            return f10861e;
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            String str;
            int i3;
            String str2;
            List<String> list = f10860d;
            int length = charSequence.length();
            int min = Math.min(length, f10862f + i2);
            int i4 = i2;
            while (true) {
                if (i4 >= min) {
                    str = "";
                    i3 = i2;
                    break;
                } else if (charSequence.charAt(i4) == '/') {
                    int i5 = i4 + 1;
                    str = charSequence.subSequence(i2, i5).toString();
                    i3 = str.length() + i2;
                    if (i4 < length) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(charSequence.charAt(i5));
                        str2 = sb.toString();
                    } else {
                        str2 = str;
                    }
                    list = (List) f10859c.get(str2);
                    if (list == null) {
                        return ~i2;
                    }
                } else {
                    i4++;
                }
            }
            String str3 = null;
            for (int i6 = 0; i6 < list.size(); i6++) {
                String str4 = (String) list.get(i6);
                if (c.a(charSequence, i3, str4) && (str3 == null || str4.length() > str3.length())) {
                    str3 = str4;
                }
            }
            if (str3 == null) {
                return ~i2;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str3);
            eVar.a(org.joda.time.g.a(sb2.toString()));
            return i3 + str3.length();
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class k implements m, k {

        /* renamed from: a reason: collision with root package name */
        private final Map<String, org.joda.time.g> f10864a;

        /* renamed from: b reason: collision with root package name */
        private final int f10865b;

        k(int i2, Map<String, org.joda.time.g> map) {
            this.f10865b = i2;
            this.f10864a = map;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            appendable.append(a(j2 - ((long) i2), gVar, locale));
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
        }

        public int b() {
            return this.f10865b == 1 ? 4 : 20;
        }

        private String a(long j2, org.joda.time.g gVar, Locale locale) {
            String str = "";
            if (gVar == null) {
                return str;
            }
            int i2 = this.f10865b;
            if (i2 == 0) {
                return gVar.a(j2, locale);
            }
            if (i2 != 1) {
                return str;
            }
            return gVar.b(j2, locale);
        }

        public int a() {
            return this.f10865b == 1 ? 4 : 20;
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            Map<String, org.joda.time.g> map = this.f10864a;
            if (map == null) {
                map = org.joda.time.e.b();
            }
            String str = null;
            for (String str2 : map.keySet()) {
                if (c.a(charSequence, i2, str2) && (str == null || str2.length() > str.length())) {
                    str = str2;
                }
            }
            if (str == null) {
                return ~i2;
            }
            eVar.a((org.joda.time.g) map.get(str));
            return i2 + str.length();
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class l implements m, k {

        /* renamed from: a reason: collision with root package name */
        private final String f10866a;

        /* renamed from: b reason: collision with root package name */
        private final String f10867b;

        /* renamed from: c reason: collision with root package name */
        private final boolean f10868c;

        /* renamed from: d reason: collision with root package name */
        private final int f10869d;

        /* renamed from: e reason: collision with root package name */
        private final int f10870e;

        l(String str, String str2, boolean z, int i2, int i3) {
            this.f10866a = str;
            this.f10867b = str2;
            this.f10868c = z;
            if (i2 <= 0 || i3 < i2) {
                throw new IllegalArgumentException();
            }
            int i4 = 4;
            if (i2 > 4) {
                i3 = 4;
            } else {
                i4 = i2;
            }
            this.f10869d = i4;
            this.f10870e = i3;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            if (gVar != null) {
                if (i2 == 0) {
                    String str = this.f10866a;
                    if (str != null) {
                        appendable.append(str);
                        return;
                    }
                }
                if (i2 >= 0) {
                    appendable.append('+');
                } else {
                    appendable.append('-');
                    i2 = -i2;
                }
                int i3 = i2 / 3600000;
                i.a(appendable, i3, 2);
                if (this.f10870e != 1) {
                    int i4 = i2 - (i3 * 3600000);
                    if (i4 != 0 || this.f10869d > 1) {
                        int i5 = i4 / 60000;
                        if (this.f10868c) {
                            appendable.append(':');
                        }
                        i.a(appendable, i5, 2);
                        if (this.f10870e != 2) {
                            int i6 = i4 - (i5 * 60000);
                            if (i6 != 0 || this.f10869d > 2) {
                                int i7 = i6 / 1000;
                                if (this.f10868c) {
                                    appendable.append(':');
                                }
                                i.a(appendable, i7, 2);
                                if (this.f10870e != 3) {
                                    int i8 = i6 - (i7 * 1000);
                                    if (i8 != 0 || this.f10869d > 3) {
                                        if (this.f10868c) {
                                            appendable.append('.');
                                        }
                                        i.a(appendable, i8, 3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
        }

        public int b() {
            int i2 = this.f10869d;
            int i3 = (i2 + 1) << 1;
            if (this.f10868c) {
                i3 += i2 - 1;
            }
            String str = this.f10866a;
            return (str == null || str.length() <= i3) ? i3 : this.f10866a.length();
        }

        public int a() {
            return b();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0080, code lost:
            if (r6 <= '9') goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (r1 != '+') goto L_0x0023;
         */
        public int a(e eVar, CharSequence charSequence, int i2) {
            boolean z;
            int length = charSequence.length() - i2;
            String str = this.f10867b;
            boolean z2 = false;
            Integer valueOf = Integer.valueOf(0);
            if (str != null) {
                if (str.length() == 0) {
                    if (length > 0) {
                        char charAt = charSequence.charAt(i2);
                        if (charAt != '-') {
                        }
                    }
                    eVar.a(valueOf);
                    return i2;
                } else if (c.b(charSequence, i2, this.f10867b)) {
                    eVar.a(valueOf);
                    return i2 + this.f10867b.length();
                }
            }
            if (length <= 1) {
                return ~i2;
            }
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 == '-') {
                z = true;
            } else if (charAt2 != '+') {
                return ~i2;
            } else {
                z = false;
            }
            int i3 = length - 1;
            int i4 = i2 + 1;
            if (a(charSequence, i4, 2) < 2) {
                return ~i4;
            }
            int a2 = i.a(charSequence, i4);
            if (a2 > 23) {
                return ~i4;
            }
            int i5 = a2 * 3600000;
            int i6 = i3 - 2;
            int i7 = i4 + 2;
            if (i6 > 0) {
                char charAt3 = charSequence.charAt(i7);
                if (charAt3 == ':') {
                    i6--;
                    i7++;
                    z2 = true;
                } else if (charAt3 >= '0') {
                }
                int a3 = a(charSequence, i7, 2);
                if (a3 != 0 || z2) {
                    if (a3 < 2) {
                        return ~i7;
                    }
                    int a4 = i.a(charSequence, i7);
                    if (a4 > 59) {
                        return ~i7;
                    }
                    i5 += a4 * 60000;
                    int i8 = i6 - 2;
                    i7 += 2;
                    if (i8 > 0) {
                        if (z2) {
                            if (charSequence.charAt(i7) == ':') {
                                i8--;
                                i7++;
                            }
                        }
                        int a5 = a(charSequence, i7, 2);
                        if (a5 != 0 || z2) {
                            if (a5 < 2) {
                                return ~i7;
                            }
                            int a6 = i.a(charSequence, i7);
                            if (a6 > 59) {
                                return ~i7;
                            }
                            i5 += a6 * 1000;
                            i7 += 2;
                            if (i8 - 2 > 0) {
                                if (z2) {
                                    if (charSequence.charAt(i7) == '.' || charSequence.charAt(i7) == ',') {
                                        i7++;
                                    }
                                }
                                int a7 = a(charSequence, i7, 3);
                                if (a7 != 0 || z2) {
                                    if (a7 < 1) {
                                        return ~i7;
                                    }
                                    int i9 = i7 + 1;
                                    i5 += (charSequence.charAt(i7) - '0') * 100;
                                    if (a7 > 1) {
                                        i7 = i9 + 1;
                                        i5 += (charSequence.charAt(i9) - '0') * 10;
                                        if (a7 > 2) {
                                            i5 += charSequence.charAt(i7) - '0';
                                            i7++;
                                        }
                                    } else {
                                        i7 = i9;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (z) {
                i5 = -i5;
            }
            eVar.a(Integer.valueOf(i5));
            return i7;
        }

        private int a(CharSequence charSequence, int i2, int i3) {
            int i4 = 0;
            for (int min = Math.min(charSequence.length() - i2, i3); min > 0; min--) {
                char charAt = charSequence.charAt(i2 + i4);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                i4++;
            }
            return i4;
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class m implements m, k {

        /* renamed from: a reason: collision with root package name */
        private final org.joda.time.d f10871a;

        /* renamed from: b reason: collision with root package name */
        private final int f10872b;

        /* renamed from: c reason: collision with root package name */
        private final boolean f10873c;

        m(org.joda.time.d dVar, int i2, boolean z) {
            this.f10871a = dVar;
            this.f10872b = i2;
            this.f10873c = z;
        }

        public int a() {
            return this.f10873c ? 4 : 2;
        }

        public int b() {
            return 2;
        }

        public int a(e eVar, CharSequence charSequence, int i2) {
            int i3;
            int i4;
            int i5;
            int length = charSequence.length() - i2;
            if (this.f10873c) {
                int i6 = i2;
                int i7 = 0;
                boolean z = false;
                boolean z2 = false;
                while (i7 < length) {
                    char charAt = charSequence.charAt(i6 + i7);
                    if (i7 != 0 || (charAt != '-' && charAt != '+')) {
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i7++;
                    } else {
                        z2 = charAt == '-';
                        if (z2) {
                            i7++;
                        } else {
                            i6++;
                            length--;
                        }
                        z = true;
                    }
                }
                if (i7 == 0) {
                    return ~i6;
                }
                if (z || i7 != 2) {
                    if (i7 >= 9) {
                        i4 = i7 + i6;
                        i5 = Integer.parseInt(charSequence.subSequence(i6, i4).toString());
                    } else {
                        int i8 = z2 ? i6 + 1 : i6;
                        int i9 = i8 + 1;
                        try {
                            int charAt2 = charSequence.charAt(i8) - '0';
                            i4 = i7 + i6;
                            while (i9 < i4) {
                                i9++;
                                charAt2 = (((charAt2 << 3) + (charAt2 << 1)) + charSequence.charAt(i9)) - 48;
                            }
                            i5 = z2 ? -charAt2 : charAt2;
                        } catch (StringIndexOutOfBoundsException unused) {
                            return ~i6;
                        }
                    }
                    eVar.a(this.f10871a, i5);
                    return i4;
                }
                i2 = i6;
            } else if (Math.min(2, length) < 2) {
                return ~i2;
            }
            char charAt3 = charSequence.charAt(i2);
            if (charAt3 < '0' || charAt3 > '9') {
                return ~i2;
            }
            int i10 = charAt3 - '0';
            char charAt4 = charSequence.charAt(i2 + 1);
            if (charAt4 < '0' || charAt4 > '9') {
                return ~i2;
            }
            int i11 = (((i10 << 3) + (i10 << 1)) + charAt4) - 48;
            int i12 = this.f10872b;
            if (eVar.d() != null) {
                i12 = eVar.d().intValue();
            }
            int i13 = i12 - 50;
            int i14 = 100;
            if (i13 >= 0) {
                i3 = i13 % 100;
            } else {
                i3 = ((i13 + 1) % 100) + 99;
            }
            if (i11 >= i3) {
                i14 = 0;
            }
            eVar.a(this.f10871a, i11 + ((i13 + i14) - i3));
            return i2 + 2;
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            int a2 = a(j2, aVar);
            if (a2 < 0) {
                appendable.append(65533);
                appendable.append(65533);
                return;
            }
            i.a(appendable, a2, 2);
        }

        private int a(long j2, org.joda.time.a aVar) {
            try {
                int a2 = this.f10871a.a(aVar).a(j2);
                if (a2 < 0) {
                    a2 = -a2;
                }
                return a2 % 100;
            } catch (RuntimeException unused) {
                return -1;
            }
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
            int a2 = a(tVar);
            if (a2 < 0) {
                appendable.append(65533);
                appendable.append(65533);
                return;
            }
            i.a(appendable, a2, 2);
        }

        private int a(t tVar) {
            if (tVar.a(this.f10871a)) {
                try {
                    int b2 = tVar.b(this.f10871a);
                    if (b2 < 0) {
                        b2 = -b2;
                    }
                    return b2 % 100;
                } catch (RuntimeException unused) {
                }
            }
            return -1;
        }
    }

    /* compiled from: DateTimeFormatterBuilder */
    static class n extends f {
        protected n(org.joda.time.d dVar, int i2, boolean z) {
            super(dVar, i2, z);
        }

        public void a(Appendable appendable, long j2, org.joda.time.a aVar, int i2, org.joda.time.g gVar, Locale locale) throws IOException {
            try {
                i.a(appendable, this.f10849a.a(aVar).a(j2));
            } catch (RuntimeException unused) {
                appendable.append(65533);
            }
        }

        public int b() {
            return this.f10850b;
        }

        public void a(Appendable appendable, t tVar, Locale locale) throws IOException {
            if (tVar.a(this.f10849a)) {
                try {
                    i.a(appendable, tVar.b(this.f10849a));
                } catch (RuntimeException unused) {
                    appendable.append(65533);
                }
            } else {
                appendable.append(65533);
            }
        }
    }

    private void c(d dVar) {
        if (dVar == null) {
            throw new IllegalArgumentException("No parser supplied");
        }
    }

    public c a(b bVar) {
        if (bVar != null) {
            a(bVar.d(), bVar.c());
            return this;
        }
        throw new IllegalArgumentException("No formatter supplied");
    }

    public c b(d dVar) {
        c(dVar);
        a((m) null, (k) new e(new k[]{f.a(dVar), null}));
        return this;
    }

    public c d(int i2, int i3) {
        b(org.joda.time.d.O(), i2, i3);
        return this;
    }

    public c e(int i2) {
        a(org.joda.time.d.C(), i2, 3);
        return this;
    }

    public c f(int i2) {
        a(org.joda.time.d.H(), i2, 2);
        return this;
    }

    public c g(int i2) {
        a(org.joda.time.d.I(), i2, 2);
        return this;
    }

    public c h(int i2) {
        a(org.joda.time.d.M(), i2, 2);
        return this;
    }

    public b i() {
        Object k2 = k();
        k kVar = null;
        m mVar = c(k2) ? (m) k2 : null;
        if (b(k2)) {
            kVar = (k) k2;
        }
        if (mVar != null || kVar != null) {
            return new b(mVar, kVar);
        }
        throw new UnsupportedOperationException("Both printing and parsing not supported");
    }

    public d j() {
        Object k2 = k();
        if (b(k2)) {
            return l.a((k) k2);
        }
        throw new UnsupportedOperationException("Parsing is not supported");
    }

    public c k(int i2) {
        a(org.joda.time.d.Q(), i2, 2);
        return this;
    }

    private Object k() {
        Object obj = this.f10838b;
        if (obj == null) {
            if (this.f10837a.size() == 2) {
                Object obj2 = this.f10837a.get(0);
                Object obj3 = this.f10837a.get(1);
                if (obj2 == null) {
                    obj = obj3;
                } else if (obj2 == obj3 || obj3 == null) {
                    obj = obj2;
                }
            }
            if (obj == null) {
                obj = new b(this.f10837a);
            }
            this.f10838b = obj;
        }
        return obj;
    }

    public c c(org.joda.time.d dVar, int i2, int i3) {
        if (dVar != null) {
            if (i3 < i2) {
                i3 = i2;
            }
            if (i2 < 0 || i3 <= 0) {
                throw new IllegalArgumentException();
            } else if (i2 <= 1) {
                a((Object) new n(dVar, i3, true));
                return this;
            } else {
                a((Object) new g(dVar, i3, true, i2));
                return this;
            }
        } else {
            throw new IllegalArgumentException("Field type must not be null");
        }
    }

    public c d(int i2) {
        a(org.joda.time.d.B(), i2, 1);
        return this;
    }

    public c e(int i2, int i3) {
        c(org.joda.time.d.R(), i2, i3);
        return this;
    }

    public c f(int i2, int i3) {
        c(org.joda.time.d.T(), i2, i3);
        return this;
    }

    public c g(int i2, int i3) {
        a(org.joda.time.d.V(), i2, i3);
        return this;
    }

    public c h() {
        a((m) new k(0, null), (k) null);
        return this;
    }

    public c a(d dVar) {
        c(dVar);
        a((m) null, f.a(dVar));
        return this;
    }

    public c d() {
        b(org.joda.time.d.G());
        return this;
    }

    public c e() {
        a(org.joda.time.d.N());
        return this;
    }

    public c f() {
        b(org.joda.time.d.N());
        return this;
    }

    public c g() {
        j jVar = j.INSTANCE;
        a((m) jVar, (k) jVar);
        return this;
    }

    public c b(org.joda.time.d dVar) {
        if (dVar != null) {
            a((Object) new i(dVar, false));
            return this;
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public c a(g gVar, d[] dVarArr) {
        if (gVar != null) {
            a(gVar);
        }
        if (dVarArr != null) {
            int length = dVarArr.length;
            int i2 = 0;
            if (length != 1) {
                k[] kVarArr = new k[length];
                while (i2 < length - 1) {
                    k a2 = f.a(dVarArr[i2]);
                    kVarArr[i2] = a2;
                    if (a2 != null) {
                        i2++;
                    } else {
                        throw new IllegalArgumentException("Incomplete parser array");
                    }
                }
                kVarArr[i2] = f.a(dVarArr[i2]);
                a(h.a(gVar), (k) new e(kVarArr));
                return this;
            } else if (dVarArr[0] != null) {
                a(h.a(gVar), f.a(dVarArr[0]));
                return this;
            } else {
                throw new IllegalArgumentException("No parser supplied");
            }
        } else {
            throw new IllegalArgumentException("No parsers supplied");
        }
    }

    public c b(org.joda.time.d dVar, int i2, int i3) {
        if (dVar != null) {
            if (i3 < i2) {
                i3 = i2;
            }
            if (i2 < 0 || i3 <= 0) {
                throw new IllegalArgumentException();
            }
            a((Object) new d(dVar, i2, i3));
            return this;
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public c c(int i2, int i3) {
        b(org.joda.time.d.L(), i2, i3);
        return this;
    }

    public c j(int i2) {
        a(org.joda.time.d.P(), i2, 2);
        return this;
    }

    public c c(int i2) {
        a(org.joda.time.d.A(), i2, 2);
        return this;
    }

    public c c() {
        b(org.joda.time.d.D());
        return this;
    }

    public c i(int i2) {
        a(org.joda.time.d.N(), i2, 2);
        return this;
    }

    private boolean c(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        if (obj instanceof b) {
            return ((b) obj).d();
        }
        return true;
    }

    public c b(int i2, int i3) {
        b(org.joda.time.d.H(), i2, i3);
        return this;
    }

    public c b(int i2) {
        a(org.joda.time.d.z(), i2, 2);
        return this;
    }

    public c b(int i2, boolean z) {
        a((Object) new m(org.joda.time.d.T(), i2, z));
        return this;
    }

    public c b() {
        b(org.joda.time.d.B());
        return this;
    }

    private boolean b(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj instanceof b) {
            return ((b) obj).c();
        }
        return true;
    }

    private void a(g gVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("No printer supplied");
        }
    }

    static boolean b(CharSequence charSequence, int i2, String str) {
        int length = str.length();
        if (charSequence.length() - i2 < length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = charSequence.charAt(i2 + i3);
            char charAt2 = str.charAt(i3);
            if (charAt != charAt2) {
                char upperCase = Character.toUpperCase(charAt);
                char upperCase2 = Character.toUpperCase(charAt2);
                if (!(upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2))) {
                    return false;
                }
            }
        }
        return true;
    }

    private c a(Object obj) {
        this.f10838b = null;
        this.f10837a.add(obj);
        this.f10837a.add(obj);
        return this;
    }

    private c a(m mVar, k kVar) {
        this.f10838b = null;
        this.f10837a.add(mVar);
        this.f10837a.add(kVar);
        return this;
    }

    public c a(char c2) {
        a((Object) new a(c2));
        return this;
    }

    public c a(String str) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                if (length != 1) {
                    a((Object) new h(str));
                    return this;
                }
                a((Object) new a(str.charAt(0)));
            }
            return this;
        }
        throw new IllegalArgumentException("Literal must not be null");
    }

    public c a(org.joda.time.d dVar, int i2, int i3) {
        if (dVar != null) {
            if (i3 < i2) {
                i3 = i2;
            }
            if (i2 < 0 || i3 <= 0) {
                throw new IllegalArgumentException();
            } else if (i2 <= 1) {
                a((Object) new n(dVar, i3, false));
                return this;
            } else {
                a((Object) new g(dVar, i3, false, i2));
                return this;
            }
        } else {
            throw new IllegalArgumentException("Field type must not be null");
        }
    }

    public c a(org.joda.time.d dVar, int i2) {
        if (dVar == null) {
            throw new IllegalArgumentException("Field type must not be null");
        } else if (i2 > 0) {
            a((Object) new C0125c(dVar, i2, false));
            return this;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal number of digits: ");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public c a(org.joda.time.d dVar) {
        if (dVar != null) {
            a((Object) new i(dVar, true));
            return this;
        }
        throw new IllegalArgumentException("Field type must not be null");
    }

    public c a(int i2) {
        a(org.joda.time.d.y(), i2, 2);
        return this;
    }

    public c a(int i2, boolean z) {
        a((Object) new m(org.joda.time.d.R(), i2, z));
        return this;
    }

    public c a(int i2, int i3) {
        c(org.joda.time.d.x(), i2, i3);
        return this;
    }

    public c a() {
        a(org.joda.time.d.B());
        return this;
    }

    public c a(Map<String, org.joda.time.g> map) {
        k kVar = new k(1, map);
        a((m) kVar, (k) kVar);
        return this;
    }

    public c a(String str, boolean z, int i2, int i3) {
        l lVar = new l(str, str, z, i2, i3);
        a((Object) lVar);
        return this;
    }

    public c a(String str, String str2, boolean z, int i2, int i3) {
        l lVar = new l(str, str2, z, i2, i3);
        a((Object) lVar);
        return this;
    }

    static void a(Appendable appendable, int i2) throws IOException {
        while (true) {
            i2--;
            if (i2 >= 0) {
                appendable.append(65533);
            } else {
                return;
            }
        }
    }

    static boolean a(CharSequence charSequence, int i2, String str) {
        int length = str.length();
        if (charSequence.length() - i2 < length) {
            return false;
        }
        for (int i3 = 0; i3 < length; i3++) {
            if (charSequence.charAt(i2 + i3) != str.charAt(i3)) {
                return false;
            }
        }
        return true;
    }
}
