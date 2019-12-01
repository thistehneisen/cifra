package org.joda.time;

import java.io.Serializable;

/* compiled from: DateTimeFieldType */
public abstract class d implements Serializable {
    /* access modifiers changed from: private */

    /* renamed from: a reason: collision with root package name */
    public static final d f10788a = new a("era", 1, i.c(), null);
    /* access modifiers changed from: private */

    /* renamed from: b reason: collision with root package name */
    public static final d f10789b = new a("yearOfEra", 2, i.m(), i.c());
    /* access modifiers changed from: private */

    /* renamed from: c reason: collision with root package name */
    public static final d f10790c = new a("centuryOfEra", 3, i.a(), i.c());
    /* access modifiers changed from: private */

    /* renamed from: d reason: collision with root package name */
    public static final d f10791d = new a("yearOfCentury", 4, i.m(), i.a());
    /* access modifiers changed from: private */

    /* renamed from: e reason: collision with root package name */
    public static final d f10792e = new a("year", 5, i.m(), null);
    /* access modifiers changed from: private */

    /* renamed from: f reason: collision with root package name */
    public static final d f10793f = new a("dayOfYear", 6, i.b(), i.m());
    /* access modifiers changed from: private */

    /* renamed from: g reason: collision with root package name */
    public static final d f10794g = new a("monthOfYear", 7, i.i(), i.m());
    /* access modifiers changed from: private */

    /* renamed from: h reason: collision with root package name */
    public static final d f10795h = new a("dayOfMonth", 8, i.b(), i.i());
    /* access modifiers changed from: private */

    /* renamed from: i reason: collision with root package name */
    public static final d f10796i = new a("weekyearOfCentury", 9, i.l(), i.a());
    /* access modifiers changed from: private */

    /* renamed from: j reason: collision with root package name */
    public static final d f10797j = new a("weekyear", 10, i.l(), null);
    /* access modifiers changed from: private */

    /* renamed from: k reason: collision with root package name */
    public static final d f10798k = new a("weekOfWeekyear", 11, i.k(), i.l());
    /* access modifiers changed from: private */

    /* renamed from: l reason: collision with root package name */
    public static final d f10799l = new a("dayOfWeek", 12, i.b(), i.k());
    /* access modifiers changed from: private */
    public static final d m = new a("halfdayOfDay", 13, i.e(), i.b());
    /* access modifiers changed from: private */
    public static final d n = new a("hourOfHalfday", 14, i.f(), i.e());
    /* access modifiers changed from: private */
    public static final d o = new a("clockhourOfHalfday", 15, i.f(), i.e());
    /* access modifiers changed from: private */
    public static final d p = new a("clockhourOfDay", 16, i.f(), i.b());
    /* access modifiers changed from: private */
    public static final d q = new a("hourOfDay", 17, i.f(), i.b());
    /* access modifiers changed from: private */
    public static final d r = new a("minuteOfDay", 18, i.h(), i.b());
    /* access modifiers changed from: private */
    public static final d s = new a("minuteOfHour", 19, i.h(), i.f());
    private static final long serialVersionUID = -42615285973990L;
    /* access modifiers changed from: private */
    public static final d t = new a("secondOfDay", 20, i.j(), i.b());
    /* access modifiers changed from: private */
    public static final d u = new a("secondOfMinute", 21, i.j(), i.h());
    /* access modifiers changed from: private */
    public static final d v = new a("millisOfDay", 22, i.g(), i.b());
    /* access modifiers changed from: private */
    public static final d w = new a("millisOfSecond", 23, i.g(), i.j());
    private final String iName;

    /* compiled from: DateTimeFieldType */
    private static class a extends d {
        private static final long serialVersionUID = -9937958251642L;
        private final byte iOrdinal;
        private final transient i x;
        private final transient i y;

        a(String str, byte b2, i iVar, i iVar2) {
            super(str);
            this.iOrdinal = b2;
            this.x = iVar;
            this.y = iVar2;
        }

        private Object readResolve() {
            switch (this.iOrdinal) {
                case 1:
                    return d.f10788a;
                case 2:
                    return d.f10789b;
                case 3:
                    return d.f10790c;
                case 4:
                    return d.f10791d;
                case 5:
                    return d.f10792e;
                case 6:
                    return d.f10793f;
                case 7:
                    return d.f10794g;
                case 8:
                    return d.f10795h;
                case 9:
                    return d.f10796i;
                case 10:
                    return d.f10797j;
                case 11:
                    return d.f10798k;
                case 12:
                    return d.f10799l;
                case 13:
                    return d.m;
                case 14:
                    return d.n;
                case 15:
                    return d.o;
                case 16:
                    return d.p;
                case 17:
                    return d.q;
                case 18:
                    return d.r;
                case 19:
                    return d.s;
                case 20:
                    return d.t;
                case 21:
                    return d.u;
                case 22:
                    return d.v;
                case 23:
                    return d.w;
                default:
                    return this;
            }
        }

        public i E() {
            return this.x;
        }

        public c a(a aVar) {
            a a2 = e.a(aVar);
            switch (this.iOrdinal) {
                case 1:
                    return a2.i();
                case 2:
                    return a2.J();
                case 3:
                    return a2.b();
                case 4:
                    return a2.I();
                case 5:
                    return a2.H();
                case 6:
                    return a2.g();
                case 7:
                    return a2.w();
                case 8:
                    return a2.e();
                case 9:
                    return a2.E();
                case 10:
                    return a2.D();
                case 11:
                    return a2.B();
                case 12:
                    return a2.f();
                case 13:
                    return a2.l();
                case 14:
                    return a2.o();
                case 15:
                    return a2.d();
                case 16:
                    return a2.c();
                case 17:
                    return a2.n();
                case 18:
                    return a2.t();
                case 19:
                    return a2.u();
                case 20:
                    return a2.y();
                case 21:
                    return a2.z();
                case 22:
                    return a2.r();
                case 23:
                    return a2.s();
                default:
                    throw new InternalError();
            }
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            if (this.iOrdinal != ((a) obj).iOrdinal) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return 1 << this.iOrdinal;
        }
    }

    protected d(String str) {
        this.iName = str;
    }

    public static d A() {
        return f10795h;
    }

    public static d B() {
        return f10799l;
    }

    public static d C() {
        return f10793f;
    }

    public static d D() {
        return f10788a;
    }

    public static d G() {
        return m;
    }

    public static d H() {
        return q;
    }

    public static d I() {
        return n;
    }

    public static d J() {
        return v;
    }

    public static d K() {
        return w;
    }

    public static d L() {
        return r;
    }

    public static d M() {
        return s;
    }

    public static d N() {
        return f10794g;
    }

    public static d O() {
        return t;
    }

    public static d P() {
        return u;
    }

    public static d Q() {
        return f10798k;
    }

    public static d R() {
        return f10797j;
    }

    public static d S() {
        return f10796i;
    }

    public static d T() {
        return f10792e;
    }

    public static d U() {
        return f10791d;
    }

    public static d V() {
        return f10789b;
    }

    public static d x() {
        return f10790c;
    }

    public static d y() {
        return p;
    }

    public static d z() {
        return o;
    }

    public abstract i E();

    public String F() {
        return this.iName;
    }

    public abstract c a(a aVar);

    public String toString() {
        return F();
    }
}
