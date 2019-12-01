package b.e.b.a;

import b.e.b.a.f.b;
import java.util.ArrayList;

/* compiled from: Snapshot */
public class t {

    /* renamed from: a reason: collision with root package name */
    private int f2413a;

    /* renamed from: b reason: collision with root package name */
    private int f2414b;

    /* renamed from: c reason: collision with root package name */
    private int f2415c;

    /* renamed from: d reason: collision with root package name */
    private int f2416d;

    /* renamed from: e reason: collision with root package name */
    private ArrayList<a> f2417e = new ArrayList<>();

    /* compiled from: Snapshot */
    static class a {

        /* renamed from: a reason: collision with root package name */
        private f f2418a;

        /* renamed from: b reason: collision with root package name */
        private f f2419b;

        /* renamed from: c reason: collision with root package name */
        private int f2420c;

        /* renamed from: d reason: collision with root package name */
        private b f2421d;

        /* renamed from: e reason: collision with root package name */
        private int f2422e;

        public a(f fVar) {
            this.f2418a = fVar;
            this.f2419b = fVar.g();
            this.f2420c = fVar.b();
            this.f2421d = fVar.f();
            this.f2422e = fVar.a();
        }

        public void a(h hVar) {
            hVar.a(this.f2418a.h()).a(this.f2419b, this.f2420c, this.f2421d, this.f2422e);
        }

        public void b(h hVar) {
            this.f2418a = hVar.a(this.f2418a.h());
            f fVar = this.f2418a;
            if (fVar != null) {
                this.f2419b = fVar.g();
                this.f2420c = this.f2418a.b();
                this.f2421d = this.f2418a.f();
                this.f2422e = this.f2418a.a();
                return;
            }
            this.f2419b = null;
            this.f2420c = 0;
            this.f2421d = b.STRONG;
            this.f2422e = 0;
        }
    }

    public t(h hVar) {
        this.f2413a = hVar.x();
        this.f2414b = hVar.y();
        this.f2415c = hVar.u();
        this.f2416d = hVar.j();
        ArrayList c2 = hVar.c();
        int size = c2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2417e.add(new a((f) c2.get(i2)));
        }
    }

    public void a(h hVar) {
        hVar.n(this.f2413a);
        hVar.o(this.f2414b);
        hVar.k(this.f2415c);
        hVar.c(this.f2416d);
        int size = this.f2417e.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((a) this.f2417e.get(i2)).a(hVar);
        }
    }

    public void b(h hVar) {
        this.f2413a = hVar.x();
        this.f2414b = hVar.y();
        this.f2415c = hVar.u();
        this.f2416d = hVar.j();
        int size = this.f2417e.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((a) this.f2417e.get(i2)).b(hVar);
        }
    }
}
