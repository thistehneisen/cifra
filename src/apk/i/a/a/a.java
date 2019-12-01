package i.a.a;

import i.a.e;
import j.A;
import j.C;
import j.f;
import j.g;
import j.h;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheInterceptor */
class a implements A {

    /* renamed from: a reason: collision with root package name */
    boolean f8555a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ h f8556b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ c f8557c;

    /* renamed from: d reason: collision with root package name */
    final /* synthetic */ g f8558d;

    /* renamed from: e reason: collision with root package name */
    final /* synthetic */ b f8559e;

    a(b bVar, h hVar, c cVar, g gVar) {
        this.f8559e = bVar;
        this.f8556b = hVar;
        this.f8557c = cVar;
        this.f8558d = gVar;
    }

    public long b(f fVar, long j2) throws IOException {
        try {
            long b2 = this.f8556b.b(fVar, j2);
            if (b2 == -1) {
                if (!this.f8555a) {
                    this.f8555a = true;
                    this.f8558d.close();
                }
                return -1;
            }
            fVar.a(this.f8558d.n(), fVar.size() - b2, b2);
            this.f8558d.u();
            return b2;
        } catch (IOException e2) {
            if (!this.f8555a) {
                this.f8555a = true;
                this.f8557c.abort();
            }
            throw e2;
        }
    }

    public void close() throws IOException {
        if (!this.f8555a && !e.a((A) this, 100, TimeUnit.MILLISECONDS)) {
            this.f8555a = true;
            this.f8557c.abort();
        }
        this.f8556b.close();
    }

    public C timeout() {
        return this.f8556b.timeout();
    }
}
