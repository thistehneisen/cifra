package com.fasterxml.jackson.core.c;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.a.a;
import com.fasterxml.jackson.core.b.b;
import com.fasterxml.jackson.core.e.d;
import com.fasterxml.jackson.core.h;
import com.fasterxml.jackson.core.j;
import java.io.IOException;

/* compiled from: JsonGeneratorImpl */
public abstract class c extends a {

    /* renamed from: h reason: collision with root package name */
    protected static final int[] f4274h = com.fasterxml.jackson.core.b.a.c();

    /* renamed from: i reason: collision with root package name */
    protected final com.fasterxml.jackson.core.b.c f4275i;

    /* renamed from: j reason: collision with root package name */
    protected int[] f4276j = f4274h;

    /* renamed from: k reason: collision with root package name */
    protected int f4277k;

    /* renamed from: l reason: collision with root package name */
    protected b f4278l;
    protected j m = d.f4372a;

    public c(com.fasterxml.jackson.core.b.c cVar, int i2, h hVar) {
        super(i2, hVar);
        this.f4275i = cVar;
        if (a(com.fasterxml.jackson.core.c.a.ESCAPE_NON_ASCII)) {
            b(127);
        }
    }

    public com.fasterxml.jackson.core.c a(b bVar) {
        this.f4278l = bVar;
        if (bVar == null) {
            this.f4276j = f4274h;
        } else {
            this.f4276j = bVar.a();
        }
        return this;
    }

    public com.fasterxml.jackson.core.c b(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f4277k = i2;
        return this;
    }

    public com.fasterxml.jackson.core.c b(j jVar) {
        this.m = jVar;
        return this;
    }

    public final void a(String str, String str2) throws IOException, JsonGenerationException {
        c(str);
        f(str2);
    }
}
