package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;
import java.util.Collections;
import java.util.List;

public final class Q extends Eb<Q, a> implements C0412oc {
    private static volatile C0447uc<Q> zzuo;
    /* access modifiers changed from: private */
    public static final Q zzwo = new Q();
    private int zzue;
    private Mb<T> zzwj = Eb.n();
    private String zzwk = "";
    private long zzwl;
    private long zzwm;
    private int zzwn;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<Q, a> implements C0412oc {
        private a() {
            super(Q.zzwo);
        }

        public final T a(int i2) {
            return ((Q) this.f4912b).b(i2);
        }

        public final a b(int i2) {
            g();
            ((Q) this.f4912b).c(i2);
            return this;
        }

        public final String j() {
            return ((Q) this.f4912b).p();
        }

        public final long k() {
            return ((Q) this.f4912b).q();
        }

        public final List<T> l() {
            return Collections.unmodifiableList(((Q) this.f4912b).r());
        }

        public final int m() {
            return ((Q) this.f4912b).s();
        }

        public final long n() {
            return ((Q) this.f4912b).u();
        }

        /* synthetic */ a(N n) {
            this();
        }

        public final a a(int i2, T t) {
            g();
            ((Q) this.f4912b).a(i2, t);
            return this;
        }

        public final a b(long j2) {
            g();
            ((Q) this.f4912b).b(j2);
            return this;
        }

        public final a a(int i2, com.google.android.gms.internal.measurement.T.a aVar) {
            g();
            ((Q) this.f4912b).a(i2, aVar);
            return this;
        }

        public final a a(T t) {
            g();
            ((Q) this.f4912b).a(t);
            return this;
        }

        public final a a(com.google.android.gms.internal.measurement.T.a aVar) {
            g();
            ((Q) this.f4912b).a(aVar);
            return this;
        }

        public final a a(String str) {
            g();
            ((Q) this.f4912b).a(str);
            return this;
        }

        public final a a(long j2) {
            g();
            ((Q) this.f4912b).a(j2);
            return this;
        }
    }

    static {
        Eb.a(Q.class, zzwo);
    }

    private Q() {
    }

    private final void C() {
        if (!this.zzwj.b()) {
            this.zzwj = Eb.a(this.zzwj);
        }
    }

    /* access modifiers changed from: private */
    public final void a(int i2, T t) {
        if (t != null) {
            C();
            this.zzwj.set(i2, t);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void c(int i2) {
        C();
        this.zzwj.remove(i2);
    }

    public static a x() {
        return (a) zzwo.j();
    }

    public final T b(int i2) {
        return (T) this.zzwj.get(i2);
    }

    public final int o() {
        return this.zzwn;
    }

    public final String p() {
        return this.zzwk;
    }

    public final long q() {
        return this.zzwl;
    }

    public final List<T> r() {
        return this.zzwj;
    }

    public final int s() {
        return this.zzwj.size();
    }

    public final boolean t() {
        return (this.zzue & 2) != 0;
    }

    public final long u() {
        return this.zzwm;
    }

    public final boolean v() {
        return (this.zzue & 4) != 0;
    }

    public final boolean w() {
        return (this.zzue & 8) != 0;
    }

    /* access modifiers changed from: private */
    public final void b(long j2) {
        this.zzue |= 4;
        this.zzwm = j2;
    }

    /* access modifiers changed from: private */
    public final void a(int i2, com.google.android.gms.internal.measurement.T.a aVar) {
        C();
        this.zzwj.set(i2, (T) aVar.A());
    }

    /* access modifiers changed from: private */
    public final void a(T t) {
        if (t != null) {
            C();
            this.zzwj.add(t);
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void a(com.google.android.gms.internal.measurement.T.a aVar) {
        C();
        this.zzwj.add((T) aVar.A());
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (str != null) {
            this.zzue |= 1;
            this.zzwk = str;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: private */
    public final void a(long j2) {
        this.zzue |= 2;
        this.zzwl = j2;
    }

    public static Q a(byte[] bArr, C0428rb rbVar) throws zzfi {
        return (Q) Eb.a(zzwo, bArr, rbVar);
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (N.f4993a[i2 - 1]) {
            case 1:
                return new Q();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzwo, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\b\u0000\u0003\u0002\u0001\u0004\u0002\u0002\u0005\u0004\u0003", new Object[]{"zzue", "zzwj", T.class, "zzwk", "zzwl", "zzwm", "zzwn"});
            case 4:
                return zzwo;
            case 5:
                C0447uc<Q> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (Q.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzwo);
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
