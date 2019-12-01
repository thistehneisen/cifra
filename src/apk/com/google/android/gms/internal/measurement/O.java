package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;

public final class O extends Eb<O, a> implements C0412oc {
    private static volatile C0447uc<O> zzuo;
    /* access modifiers changed from: private */
    public static final O zzwf = new O();
    private int zzue;
    private int zzwb;
    private X zzwc;
    private X zzwd;
    private boolean zzwe;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<O, a> implements C0412oc {
        private a() {
            super(O.zzwf);
        }

        public final a a(int i2) {
            g();
            ((O) this.f4912b).b(i2);
            return this;
        }

        public final X j() {
            return ((O) this.f4912b).o();
        }

        public final boolean k() {
            return ((O) this.f4912b).p();
        }

        public final X l() {
            return ((O) this.f4912b).q();
        }

        /* synthetic */ a(N n) {
            this();
        }

        public final a a(com.google.android.gms.internal.measurement.X.a aVar) {
            g();
            ((O) this.f4912b).a(aVar);
            return this;
        }

        public final a a(X x) {
            g();
            ((O) this.f4912b).a(x);
            return this;
        }

        public final a a(boolean z) {
            g();
            ((O) this.f4912b).a(z);
            return this;
        }
    }

    static {
        Eb.a(O.class, zzwf);
    }

    private O() {
    }

    /* access modifiers changed from: private */
    public final void a(com.google.android.gms.internal.measurement.X.a aVar) {
        this.zzwc = (X) aVar.A();
        this.zzue |= 2;
    }

    /* access modifiers changed from: private */
    public final void b(int i2) {
        this.zzue |= 1;
        this.zzwb = i2;
    }

    public static a v() {
        return (a) zzwf.j();
    }

    public final X o() {
        X x = this.zzwc;
        return x == null ? X.x() : x;
    }

    public final boolean p() {
        return (this.zzue & 4) != 0;
    }

    public final X q() {
        X x = this.zzwd;
        return x == null ? X.x() : x;
    }

    public final boolean r() {
        return (this.zzue & 1) != 0;
    }

    public final int s() {
        return this.zzwb;
    }

    public final boolean t() {
        return (this.zzue & 8) != 0;
    }

    public final boolean u() {
        return this.zzwe;
    }

    /* access modifiers changed from: private */
    public final void a(X x) {
        if (x != null) {
            this.zzwd = x;
            this.zzue |= 4;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void a(boolean z) {
        this.zzue |= 8;
        this.zzwe = z;
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new O();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzwf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0007\u0003", new Object[]{"zzue", "zzwb", "zzwc", "zzwd", "zzwe"});
            case 4:
                return zzwf;
            case 5:
                C0447uc<O> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (O.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzwf);
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
