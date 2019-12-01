package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;
import com.google.android.gms.internal.measurement.Eb.d;

public final class M extends Eb<M, a> implements C0412oc {
    private static volatile C0447uc<M> zzuo;
    /* access modifiers changed from: private */
    public static final M zzwa = new M();
    private int zzue;
    private String zzvy;
    private String zzvz;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<M, a> implements C0412oc {
        private a() {
            super(M.zzwa);
        }

        /* synthetic */ a(L l2) {
            this();
        }
    }

    static {
        Eb.a(M.class, zzwa);
    }

    private M() {
        String str = "";
        this.zzvy = str;
        this.zzvz = str;
    }

    public static C0447uc<M> q() {
        return (C0447uc) zzwa.a(d.f4921g, null, null);
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (L.f4984a[i2 - 1]) {
            case 1:
                return new M();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzwa, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzue", "zzvy", "zzvz"});
            case 4:
                return zzwa;
            case 5:
                C0447uc<M> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (M.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzwa);
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

    public final String o() {
        return this.zzvy;
    }

    public final String p() {
        return this.zzvz;
    }
}
