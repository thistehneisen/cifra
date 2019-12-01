package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;

public final class T extends Eb<T, a> implements C0412oc {
    private static volatile C0447uc<T> zzuo;
    /* access modifiers changed from: private */
    public static final T zzwu = new T();
    private int zzue;
    private String zzwk;
    private long zzwp;
    private String zzwr;
    private float zzws;
    private double zzwt;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<T, a> implements C0412oc {
        private a() {
            super(T.zzwu);
        }

        public final a a(String str) {
            g();
            ((T) this.f4912b).a(str);
            return this;
        }

        public final a b(String str) {
            g();
            ((T) this.f4912b).b(str);
            return this;
        }

        public final a j() {
            g();
            ((T) this.f4912b).x();
            return this;
        }

        public final a k() {
            g();
            ((T) this.f4912b).B();
            return this;
        }

        public final a l() {
            g();
            ((T) this.f4912b).C();
            return this;
        }

        /* synthetic */ a(N n) {
            this();
        }

        public final a a(long j2) {
            g();
            ((T) this.f4912b).a(j2);
            return this;
        }

        public final a a(double d2) {
            g();
            ((T) this.f4912b).a(d2);
            return this;
        }
    }

    static {
        Eb.a(T.class, zzwu);
    }

    private T() {
        String str = "";
        this.zzwk = str;
        this.zzwr = str;
    }

    /* access modifiers changed from: private */
    public final void B() {
        this.zzue &= -5;
        this.zzwp = 0;
    }

    /* access modifiers changed from: private */
    public final void C() {
        this.zzue &= -17;
        this.zzwt = 0.0d;
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (str != null) {
            this.zzue |= 1;
            this.zzwk = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        if (str != null) {
            this.zzue |= 2;
            this.zzwr = str;
            return;
        }
        throw new NullPointerException();
    }

    public static a v() {
        return (a) zzwu.j();
    }

    /* access modifiers changed from: private */
    public final void x() {
        this.zzue &= -3;
        this.zzwr = zzwu.zzwr;
    }

    public final String o() {
        return this.zzwk;
    }

    public final boolean p() {
        return (this.zzue & 2) != 0;
    }

    public final String q() {
        return this.zzwr;
    }

    public final boolean r() {
        return (this.zzue & 4) != 0;
    }

    public final long s() {
        return this.zzwp;
    }

    public final boolean t() {
        return (this.zzue & 16) != 0;
    }

    public final double u() {
        return this.zzwt;
    }

    /* access modifiers changed from: private */
    public final void a(long j2) {
        this.zzue |= 4;
        this.zzwp = j2;
    }

    /* access modifiers changed from: private */
    public final void a(double d2) {
        this.zzue |= 16;
        this.zzwt = d2;
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new T();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzwu, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0001\u0003\u0005\u0000\u0004", new Object[]{"zzue", "zzwk", "zzwr", "zzwp", "zzws", "zzwt"});
            case 4:
                return zzwu;
            case 5:
                C0447uc<T> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (T.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzwu);
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
}
