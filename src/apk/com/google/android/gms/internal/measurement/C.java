package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;
import com.google.android.gms.internal.measurement.Eb.d;
import java.util.List;

public final class C extends Eb<C, a> implements C0412oc {
    /* access modifiers changed from: private */
    public static final C zzun = new C();
    private static volatile C0447uc<C> zzuo;
    private int zzue;
    private int zzuf;
    private String zzug = "";
    private Mb<D> zzuh = Eb.n();
    private boolean zzui;
    private E zzuj;
    private boolean zzuk;
    private boolean zzul;
    private boolean zzum;

    public static final class a extends com.google.android.gms.internal.measurement.Eb.a<C, a> implements C0412oc {
        private a() {
            super(C.zzun);
        }

        public final a a(String str) {
            g();
            ((C) this.f4912b).a(str);
            return this;
        }

        public final String j() {
            return ((C) this.f4912b).p();
        }

        public final int k() {
            return ((C) this.f4912b).q();
        }

        /* synthetic */ a(B b2) {
            this();
        }

        public final D a(int i2) {
            return ((C) this.f4912b).b(i2);
        }

        public final a a(int i2, D d2) {
            g();
            ((C) this.f4912b).a(i2, d2);
            return this;
        }
    }

    static {
        Eb.a(C.class, zzun);
    }

    private C() {
    }

    public static C0447uc<C> C() {
        return (C0447uc) zzun.a(d.f4921g, (Object) null, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (str != null) {
            this.zzue |= 2;
            this.zzug = str;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean B() {
        return this.zzum;
    }

    public final D b(int i2) {
        return (D) this.zzuh.get(i2);
    }

    public final int o() {
        return this.zzuf;
    }

    public final String p() {
        return this.zzug;
    }

    public final int q() {
        return this.zzuh.size();
    }

    public final boolean r() {
        return (this.zzue & 1) != 0;
    }

    public final List<D> s() {
        return this.zzuh;
    }

    public final boolean t() {
        return (this.zzue & 8) != 0;
    }

    public final E u() {
        E e2 = this.zzuj;
        return e2 == null ? E.B() : e2;
    }

    public final boolean v() {
        return this.zzuk;
    }

    public final boolean w() {
        return this.zzul;
    }

    public final boolean x() {
        return (this.zzue & 64) != 0;
    }

    /* access modifiers changed from: private */
    public final void a(int i2, D d2) {
        if (d2 != null) {
            if (!this.zzuh.b()) {
                this.zzuh = Eb.a(this.zzuh);
            }
            this.zzuh.set(i2, d2);
            return;
        }
        throw new NullPointerException();
    }

    public static C a(byte[] bArr, C0428rb rbVar) throws zzfi {
        return (C) Eb.a(zzun, bArr, rbVar);
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (B.f4859a[i2 - 1]) {
            case 1:
                return new C();
            case 2:
                return new a(null);
            case 3:
                return Eb.a((C0400mc) zzun, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u001b\u0004\u0007\u0002\u0005\t\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\u0007\u0006", new Object[]{"zzue", "zzuf", "zzug", "zzuh", D.class, "zzui", "zzuj", "zzuk", "zzul", "zzum"});
            case 4:
                return zzun;
            case 5:
                C0447uc<C> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (C.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzun);
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
