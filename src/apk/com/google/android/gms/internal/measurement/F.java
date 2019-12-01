package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;
import com.google.android.gms.internal.measurement.Eb.d;

public final class F extends Eb<F, a> implements C0412oc {
    private static volatile C0447uc<F> zzuo;
    /* access modifiers changed from: private */
    public static final F zzvj = new F();
    private int zzue;
    private int zzuf;
    private boolean zzuk;
    private boolean zzul;
    private boolean zzum;
    private String zzvh = "";
    private D zzvi;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<F, a> implements C0412oc {
        private a() {
            super(F.zzvj);
        }

        public final a a(String str) {
            g();
            ((F) this.f4912b).a(str);
            return this;
        }

        /* synthetic */ a(B b2) {
            this();
        }
    }

    static {
        Eb.a(F.class, zzvj);
    }

    private F() {
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (str != null) {
            this.zzue |= 2;
            this.zzvh = str;
            return;
        }
        throw new NullPointerException();
    }

    public static C0447uc<F> v() {
        return (C0447uc) zzvj.a(d.f4921g, null, null);
    }

    public final int o() {
        return this.zzuf;
    }

    public final String p() {
        return this.zzvh;
    }

    public final boolean q() {
        return (this.zzue & 1) != 0;
    }

    public final boolean r() {
        return this.zzuk;
    }

    public final boolean s() {
        return this.zzul;
    }

    public final boolean t() {
        return (this.zzue & 32) != 0;
    }

    public final boolean u() {
        return this.zzum;
    }

    public final D w() {
        D d2 = this.zzvi;
        return d2 == null ? D.v() : d2;
    }

    public static F a(byte[] bArr, C0428rb rbVar) throws zzfi {
        return (F) Eb.a(zzvj, bArr, rbVar);
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (B.f4859a[i2 - 1]) {
            case 1:
                return new F();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzvj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\t\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzue", "zzuf", "zzvh", "zzvi", "zzuk", "zzul", "zzum"});
            case 4:
                return zzvj;
            case 5:
                C0447uc<F> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (F.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzvj);
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
