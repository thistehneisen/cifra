package e.b.d.j;

import e.b.m;
import java.io.Serializable;
import k.a.d;

/* compiled from: NotificationLite */
public enum h {
    COMPLETE;

    /* compiled from: NotificationLite */
    static final class a implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final e.b.b.b upstream;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Disposable[");
            sb.append(this.upstream);
            sb.append("]");
            return sb.toString();
        }
    }

    /* compiled from: NotificationLite */
    static final class b implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e reason: collision with root package name */
        final Throwable f8296e;

        b(Throwable th) {
            this.f8296e = th;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            return e.b.d.b.b.a((Object) this.f8296e, (Object) ((b) obj).f8296e);
        }

        public int hashCode() {
            return this.f8296e.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Error[");
            sb.append(this.f8296e);
            sb.append("]");
            return sb.toString();
        }
    }

    /* compiled from: NotificationLite */
    static final class c implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final d upstream;

        c(d dVar) {
            this.upstream = dVar;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Subscription[");
            sb.append(this.upstream);
            sb.append("]");
            return sb.toString();
        }
    }

    public static Object a() {
        return COMPLETE;
    }

    public static <T> T a(Object obj) {
        return obj;
    }

    public static boolean b(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean c(Object obj) {
        return obj instanceof b;
    }

    public static <T> Object d(T t) {
        return t;
    }

    public String toString() {
        return "NotificationLite.Complete";
    }

    public static Object a(Throwable th) {
        return new b(th);
    }

    public static <T> boolean b(Object obj, m<? super T> mVar) {
        if (obj == COMPLETE) {
            mVar.c();
            return true;
        } else if (obj instanceof b) {
            mVar.a(((b) obj).f8296e);
            return true;
        } else if (obj instanceof a) {
            mVar.a(((a) obj).upstream);
            return false;
        } else {
            mVar.a(obj);
            return false;
        }
    }

    public static Object a(d dVar) {
        return new c(dVar);
    }

    public static <T> boolean a(Object obj, m<? super T> mVar) {
        if (obj == COMPLETE) {
            mVar.c();
            return true;
        } else if (obj instanceof b) {
            mVar.a(((b) obj).f8296e);
            return true;
        } else {
            mVar.a(obj);
            return false;
        }
    }

    public static <T> boolean a(Object obj, k.a.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.c();
            return true;
        } else if (obj instanceof b) {
            cVar.a(((b) obj).f8296e);
            return true;
        } else if (obj instanceof c) {
            cVar.a(((c) obj).upstream);
            return false;
        } else {
            cVar.a(obj);
            return false;
        }
    }
}
