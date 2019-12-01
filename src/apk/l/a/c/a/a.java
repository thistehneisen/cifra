package l.a.c.a;

import kotlin.e.b.h;

/* compiled from: ContentEvent.kt */
public abstract class a<T> {

    /* renamed from: a reason: collision with root package name */
    private final T f10373a;

    /* renamed from: l.a.c.a.a$a reason: collision with other inner class name */
    /* compiled from: ContentEvent.kt */
    public static final class C0118a<T> extends a<T> {

        /* renamed from: b reason: collision with root package name */
        private final T f10374b;

        public C0118a() {
            this(null, 1, null);
        }

        public C0118a(T t) {
            super(t, null);
            this.f10374b = t;
        }

        public T a() {
            return this.f10374b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
            if (kotlin.e.b.h.a(a(), ((l.a.c.a.a.C0118a) r2).a()) != false) goto L_0x0019;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof C0118a) {
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            Object a2 = a();
            if (a2 != null) {
                return a2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Complete(data=");
            sb.append(a());
            sb.append(")");
            return sb.toString();
        }

        public /* synthetic */ C0118a(Object obj, int i2, e eVar) {
            if ((i2 & 1) != 0) {
                obj = null;
            }
            this(obj);
        }
    }

    /* compiled from: ContentEvent.kt */
    public static final class b<T> extends a<T> {

        /* renamed from: b reason: collision with root package name */
        private final Throwable f10375b;

        /* renamed from: c reason: collision with root package name */
        private final T f10376c;

        public b(Throwable th, T t) {
            h.b(th, "throwable");
            super(t, null);
            this.f10375b = th;
            this.f10376c = t;
        }

        public T a() {
            return this.f10376c;
        }

        public final Throwable b() {
            return this.f10375b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
            if (kotlin.e.b.h.a(a(), r3.a()) != false) goto L_0x0023;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (h.a((Object) this.f10375b, (Object) bVar.f10375b)) {
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            Throwable th = this.f10375b;
            int i2 = 0;
            int hashCode = (th != null ? th.hashCode() : 0) * 31;
            Object a2 = a();
            if (a2 != null) {
                i2 = a2.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Error(throwable=");
            sb.append(this.f10375b);
            sb.append(", data=");
            sb.append(a());
            sb.append(")");
            return sb.toString();
        }
    }

    /* compiled from: ContentEvent.kt */
    public static final class c<T> extends a<T> {

        /* renamed from: b reason: collision with root package name */
        private final T f10377b;

        public c() {
            this(null, 1, null);
        }

        public c(T t) {
            super(t, null);
            this.f10377b = t;
        }

        public T a() {
            return this.f10377b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
            if (kotlin.e.b.h.a(a(), ((l.a.c.a.a.c) r2).a()) != false) goto L_0x0019;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof c) {
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            Object a2 = a();
            if (a2 != null) {
                return a2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Loading(data=");
            sb.append(a());
            sb.append(")");
            return sb.toString();
        }

        public /* synthetic */ c(Object obj, int i2, e eVar) {
            if ((i2 & 1) != 0) {
                obj = null;
            }
            this(obj);
        }
    }

    /* compiled from: ContentEvent.kt */
    public static final class d<T> extends a<T> {

        /* renamed from: b reason: collision with root package name */
        private final T f10378b;

        public d(T t) {
            super(t, null);
            this.f10378b = t;
        }

        public T a() {
            return this.f10378b;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
            if (kotlin.e.b.h.a(a(), ((l.a.c.a.a.d) r2).a()) != false) goto L_0x0019;
         */
        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof d) {
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            Object a2 = a();
            if (a2 != null) {
                return a2.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Success(data=");
            sb.append(a());
            sb.append(")");
            return sb.toString();
        }
    }

    private a(T t) {
        this.f10373a = t;
    }

    public T a() {
        return this.f10373a;
    }

    public /* synthetic */ a(Object obj, e eVar) {
        this(obj);
    }
}
