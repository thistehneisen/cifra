package i;

import i.a.b.g;
import i.a.e;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: Request */
public final class J {

    /* renamed from: a reason: collision with root package name */
    final B f8502a;

    /* renamed from: b reason: collision with root package name */
    final String f8503b;

    /* renamed from: c reason: collision with root package name */
    final A f8504c;

    /* renamed from: d reason: collision with root package name */
    final L f8505d;

    /* renamed from: e reason: collision with root package name */
    final Map<Class<?>, Object> f8506e;

    /* renamed from: f reason: collision with root package name */
    private volatile C0720i f8507f;

    /* compiled from: Request */
    public static class a {

        /* renamed from: a reason: collision with root package name */
        B f8508a;

        /* renamed from: b reason: collision with root package name */
        String f8509b;

        /* renamed from: c reason: collision with root package name */
        i.A.a f8510c;

        /* renamed from: d reason: collision with root package name */
        L f8511d;

        /* renamed from: e reason: collision with root package name */
        Map<Class<?>, Object> f8512e;

        public a() {
            this.f8512e = Collections.emptyMap();
            this.f8509b = "GET";
            this.f8510c = new i.A.a();
        }

        public a a(B b2) {
            if (b2 != null) {
                this.f8508a = b2;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a b(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("http:");
                    sb.append(str.substring(3));
                    str = sb.toString();
                } else {
                    if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("https:");
                        sb2.append(str.substring(4));
                        str = sb2.toString();
                    }
                }
                a(B.b(str));
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a a(String str, String str2) {
            this.f8510c.a(str, str2);
            return this;
        }

        public a a(String str) {
            this.f8510c.b(str);
            return this;
        }

        a(J j2) {
            Map<Class<?>, Object> map;
            this.f8512e = Collections.emptyMap();
            this.f8508a = j2.f8502a;
            this.f8509b = j2.f8503b;
            this.f8511d = j2.f8505d;
            if (j2.f8506e.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = new LinkedHashMap<>(j2.f8506e);
            }
            this.f8512e = map;
            this.f8510c = j2.f8504c.a();
        }

        public a a(A a2) {
            this.f8510c = a2.a();
            return this;
        }

        public a a(String str, L l2) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() != 0) {
                String str2 = "method ";
                if (l2 != null && !g.b(str)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(str);
                    sb.append(" must not have a request body.");
                    throw new IllegalArgumentException(sb.toString());
                } else if (l2 != null || !g.e(str)) {
                    this.f8509b = str;
                    this.f8511d = l2;
                    return this;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append(str);
                    sb2.append(" must have a request body.");
                    throw new IllegalArgumentException(sb2.toString());
                }
            } else {
                throw new IllegalArgumentException("method.length() == 0");
            }
        }

        public a b(String str, String str2) {
            this.f8510c.c(str, str2);
            return this;
        }

        public J a() {
            if (this.f8508a != null) {
                return new J(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    J(a aVar) {
        this.f8502a = aVar.f8508a;
        this.f8503b = aVar.f8509b;
        this.f8504c = aVar.f8510c.a();
        this.f8505d = aVar.f8511d;
        this.f8506e = e.a(aVar.f8512e);
    }

    public String a(String str) {
        return this.f8504c.b(str);
    }

    public C0720i b() {
        C0720i iVar = this.f8507f;
        if (iVar != null) {
            return iVar;
        }
        C0720i a2 = C0720i.a(this.f8504c);
        this.f8507f = a2;
        return a2;
    }

    public A c() {
        return this.f8504c;
    }

    public boolean d() {
        return this.f8502a.h();
    }

    public String e() {
        return this.f8503b;
    }

    public a f() {
        return new a(this);
    }

    public B g() {
        return this.f8502a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f8503b);
        sb.append(", url=");
        sb.append(this.f8502a);
        sb.append(", tags=");
        sb.append(this.f8506e);
        sb.append('}');
        return sb.toString();
    }

    public L a() {
        return this.f8505d;
    }
}
