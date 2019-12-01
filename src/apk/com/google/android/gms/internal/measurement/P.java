package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;

public final class P extends Eb<P, a> implements C0412oc {
    private static volatile C0447uc<P> zzuo;
    /* access modifiers changed from: private */
    public static final P zzwi = new P();
    private int zzue;
    private int zzwg;
    private long zzwh;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<P, a> implements C0412oc {
        private a() {
            super(P.zzwi);
        }

        public final a a(int i2) {
            g();
            ((P) this.f4912b).b(i2);
            return this;
        }

        /* synthetic */ a(N n) {
            this();
        }

        public final a a(long j2) {
            g();
            ((P) this.f4912b).a(j2);
            return this;
        }
    }

    static {
        Eb.a(P.class, zzwi);
    }

    private P() {
    }

    /* access modifiers changed from: private */
    public final void a(long j2) {
        this.zzue |= 2;
        this.zzwh = j2;
    }

    /* access modifiers changed from: private */
    public final void b(int i2) {
        this.zzue |= 1;
        this.zzwg = i2;
    }

    public static a s() {
        return (a) zzwi.j();
    }

    public final int o() {
        return this.zzwg;
    }

    public final boolean p() {
        return (this.zzue & 1) != 0;
    }

    public final boolean q() {
        return (this.zzue & 2) != 0;
    }

    public final long r() {
        return this.zzwh;
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new P();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzwi, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0002\u0001", new Object[]{"zzue", "zzwg", "zzwh"});
            case 4:
                return zzwi;
            case 5:
                C0447uc<P> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (P.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzwi);
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
