package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.f.c;
import androidx.recyclerview.widget.RecyclerView.x;
import b.d.f;
import b.g.h.d;
import b.g.h.e;

/* compiled from: ViewInfoStore */
class ea {

    /* renamed from: a reason: collision with root package name */
    final b.d.b<x, a> f1904a = new b.d.b<>();

    /* renamed from: b reason: collision with root package name */
    final f<x> f1905b = new f<>();

    /* compiled from: ViewInfoStore */
    static class a {

        /* renamed from: a reason: collision with root package name */
        static d<a> f1906a = new e(20);

        /* renamed from: b reason: collision with root package name */
        int f1907b;

        /* renamed from: c reason: collision with root package name */
        c f1908c;

        /* renamed from: d reason: collision with root package name */
        c f1909d;

        private a() {
        }

        static void a(a aVar) {
            aVar.f1907b = 0;
            aVar.f1908c = null;
            aVar.f1909d = null;
            f1906a.a(aVar);
        }

        static a b() {
            a aVar = (a) f1906a.a();
            return aVar == null ? new a() : aVar;
        }

        static void a() {
            do {
            } while (f1906a.a() != null);
        }
    }

    /* compiled from: ViewInfoStore */
    interface b {
        void a(x xVar);

        void a(x xVar, c cVar, c cVar2);

        void b(x xVar, c cVar, c cVar2);

        void c(x xVar, c cVar, c cVar2);
    }

    ea() {
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f1904a.clear();
        this.f1905b.a();
    }

    /* access modifiers changed from: 0000 */
    public boolean b(x xVar) {
        a aVar = (a) this.f1904a.get(xVar);
        if (aVar == null || (aVar.f1907b & 1) == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void c(x xVar, c cVar) {
        a aVar = (a) this.f1904a.get(xVar);
        if (aVar == null) {
            aVar = a.b();
            this.f1904a.put(xVar, aVar);
        }
        aVar.f1908c = cVar;
        aVar.f1907b |= 4;
    }

    public void d(x xVar) {
        g(xVar);
    }

    /* access modifiers changed from: 0000 */
    public c e(x xVar) {
        return a(xVar, 8);
    }

    /* access modifiers changed from: 0000 */
    public c f(x xVar) {
        return a(xVar, 4);
    }

    /* access modifiers changed from: 0000 */
    public void g(x xVar) {
        a aVar = (a) this.f1904a.get(xVar);
        if (aVar != null) {
            aVar.f1907b &= -2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void h(x xVar) {
        int b2 = this.f1905b.b() - 1;
        while (true) {
            if (b2 < 0) {
                break;
            } else if (xVar == this.f1905b.c(b2)) {
                this.f1905b.b(b2);
                break;
            } else {
                b2--;
            }
        }
        a aVar = (a) this.f1904a.remove(xVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }

    private c a(x xVar, int i2) {
        c cVar;
        int a2 = this.f1904a.a((Object) xVar);
        if (a2 < 0) {
            return null;
        }
        a aVar = (a) this.f1904a.d(a2);
        if (aVar != null) {
            int i3 = aVar.f1907b;
            if ((i3 & i2) != 0) {
                aVar.f1907b = (~i2) & i3;
                if (i2 == 4) {
                    cVar = aVar.f1908c;
                } else if (i2 == 8) {
                    cVar = aVar.f1909d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.f1907b & 12) == 0) {
                    this.f1904a.c(a2);
                    a.a(aVar);
                }
                return cVar;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public void b(x xVar, c cVar) {
        a aVar = (a) this.f1904a.get(xVar);
        if (aVar == null) {
            aVar = a.b();
            this.f1904a.put(xVar, aVar);
        }
        aVar.f1909d = cVar;
        aVar.f1907b |= 8;
    }

    /* access modifiers changed from: 0000 */
    public boolean c(x xVar) {
        a aVar = (a) this.f1904a.get(xVar);
        return (aVar == null || (aVar.f1907b & 4) == 0) ? false : true;
    }

    /* access modifiers changed from: 0000 */
    public void b() {
        a.a();
    }

    /* access modifiers changed from: 0000 */
    public void a(long j2, x xVar) {
        this.f1905b.c(j2, xVar);
    }

    /* access modifiers changed from: 0000 */
    public void a(x xVar, c cVar) {
        a aVar = (a) this.f1904a.get(xVar);
        if (aVar == null) {
            aVar = a.b();
            this.f1904a.put(xVar, aVar);
        }
        aVar.f1907b |= 2;
        aVar.f1908c = cVar;
    }

    /* access modifiers changed from: 0000 */
    public x a(long j2) {
        return (x) this.f1905b.b(j2);
    }

    /* access modifiers changed from: 0000 */
    public void a(x xVar) {
        a aVar = (a) this.f1904a.get(xVar);
        if (aVar == null) {
            aVar = a.b();
            this.f1904a.put(xVar, aVar);
        }
        aVar.f1907b |= 1;
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar) {
        for (int size = this.f1904a.size() - 1; size >= 0; size--) {
            x xVar = (x) this.f1904a.b(size);
            a aVar = (a) this.f1904a.c(size);
            int i2 = aVar.f1907b;
            if ((i2 & 3) == 3) {
                bVar.a(xVar);
            } else if ((i2 & 1) != 0) {
                c cVar = aVar.f1908c;
                if (cVar == null) {
                    bVar.a(xVar);
                } else {
                    bVar.b(xVar, cVar, aVar.f1909d);
                }
            } else if ((i2 & 14) == 14) {
                bVar.a(xVar, aVar.f1908c, aVar.f1909d);
            } else if ((i2 & 12) == 12) {
                bVar.c(xVar, aVar.f1908c, aVar.f1909d);
            } else if ((i2 & 4) != 0) {
                bVar.b(xVar, aVar.f1908c, null);
            } else if ((i2 & 8) != 0) {
                bVar.a(xVar, aVar.f1908c, aVar.f1909d);
            }
            a.a(aVar);
        }
    }
}
