package io.intercom.com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* compiled from: JsonWriter */
public class d implements Closeable, Flushable {

    /* renamed from: a reason: collision with root package name */
    private static final String[] f10213a = new String[128];

    /* renamed from: b reason: collision with root package name */
    private static final String[] f10214b;

    /* renamed from: c reason: collision with root package name */
    private final Writer f10215c;

    /* renamed from: d reason: collision with root package name */
    private int[] f10216d = new int[32];

    /* renamed from: e reason: collision with root package name */
    private int f10217e = 0;

    /* renamed from: f reason: collision with root package name */
    private String f10218f;

    /* renamed from: g reason: collision with root package name */
    private String f10219g;

    /* renamed from: h reason: collision with root package name */
    private boolean f10220h;

    /* renamed from: i reason: collision with root package name */
    private boolean f10221i;

    /* renamed from: j reason: collision with root package name */
    private String f10222j;

    /* renamed from: k reason: collision with root package name */
    private boolean f10223k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f10213a[i2] = String.format("\\u%04x", new Object[]{Integer.valueOf(i2)});
        }
        String[] strArr = f10213a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f10214b = (String[]) strArr.clone();
        String[] strArr2 = f10214b;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public d(Writer writer) {
        a(6);
        this.f10219g = ":";
        this.f10223k = true;
        if (writer != null) {
            this.f10215c = writer;
            return;
        }
        throw new NullPointerException("out == null");
    }

    private void i() throws IOException {
        int l2 = l();
        if (l2 == 5) {
            this.f10215c.write(44);
        } else if (l2 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    private void j() throws IOException {
        int l2 = l();
        if (l2 == 1) {
            b(2);
            k();
        } else if (l2 == 2) {
            this.f10215c.append(',');
            k();
        } else if (l2 != 4) {
            if (l2 != 6) {
                if (l2 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.f10220h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        } else {
            this.f10215c.append(this.f10219g);
            b(5);
        }
    }

    private void k() throws IOException {
        if (this.f10218f != null) {
            this.f10215c.write("\n");
            int i2 = this.f10217e;
            for (int i3 = 1; i3 < i2; i3++) {
                this.f10215c.write(this.f10218f);
            }
        }
    }

    private int l() {
        int i2 = this.f10217e;
        if (i2 != 0) {
            return this.f10216d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void m() throws IOException {
        if (this.f10222j != null) {
            i();
            e(this.f10222j);
            this.f10222j = null;
        }
    }

    public final void a(boolean z) {
        this.f10221i = z;
    }

    public final void b(boolean z) {
        this.f10220h = z;
    }

    public final void c(String str) {
        if (str.length() == 0) {
            this.f10218f = null;
            this.f10219g = ":";
            return;
        }
        this.f10218f = str;
        this.f10219g = ": ";
    }

    public void close() throws IOException {
        this.f10215c.close();
        int i2 = this.f10217e;
        if (i2 > 1 || (i2 == 1 && this.f10216d[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f10217e = 0;
    }

    public d d() throws IOException {
        a(3, 5, "}");
        return this;
    }

    public final boolean e() {
        return this.f10223k;
    }

    public final boolean f() {
        return this.f10221i;
    }

    public void flush() throws IOException {
        if (this.f10217e != 0) {
            this.f10215c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public boolean g() {
        return this.f10220h;
    }

    public d h() throws IOException {
        if (this.f10222j != null) {
            if (this.f10223k) {
                m();
            } else {
                this.f10222j = null;
                return this;
            }
        }
        j();
        this.f10215c.write("null");
        return this;
    }

    private void e(String str) throws IOException {
        String str2;
        String[] strArr = this.f10221i ? f10214b : f10213a;
        String str3 = "\"";
        this.f10215c.write(str3);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i2 < i3) {
                this.f10215c.write(str, i2, i3 - i2);
            }
            this.f10215c.write(str2);
            i2 = i3 + 1;
        }
        if (i2 < length) {
            this.f10215c.write(str, i2, length - i2);
        }
        this.f10215c.write(str3);
    }

    public d a() throws IOException {
        m();
        a(1, "[");
        return this;
    }

    public d b() throws IOException {
        m();
        a(3, "{");
        return this;
    }

    public d d(String str) throws IOException {
        if (str == null) {
            return h();
        }
        m();
        j();
        e(str);
        return this;
    }

    private d a(int i2, String str) throws IOException {
        j();
        a(i2);
        this.f10215c.write(str);
        return this;
    }

    private void b(int i2) {
        this.f10216d[this.f10217e - 1] = i2;
    }

    public d b(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.f10222j != null) {
            throw new IllegalStateException();
        } else if (this.f10217e != 0) {
            this.f10222j = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public final void c(boolean z) {
        this.f10223k = z;
    }

    public d d(boolean z) throws IOException {
        m();
        j();
        this.f10215c.write(z ? "true" : "false");
        return this;
    }

    private d a(int i2, int i3, String str) throws IOException {
        int l2 = l();
        if (l2 != i3 && l2 != i2) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.f10222j == null) {
            this.f10217e--;
            if (l2 == i3) {
                k();
            }
            this.f10215c.write(str);
            return this;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Dangling name: ");
            sb.append(this.f10222j);
            throw new IllegalStateException(sb.toString());
        }
    }

    public d c() throws IOException {
        a(1, 2, "]");
        return this;
    }

    public d h(long j2) throws IOException {
        m();
        j();
        this.f10215c.write(Long.toString(j2));
        return this;
    }

    private void a(int i2) {
        int i3 = this.f10217e;
        int[] iArr = this.f10216d;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[(i3 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f10216d = iArr2;
        }
        int[] iArr3 = this.f10216d;
        int i4 = this.f10217e;
        this.f10217e = i4 + 1;
        iArr3[i4] = i2;
    }

    public d a(Boolean bool) throws IOException {
        if (bool == null) {
            return h();
        }
        m();
        j();
        this.f10215c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public d a(Number number) throws IOException {
        if (number == null) {
            return h();
        }
        m();
        String obj = number.toString();
        if (this.f10220h || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            j();
            this.f10215c.append(obj);
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Numeric values must be finite, but was ");
        sb.append(number);
        throw new IllegalArgumentException(sb.toString());
    }
}
