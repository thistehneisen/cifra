package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;
import java.util.List;

public final class Y extends Eb<Y, a> implements C0412oc {
    private static volatile C0447uc<Y> zzuo;
    /* access modifiers changed from: private */
    public static final Y zzzb = new Y();
    private int zzue;
    private int zzwg;
    private Nb zzza = Eb.m();

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<Y, a> implements C0412oc {
        private a() {
            super(Y.zzzb);
        }

        public final a a(int i2) {
            g();
            ((Y) this.f4912b).c(i2);
            return this;
        }

        public final a j() {
            g();
            ((Y) this.f4912b).v();
            return this;
        }

        /* synthetic */ a(N n) {
            this();
        }

        public final a a(long j2) {
            g();
            ((Y) this.f4912b).a(j2);
            return this;
        }

        public final a a(Iterable<? extends Long> iterable) {
            g();
            ((Y) this.f4912b).a(iterable);
            return this;
        }
    }

    static {
        Eb.a(Y.class, zzzb);
    }

    private Y() {
    }

    /* access modifiers changed from: private */
    public final void a(long j2) {
        u();
        this.zzza.a(j2);
    }

    /* access modifiers changed from: private */
    public final void c(int i2) {
        this.zzue |= 1;
        this.zzwg = i2;
    }

    public static a s() {
        return (a) zzzb.j();
    }

    private final void u() {
        if (!this.zzza.b()) {
            this.zzza = Eb.a(this.zzza);
        }
    }

    /* access modifiers changed from: private */
    public final void v() {
        this.zzza = Eb.m();
    }

    public final long b(int i2) {
        return this.zzza.getLong(i2);
    }

    public final int o() {
        return this.zzwg;
    }

    public final boolean p() {
        return (this.zzue & 1) != 0;
    }

    public final List<Long> q() {
        return this.zzza;
    }

    public final int r() {
        return this.zzza.size();
    }

    /* access modifiers changed from: private */
    public final void a(Iterable<? extends Long> iterable) {
        u();
        Na.a(iterable, this.zzza);
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new Y();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0014", new Object[]{"zzue", "zzwg", "zzza"});
            case 4:
                return zzzb;
            case 5:
                C0447uc<Y> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (Y.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzzb);
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
