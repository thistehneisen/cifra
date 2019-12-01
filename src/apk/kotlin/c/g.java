package kotlin.c;

import kotlin.c.f.b;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;

/* compiled from: CoroutineContext.kt */
final class g extends i implements c<f, b, f> {

    /* renamed from: a reason: collision with root package name */
    public static final g f10299a = new g();

    g() {
        super(2);
    }

    public final f a(f fVar, b bVar) {
        h.b(fVar, "acc");
        h.b(bVar, "element");
        f minusKey = fVar.minusKey(bVar.getKey());
        if (minusKey == h.f10300a) {
            return bVar;
        }
        e eVar = (e) minusKey.get(e.f10297c);
        if (eVar == null) {
            return new b(minusKey, bVar);
        }
        f minusKey2 = minusKey.minusKey(e.f10297c);
        if (minusKey2 == h.f10300a) {
            return new b(bVar, eVar);
        }
        return new b(new b(minusKey2, bVar), eVar);
    }
}
