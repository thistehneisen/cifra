package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;

public final class E extends Eb<E, a> implements C0412oc {
    private static volatile C0447uc<E> zzuo;
    /* access modifiers changed from: private */
    public static final E zzuz = new E();
    private int zzue;
    private int zzuu;
    private boolean zzuv;
    private String zzuw;
    private String zzux;
    private String zzuy;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<E, a> implements C0412oc {
        private a() {
            super(E.zzuz);
        }

        /* synthetic */ a(B b2) {
            this();
        }
    }

    public enum b implements Jb {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);
        

        /* renamed from: f reason: collision with root package name */
        private static final Ib<b> f4909f = null;
        private final int value;

        static {
            f4909f = new H();
        }

        private b(int i2) {
            this.value = i2;
        }

        public static Lb a() {
            return I.f4966a;
        }

        public static b b(int i2) {
            if (i2 == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i2 == 1) {
                return LESS_THAN;
            }
            if (i2 == 2) {
                return GREATER_THAN;
            }
            if (i2 == 3) {
                return EQUAL;
            }
            if (i2 != 4) {
                return null;
            }
            return BETWEEN;
        }

        public final int o() {
            return this.value;
        }
    }

    static {
        Eb.a(E.class, zzuz);
    }

    private E() {
        String str = "";
        this.zzuw = str;
        this.zzux = str;
        this.zzuy = str;
    }

    public static E B() {
        return zzuz;
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (B.f4859a[i2 - 1]) {
            case 1:
                return new E();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzuz, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"zzue", "zzuu", b.a(), "zzuv", "zzuw", "zzux", "zzuy"});
            case 4:
                return zzuz;
            case 5:
                C0447uc<E> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (E.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzuz);
                            zzuo = ucVar;
                        }
                    }
                }
                return ucVar;
            case 6:
                return Byte.valueOf(1);
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final boolean o() {
        return (this.zzue & 1) != 0;
    }

    public final b p() {
        b b2 = b.b(this.zzuu);
        return b2 == null ? b.UNKNOWN_COMPARISON_TYPE : b2;
    }

    public final boolean q() {
        return (this.zzue & 2) != 0;
    }

    public final boolean r() {
        return this.zzuv;
    }

    public final boolean s() {
        return (this.zzue & 4) != 0;
    }

    public final String t() {
        return this.zzuw;
    }

    public final boolean u() {
        return (this.zzue & 8) != 0;
    }

    public final String v() {
        return this.zzux;
    }

    public final boolean w() {
        return (this.zzue & 16) != 0;
    }

    public final String x() {
        return this.zzuy;
    }
}
