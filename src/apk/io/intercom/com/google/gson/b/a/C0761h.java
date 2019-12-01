package io.intercom.com.google.gson.b.a;

import io.intercom.com.google.gson.q;
import io.intercom.com.google.gson.stream.b;
import io.intercom.com.google.gson.stream.c;
import io.intercom.com.google.gson.u;
import io.intercom.com.google.gson.v;
import io.intercom.com.google.gson.w;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;

/* renamed from: io.intercom.com.google.gson.b.a.h reason: case insensitive filesystem */
/* compiled from: JsonTreeReader */
public final class C0761h extends b {
    private static final Reader q = new C0760g();
    private static final Object r = new Object();
    private Object[] s;
    private int t;
    private String[] u;
    private int[] v;

    private Object Q() {
        return this.s[this.t - 1];
    }

    private Object R() {
        Object[] objArr = this.s;
        int i2 = this.t - 1;
        this.t = i2;
        Object obj = objArr[i2];
        objArr[this.t] = null;
        return obj;
    }

    private String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(" at path ");
        sb.append(f());
        return sb.toString();
    }

    public String D() throws IOException {
        a(c.NAME);
        Entry entry = (Entry) ((Iterator) Q()).next();
        String str = (String) entry.getKey();
        this.u[this.t - 1] = str;
        a(entry.getValue());
        return str;
    }

    public void E() throws IOException {
        a(c.NULL);
        R();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public String F() throws IOException {
        c G = G();
        if (G == c.STRING || G == c.NUMBER) {
            String r2 = ((w) R()).r();
            int i2 = this.t;
            if (i2 > 0) {
                int[] iArr = this.v;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return r2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(c.STRING);
        sb.append(" but was ");
        sb.append(G);
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    public c G() throws IOException {
        if (this.t == 0) {
            return c.END_DOCUMENT;
        }
        Object Q = Q();
        if (Q instanceof Iterator) {
            boolean z = this.s[this.t - 2] instanceof v;
            Iterator it = (Iterator) Q;
            if (!it.hasNext()) {
                return z ? c.END_OBJECT : c.END_ARRAY;
            } else if (z) {
                return c.NAME;
            } else {
                a(it.next());
                return G();
            }
        } else if (Q instanceof v) {
            return c.BEGIN_OBJECT;
        } else {
            if (Q instanceof q) {
                return c.BEGIN_ARRAY;
            }
            if (Q instanceof w) {
                w wVar = (w) Q;
                if (wVar.u()) {
                    return c.STRING;
                }
                if (wVar.s()) {
                    return c.BOOLEAN;
                }
                if (wVar.t()) {
                    return c.NUMBER;
                }
                throw new AssertionError();
            } else if (Q instanceof u) {
                return c.NULL;
            } else {
                if (Q == r) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    public void H() throws IOException {
        String str = "null";
        if (G() == c.NAME) {
            D();
            this.u[this.t - 2] = str;
        } else {
            R();
            int i2 = this.t;
            if (i2 > 0) {
                this.u[i2 - 1] = str;
            }
        }
        int i3 = this.t;
        if (i3 > 0) {
            int[] iArr = this.v;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    public void I() throws IOException {
        a(c.NAME);
        Entry entry = (Entry) ((Iterator) Q()).next();
        a(entry.getValue());
        a((Object) new w((String) entry.getKey()));
    }

    public void a() throws IOException {
        a(c.BEGIN_ARRAY);
        a((Object) ((q) Q()).iterator());
        this.v[this.t - 1] = 0;
    }

    public void b() throws IOException {
        a(c.BEGIN_OBJECT);
        a((Object) ((v) Q()).l().iterator());
    }

    public void close() throws IOException {
        this.s = new Object[]{r};
        this.t = 1;
    }

    public void d() throws IOException {
        a(c.END_ARRAY);
        R();
        R();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public void e() throws IOException {
        a(c.END_OBJECT);
        R();
        R();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (i2 < this.t) {
            Object[] objArr = this.s;
            if (objArr[i2] instanceof q) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.v[i2]);
                    sb.append(']');
                }
            } else if (objArr[i2] instanceof v) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.u;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
            }
            i2++;
        }
        return sb.toString();
    }

    public boolean g() throws IOException {
        c G = G();
        return (G == c.END_OBJECT || G == c.END_ARRAY) ? false : true;
    }

    public boolean j() throws IOException {
        a(c.BOOLEAN);
        boolean l2 = ((w) R()).l();
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return l2;
    }

    public double k() throws IOException {
        c G = G();
        if (G == c.NUMBER || G == c.STRING) {
            double n = ((w) Q()).n();
            if (h() || (!Double.isNaN(n) && !Double.isInfinite(n))) {
                R();
                int i2 = this.t;
                if (i2 > 0) {
                    int[] iArr = this.v;
                    int i3 = i2 - 1;
                    iArr[i3] = iArr[i3] + 1;
                }
                return n;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("JSON forbids NaN and infinities: ");
            sb.append(n);
            throw new NumberFormatException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Expected ");
        sb2.append(c.NUMBER);
        sb2.append(" but was ");
        sb2.append(G);
        sb2.append(i());
        throw new IllegalStateException(sb2.toString());
    }

    public int l() throws IOException {
        c G = G();
        if (G == c.NUMBER || G == c.STRING) {
            int o = ((w) Q()).o();
            R();
            int i2 = this.t;
            if (i2 > 0) {
                int[] iArr = this.v;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return o;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(c.NUMBER);
        sb.append(" but was ");
        sb.append(G);
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    public long m() throws IOException {
        c G = G();
        if (G == c.NUMBER || G == c.STRING) {
            long p = ((w) Q()).p();
            R();
            int i2 = this.t;
            if (i2 > 0) {
                int[] iArr = this.v;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return p;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(c.NUMBER);
        sb.append(" but was ");
        sb.append(G);
        sb.append(i());
        throw new IllegalStateException(sb.toString());
    }

    public String toString() {
        return C0761h.class.getSimpleName();
    }

    private void a(c cVar) throws IOException {
        if (G() != cVar) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected ");
            sb.append(cVar);
            sb.append(" but was ");
            sb.append(G());
            sb.append(i());
            throw new IllegalStateException(sb.toString());
        }
    }

    private void a(Object obj) {
        int i2 = this.t;
        Object[] objArr = this.s;
        if (i2 == objArr.length) {
            Object[] objArr2 = new Object[(i2 * 2)];
            int[] iArr = new int[(i2 * 2)];
            String[] strArr = new String[(i2 * 2)];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.v, 0, iArr, 0, this.t);
            System.arraycopy(this.u, 0, strArr, 0, this.t);
            this.s = objArr2;
            this.v = iArr;
            this.u = strArr;
        }
        Object[] objArr3 = this.s;
        int i3 = this.t;
        this.t = i3 + 1;
        objArr3[i3] = obj;
    }
}
