package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;
import java.util.List;

public final class X extends Eb<X, a> implements C0412oc {
    private static volatile C0447uc<X> zzuo;
    /* access modifiers changed from: private */
    public static final X zzyz = new X();
    private Nb zzyv = Eb.m();
    private Nb zzyw = Eb.m();
    private Mb<P> zzyx = Eb.n();
    private Mb<Y> zzyy = Eb.n();

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<X, a> implements C0412oc {
        private a() {
            super(X.zzyz);
        }

        public final a a(Iterable<? extends Long> iterable) {
            g();
            ((X) this.f4912b).a(iterable);
            return this;
        }

        public final a b(Iterable<? extends Long> iterable) {
            g();
            ((X) this.f4912b).b(iterable);
            return this;
        }

        public final a c(Iterable<? extends P> iterable) {
            g();
            ((X) this.f4912b).c(iterable);
            return this;
        }

        public final a d(Iterable<? extends Y> iterable) {
            g();
            ((X) this.f4912b).d(iterable);
            return this;
        }

        public final a j() {
            g();
            ((X) this.f4912b).C();
            return this;
        }

        public final a k() {
            g();
            ((X) this.f4912b).D();
            return this;
        }

        /* synthetic */ a(N n) {
            this();
        }

        public final a a(int i2) {
            g();
            ((X) this.f4912b).d(i2);
            return this;
        }

        public final a b(int i2) {
            g();
            ((X) this.f4912b).e(i2);
            return this;
        }
    }

    static {
        Eb.a(X.class, zzyz);
    }

    private X() {
    }

    /* access modifiers changed from: private */
    public final void C() {
        this.zzyv = Eb.m();
    }

    /* access modifiers changed from: private */
    public final void D() {
        this.zzyw = Eb.m();
    }

    private final void E() {
        if (!this.zzyx.b()) {
            this.zzyx = Eb.a(this.zzyx);
        }
    }

    private final void F() {
        if (!this.zzyy.b()) {
            this.zzyy = Eb.a(this.zzyy);
        }
    }

    /* access modifiers changed from: private */
    public final void a(Iterable<? extends Long> iterable) {
        if (!this.zzyv.b()) {
            this.zzyv = Eb.a(this.zzyv);
        }
        Na.a(iterable, this.zzyv);
    }

    /* access modifiers changed from: private */
    public final void b(Iterable<? extends Long> iterable) {
        if (!this.zzyw.b()) {
            this.zzyw = Eb.a(this.zzyw);
        }
        Na.a(iterable, this.zzyw);
    }

    /* access modifiers changed from: private */
    public final void c(Iterable<? extends P> iterable) {
        E();
        Na.a(iterable, this.zzyx);
    }

    /* access modifiers changed from: private */
    public final void d(int i2) {
        E();
        this.zzyx.remove(i2);
    }

    /* access modifiers changed from: private */
    public final void e(int i2) {
        F();
        this.zzyy.remove(i2);
    }

    public static a w() {
        return (a) zzyz.j();
    }

    public static X x() {
        return zzyz;
    }

    public final List<Long> o() {
        return this.zzyv;
    }

    public final int p() {
        return this.zzyv.size();
    }

    public final List<Long> q() {
        return this.zzyw;
    }

    public final int r() {
        return this.zzyw.size();
    }

    public final List<P> s() {
        return this.zzyx;
    }

    public final int t() {
        return this.zzyx.size();
    }

    public final List<Y> u() {
        return this.zzyy;
    }

    public final int v() {
        return this.zzyy.size();
    }

    /* access modifiers changed from: private */
    public final void d(Iterable<? extends Y> iterable) {
        F();
        Na.a(iterable, this.zzyy);
    }

    public final Y c(int i2) {
        return (Y) this.zzyy.get(i2);
    }

    public static X a(byte[] bArr, C0428rb rbVar) throws zzfi {
        return (X) Eb.a(zzyz, bArr, rbVar);
    }

    public final P b(int i2) {
        return (P) this.zzyx.get(i2);
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new X();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzyz, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzyv", "zzyw", "zzyx", P.class, "zzyy", Y.class});
            case 4:
                return zzyz;
            case 5:
                C0447uc<X> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (X.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzyz);
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
