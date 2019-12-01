package l.a.c.a;

import kotlin.e.b.h;

/* compiled from: Event.kt */
public abstract class b {

    /* compiled from: Event.kt */
    public static final class a extends b {

        /* renamed from: a reason: collision with root package name */
        public static final a f10379a = new a();

        private a() {
            super(null);
        }
    }

    /* renamed from: l.a.c.a.b$b reason: collision with other inner class name */
    /* compiled from: Event.kt */
    public static final class C0119b extends b {

        /* renamed from: a reason: collision with root package name */
        private final Throwable f10380a;

        public C0119b(Throwable th) {
            h.b(th, "throwable");
            super(null);
            this.f10380a = th;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
            if (kotlin.e.b.h.a((java.lang.Object) r1.f10380a, (java.lang.Object) ((l.a.c.a.b.C0119b) r2).f10380a) != false) goto L_0x0015;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C0119b) {
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            Throwable th = this.f10380a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Error(throwable=");
            sb.append(this.f10380a);
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: Event.kt */
    public static final class c extends b {

        /* renamed from: a reason: collision with root package name */
        public static final c f10381a = new c();

        private c() {
            super(null);
        }
    }

    private b() {
    }

    public /* synthetic */ b(e eVar) {
        this();
    }
}
