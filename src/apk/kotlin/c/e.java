package kotlin.c;

import kotlin.TypeCastException;
import kotlin.c.f.c;
import kotlin.e.b.h;

/* compiled from: ContinuationInterceptor.kt */
public interface e extends kotlin.c.f.b {

    /* renamed from: c reason: collision with root package name */
    public static final b f10297c = b.f10298a;

    /* compiled from: ContinuationInterceptor.kt */
    public static final class a {
        public static <E extends kotlin.c.f.b> E a(e eVar, c<E> cVar) {
            h.b(cVar, "key");
            if (cVar != e.f10297c) {
                return null;
            }
            if (eVar != null) {
                return eVar;
            }
            throw new TypeCastException("null cannot be cast to non-null type E");
        }

        public static f b(e eVar, c<?> cVar) {
            h.b(cVar, "key");
            return cVar == e.f10297c ? h.f10300a : eVar;
        }
    }

    /* compiled from: ContinuationInterceptor.kt */
    public static final class b implements c<e> {

        /* renamed from: a reason: collision with root package name */
        static final /* synthetic */ b f10298a = new b();

        private b() {
        }
    }
}
