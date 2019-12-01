package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.e.h;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* compiled from: JsonGenerator */
public abstract class c implements Closeable, Flushable, l {

    /* renamed from: a reason: collision with root package name */
    protected i f4249a;

    /* compiled from: JsonGenerator */
    public enum a {
        AUTO_CLOSE_TARGET(true),
        AUTO_CLOSE_JSON_CONTENT(true),
        QUOTE_FIELD_NAMES(true),
        QUOTE_NON_NUMERIC_NUMBERS(true),
        WRITE_NUMBERS_AS_STRINGS(false),
        WRITE_BIGDECIMAL_AS_PLAIN(false),
        FLUSH_PASSED_TO_STREAM(true),
        ESCAPE_NON_ASCII(false),
        STRICT_DUPLICATE_DETECTION(false),
        IGNORE_UNKNOWN(false);
        
        private final boolean _defaultState;
        private final int _mask;

        private a(boolean z) {
            this._defaultState = z;
            this._mask = 1 << ordinal();
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

    protected c() {
    }

    public abstract void a(char c2) throws IOException;

    public abstract void a(double d2) throws IOException;

    public abstract void a(float f2) throws IOException;

    public abstract void a(int i2) throws IOException;

    public abstract void a(j jVar) throws IOException;

    public abstract void a(String str, String str2) throws IOException;

    public final void a(String str, boolean z) throws IOException {
        c(str);
        a(z);
    }

    public abstract void a(boolean z) throws IOException;

    public abstract void a(char[] cArr, int i2, int i3) throws IOException;

    public abstract void b() throws IOException;

    /* access modifiers changed from: protected */
    public void b(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str);
    }

    public abstract void c() throws IOException;

    public abstract void c(String str) throws IOException;

    public abstract void close() throws IOException;

    public abstract void d() throws IOException;

    public final void d(String str) throws IOException {
        c(str);
        d();
    }

    public abstract void e() throws IOException;

    public abstract void e(String str) throws IOException;

    public abstract void f() throws IOException;

    public abstract void f(String str) throws IOException;

    public abstract void h(long j2) throws IOException;

    public final void a(String str, int i2) throws IOException {
        c(str);
        a(i2);
    }

    public final void a(String str, long j2) throws IOException {
        c(str);
        h(j2);
    }

    public final void a(String str, double d2) throws IOException {
        c(str);
        a(d2);
    }

    public final void a(String str, float f2) throws IOException {
        c(str);
        a(f2);
    }

    /* access modifiers changed from: protected */
    public final void a() {
        h.a();
        throw null;
    }
}
