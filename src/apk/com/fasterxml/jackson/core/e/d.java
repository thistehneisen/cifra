package com.fasterxml.jackson.core.e;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.b.j;
import com.fasterxml.jackson.core.i;
import java.io.IOException;
import java.io.Serializable;

/* compiled from: DefaultPrettyPrinter */
public class d implements i, e<d>, Serializable {

    /* renamed from: a reason: collision with root package name */
    public static final j f4372a = new j(" ");
    private static final long serialVersionUID = 1;
    protected b _arrayIndenter;
    protected b _objectIndenter;
    protected final com.fasterxml.jackson.core.j _rootSeparator;
    protected boolean _spacesInObjectEntries;

    /* renamed from: b reason: collision with root package name */
    protected transient int f4373b;

    /* compiled from: DefaultPrettyPrinter */
    public static class a extends c {

        /* renamed from: b reason: collision with root package name */
        public static final a f4374b = new a();

        public void a(com.fasterxml.jackson.core.c cVar, int i2) throws IOException, JsonGenerationException {
            cVar.a(' ');
        }

        public boolean a() {
            return true;
        }
    }

    /* compiled from: DefaultPrettyPrinter */
    public interface b {
        void a(com.fasterxml.jackson.core.c cVar, int i2) throws IOException;

        boolean a();
    }

    /* compiled from: DefaultPrettyPrinter */
    public static class c implements b, Serializable {

        /* renamed from: a reason: collision with root package name */
        public static final c f4375a = new c();

        public void a(com.fasterxml.jackson.core.c cVar, int i2) throws IOException {
        }

        public boolean a() {
            return true;
        }
    }

    public d() {
        this(f4372a);
    }

    public void a(com.fasterxml.jackson.core.c cVar) throws IOException, JsonGenerationException {
        cVar.a('{');
        if (!this._objectIndenter.a()) {
            this.f4373b++;
        }
    }

    public void b(com.fasterxml.jackson.core.c cVar) throws IOException, JsonGenerationException {
        com.fasterxml.jackson.core.j jVar = this._rootSeparator;
        if (jVar != null) {
            cVar.a(jVar);
        }
    }

    public void c(com.fasterxml.jackson.core.c cVar) throws IOException, JsonGenerationException {
        cVar.a(',');
        this._arrayIndenter.a(cVar, this.f4373b);
    }

    public void d(com.fasterxml.jackson.core.c cVar) throws IOException, JsonGenerationException {
        this._objectIndenter.a(cVar, this.f4373b);
    }

    public void e(com.fasterxml.jackson.core.c cVar) throws IOException, JsonGenerationException {
        if (!this._arrayIndenter.a()) {
            this.f4373b++;
        }
        cVar.a('[');
    }

    public void f(com.fasterxml.jackson.core.c cVar) throws IOException, JsonGenerationException {
        this._arrayIndenter.a(cVar, this.f4373b);
    }

    public void g(com.fasterxml.jackson.core.c cVar) throws IOException, JsonGenerationException {
        cVar.a(',');
        this._objectIndenter.a(cVar, this.f4373b);
    }

    public void h(com.fasterxml.jackson.core.c cVar) throws IOException, JsonGenerationException {
        if (this._spacesInObjectEntries) {
            cVar.e(" : ");
        } else {
            cVar.a(':');
        }
    }

    public d(com.fasterxml.jackson.core.j jVar) {
        this._arrayIndenter = a.f4374b;
        this._objectIndenter = c.f4371c;
        this._spacesInObjectEntries = true;
        this.f4373b = 0;
        this._rootSeparator = jVar;
    }

    public void b(com.fasterxml.jackson.core.c cVar, int i2) throws IOException, JsonGenerationException {
        if (!this._arrayIndenter.a()) {
            this.f4373b--;
        }
        if (i2 > 0) {
            this._arrayIndenter.a(cVar, this.f4373b);
        } else {
            cVar.a(' ');
        }
        cVar.a(']');
    }

    public void a(com.fasterxml.jackson.core.c cVar, int i2) throws IOException, JsonGenerationException {
        if (!this._objectIndenter.a()) {
            this.f4373b--;
        }
        if (i2 > 0) {
            this._objectIndenter.a(cVar, this.f4373b);
        } else {
            cVar.a(' ');
        }
        cVar.a('}');
    }
}
