package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.Eb.c;
import java.util.List;

public final class G extends Eb<G, b> implements C0412oc {
    private static volatile C0447uc<G> zzuo;
    /* access modifiers changed from: private */
    public static final G zzvp = new G();
    private int zzue;
    private int zzvl;
    private String zzvm = "";
    private boolean zzvn;
    private Mb<String> zzvo = Eb.n();

    public enum a implements Jb {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);
        

        /* renamed from: h reason: collision with root package name */
        private static final Ib<a> f4944h = null;
        private final int value;

        static {
            f4944h = new K();
        }

        private a(int i2) {
            this.value = i2;
        }

        public static Lb a() {
            return J.f4972a;
        }

        public static a b(int i2) {
            switch (i2) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }

        public final int o() {
            return this.value;
        }
    }

    public static final class b extends com.google.android.gms.internal.measurement.Eb.a<G, b> implements C0412oc {
        private b() {
            super(G.zzvp);
        }

        /* synthetic */ b(B b2) {
            this();
        }
    }

    static {
        Eb.a(G.class, zzvp);
    }

    private G() {
    }

    public static G w() {
        return zzvp;
    }

    /* access modifiers changed from: protected */
    public final Object a(int i2, Object obj, Object obj2) {
        switch (B.f4859a[i2 - 1]) {
            case 1:
                return new G();
            case 2:
                return new b(null);
            case 3:
                return Eb.a((C0400mc) zzvp, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\f\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u001a", new Object[]{"zzue", "zzvl", a.a(), "zzvm", "zzvn", "zzvo"});
            case 4:
                return zzvp;
            case 5:
                C0447uc<G> ucVar = zzuo;
                if (ucVar == null) {
                    synchronized (G.class) {
                        ucVar = zzuo;
                        if (ucVar == null) {
                            ucVar = new c<>(zzvp);
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

    public final boolean o() {
        return (this.zzue & 1) != 0;
    }

    public final a p() {
        a b2 = a.b(this.zzvl);
        return b2 == null ? a.UNKNOWN_MATCH_TYPE : b2;
    }

    public final boolean q() {
        return (this.zzue & 2) != 0;
    }

    public final String r() {
        return this.zzvm;
    }

    public final boolean s() {
        return (this.zzue & 4) != 0;
    }

    public final boolean t() {
        return this.zzvn;
    }

    public final List<String> u() {
        return this.zzvo;
    }

    public final int v() {
        return this.zzvo.size();
    }
}
