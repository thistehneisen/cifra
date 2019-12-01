package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;

public final class S extends Eb<S, a> implements C0412oc {
    private static volatile C0447uc<S> zzuo;
    /* access modifiers changed from: private */
    public static final S zzwq = new S();
    private int zzue;
    private String zzwk = "";
    private long zzwp;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<S, a> implements C0412oc {
        private a() {
            super(S.zzwq);
        }

        /* synthetic */ a(N n) {
            this();
        }
    }

    static {
        Eb.a(S.class, zzwq);
    }

    private S() {
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new S();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzwq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zzue", "zzwk", "zzwp"});
            case 4:
                return zzwq;
            case 5:
                C0447uc<S> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (S.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzwq);
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
