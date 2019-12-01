package b.g.g;

import java.util.Locale;

/* compiled from: TextDirectionHeuristicsCompat */
public final class e {

    /* renamed from: a reason: collision with root package name */
    public static final d f2606a = new C0026e(null, false);

    /* renamed from: b reason: collision with root package name */
    public static final d f2607b = new C0026e(null, true);

    /* renamed from: c reason: collision with root package name */
    public static final d f2608c = new C0026e(b.f2614a, false);

    /* renamed from: d reason: collision with root package name */
    public static final d f2609d = new C0026e(b.f2614a, true);

    /* renamed from: e reason: collision with root package name */
    public static final d f2610e = new C0026e(a.f2612a, false);

    /* renamed from: f reason: collision with root package name */
    public static final d f2611f = f.f2617b;

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class a implements c {

        /* renamed from: a reason: collision with root package name */
        static final a f2612a = new a(true);

        /* renamed from: b reason: collision with root package name */
        private final boolean f2613b;

        private a(boolean z) {
            this.f2613b = z;
        }

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z = false;
            while (i2 < i4) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i2++;
                    } else if (!this.f2613b) {
                        return 1;
                    }
                } else if (this.f2613b) {
                    return 0;
                }
                z = true;
                i2++;
            }
            if (z) {
                return this.f2613b ? 1 : 0;
            }
            return 2;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class b implements c {

        /* renamed from: a reason: collision with root package name */
        static final b f2614a = new b();

        private b() {
        }

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                i5 = e.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i5;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private interface c {
        int a(CharSequence charSequence, int i2, int i3);
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static abstract class d implements d {

        /* renamed from: a reason: collision with root package name */
        private final c f2615a;

        d(c cVar) {
            this.f2615a = cVar;
        }

        private boolean a(CharSequence charSequence, int i2, int i3) {
            int a2 = this.f2615a.a(charSequence, i2, i3);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract boolean a();

        public boolean isRtl(CharSequence charSequence, int i2, int i3) {
            if (charSequence == null || i2 < 0 || i3 < 0 || charSequence.length() - i3 < i2) {
                throw new IllegalArgumentException();
            } else if (this.f2615a == null) {
                return a();
            } else {
                return a(charSequence, i2, i3);
            }
        }
    }

    /* renamed from: b.g.g.e$e reason: collision with other inner class name */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C0026e extends d {

        /* renamed from: b reason: collision with root package name */
        private final boolean f2616b;

        C0026e(c cVar, boolean z) {
            super(cVar);
            this.f2616b = z;
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return this.f2616b;
        }
    }

    /* compiled from: TextDirectionHeuristicsCompat */
    private static class f extends d {

        /* renamed from: b reason: collision with root package name */
        static final f f2617b = new f();

        f() {
            super(null);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return f.a(Locale.getDefault()) == 1;
        }
    }

    static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i2) {
        if (i2 != 0) {
            if (!(i2 == 1 || i2 == 2)) {
                switch (i2) {
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                        break;
                    default:
                        return 2;
                }
            }
            return 0;
        }
        return 1;
    }
}
