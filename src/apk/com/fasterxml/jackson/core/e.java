package com.fasterxml.jackson.core;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: JsonParser */
public abstract class e implements Closeable, l {

    /* renamed from: a reason: collision with root package name */
    protected int f4348a;

    /* compiled from: JsonParser */
    public enum a {
        AUTO_CLOSE_SOURCE(true),
        ALLOW_COMMENTS(false),
        ALLOW_YAML_COMMENTS(false),
        ALLOW_UNQUOTED_FIELD_NAMES(false),
        ALLOW_SINGLE_QUOTES(false),
        ALLOW_UNQUOTED_CONTROL_CHARS(false),
        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false),
        ALLOW_NUMERIC_LEADING_ZEROS(false),
        ALLOW_NON_NUMERIC_NUMBERS(false),
        STRICT_DUPLICATE_DETECTION(false);
        
        private final boolean _defaultState;
        private final int _mask;

        private a(boolean z) {
            this._mask = 1 << ordinal();
            this._defaultState = z;
        }

        public static int a() {
            a[] values;
            int i2 = 0;
            for (a aVar : values()) {
                if (aVar.b()) {
                    i2 |= aVar.c();
                }
            }
            return i2;
        }

        public boolean b() {
            return this._defaultState;
        }

        public int c() {
            return this._mask;
        }

        public boolean b(int i2) {
            return (i2 & this._mask) != 0;
        }
    }

    protected e() {
    }

    public long D() throws IOException {
        return h(0);
    }

    public String E() throws IOException {
        return c(null);
    }

    public abstract g F() throws IOException, JsonParseException;

    public abstract e G() throws IOException, JsonParseException;

    public double a(double d2) throws IOException {
        return d2;
    }

    public int a(int i2) throws IOException {
        return i2;
    }

    public boolean a(a aVar) {
        return aVar.b(this.f4348a);
    }

    public boolean a(boolean z) throws IOException {
        return z;
    }

    /* access modifiers changed from: protected */
    public JsonParseException b(String str) {
        return new JsonParseException(str, b());
    }

    public abstract d b();

    public abstract String c() throws IOException;

    public abstract String c(String str) throws IOException;

    public abstract g d();

    public abstract double e() throws IOException;

    public abstract Object f() throws IOException;

    public abstract float g() throws IOException;

    public abstract int h() throws IOException;

    public long h(long j2) throws IOException {
        return j2;
    }

    public abstract long i() throws IOException;

    public abstract String j() throws IOException;

    public boolean k() throws IOException {
        return a(false);
    }

    public double l() throws IOException {
        return a(0.0d);
    }

    public int m() throws IOException {
        return a(0);
    }

    public boolean a() throws IOException {
        g d2 = d();
        if (d2 == g.VALUE_TRUE) {
            return true;
        }
        if (d2 == g.VALUE_FALSE) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Current token (");
        sb.append(d2);
        sb.append(") not of boolean type");
        throw new JsonParseException(sb.toString(), b());
    }
}
