package com.fasterxml.jackson.core.a;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.e;
import com.fasterxml.jackson.core.e.a;
import com.fasterxml.jackson.core.e.h;
import com.fasterxml.jackson.core.g;
import java.io.IOException;

/* compiled from: ParserMinimalBase */
public abstract class c extends e {

    /* renamed from: b reason: collision with root package name */
    protected g f4175b;

    protected c() {
    }

    public e G() throws IOException {
        g gVar = this.f4175b;
        if (gVar != g.START_OBJECT && gVar != g.START_ARRAY) {
            return this;
        }
        int i2 = 1;
        while (true) {
            g F = F();
            if (F == null) {
                H();
                return this;
            } else if (F.e()) {
                i2++;
            } else if (F.d()) {
                i2--;
                if (i2 == 0) {
                    return this;
                }
            } else {
                continue;
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void H() throws JsonParseException;

    /* access modifiers changed from: protected */
    public void I() throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append(" in ");
        sb.append(this.f4175b);
        f(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public void J() throws JsonParseException {
        f(" in a value");
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void K() {
        h.a();
        throw null;
    }

    public boolean a(boolean z) throws IOException {
        g gVar = this.f4175b;
        if (gVar != null) {
            boolean z2 = true;
            switch (gVar.b()) {
                case 6:
                    String trim = j().trim();
                    if ("true".equals(trim)) {
                        return true;
                    }
                    if (!"false".equals(trim) && !d(trim)) {
                        return z;
                    }
                    return false;
                case 7:
                    if (h() == 0) {
                        z2 = false;
                    }
                    return z2;
                case 9:
                    return true;
                case 10:
                case 11:
                    return false;
                case 12:
                    Object f2 = f();
                    if (f2 instanceof Boolean) {
                        return ((Boolean) f2).booleanValue();
                    }
                    break;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void b(int i2, String str) throws JsonParseException {
        if (!a(a.ALLOW_UNQUOTED_CONTROL_CHARS) || i2 > 32) {
            char c2 = (char) i2;
            StringBuilder sb = new StringBuilder();
            sb.append("Illegal unquoted character (");
            sb.append(b(c2));
            sb.append("): has to be escaped using backslash to be included in ");
            sb.append(str);
            e(sb.toString());
            throw null;
        }
    }

    public String c(String str) throws IOException {
        g gVar = this.f4175b;
        if (gVar == g.VALUE_STRING || (gVar != null && gVar != g.VALUE_NULL && gVar.c())) {
            return j();
        }
        return str;
    }

    public g d() {
        return this.f4175b;
    }

    /* access modifiers changed from: protected */
    public final void e(String str) throws JsonParseException {
        throw b(str);
    }

    /* access modifiers changed from: protected */
    public void f(String str) throws JsonParseException {
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected end-of-input");
        sb.append(str);
        e(sb.toString());
        throw null;
    }

    public long h(long j2) throws IOException {
        g gVar = this.f4175b;
        if (gVar != null) {
            switch (gVar.b()) {
                case 6:
                    String j3 = j();
                    if (!d(j3)) {
                        j2 = com.fasterxml.jackson.core.b.g.a(j3, j2);
                        break;
                    } else {
                        return 0;
                    }
                case 7:
                case 8:
                    return i();
                case 9:
                    return 1;
                case 10:
                case 11:
                    return 0;
                case 12:
                    Object f2 = f();
                    if (f2 instanceof Number) {
                        return ((Number) f2).longValue();
                    }
                    break;
            }
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    public boolean d(String str) {
        return "null".equals(str);
    }

    /* access modifiers changed from: protected */
    public void d(int i2) throws JsonParseException {
        char c2 = (char) i2;
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal character (");
        sb.append(b(c2));
        sb.append("): only regular white space (\\r, \\n, \\t) is allowed between tokens");
        e(sb.toString());
        throw null;
    }

    protected static final String b(int i2) {
        char c2 = (char) i2;
        String str = ")";
        if (Character.isISOControl(c2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("(CTRL-CHAR, code ");
            sb.append(i2);
            sb.append(str);
            return sb.toString();
        }
        String str2 = "' (code ";
        String str3 = "'";
        if (i2 > 255) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str3);
            sb2.append(c2);
            sb2.append(str2);
            sb2.append(i2);
            sb2.append(" / 0x");
            sb2.append(Integer.toHexString(i2));
            sb2.append(str);
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(c2);
        sb3.append(str2);
        sb3.append(i2);
        sb3.append(str);
        return sb3.toString();
    }

    /* access modifiers changed from: protected */
    public void c(int i2) throws JsonParseException {
        a(i2, "Expected space separating root-level values");
        throw null;
    }

    /* access modifiers changed from: protected */
    public final void b(String str, Throwable th) throws JsonParseException {
        throw a(str, th);
    }

    public int a(int i2) throws IOException {
        g gVar = this.f4175b;
        if (gVar != null) {
            switch (gVar.b()) {
                case 6:
                    String j2 = j();
                    if (!d(j2)) {
                        i2 = com.fasterxml.jackson.core.b.g.a(j2, i2);
                        break;
                    } else {
                        return 0;
                    }
                case 7:
                case 8:
                    return h();
                case 9:
                    return 1;
                case 10:
                case 11:
                    return 0;
                case 12:
                    Object f2 = f();
                    if (f2 instanceof Number) {
                        return ((Number) f2).intValue();
                    }
                    break;
            }
        }
        return i2;
    }

    public double a(double d2) throws IOException {
        g gVar = this.f4175b;
        if (gVar != null) {
            switch (gVar.b()) {
                case 6:
                    String j2 = j();
                    if (!d(j2)) {
                        d2 = com.fasterxml.jackson.core.b.g.a(j2, d2);
                        break;
                    } else {
                        return 0.0d;
                    }
                case 7:
                case 8:
                    return e();
                case 9:
                    return 1.0d;
                case 10:
                case 11:
                    return 0.0d;
                case 12:
                    Object f2 = f();
                    if (f2 instanceof Number) {
                        return ((Number) f2).doubleValue();
                    }
                    break;
            }
        }
        return d2;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, String str) throws JsonParseException {
        if (i2 >= 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected character (");
            sb.append(b(i2));
            sb.append(")");
            String sb2 = sb.toString();
            if (str != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append(": ");
                sb3.append(str);
                sb2 = sb3.toString();
            }
            e(sb2);
            throw null;
        }
        I();
        throw null;
    }

    /* access modifiers changed from: protected */
    public char a(char c2) throws JsonProcessingException {
        if (a(a.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {
            return c2;
        }
        if (c2 == '\'' && a(a.ALLOW_SINGLE_QUOTES)) {
            return c2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unrecognized character escape ");
        sb.append(b(c2));
        e(sb.toString());
        throw null;
    }

    /* access modifiers changed from: protected */
    public final JsonParseException a(String str, Throwable th) {
        return new JsonParseException(str, b(), th);
    }
}
