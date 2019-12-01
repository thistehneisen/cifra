package com.fasterxml.jackson.core.a;

import com.fasterxml.jackson.core.c;
import com.fasterxml.jackson.core.c.b;
import com.fasterxml.jackson.core.c.e;
import com.fasterxml.jackson.core.h;
import java.io.IOException;

/* compiled from: GeneratorBase */
public abstract class a extends c {

    /* renamed from: b reason: collision with root package name */
    protected static final int f4159b = ((com.fasterxml.jackson.core.c.a.WRITE_NUMBERS_AS_STRINGS.c() | com.fasterxml.jackson.core.c.a.ESCAPE_NON_ASCII.c()) | com.fasterxml.jackson.core.c.a.STRICT_DUPLICATE_DETECTION.c());

    /* renamed from: c reason: collision with root package name */
    protected h f4160c;

    /* renamed from: d reason: collision with root package name */
    protected int f4161d;

    /* renamed from: e reason: collision with root package name */
    protected boolean f4162e;

    /* renamed from: f reason: collision with root package name */
    protected e f4163f;

    /* renamed from: g reason: collision with root package name */
    protected boolean f4164g;

    protected a(int i2, h hVar) {
        this.f4161d = i2;
        this.f4160c = hVar;
        this.f4163f = e.a(com.fasterxml.jackson.core.c.a.STRICT_DUPLICATE_DETECTION.b(i2) ? b.a((c) this) : null);
        this.f4162e = com.fasterxml.jackson.core.c.a.WRITE_NUMBERS_AS_STRINGS.b(i2);
    }

    public final boolean a(com.fasterxml.jackson.core.c.a aVar) {
        return (aVar.c() & this.f4161d) != 0;
    }

    public void close() throws IOException {
        this.f4164g = true;
    }

    public final e g() {
        return this.f4163f;
    }

    /* access modifiers changed from: protected */
    public final int a(int i2, int i3) throws IOException {
        if (i3 >= 56320 && i3 <= 57343) {
            return ((i2 - 55296) << 10) + 65536 + (i3 - 56320);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Incomplete surrogate pair: first char 0x");
        sb.append(Integer.toHexString(i2));
        sb.append(", second 0x");
        sb.append(Integer.toHexString(i3));
        b(sb.toString());
        throw null;
    }
}
