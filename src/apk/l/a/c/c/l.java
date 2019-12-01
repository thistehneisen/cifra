package l.a.c.c;

import e.b.b.b;
import e.b.o;
import kotlin.m;

/* compiled from: Destroyable.kt */
public interface l {

    /* compiled from: Destroyable.kt */
    public static final class a {
        public static /* synthetic */ b a(l lVar, o oVar, kotlin.e.a.b bVar, kotlin.e.a.b bVar2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    bVar = new n(e.b.d.b.a.a());
                }
                if ((i2 & 2) != 0) {
                    bVar2 = o.f10390c;
                }
                return lVar.a(oVar, bVar, bVar2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: untilDestroy");
        }

        public static /* synthetic */ b a(l lVar, e.b.b bVar, kotlin.e.a.a aVar, kotlin.e.a.b bVar2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    aVar = new p(e.b.d.b.a.f7958c);
                }
                if ((i2 & 2) != 0) {
                    bVar2 = m.f10389c;
                }
                return lVar.a(bVar, aVar, bVar2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: untilDestroy");
        }
    }

    b a(e.b.b bVar, kotlin.e.a.a<m> aVar, kotlin.e.a.b<? super Throwable, m> bVar2);

    <T> b a(o<T> oVar, kotlin.e.a.b<? super T, m> bVar, kotlin.e.a.b<? super Throwable, m> bVar2);
}
