package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;

public final class D extends Eb<D, a> implements C0412oc {
    private static volatile C0447uc<D> zzuo;
    /* access modifiers changed from: private */
    public static final D zzut = new D();
    private int zzue;
    private G zzup;
    private E zzuq;
    private boolean zzur;
    private String zzus = "";

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<D, a> implements C0412oc {
        private a() {
            super(D.zzut);
        }

        public final a a(String str) {
            g();
            ((D) this.f4912b).a(str);
            return this;
        }

        /* synthetic */ a(B b2) {
            this();
        }
    }

    static {
        Eb.a(D.class, zzut);
    }

    private D() {
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (str != null) {
            this.zzue |= 8;
            this.zzus = str;
            return;
        }
        throw new NullPointerException();
    }

    public static D v() {
        return zzut;
    }

    public final boolean o() {
        return (this.zzue & 1) != 0;
    }

    public final G p() {
        G g2 = this.zzup;
        return g2 == null ? G.w() : g2;
    }

    public final boolean q() {
        return (this.zzue & 2) != 0;
    }

    public final E r() {
        E e2 = this.zzuq;
        return e2 == null ? E.B() : e2;
    }

    public final boolean s() {
        return (this.zzue & 4) != 0;
    }

    public final boolean t() {
        return this.zzur;
    }

    public final String u() {
        return this.zzus;
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (B.f4859a[i2 - 1]) {
            case 1:
                return new D();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzut, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u0007\u0002\u0004\b\u0003", new Object[]{"zzue", "zzup", "zzuq", "zzur", "zzus"});
            case 4:
                return zzut;
            case 5:
                C0447uc<D> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (D.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzut);
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
