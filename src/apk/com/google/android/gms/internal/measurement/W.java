package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;

public final class W extends Eb<W, a> implements C0412oc {
    private static volatile C0447uc<W> zzuo;
    /* access modifiers changed from: private */
    public static final W zzyr = new W();
    private int zzue;
    private int zzyp = 1;
    private Mb<S> zzyq = Eb.n();

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<W, a> implements C0412oc {
        private a() {
            super(W.zzyr);
        }

        /* synthetic */ a(N n) {
            this();
        }
    }

    public enum b implements Jb {
        RADS(1),
        PROVISIONING(2);
        

        /* renamed from: c reason: collision with root package name */
        private static final Ib<b> f5070c = null;
        private final int value;

        static {
            f5070c = new C0323aa();
        }

        private b(int i2) {
            this.value = i2;
        }

        public static Lb a() {
            return C0330ba.f5127a;
        }

        public static b b(int i2) {
            if (i2 == 1) {
                return RADS;
            }
            if (i2 != 2) {
                return null;
            }
            return PROVISIONING;
        }

        public final int o() {
            return this.value;
        }
    }

    static {
        Eb.a(W.class, zzyr);
    }

    private W() {
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new W();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzyr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zzue", "zzyp", b.a(), "zzyq", S.class});
            case 4:
                return zzyr;
            case 5:
                C0447uc<W> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (W.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzyr);
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
