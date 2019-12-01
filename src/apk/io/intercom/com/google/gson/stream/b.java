package io.intercom.com.google.gson.stream;

import io.intercom.com.google.gson.b.t;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* compiled from: JsonReader */
public class b implements Closeable {

    /* renamed from: a reason: collision with root package name */
    private static final char[] f10190a = ")]}'\n".toCharArray();

    /* renamed from: b reason: collision with root package name */
    private final Reader f10191b;

    /* renamed from: c reason: collision with root package name */
    private boolean f10192c = false;

    /* renamed from: d reason: collision with root package name */
    private final char[] f10193d = new char[1024];

    /* renamed from: e reason: collision with root package name */
    private int f10194e = 0;

    /* renamed from: f reason: collision with root package name */
    private int f10195f = 0;

    /* renamed from: g reason: collision with root package name */
    private int f10196g = 0;

    /* renamed from: h reason: collision with root package name */
    private int f10197h = 0;

    /* renamed from: i reason: collision with root package name */
    int f10198i = 0;

    /* renamed from: j reason: collision with root package name */
    private long f10199j;

    /* renamed from: k reason: collision with root package name */
    private int f10200k;

    /* renamed from: l reason: collision with root package name */
    private String f10201l;
    private int[] m = new int[32];
    private int n = 0;
    private String[] o;
    private int[] p;

    static {
        t.f10145a = new a();
    }

    public b(Reader reader) {
        int[] iArr = this.m;
        int i2 = this.n;
        this.n = i2 + 1;
        iArr[i2] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader != null) {
            this.f10191b = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    private void I() throws IOException {
        if (!this.f10192c) {
            c("Use JsonReader.setLenient(true) to accept malformed JSON");
            throw null;
        }
    }

    private void J() throws IOException {
        b(true);
        this.f10194e--;
        int i2 = this.f10194e;
        char[] cArr = f10190a;
        if (i2 + cArr.length <= this.f10195f || a(cArr.length)) {
            int i3 = 0;
            while (true) {
                char[] cArr2 = f10190a;
                if (i3 >= cArr2.length) {
                    this.f10194e += cArr2.length;
                    return;
                } else if (this.f10193d[this.f10194e + i3] == cArr2[i3]) {
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        I();
     */
    private String K() throws IOException {
        int i2;
        String str;
        int i3 = 0;
        StringBuilder sb = null;
        while (true) {
            i2 = 0;
            while (true) {
                int i4 = this.f10194e;
                if (i4 + i2 < this.f10195f) {
                    char c2 = this.f10193d[i4 + i2];
                    if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (!(c2 == '/' || c2 == '=')) {
                                    if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= this.f10193d.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.f10193d, this.f10194e, i2);
                    this.f10194e += i2;
                    if (!a(1)) {
                    }
                } else if (a(i2 + 1)) {
                }
            }
        }
        i3 = i2;
        if (sb == null) {
            str = new String(this.f10193d, this.f10194e, i3);
        } else {
            sb.append(this.f10193d, this.f10194e, i3);
            str = sb.toString();
        }
        this.f10194e += i3;
        return str;
    }

    private int L() throws IOException {
        String str;
        String str2;
        int i2;
        char c2 = this.f10193d[this.f10194e];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f10194e + i3 >= this.f10195f && !a(i3 + 1)) {
                return 0;
            }
            char c3 = this.f10193d[this.f10194e + i3];
            if (c3 != str2.charAt(i3) && c3 != str.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f10194e + length < this.f10195f || a(length + 1)) && a(this.f10193d[this.f10194e + length])) {
            return 0;
        }
        this.f10194e += length;
        this.f10198i = i2;
        return i2;
    }

    private int M() throws IOException {
        char c2;
        char[] cArr = this.f10193d;
        int i2 = this.f10194e;
        int i3 = 0;
        int i4 = this.f10195f;
        int i5 = 0;
        char c3 = 0;
        boolean z = true;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 == i4) {
                if (i5 == cArr.length) {
                    return i3;
                }
                if (!a(i5 + 1)) {
                    break;
                }
                i2 = this.f10194e;
                i4 = this.f10195f;
            }
            c2 = cArr[i2 + i5];
            if (c2 == '+') {
                i3 = 0;
                if (c3 != 5) {
                    return 0;
                }
            } else if (c2 == 'E' || c2 == 'e') {
                i3 = 0;
                if (c3 != 2 && c3 != 4) {
                    return 0;
                }
                c3 = 5;
                i5++;
            } else {
                if (c2 == '-') {
                    i3 = 0;
                    if (c3 == 0) {
                        c3 = 1;
                        z2 = true;
                    } else if (c3 != 5) {
                        return 0;
                    }
                } else if (c2 == '.') {
                    i3 = 0;
                    if (c3 != 2) {
                        return 0;
                    }
                    c3 = 3;
                } else if (c2 >= '0' && c2 <= '9') {
                    if (c3 == 1 || c3 == 0) {
                        j2 = (long) (-(c2 - '0'));
                        i3 = 0;
                        c3 = 2;
                    } else {
                        if (c3 == 2) {
                            if (j2 == 0) {
                                return 0;
                            }
                            long j3 = (10 * j2) - ((long) (c2 - '0'));
                            int i6 = (j2 > -922337203685477580L ? 1 : (j2 == -922337203685477580L ? 0 : -1));
                            boolean z3 = i6 > 0 || (i6 == 0 && j3 < j2);
                            j2 = j3;
                            z = z3 & z;
                        } else if (c3 == 3) {
                            i3 = 0;
                            c3 = 4;
                        } else if (c3 == 5 || c3 == 6) {
                            i3 = 0;
                            c3 = 7;
                        }
                        i3 = 0;
                    }
                }
                i5++;
            }
            c3 = 6;
            i5++;
        }
        if (a(c2)) {
            return 0;
        }
        if (c3 == 2 && z && ((j2 != Long.MIN_VALUE || z2) && (j2 != 0 || !z2))) {
            if (!z2) {
                j2 = -j2;
            }
            this.f10199j = j2;
            this.f10194e += i5;
            this.f10198i = 15;
            return 15;
        } else if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        } else {
            this.f10200k = i5;
            this.f10198i = 16;
            return 16;
        }
    }

    private char N() throws IOException {
        int i2;
        int i3;
        String str = "Unterminated escape sequence";
        if (this.f10194e != this.f10195f || a(1)) {
            char[] cArr = this.f10193d;
            int i4 = this.f10194e;
            this.f10194e = i4 + 1;
            char c2 = cArr[i4];
            if (c2 == 10) {
                this.f10196g++;
                this.f10197h = this.f10194e;
            } else if (!(c2 == '\"' || c2 == '\'' || c2 == '/' || c2 == '\\')) {
                if (c2 == 'b') {
                    return 8;
                }
                if (c2 == 'f') {
                    return 12;
                }
                if (c2 == 'n') {
                    return 10;
                }
                if (c2 == 'r') {
                    return 13;
                }
                if (c2 == 't') {
                    return 9;
                }
                if (c2 != 'u') {
                    c("Invalid escape sequence");
                    throw null;
                } else if (this.f10194e + 4 <= this.f10195f || a(4)) {
                    char c3 = 0;
                    int i5 = this.f10194e;
                    int i6 = i5 + 4;
                    while (i5 < i6) {
                        char c4 = this.f10193d[i5];
                        char c5 = (char) (c3 << 4);
                        if (c4 < '0' || c4 > '9') {
                            if (c4 >= 'a' && c4 <= 'f') {
                                i2 = c4 - 'a';
                            } else if (c4 < 'A' || c4 > 'F') {
                                StringBuilder sb = new StringBuilder();
                                sb.append("\\u");
                                sb.append(new String(this.f10193d, this.f10194e, 4));
                                throw new NumberFormatException(sb.toString());
                            } else {
                                i2 = c4 - 'A';
                            }
                            i3 = i2 + 10;
                        } else {
                            i3 = c4 - '0';
                        }
                        c3 = (char) (c5 + i3);
                        i5++;
                    }
                    this.f10194e += 4;
                    return c3;
                } else {
                    c(str);
                    throw null;
                }
            }
            return c2;
        }
        c(str);
        throw null;
    }

    private void O() throws IOException {
        char c2;
        do {
            if (this.f10194e < this.f10195f || a(1)) {
                char[] cArr = this.f10193d;
                int i2 = this.f10194e;
                this.f10194e = i2 + 1;
                c2 = cArr[i2];
                if (c2 == 10) {
                    this.f10196g++;
                    this.f10197h = this.f10194e;
                    return;
                }
            } else {
                return;
            }
        } while (c2 != 13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        I();
     */
    private void P() throws IOException {
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f10194e;
                if (i3 + i2 < this.f10195f) {
                    char c2 = this.f10193d[i3 + i2];
                    if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (!(c2 == '/' || c2 == '=')) {
                                    if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.f10194e = i3 + i2;
                }
            }
            this.f10194e += i2;
            return;
        } while (a(1));
    }

    public String D() throws IOException {
        String str;
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 14) {
            str = K();
        } else if (i2 == 12) {
            str = b('\'');
        } else if (i2 == 13) {
            str = b('\"');
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a name but was ");
            sb.append(G());
            sb.append(i());
            throw new IllegalStateException(sb.toString());
        }
        this.f10198i = 0;
        this.o[this.n - 1] = str;
        return str;
    }

    public void E() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 7) {
            this.f10198i = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected null but was ");
        sb.append(G());
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    public String F() throws IOException {
        String str;
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 10) {
            str = K();
        } else if (i2 == 8) {
            str = b('\'');
        } else if (i2 == 9) {
            str = b('\"');
        } else if (i2 == 11) {
            str = this.f10201l;
            this.f10201l = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f10199j);
        } else if (i2 == 16) {
            str = new String(this.f10193d, this.f10194e, this.f10200k);
            this.f10194e += this.f10200k;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a string but was ");
            sb.append(G());
            sb.append(i());
            throw new IllegalStateException(sb.toString());
        }
        this.f10198i = 0;
        int[] iArr = this.p;
        int i3 = this.n - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public c G() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        switch (i2) {
            case 1:
                return c.BEGIN_OBJECT;
            case 2:
                return c.END_OBJECT;
            case 3:
                return c.BEGIN_ARRAY;
            case 4:
                return c.END_ARRAY;
            case 5:
            case 6:
                return c.BOOLEAN;
            case 7:
                return c.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.STRING;
            case 12:
            case 13:
            case 14:
                return c.NAME;
            case 15:
            case 16:
                return c.NUMBER;
            case 17:
                return c.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void H() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.f10198i;
            if (i3 == 0) {
                i3 = c();
            }
            if (i3 == 3) {
                b(1);
            } else if (i3 == 1) {
                b(3);
            } else {
                if (i3 == 4) {
                    this.n--;
                } else if (i3 == 2) {
                    this.n--;
                } else if (i3 == 14 || i3 == 10) {
                    P();
                    this.f10198i = 0;
                } else if (i3 == 8 || i3 == 12) {
                    c('\'');
                    this.f10198i = 0;
                } else if (i3 == 9 || i3 == 13) {
                    c('\"');
                    this.f10198i = 0;
                } else {
                    if (i3 == 16) {
                        this.f10194e += this.f10200k;
                    }
                    this.f10198i = 0;
                }
                i2--;
                this.f10198i = 0;
            }
            i2++;
            this.f10198i = 0;
        } while (i2 != 0);
        int[] iArr = this.p;
        int i4 = this.n;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.o[i4 - 1] = "null";
    }

    public final void a(boolean z) {
        this.f10192c = z;
    }

    public void b() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 1) {
            b(3);
            this.f10198i = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append(G());
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public int c() throws IOException {
        int[] iArr = this.m;
        int i2 = this.n;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int b2 = b(true);
            if (b2 != 44) {
                if (b2 == 59) {
                    I();
                } else if (b2 == 93) {
                    this.f10198i = 4;
                    return 4;
                } else {
                    c("Unterminated array");
                    throw null;
                }
            }
        } else if (i3 == 3 || i3 == 5) {
            this.m[this.n - 1] = 4;
            if (i3 == 5) {
                int b3 = b(true);
                if (b3 != 44) {
                    if (b3 == 59) {
                        I();
                    } else if (b3 == 125) {
                        this.f10198i = 2;
                        return 2;
                    } else {
                        c("Unterminated object");
                        throw null;
                    }
                }
            }
            int b4 = b(true);
            if (b4 == 34) {
                this.f10198i = 13;
                return 13;
            } else if (b4 != 39) {
                String str = "Expected name";
                if (b4 != 125) {
                    I();
                    this.f10194e--;
                    if (a((char) b4)) {
                        this.f10198i = 14;
                        return 14;
                    }
                    c(str);
                    throw null;
                } else if (i3 != 5) {
                    this.f10198i = 2;
                    return 2;
                } else {
                    c(str);
                    throw null;
                }
            } else {
                I();
                this.f10198i = 12;
                return 12;
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int b5 = b(true);
            if (b5 != 58) {
                if (b5 == 61) {
                    I();
                    if (this.f10194e < this.f10195f || a(1)) {
                        char[] cArr = this.f10193d;
                        int i4 = this.f10194e;
                        if (cArr[i4] == '>') {
                            this.f10194e = i4 + 1;
                        }
                    }
                } else {
                    c("Expected ':'");
                    throw null;
                }
            }
        } else if (i3 == 6) {
            if (this.f10192c) {
                J();
            }
            this.m[this.n - 1] = 7;
        } else if (i3 == 7) {
            if (b(false) == -1) {
                this.f10198i = 17;
                return 17;
            }
            I();
            this.f10194e--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int b6 = b(true);
        if (b6 == 34) {
            this.f10198i = 9;
            return 9;
        } else if (b6 != 39) {
            if (!(b6 == 44 || b6 == 59)) {
                if (b6 == 91) {
                    this.f10198i = 3;
                    return 3;
                } else if (b6 != 93) {
                    if (b6 != 123) {
                        this.f10194e--;
                        int L = L();
                        if (L != 0) {
                            return L;
                        }
                        int M = M();
                        if (M != 0) {
                            return M;
                        }
                        if (a(this.f10193d[this.f10194e])) {
                            I();
                            this.f10198i = 10;
                            return 10;
                        }
                        c("Expected value");
                        throw null;
                    }
                    this.f10198i = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f10198i = 4;
                    return 4;
                }
            }
            if (i3 == 1 || i3 == 2) {
                I();
                this.f10194e--;
                this.f10198i = 7;
                return 7;
            }
            c("Unexpected value");
            throw null;
        } else {
            I();
            this.f10198i = 8;
            return 8;
        }
    }

    public void close() throws IOException {
        this.f10198i = 0;
        this.m[0] = 8;
        this.n = 1;
        this.f10191b.close();
    }

    public void d() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 4) {
            this.n--;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            this.f10198i = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected END_ARRAY but was ");
        sb.append(G());
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    public void e() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 2) {
            this.n--;
            String[] strArr = this.o;
            int i3 = this.n;
            strArr[i3] = null;
            int[] iArr = this.p;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f10198i = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected END_OBJECT but was ");
        sb.append(G());
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.n;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.m[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.p[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.o;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public boolean g() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean h() {
        return this.f10192c;
    }

    /* access modifiers changed from: 0000 */
    public String i() {
        int i2 = this.f10196g + 1;
        int i3 = (this.f10194e - this.f10197h) + 1;
        StringBuilder sb = new StringBuilder();
        sb.append(" at line ");
        sb.append(i2);
        sb.append(" column ");
        sb.append(i3);
        sb.append(" path ");
        sb.append(f());
        return sb.toString();
    }

    public boolean j() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 5) {
            this.f10198i = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f10198i = 0;
            int[] iArr2 = this.p;
            int i4 = this.n - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a boolean but was ");
            sb.append(G());
            sb.append(i());
            throw new IllegalStateException(sb.toString());
        }
    }

    public double k() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 15) {
            this.f10198i = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return (double) this.f10199j;
        }
        if (i2 == 16) {
            this.f10201l = new String(this.f10193d, this.f10194e, this.f10200k);
            this.f10194e += this.f10200k;
        } else if (i2 == 8 || i2 == 9) {
            this.f10201l = b(i2 == 8 ? '\'' : '\"');
        } else if (i2 == 10) {
            this.f10201l = K();
        } else if (i2 != 11) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a double but was ");
            sb.append(G());
            sb.append(i());
            throw new IllegalStateException(sb.toString());
        }
        this.f10198i = 11;
        double parseDouble = Double.parseDouble(this.f10201l);
        if (this.f10192c || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.f10201l = null;
            this.f10198i = 0;
            int[] iArr2 = this.p;
            int i4 = this.n - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("JSON forbids NaN and infinities: ");
        sb2.append(parseDouble);
        sb2.append(i());
        throw new MalformedJsonException(sb2.toString());
    }

    public int l() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        String str = "Expected an int but was ";
        if (i2 == 15) {
            long j2 = this.f10199j;
            int i3 = (int) j2;
            if (j2 == ((long) i3)) {
                this.f10198i = 0;
                int[] iArr = this.p;
                int i4 = this.n - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.f10199j);
            sb.append(i());
            throw new NumberFormatException(sb.toString());
        }
        if (i2 == 16) {
            this.f10201l = new String(this.f10193d, this.f10194e, this.f10200k);
            this.f10194e += this.f10200k;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.f10201l = K();
            } else {
                this.f10201l = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                int parseInt = Integer.parseInt(this.f10201l);
                this.f10198i = 0;
                int[] iArr2 = this.p;
                int i5 = this.n - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(G());
            sb2.append(i());
            throw new IllegalStateException(sb2.toString());
        }
        this.f10198i = 11;
        double parseDouble = Double.parseDouble(this.f10201l);
        int i6 = (int) parseDouble;
        if (((double) i6) == parseDouble) {
            this.f10201l = null;
            this.f10198i = 0;
            int[] iArr3 = this.p;
            int i7 = this.n - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append(this.f10201l);
        sb3.append(i());
        throw new NumberFormatException(sb3.toString());
    }

    public long m() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 15) {
            this.f10198i = 0;
            int[] iArr = this.p;
            int i3 = this.n - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f10199j;
        }
        String str = "Expected a long but was ";
        if (i2 == 16) {
            this.f10201l = new String(this.f10193d, this.f10194e, this.f10200k);
            this.f10194e += this.f10200k;
        } else if (i2 == 8 || i2 == 9 || i2 == 10) {
            if (i2 == 10) {
                this.f10201l = K();
            } else {
                this.f10201l = b(i2 == 8 ? '\'' : '\"');
            }
            try {
                long parseLong = Long.parseLong(this.f10201l);
                this.f10198i = 0;
                int[] iArr2 = this.p;
                int i4 = this.n - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(G());
            sb.append(i());
            throw new IllegalStateException(sb.toString());
        }
        this.f10198i = 11;
        double parseDouble = Double.parseDouble(this.f10201l);
        long j2 = (long) parseDouble;
        if (((double) j2) == parseDouble) {
            this.f10201l = null;
            this.f10198i = 0;
            int[] iArr3 = this.p;
            int i5 = this.n - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.f10201l);
        sb2.append(i());
        throw new NumberFormatException(sb2.toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(i());
        return sb.toString();
    }

    public void a() throws IOException {
        int i2 = this.f10198i;
        if (i2 == 0) {
            i2 = c();
        }
        if (i2 == 3) {
            b(1);
            this.p[this.n - 1] = 0;
            this.f10198i = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append(G());
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r2 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r5) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        r2.append(r0, r5, r3 - r5);
        r10.f10194e = r3;
     */
    private String b(char c2) throws IOException {
        char[] cArr = this.f10193d;
        StringBuilder sb = null;
        do {
            int i2 = this.f10194e;
            int i3 = this.f10195f;
            while (true) {
                int i4 = i2;
                while (i2 < i3) {
                    int i5 = i2 + 1;
                    char c3 = cArr[i2];
                    if (c3 == c2) {
                        this.f10194e = i5;
                        int i6 = (i5 - i4) - 1;
                        if (sb == null) {
                            return new String(cArr, i4, i6);
                        }
                        sb.append(cArr, i4, i6);
                        return sb.toString();
                    } else if (c3 == '\\') {
                        this.f10194e = i5;
                        int i7 = (i5 - i4) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i7 + 1) * 2, 16));
                        }
                        sb.append(cArr, i4, i7);
                        sb.append(N());
                        i2 = this.f10194e;
                        i3 = this.f10195f;
                    } else {
                        if (c3 == 10) {
                            this.f10196g++;
                            this.f10197h = i5;
                        }
                        i2 = i5;
                    }
                }
                break;
            }
        } while (a(1));
        c("Unterminated string");
        throw null;
    }

    private boolean a(char c2) throws IOException {
        if (!(c2 == 9 || c2 == 10 || c2 == 12 || c2 == 13 || c2 == ' ')) {
            if (c2 != '#') {
                if (c2 != ',') {
                    if (!(c2 == '/' || c2 == '=')) {
                        if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                            if (c2 != ';') {
                                switch (c2) {
                                    case '[':
                                    case ']':
                                        break;
                                    case '\\':
                                        break;
                                    default:
                                        return true;
                                }
                            }
                        }
                    }
                }
            }
            I();
        }
        return false;
    }

    private boolean a(int i2) throws IOException {
        char[] cArr = this.f10193d;
        int i3 = this.f10197h;
        int i4 = this.f10194e;
        this.f10197h = i3 - i4;
        int i5 = this.f10195f;
        if (i5 != i4) {
            this.f10195f = i5 - i4;
            System.arraycopy(cArr, i4, cArr, 0, this.f10195f);
        } else {
            this.f10195f = 0;
        }
        this.f10194e = 0;
        do {
            Reader reader = this.f10191b;
            int i6 = this.f10195f;
            int read = reader.read(cArr, i6, cArr.length - i6);
            if (read == -1) {
                return false;
            }
            this.f10195f += read;
            if (this.f10196g == 0) {
                int i7 = this.f10197h;
                if (i7 == 0 && this.f10195f > 0 && cArr[0] == 65279) {
                    this.f10194e++;
                    this.f10197h = i7 + 1;
                    i2++;
                }
            }
        } while (this.f10195f < i2);
        return true;
    }

    private void b(int i2) {
        int i3 = this.n;
        int[] iArr = this.m;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            int[] iArr3 = new int[(i3 * 2)];
            String[] strArr = new String[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.p, 0, iArr3, 0, this.n);
            System.arraycopy(this.o, 0, strArr, 0, this.n);
            this.m = iArr2;
            this.p = iArr3;
            this.o = strArr;
        }
        int[] iArr4 = this.m;
        int i4 = this.n;
        this.n = i4 + 1;
        iArr4[i4] = i2;
    }

    private int b(boolean z) throws IOException {
        char[] cArr = this.f10193d;
        int i2 = this.f10194e;
        int i3 = this.f10195f;
        while (true) {
            if (i2 == i3) {
                this.f10194e = i2;
                if (a(1)) {
                    i2 = this.f10194e;
                    i3 = this.f10195f;
                } else if (!z) {
                    return -1;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("End of input");
                    sb.append(i());
                    throw new EOFException(sb.toString());
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == 10) {
                this.f10196g++;
                this.f10197h = i4;
            } else if (!(c2 == ' ' || c2 == 13 || c2 == 9)) {
                if (c2 == '/') {
                    this.f10194e = i4;
                    if (i4 == i3) {
                        this.f10194e--;
                        boolean a2 = a(2);
                        this.f10194e++;
                        if (!a2) {
                            return c2;
                        }
                    }
                    I();
                    int i5 = this.f10194e;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f10194e = i5 + 1;
                        if (b("*/")) {
                            i2 = this.f10194e + 2;
                            i3 = this.f10195f;
                        } else {
                            c("Unterminated comment");
                            throw null;
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f10194e = i5 + 1;
                        O();
                        i2 = this.f10194e;
                        i3 = this.f10195f;
                    }
                } else if (c2 == '#') {
                    this.f10194e = i4;
                    I();
                    O();
                    i2 = this.f10194e;
                    i3 = this.f10195f;
                } else {
                    this.f10194e = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private void c(char c2) throws IOException {
        char[] cArr = this.f10193d;
        do {
            int i2 = this.f10194e;
            int i3 = this.f10195f;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f10194e = i4;
                    return;
                } else if (c3 == '\\') {
                    this.f10194e = i4;
                    N();
                    i2 = this.f10194e;
                    i3 = this.f10195f;
                } else {
                    if (c3 == 10) {
                        this.f10196g++;
                        this.f10197h = i4;
                    }
                    i2 = i4;
                }
            }
            this.f10194e = i2;
        } while (a(1));
        c("Unterminated string");
        throw null;
    }

    private IOException c(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i());
        throw new MalformedJsonException(sb.toString());
    }

    private boolean b(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i2 = 0;
            if (this.f10194e + length > this.f10195f && !a(length)) {
                return false;
            }
            char[] cArr = this.f10193d;
            int i3 = this.f10194e;
            if (cArr[i3] == 10) {
                this.f10196g++;
                this.f10197h = i3 + 1;
            } else {
                while (i2 < length) {
                    if (this.f10193d[this.f10194e + i2] == str.charAt(i2)) {
                        i2++;
                    }
                }
                return true;
            }
            this.f10194e++;
        }
    }
}
