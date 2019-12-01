package j;

import java.io.IOException;

/* renamed from: j.a reason: case insensitive filesystem */
/* compiled from: AsyncTimeout */
class C0788a implements z {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ z f10235a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ C0790c f10236b;

    C0788a(C0790c cVar, z zVar) {
        this.f10236b = cVar;
        this.f10235a = zVar;
    }

    public void a(f fVar, long j2) throws IOException {
        D.a(fVar.f10250c, 0, j2);
        while (true) {
            long j3 = 0;
            if (j2 > 0) {
                w wVar = fVar.f10249b;
                while (true) {
                    if (j3 >= 65536) {
                        break;
                    }
                    j3 += (long) (wVar.f10284c - wVar.f10283b);
                    if (j3 >= j2) {
                        j3 = j2;
                        break;
                    }
                    wVar = wVar.f10287f;
                }
                this.f10236b.h();
                try {
                    this.f10235a.a(fVar, j3);
                    j2 -= j3;
                    this.f10236b.a(true);
                } catch (IOException e2) {
                    throw this.f10236b.a(e2);
                } catch (Throwable th) {
                    this.f10236b.a(false);
                    throw th;
                }
            } else {
                return;
            }
        }
    }

    public void close() throws IOException {
        this.f10236b.h();
        try {
            this.f10235a.close();
            this.f10236b.a(true);
        } catch (IOException e2) {
            throw this.f10236b.a(e2);
        } catch (Throwable th) {
            this.f10236b.a(false);
            throw th;
        }
    }

    public void flush() throws IOException {
        this.f10236b.h();
        try {
            this.f10235a.flush();
            this.f10236b.a(true);
        } catch (IOException e2) {
            throw this.f10236b.a(e2);
        } catch (Throwable th) {
            this.f10236b.a(false);
            throw th;
        }
    }

    public C timeout() {
        return this.f10236b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AsyncTimeout.sink(");
        sb.append(this.f10235a);
        sb.append(")");
        return sb.toString();
    }
}
