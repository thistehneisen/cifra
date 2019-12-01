package i;

import i.a.e;
import j.f;
import j.g;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FormBody */
public final class y extends L {

    /* renamed from: a reason: collision with root package name */
    private static final D f8770a = D.a("application/x-www-form-urlencoded");

    /* renamed from: b reason: collision with root package name */
    private final List<String> f8771b;

    /* renamed from: c reason: collision with root package name */
    private final List<String> f8772c;

    /* compiled from: FormBody */
    public static final class a {

        /* renamed from: a reason: collision with root package name */
        private final List<String> f8773a;

        /* renamed from: b reason: collision with root package name */
        private final List<String> f8774b;

        /* renamed from: c reason: collision with root package name */
        private final Charset f8775c;

        public a() {
            this(null);
        }

        public a a(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                String str3 = str;
                this.f8773a.add(B.a(str3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f8775c));
                String str4 = str2;
                this.f8774b.add(B.a(str4, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f8775c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public a b(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            } else if (str2 != null) {
                String str3 = str;
                this.f8773a.add(B.a(str3, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f8775c));
                String str4 = str2;
                this.f8774b.add(B.a(str4, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f8775c));
                return this;
            } else {
                throw new NullPointerException("value == null");
            }
        }

        public a(Charset charset) {
            this.f8773a = new ArrayList();
            this.f8774b = new ArrayList();
            this.f8775c = charset;
        }

        public y a() {
            return new y(this.f8773a, this.f8774b);
        }
    }

    y(List<String> list, List<String> list2) {
        this.f8771b = e.a(list);
        this.f8772c = e.a(list2);
    }

    public long a() {
        return a(null, true);
    }

    public D b() {
        return f8770a;
    }

    public void a(g gVar) throws IOException {
        a(gVar, false);
    }

    private long a(g gVar, boolean z) {
        f fVar;
        if (z) {
            fVar = new f();
        } else {
            fVar = gVar.n();
        }
        int size = this.f8771b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                fVar.writeByte(38);
            }
            fVar.a((String) this.f8771b.get(i2));
            fVar.writeByte(61);
            fVar.a((String) this.f8772c.get(i2));
        }
        if (!z) {
            return 0;
        }
        long size2 = fVar.size();
        fVar.a();
        return size2;
    }
}
