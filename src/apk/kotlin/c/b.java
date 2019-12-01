package kotlin.c;

import java.io.Serializable;
import kotlin.TypeCastException;
import kotlin.e.a.c;
import kotlin.e.b.h;
import kotlin.e.b.n;
import kotlin.m;

/* compiled from: CoroutineContextImpl.kt */
public final class b implements f, Serializable {
    private final kotlin.c.f.b element;
    private final f left;

    /* compiled from: CoroutineContextImpl.kt */
    private static final class a implements Serializable {

        /* renamed from: a reason: collision with root package name */
        public static final C0116a f10295a = new C0116a(null);
        private static final long serialVersionUID = 0;
        private final f[] elements;

        /* renamed from: kotlin.c.b$a$a reason: collision with other inner class name */
        /* compiled from: CoroutineContextImpl.kt */
        public static final class C0116a {
            private C0116a() {
            }

            public /* synthetic */ C0116a(e eVar) {
                this();
            }
        }

        public a(f[] fVarArr) {
            h.b(fVarArr, "elements");
            this.elements = fVarArr;
        }

        private final Object readResolve() {
            f[] fVarArr = this.elements;
            f fVar = h.f10300a;
            for (f plus : fVarArr) {
                fVar = fVar.plus(plus);
            }
            return fVar;
        }
    }

    public b(f fVar, kotlin.c.f.b bVar) {
        h.b(fVar, "left");
        h.b(bVar, "element");
        this.left = fVar;
        this.element = bVar;
    }

    private final int a() {
        int i2 = 2;
        b bVar = this;
        while (true) {
            f fVar = bVar.left;
            if (!(fVar instanceof b)) {
                fVar = null;
            }
            bVar = (b) fVar;
            if (bVar == null) {
                return i2;
            }
            i2++;
        }
    }

    private final Object writeReplace() {
        int a2 = a();
        f[] fVarArr = new f[a2];
        n nVar = new n();
        boolean z = false;
        nVar.element = 0;
        fold(m.f10346a, new d(fVarArr, nVar));
        if (nVar.element == a2) {
            z = true;
        }
        if (z) {
            return new a(fVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r3.a(r2) != false) goto L_0x001b;
     */
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (bVar.a() == a()) {
                }
            }
            return false;
        }
        return true;
    }

    public <R> R fold(R r, c<? super R, ? super kotlin.c.f.b, ? extends R> cVar) {
        h.b(cVar, "operation");
        return cVar.a(this.left.fold(r, cVar), this.element);
    }

    public <E extends kotlin.c.f.b> E get(f.c<E> cVar) {
        h.b(cVar, "key");
        b bVar = this;
        while (true) {
            E e2 = bVar.element.get(cVar);
            if (e2 != null) {
                return e2;
            }
            f fVar = bVar.left;
            if (!(fVar instanceof b)) {
                return fVar.get(cVar);
            }
            bVar = (b) fVar;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public f minusKey(f.c<?> cVar) {
        f fVar;
        h.b(cVar, "key");
        if (this.element.get(cVar) != null) {
            return this.left;
        }
        f minusKey = this.left.minusKey(cVar);
        if (minusKey == this.left) {
            fVar = this;
        } else if (minusKey == h.f10300a) {
            fVar = this.element;
        } else {
            fVar = new b(minusKey, this.element);
        }
        return fVar;
    }

    public f plus(f fVar) {
        h.b(fVar, "context");
        return kotlin.c.f.a.a(this, fVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append((String) fold("", c.f10296a));
        sb.append("]");
        return sb.toString();
    }

    private final boolean a(kotlin.c.f.b bVar) {
        return h.a((Object) get(bVar.getKey()), (Object) bVar);
    }

    private final boolean a(b bVar) {
        while (a(bVar.element)) {
            f fVar = bVar.left;
            if (fVar instanceof b) {
                bVar = (b) fVar;
            } else if (fVar != null) {
                return a((kotlin.c.f.b) fVar);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
            }
        }
        return false;
    }
}
