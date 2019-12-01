package kotlin.c;

import kotlin.c.f.b;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.i;
import kotlin.e.b.n;
import kotlin.m;

/* compiled from: CoroutineContextImpl.kt */
final class d extends i implements c<m, b, m> {
    final /* synthetic */ f[] $elements;
    final /* synthetic */ n $index;

    d(f[] fVarArr, n nVar) {
        this.$elements = fVarArr;
        this.$index = nVar;
        super(2);
    }

    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        a((m) obj, (b) obj2);
        return m.f10346a;
    }

    public final void a(m mVar, b bVar) {
        h.b(mVar, "<anonymous parameter 0>");
        h.b(bVar, "element");
        f[] fVarArr = this.$elements;
        n nVar = this.$index;
        int i2 = nVar.element;
        nVar.element = i2 + 1;
        fVarArr[i2] = bVar;
    }
}
