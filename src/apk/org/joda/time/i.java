package org.joda.time;

import java.io.Serializable;

/* compiled from: DurationFieldType */
public abstract class i implements Serializable {

    /* renamed from: a reason: collision with root package name */
    static final i f10945a = new a("eras", 1);

    /* renamed from: b reason: collision with root package name */
    static final i f10946b = new a("centuries", 2);

    /* renamed from: c reason: collision with root package name */
    static final i f10947c = new a("weekyears", 3);

    /* renamed from: d reason: collision with root package name */
    static final i f10948d = new a("years", 4);

    /* renamed from: e reason: collision with root package name */
    static final i f10949e = new a("months", 5);

    /* renamed from: f reason: collision with root package name */
    static final i f10950f = new a("weeks", 6);

    /* renamed from: g reason: collision with root package name */
    static final i f10951g = new a("days", 7);

    /* renamed from: h reason: collision with root package name */
    static final i f10952h = new a("halfdays", 8);

    /* renamed from: i reason: collision with root package name */
    static final i f10953i = new a("hours", 9);

    /* renamed from: j reason: collision with root package name */
    static final i f10954j = new a("minutes", 10);

    /* renamed from: k reason: collision with root package name */
    static final i f10955k = new a("seconds", 11);

    /* renamed from: l reason: collision with root package name */
    static final i f10956l = new a("millis", 12);
    private static final long serialVersionUID = 8765135187319L;
    private final String iName;

    /* compiled from: DurationFieldType */
    private static class a extends i {
        private static final long serialVersionUID = 31156755687123L;
        private final byte iOrdinal;

        a(String str, byte b2) {
            super(str);
            this.iOrdinal = b2;
        }

        private Object readResolve() {
            switch (this.iOrdinal) {
                case 1:
                    return i.f10945a;
                case 2:
                    return i.f10946b;
                case 3:
                    return i.f10947c;
                case 4:
                    return i.f10948d;
                case 5:
                    return i.f10949e;
                case 6:
                    return i.f10950f;
                case 7:
                    return i.f10951g;
                case 8:
                    return i.f10952h;
                case 9:
                    return i.f10953i;
                case 10:
                    return i.f10954j;
                case 11:
                    return i.f10955k;
                case 12:
                    return i.f10956l;
                default:
                    return this;
            }
        }

        public h a(a aVar) {
            a a2 = e.a(aVar);
            switch (this.iOrdinal) {
                case 1:
                    return a2.j();
                case 2:
                    return a2.a();
                case 3:
                    return a2.F();
                case 4:
                    return a2.K();
                case 5:
                    return a2.x();
                case 6:
                    return a2.C();
                case 7:
                    return a2.h();
                case 8:
                    return a2.m();
                case 9:
                    return a2.p();
                case 10:
                    return a2.v();
                case 11:
                    return a2.A();
                case 12:
                    return a2.q();
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

    protected i(String str) {
        this.iName = str;
    }

    public static i a() {
        return f10946b;
    }

    public static i b() {
        return f10951g;
    }

    public static i c() {
        return f10945a;
    }

    public static i e() {
        return f10952h;
    }

    public static i f() {
        return f10953i;
    }

    public static i g() {
        return f10956l;
    }

    public static i h() {
        return f10954j;
    }

    public static i i() {
        return f10949e;
    }

    public static i j() {
        return f10955k;
    }

    public static i k() {
        return f10950f;
    }

    public static i l() {
        return f10947c;
    }

    public static i m() {
        return f10948d;
    }

    public abstract h a(a aVar);

    public String d() {
        return this.iName;
    }

    public String toString() {
        return d();
    }
}
