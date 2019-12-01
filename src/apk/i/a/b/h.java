package i.a.b;

import i.C;
import i.C.a;
import i.C0721j;
import i.J;
import i.M;
import java.io.IOException;
import java.util.List;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.k;

/* compiled from: RealInterceptorChain */
public final class h implements a {

    /* renamed from: a reason: collision with root package name */
    private final List<C> f8584a;

    /* renamed from: b reason: collision with root package name */
    private final k f8585b;

    /* renamed from: c reason: collision with root package name */
    private final d f8586c;

    /* renamed from: d reason: collision with root package name */
    private final int f8587d;

    /* renamed from: e reason: collision with root package name */
    private final J f8588e;

    /* renamed from: f reason: collision with root package name */
    private final C0721j f8589f;

    /* renamed from: g reason: collision with root package name */
    private final int f8590g;

    /* renamed from: h reason: collision with root package name */
    private final int f8591h;

    /* renamed from: i reason: collision with root package name */
    private final int f8592i;

    /* renamed from: j reason: collision with root package name */
    private int f8593j;

    public h(List<C> list, k kVar, d dVar, int i2, J j2, C0721j jVar, int i3, int i4, int i5) {
        this.f8584a = list;
        this.f8585b = kVar;
        this.f8586c = dVar;
        this.f8587d = i2;
        this.f8588e = j2;
        this.f8589f = jVar;
        this.f8590g = i3;
        this.f8591h = i4;
        this.f8592i = i5;
    }

    public d a() {
        d dVar = this.f8586c;
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalStateException();
    }

    public k b() {
        return this.f8585b;
    }

    public int connectTimeoutMillis() {
        return this.f8590g;
    }

    public int readTimeoutMillis() {
        return this.f8591h;
    }

    public J request() {
        return this.f8588e;
    }

    public int writeTimeoutMillis() {
        return this.f8592i;
    }

    public M a(J j2) throws IOException {
        return a(j2, this.f8585b, this.f8586c);
    }

    public M a(J j2, k kVar, d dVar) throws IOException {
        if (this.f8587d < this.f8584a.size()) {
            this.f8593j++;
            d dVar2 = this.f8586c;
            String str = "network interceptor ";
            if (dVar2 == null || dVar2.b().a(j2.g())) {
                String str2 = " must call proceed() exactly once";
                if (this.f8586c == null || this.f8593j <= 1) {
                    h hVar = new h(this.f8584a, kVar, dVar, this.f8587d + 1, j2, this.f8589f, this.f8590g, this.f8591h, this.f8592i);
                    C c2 = (C) this.f8584a.get(this.f8587d);
                    M a2 = c2.a(hVar);
                    if (dVar == null || this.f8587d + 1 >= this.f8584a.size() || hVar.f8593j == 1) {
                        String str3 = "interceptor ";
                        if (a2 == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            sb.append(c2);
                            sb.append(" returned null");
                            throw new NullPointerException(sb.toString());
                        } else if (a2.a() != null) {
                            return a2;
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(str3);
                            sb2.append(c2);
                            sb2.append(" returned a response with no body");
                            throw new IllegalStateException(sb2.toString());
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(c2);
                        sb3.append(str2);
                        throw new IllegalStateException(sb3.toString());
                    }
                } else {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append(this.f8584a.get(this.f8587d - 1));
                    sb4.append(str2);
                    throw new IllegalStateException(sb4.toString());
                }
            } else {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append(this.f8584a.get(this.f8587d - 1));
                sb5.append(" must retain the same host and port");
                throw new IllegalStateException(sb5.toString());
            }
        } else {
            throw new AssertionError();
        }
    }
}
