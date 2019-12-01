package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;

public final class Z extends Eb<Z, a> implements C0412oc {
    private static volatile C0447uc<Z> zzuo;
    /* access modifiers changed from: private */
    public static final Z zzzd = new Z();
    private int zzue;
    private String zzwk;
    private long zzwp;
    private String zzwr;
    private float zzws;
    private double zzwt;
    private long zzzc;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<Z, a> implements C0412oc {
        private a() {
            super(Z.zzzd);
        }

        public final a a(long j2) {
            g();
            ((Z) this.f4912b).b(j2);
            return this;
        }

        public final a b(String str) {
            g();
            ((Z) this.f4912b).b(str);
            return this;
        }

        public final a j() {
            g();
            ((Z) this.f4912b).C();
            return this;
        }

        public final a k() {
            g();
            ((Z) this.f4912b).D();
            return this;
        }

        public final a l() {
            g();
            ((Z) this.f4912b).E();
            return this;
        }

        /* synthetic */ a(N n) {
            this();
        }

        public final a a(String str) {
            g();
            ((Z) this.f4912b).a(str);
            return this;
        }

        public final a b(long j2) {
            g();
            ((Z) this.f4912b).a(j2);
            return this;
        }

        public final a a(double d2) {
            g();
            ((Z) this.f4912b).a(d2);
            return this;
        }
    }

    static {
        Eb.a(Z.class, zzzd);
    }

    private Z() {
        String str = "";
        this.zzwk = str;
        this.zzwr = str;
    }

    /* access modifiers changed from: private */
    public final void C() {
        this.zzue &= -5;
        this.zzwr = zzzd.zzwr;
    }

    /* access modifiers changed from: private */
    public final void D() {
        this.zzue &= -9;
        this.zzwp = 0;
    }

    /* access modifiers changed from: private */
    public final void E() {
        this.zzue &= -33;
        this.zzwt = 0.0d;
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (str != null) {
            this.zzue |= 2;
            this.zzwk = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void b(long j2) {
        this.zzue |= 1;
        this.zzzc = j2;
    }

    public static a x() {
        return (a) zzzd.j();
    }

    public final String o() {
        return this.zzwk;
    }

    public final boolean p() {
        return (this.zzue & 4) != 0;
    }

    public final String q() {
        return this.zzwr;
    }

    public final boolean r() {
        return (this.zzue & 8) != 0;
    }

    public final long s() {
        return this.zzwp;
    }

    public final boolean t() {
        return (this.zzue & 32) != 0;
    }

    public final double u() {
        return this.zzwt;
    }

    public final boolean v() {
        return (this.zzue & 1) != 0;
    }

    public final long w() {
        return this.zzzc;
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        if (str != null) {
            this.zzue |= 4;
            this.zzwr = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void a(long j2) {
        this.zzue |= 8;
        this.zzwp = j2;
    }

    /* access modifiers changed from: private */
    public final void a(double d2) {
        this.zzue |= 32;
        this.zzwt = d2;
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new Z();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzzd, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0001\u0004\u0006\u0000\u0005", new Object[]{"zzue", "zzzc", "zzwk", "zzwr", "zzwp", "zzws", "zzwt"});
            case 4:
                return zzzd;
            case 5:
                C0447uc<Z> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (Z.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzzd);
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
