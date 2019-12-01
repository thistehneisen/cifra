package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;
import java.util.List;

public final class U extends Eb<U, a> implements C0412oc {
    private static volatile C0447uc<U> zzuo;
    /* access modifiers changed from: private */
    public static final U zzww = new U();
    private Mb<V> zzwv = Eb.n();

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<U, a> implements C0412oc {
        private a() {
            super(U.zzww);
        }

        public final V a(int i2) {
            return ((U) this.f4912b).b(0);
        }

        /* synthetic */ a(N n) {
            this();
        }

        public final a a(com.google.android.gms.internal.measurement.V.a aVar) {
            g();
            ((U) this.f4912b).a(aVar);
            return this;
        }
    }

    static {
        Eb.a(U.class, zzww);
    }

    private U() {
    }

    /* access modifiers changed from: private */
    public final void a(com.google.android.gms.internal.measurement.V.a aVar) {
        if (!this.zzwv.b()) {
            this.zzwv = Eb.a(this.zzwv);
        }
        this.zzwv.add((V) aVar.A());
    }

    public static a p() {
        return (a) zzww.j();
    }

    public final V b(int i2) {
        return (V) this.zzwv.get(0);
    }

    public final List<V> o() {
        return this.zzwv;
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new U();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzww, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzwv", V.class});
            case 4:
                return zzww;
            case 5:
                C0447uc<U> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (U.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzww);
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
