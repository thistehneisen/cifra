package retrofit2;

import i.C0721j;
import i.C0722k;
import i.M;
import java.io.IOException;

/* compiled from: OkHttpCall */
class m implements C0722k {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ d f11007a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ o f11008b;

    m(o oVar, d dVar) {
        this.f11008b = oVar;
        this.f11007a = dVar;
    }

    public void a(C0721j jVar, M m) {
        try {
            try {
                this.f11007a.a((b<T>) this.f11008b, this.f11008b.a(m));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            a(th2);
        }
    }

    public void a(C0721j jVar, IOException iOException) {
        a(iOException);
    }

    private void a(Throwable th) {
        try {
            this.f11007a.a((b<T>) this.f11008b, th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
