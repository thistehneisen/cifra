package org.joda.time.e;

import java.util.Arrays;
import java.util.Locale;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.c;
import org.joda.time.d;
import org.joda.time.g;
import org.joda.time.h;
import org.joda.time.i;

/* compiled from: DateTimeParserBucket */
public class e {

    /* renamed from: a reason: collision with root package name */
    private final org.joda.time.a f10874a;

    /* renamed from: b reason: collision with root package name */
    private final long f10875b;

    /* renamed from: c reason: collision with root package name */
    private final Locale f10876c;

    /* renamed from: d reason: collision with root package name */
    private final int f10877d;

    /* renamed from: e reason: collision with root package name */
    private final g f10878e;

    /* renamed from: f reason: collision with root package name */
    private final Integer f10879f;
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public g f10880g;
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public Integer f10881h;

    /* renamed from: i reason: collision with root package name */
    private Integer f10882i;
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public a[] f10883j;
    /* access modifiers changed from: private */

    /* renamed from: k reason: collision with root package name */
    public int f10884k;
    /* access modifiers changed from: private */

    /* renamed from: l reason: collision with root package name */
    public boolean f10885l;
    private Object m;

    /* compiled from: DateTimeParserBucket */
    static class a implements Comparable<a> {

        /* renamed from: a reason: collision with root package name */
        c f10886a;

        /* renamed from: b reason: collision with root package name */
        int f10887b;

        /* renamed from: c reason: collision with root package name */
        String f10888c;

        /* renamed from: d reason: collision with root package name */
        Locale f10889d;

        a() {
        }

        /* access modifiers changed from: 0000 */
        public void a(c cVar, int i2) {
            this.f10886a = cVar;
            this.f10887b = i2;
            this.f10888c = null;
            this.f10889d = null;
        }

        /* access modifiers changed from: 0000 */
        public void a(c cVar, String str, Locale locale) {
            this.f10886a = cVar;
            this.f10887b = 0;
            this.f10888c = str;
            this.f10889d = locale;
        }

        /* access modifiers changed from: 0000 */
        public long a(long j2, boolean z) {
            long j3;
            String str = this.f10888c;
            if (str == null) {
                j3 = this.f10886a.c(j2, this.f10887b);
            } else {
                j3 = this.f10886a.a(j2, str, this.f10889d);
            }
            return z ? this.f10886a.e(j3) : j3;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            c cVar = aVar.f10886a;
            int a2 = e.a(this.f10886a.f(), cVar.f());
            if (a2 != 0) {
                return a2;
            }
            return e.a(this.f10886a.a(), cVar.a());
        }
    }

    /* compiled from: DateTimeParserBucket */
    class b {

        /* renamed from: a reason: collision with root package name */
        final g f10890a;

        /* renamed from: b reason: collision with root package name */
        final Integer f10891b;

        /* renamed from: c reason: collision with root package name */
        final a[] f10892c;

        /* renamed from: d reason: collision with root package name */
        final int f10893d;

        b() {
            this.f10890a = e.this.f10880g;
            this.f10891b = e.this.f10881h;
            this.f10892c = e.this.f10883j;
            this.f10893d = e.this.f10884k;
        }

        /* access modifiers changed from: 0000 */
        public boolean a(e eVar) {
            if (eVar != e.this) {
                return false;
            }
            eVar.f10880g = this.f10890a;
            eVar.f10881h = this.f10891b;
            eVar.f10883j = this.f10892c;
            if (this.f10893d < eVar.f10884k) {
                eVar.f10885l = true;
            }
            eVar.f10884k = this.f10893d;
            return true;
        }
    }

    public e(long j2, org.joda.time.a aVar, Locale locale, Integer num, int i2) {
        org.joda.time.a a2 = org.joda.time.e.a(aVar);
        this.f10875b = j2;
        this.f10878e = a2.k();
        this.f10874a = a2.G();
        if (locale == null) {
            locale = Locale.getDefault();
        }
        this.f10876c = locale;
        this.f10877d = i2;
        this.f10879f = num;
        this.f10880g = this.f10878e;
        this.f10882i = this.f10879f;
        this.f10883j = new a[8];
    }

    private a g() {
        a[] aVarArr = this.f10883j;
        int i2 = this.f10884k;
        if (i2 == aVarArr.length || this.f10885l) {
            a[] aVarArr2 = new a[(i2 == aVarArr.length ? i2 * 2 : aVarArr.length)];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, i2);
            this.f10883j = aVarArr2;
            this.f10885l = false;
            aVarArr = aVarArr2;
        }
        this.m = null;
        a aVar = aVarArr[i2];
        if (aVar == null) {
            aVar = new a();
            aVarArr[i2] = aVar;
        }
        this.f10884k = i2 + 1;
        return aVar;
    }

    public g e() {
        return this.f10880g;
    }

    public Object f() {
        if (this.m == null) {
            this.m = new b();
        }
        return this.m;
    }

    public Locale b() {
        return this.f10876c;
    }

    public Integer c() {
        return this.f10881h;
    }

    public Integer d() {
        return this.f10882i;
    }

    /* access modifiers changed from: 0000 */
    public long a(k kVar, CharSequence charSequence) {
        int a2 = kVar.a(this, charSequence, 0);
        if (a2 < 0) {
            a2 = ~a2;
        } else if (a2 >= charSequence.length()) {
            return a(true, charSequence);
        }
        throw new IllegalArgumentException(i.a(charSequence.toString(), a2));
    }

    public org.joda.time.a a() {
        return this.f10874a;
    }

    public void a(g gVar) {
        this.m = null;
        this.f10880g = gVar;
    }

    public void a(Integer num) {
        this.m = null;
        this.f10881h = num;
    }

    public void a(c cVar, int i2) {
        g().a(cVar, i2);
    }

    public void a(d dVar, int i2) {
        g().a(dVar.a(this.f10874a), i2);
    }

    public void a(d dVar, String str, Locale locale) {
        g().a(dVar.a(this.f10874a), str, locale);
    }

    public boolean a(Object obj) {
        if (!(obj instanceof b) || !((b) obj).a(this)) {
            return false;
        }
        this.m = obj;
        return true;
    }

    public long a(boolean z, String str) {
        return a(z, (CharSequence) str);
    }

    public long a(boolean z, CharSequence charSequence) {
        String str;
        a[] aVarArr = this.f10883j;
        int i2 = this.f10884k;
        if (this.f10885l) {
            aVarArr = (a[]) aVarArr.clone();
            this.f10883j = aVarArr;
            this.f10885l = false;
        }
        a(aVarArr, i2);
        if (i2 > 0) {
            h a2 = i.i().a(this.f10874a);
            h a3 = i.b().a(this.f10874a);
            h a4 = aVarArr[0].f10886a.a();
            if (a(a4, a2) >= 0 && a(a4, a3) <= 0) {
                a(d.T(), this.f10877d);
                return a(z, charSequence);
            }
        }
        long j2 = this.f10875b;
        int i3 = 0;
        while (true) {
            str = "Cannot parse \"";
            if (i3 >= i2) {
                break;
            }
            try {
                j2 = aVarArr[i3].a(j2, z);
                i3++;
            } catch (IllegalFieldValueException e2) {
                if (charSequence != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(charSequence);
                    sb.append('\"');
                    e2.a(sb.toString());
                }
                throw e2;
            }
        }
        if (z) {
            int i4 = 0;
            while (i4 < i2) {
                if (!aVarArr[i4].f10886a.h()) {
                    j2 = aVarArr[i4].a(j2, i4 == i2 + -1);
                }
                i4++;
            }
        }
        Integer num = this.f10881h;
        if (num != null) {
            j2 -= (long) num.intValue();
        } else {
            g gVar = this.f10880g;
            if (gVar != null) {
                int d2 = gVar.d(j2);
                j2 -= (long) d2;
                if (d2 != this.f10880g.c(j2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Illegal instant due to time zone offset transition (");
                    sb2.append(this.f10880g);
                    sb2.append(')');
                    String sb3 = sb2.toString();
                    if (charSequence != null) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(str);
                        sb4.append(charSequence);
                        sb4.append("\": ");
                        sb4.append(sb3);
                        sb3 = sb4.toString();
                    }
                    throw new IllegalInstantException(sb3);
                }
            }
        }
        return j2;
    }

    private static void a(a[] aVarArr, int i2) {
        if (i2 > 10) {
            Arrays.sort(aVarArr, 0, i2);
            return;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = i3; i4 > 0; i4--) {
                int i5 = i4 - 1;
                if (aVarArr[i5].compareTo(aVarArr[i4]) <= 0) {
                    break;
                }
                a aVar = aVarArr[i4];
                aVarArr[i4] = aVarArr[i5];
                aVarArr[i5] = aVar;
            }
        }
    }

    static int a(h hVar, h hVar2) {
        if (hVar == null || !hVar.d()) {
            return (hVar2 == null || !hVar2.d()) ? 0 : -1;
        }
        if (hVar2 == null || !hVar2.d()) {
            return 1;
        }
        return -hVar.compareTo(hVar2);
    }
}
