package okhttp3.internal.http2;

import com.appsflyer.share.Constants;
import io.intercom.android.sdk.views.holder.AttributeType;
import j.A;
import j.f;
import j.h;
import j.i;
import j.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: Hpack */
final class c {

    /* renamed from: a reason: collision with root package name */
    static final b[] f10549a;

    /* renamed from: b reason: collision with root package name */
    static final Map<i, Integer> f10550b = a();

    /* compiled from: Hpack */
    static final class a {

        /* renamed from: a reason: collision with root package name */
        private final List<b> f10551a;

        /* renamed from: b reason: collision with root package name */
        private final h f10552b;

        /* renamed from: c reason: collision with root package name */
        private final int f10553c;

        /* renamed from: d reason: collision with root package name */
        private int f10554d;

        /* renamed from: e reason: collision with root package name */
        b[] f10555e;

        /* renamed from: f reason: collision with root package name */
        int f10556f;

        /* renamed from: g reason: collision with root package name */
        int f10557g;

        /* renamed from: h reason: collision with root package name */
        int f10558h;

        a(int i2, A a2) {
            this(i2, i2, a2);
        }

        private int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f10555e.length;
                while (true) {
                    length--;
                    if (length < this.f10556f || i2 <= 0) {
                        b[] bVarArr = this.f10555e;
                        int i4 = this.f10556f;
                        System.arraycopy(bVarArr, i4 + 1, bVarArr, i4 + 1 + i3, this.f10557g);
                        this.f10556f += i3;
                    } else {
                        b[] bVarArr2 = this.f10555e;
                        i2 -= bVarArr2[length].f10548i;
                        this.f10558h -= bVarArr2[length].f10548i;
                        this.f10557g--;
                        i3++;
                    }
                }
                b[] bVarArr3 = this.f10555e;
                int i42 = this.f10556f;
                System.arraycopy(bVarArr3, i42 + 1, bVarArr3, i42 + 1 + i3, this.f10557g);
                this.f10556f += i3;
            }
            return i3;
        }

        private void d() {
            int i2 = this.f10554d;
            int i3 = this.f10558h;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                e();
            } else {
                b(i3 - i2);
            }
        }

        private void e() {
            Arrays.fill(this.f10555e, null);
            this.f10556f = this.f10555e.length - 1;
            this.f10557g = 0;
            this.f10558h = 0;
        }

        private void f(int i2) throws IOException {
            a(-1, new b(c(i2), b()));
        }

        private void g(int i2) throws IOException {
            this.f10551a.add(new b(c(i2), b()));
        }

        private void h() throws IOException {
            i b2 = b();
            c.a(b2);
            this.f10551a.add(new b(b2, b()));
        }

        public List<b> a() {
            ArrayList arrayList = new ArrayList(this.f10551a);
            this.f10551a.clear();
            return arrayList;
        }

        /* access modifiers changed from: 0000 */
        public void c() throws IOException {
            while (!this.f10552b.o()) {
                byte readByte = this.f10552b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    e(a((int) readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    f(a((int) readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    this.f10554d = a((int) readByte, 31);
                    int i2 = this.f10554d;
                    if (i2 < 0 || i2 > this.f10553c) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Invalid dynamic table size update ");
                        sb.append(this.f10554d);
                        throw new IOException(sb.toString());
                    }
                    d();
                } else if (readByte == 16 || readByte == 0) {
                    h();
                } else {
                    g(a((int) readByte, 15) - 1);
                }
            }
        }

        a(int i2, int i3, A a2) {
            this.f10551a = new ArrayList();
            this.f10555e = new b[8];
            this.f10556f = this.f10555e.length - 1;
            this.f10557g = 0;
            this.f10558h = 0;
            this.f10553c = i2;
            this.f10554d = i3;
            this.f10552b = r.a(a2);
        }

        private int a(int i2) {
            return this.f10556f + 1 + i2;
        }

        private void a(int i2, b bVar) {
            this.f10551a.add(bVar);
            int i3 = bVar.f10548i;
            if (i2 != -1) {
                i3 -= this.f10555e[a(i2)].f10548i;
            }
            int i4 = this.f10554d;
            if (i3 > i4) {
                e();
                return;
            }
            int b2 = b((this.f10558h + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f10557g + 1;
                b[] bVarArr = this.f10555e;
                if (i5 > bVarArr.length) {
                    b[] bVarArr2 = new b[(bVarArr.length * 2)];
                    System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                    this.f10556f = this.f10555e.length - 1;
                    this.f10555e = bVarArr2;
                }
                int i6 = this.f10556f;
                this.f10556f = i6 - 1;
                this.f10555e[i6] = bVar;
                this.f10557g++;
            } else {
                this.f10555e[i2 + a(i2) + b2] = bVar;
            }
            this.f10558h += i3;
        }

        private boolean d(int i2) {
            return i2 >= 0 && i2 <= c.f10549a.length - 1;
        }

        private int f() throws IOException {
            return this.f10552b.readByte() & 255;
        }

        private void g() throws IOException {
            i b2 = b();
            c.a(b2);
            a(-1, new b(b2, b()));
        }

        private void e(int i2) throws IOException {
            if (d(i2)) {
                this.f10551a.add(c.f10549a[i2]);
                return;
            }
            int a2 = a(i2 - c.f10549a.length);
            if (a2 >= 0) {
                b[] bVarArr = this.f10555e;
                if (a2 < bVarArr.length) {
                    this.f10551a.add(bVarArr[a2]);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Header index too large ");
            sb.append(i2 + 1);
            throw new IOException(sb.toString());
        }

        /* access modifiers changed from: 0000 */
        public i b() throws IOException {
            int f2 = f();
            boolean z = (f2 & 128) == 128;
            int a2 = a(f2, 127);
            if (z) {
                return i.a(t.a().a(this.f10552b.d((long) a2)));
            }
            return this.f10552b.b((long) a2);
        }

        private i c(int i2) throws IOException {
            if (d(i2)) {
                return c.f10549a[i2].f10546g;
            }
            int a2 = a(i2 - c.f10549a.length);
            if (a2 >= 0) {
                b[] bVarArr = this.f10555e;
                if (a2 < bVarArr.length) {
                    return bVarArr[a2].f10546g;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Header index too large ");
            sb.append(i2 + 1);
            throw new IOException(sb.toString());
        }

        /* access modifiers changed from: 0000 */
        public int a(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int f2 = f();
                if ((f2 & 128) == 0) {
                    return i3 + (f2 << i5);
                }
                i3 += (f2 & 127) << i5;
                i5 += 7;
            }
        }
    }

    /* compiled from: Hpack */
    static final class b {

        /* renamed from: a reason: collision with root package name */
        private final f f10559a;

        /* renamed from: b reason: collision with root package name */
        private final boolean f10560b;

        /* renamed from: c reason: collision with root package name */
        private int f10561c;

        /* renamed from: d reason: collision with root package name */
        private boolean f10562d;

        /* renamed from: e reason: collision with root package name */
        int f10563e;

        /* renamed from: f reason: collision with root package name */
        int f10564f;

        /* renamed from: g reason: collision with root package name */
        b[] f10565g;

        /* renamed from: h reason: collision with root package name */
        int f10566h;

        /* renamed from: i reason: collision with root package name */
        int f10567i;

        /* renamed from: j reason: collision with root package name */
        int f10568j;

        b(f fVar) {
            this(CodedOutputStream.DEFAULT_BUFFER_SIZE, true, fVar);
        }

        private void a(b bVar) {
            int i2 = bVar.f10548i;
            int i3 = this.f10564f;
            if (i2 > i3) {
                b();
                return;
            }
            b((this.f10568j + i2) - i3);
            int i4 = this.f10567i + 1;
            b[] bVarArr = this.f10565g;
            if (i4 > bVarArr.length) {
                b[] bVarArr2 = new b[(bVarArr.length * 2)];
                System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
                this.f10566h = this.f10565g.length - 1;
                this.f10565g = bVarArr2;
            }
            int i5 = this.f10566h;
            this.f10566h = i5 - 1;
            this.f10565g[i5] = bVar;
            this.f10567i++;
            this.f10568j += i2;
        }

        private void b() {
            Arrays.fill(this.f10565g, null);
            this.f10566h = this.f10565g.length - 1;
            this.f10567i = 0;
            this.f10568j = 0;
        }

        b(int i2, boolean z, f fVar) {
            this.f10561c = Integer.MAX_VALUE;
            this.f10565g = new b[8];
            this.f10566h = this.f10565g.length - 1;
            this.f10567i = 0;
            this.f10568j = 0;
            this.f10563e = i2;
            this.f10564f = i2;
            this.f10560b = z;
            this.f10559a = fVar;
        }

        private int b(int i2) {
            int i3 = 0;
            if (i2 > 0) {
                int length = this.f10565g.length;
                while (true) {
                    length--;
                    if (length < this.f10566h || i2 <= 0) {
                        b[] bVarArr = this.f10565g;
                        int i4 = this.f10566h;
                        System.arraycopy(bVarArr, i4 + 1, bVarArr, i4 + 1 + i3, this.f10567i);
                        b[] bVarArr2 = this.f10565g;
                        int i5 = this.f10566h;
                        Arrays.fill(bVarArr2, i5 + 1, i5 + 1 + i3, null);
                        this.f10566h += i3;
                    } else {
                        b[] bVarArr3 = this.f10565g;
                        i2 -= bVarArr3[length].f10548i;
                        this.f10568j -= bVarArr3[length].f10548i;
                        this.f10567i--;
                        i3++;
                    }
                }
                b[] bVarArr4 = this.f10565g;
                int i42 = this.f10566h;
                System.arraycopy(bVarArr4, i42 + 1, bVarArr4, i42 + 1 + i3, this.f10567i);
                b[] bVarArr22 = this.f10565g;
                int i52 = this.f10566h;
                Arrays.fill(bVarArr22, i52 + 1, i52 + 1 + i3, null);
                this.f10566h += i3;
            }
            return i3;
        }

        /* access modifiers changed from: 0000 */
        public void a(List<b> list) throws IOException {
            int i2;
            int i3;
            if (this.f10562d) {
                int i4 = this.f10561c;
                if (i4 < this.f10564f) {
                    a(i4, 31, 32);
                }
                this.f10562d = false;
                this.f10561c = Integer.MAX_VALUE;
                a(this.f10564f, 31, 32);
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                b bVar = (b) list.get(i5);
                i e2 = bVar.f10546g.e();
                i iVar = bVar.f10547h;
                Integer num = (Integer) c.f10550b.get(e2);
                if (num != null) {
                    i3 = num.intValue() + 1;
                    if (i3 > 1 && i3 < 8) {
                        if (Objects.equals(c.f10549a[i3 - 1].f10547h, iVar)) {
                            i2 = i3;
                        } else if (Objects.equals(c.f10549a[i3].f10547h, iVar)) {
                            i2 = i3;
                            i3++;
                        }
                    }
                    i2 = i3;
                    i3 = -1;
                } else {
                    i3 = -1;
                    i2 = -1;
                }
                if (i3 == -1) {
                    int i6 = this.f10566h + 1;
                    int length = this.f10565g.length;
                    while (true) {
                        if (i6 >= length) {
                            break;
                        }
                        if (Objects.equals(this.f10565g[i6].f10546g, e2)) {
                            if (Objects.equals(this.f10565g[i6].f10547h, iVar)) {
                                i3 = c.f10549a.length + (i6 - this.f10566h);
                                break;
                            } else if (i2 == -1) {
                                i2 = (i6 - this.f10566h) + c.f10549a.length;
                            }
                        }
                        i6++;
                    }
                }
                if (i3 != -1) {
                    a(i3, 127, 128);
                } else if (i2 == -1) {
                    this.f10559a.writeByte(64);
                    a(e2);
                    a(iVar);
                    a(bVar);
                } else if (!e2.b(b.f10540a) || b.f10545f.equals(e2)) {
                    a(i2, 63, 64);
                    a(iVar);
                    a(bVar);
                } else {
                    a(i2, 15, 0);
                    a(iVar);
                }
            }
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2, int i3, int i4) {
            if (i2 < i3) {
                this.f10559a.writeByte(i2 | i4);
                return;
            }
            this.f10559a.writeByte(i4 | i3);
            int i5 = i2 - i3;
            while (i5 >= 128) {
                this.f10559a.writeByte(128 | (i5 & 127));
                i5 >>>= 7;
            }
            this.f10559a.writeByte(i5);
        }

        /* access modifiers changed from: 0000 */
        public void a(i iVar) throws IOException {
            if (!this.f10560b || t.a().a(iVar) >= iVar.size()) {
                a(iVar.size(), 127, 0);
                this.f10559a.a(iVar);
                return;
            }
            f fVar = new f();
            t.a().a(iVar, fVar);
            i d2 = fVar.d();
            a(d2.size(), 127, 128);
            this.f10559a.a(d2);
        }

        /* access modifiers changed from: 0000 */
        public void a(int i2) {
            this.f10563e = i2;
            int min = Math.min(i2, 16384);
            int i3 = this.f10564f;
            if (i3 != min) {
                if (min < i3) {
                    this.f10561c = Math.min(this.f10561c, min);
                }
                this.f10562d = true;
                this.f10564f = min;
                a();
            }
        }

        private void a() {
            int i2 = this.f10564f;
            int i3 = this.f10568j;
            if (i2 >= i3) {
                return;
            }
            if (i2 == 0) {
                b();
            } else {
                b(i3 - i2);
            }
        }
    }

    static {
        String str = "";
        f10549a = new b[]{new b(b.f10545f, str), new b(b.f10542c, "GET"), new b(b.f10542c, "POST"), new b(b.f10543d, Constants.URL_PATH_DELIMITER), new b(b.f10543d, "/index.html"), new b(b.f10544e, "http"), new b(b.f10544e, "https"), new b(b.f10541b, "200"), new b(b.f10541b, "204"), new b(b.f10541b, "206"), new b(b.f10541b, "304"), new b(b.f10541b, "400"), new b(b.f10541b, "404"), new b(b.f10541b, "500"), new b("accept-charset", str), new b("accept-encoding", "gzip, deflate"), new b("accept-language", str), new b("accept-ranges", str), new b("accept", str), new b("access-control-allow-origin", str), new b("age", str), new b("allow", str), new b("authorization", str), new b("cache-control", str), new b("content-disposition", str), new b("content-encoding", str), new b("content-language", str), new b("content-length", str), new b("content-location", str), new b("content-range", str), new b("content-type", str), new b("cookie", str), new b(AttributeType.DATE, str), new b("etag", str), new b("expect", str), new b("expires", str), new b("from", str), new b("host", str), new b("if-match", str), new b("if-modified-since", str), new b("if-none-match", str), new b("if-range", str), new b("if-unmodified-since", str), new b("last-modified", str), new b("link", str), new b("location", str), new b("max-forwards", str), new b("proxy-authenticate", str), new b("proxy-authorization", str), new b("range", str), new b("referer", str), new b("refresh", str), new b("retry-after", str), new b("server", str), new b("set-cookie", str), new b("strict-transport-security", str), new b("transfer-encoding", str), new b("user-agent", str), new b("vary", str), new b("via", str), new b("www-authenticate", str)};
    }

    private static Map<i, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f10549a.length);
        int i2 = 0;
        while (true) {
            b[] bVarArr = f10549a;
            if (i2 >= bVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(bVarArr[i2].f10546g)) {
                linkedHashMap.put(f10549a[i2].f10546g, Integer.valueOf(i2));
            }
            i2++;
        }
    }

    static i a(i iVar) throws IOException {
        int size = iVar.size();
        int i2 = 0;
        while (i2 < size) {
            byte b2 = iVar.b(i2);
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("PROTOCOL_ERROR response malformed: mixed case name: ");
                sb.append(iVar.g());
                throw new IOException(sb.toString());
            }
        }
        return iVar;
    }
}
