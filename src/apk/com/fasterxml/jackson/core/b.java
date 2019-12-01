package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.b.c;
import com.fasterxml.jackson.core.b.i;
import com.fasterxml.jackson.core.b.l;
import com.fasterxml.jackson.core.c.f;
import com.fasterxml.jackson.core.c.g;
import com.fasterxml.jackson.core.e.d;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.Writer;
import java.lang.ref.SoftReference;

/* compiled from: JsonFactory */
public class b implements l, Serializable {

    /* renamed from: a reason: collision with root package name */
    protected static final int f4176a = a.a();

    /* renamed from: b reason: collision with root package name */
    protected static final int f4177b = com.fasterxml.jackson.core.e.a.a();

    /* renamed from: c reason: collision with root package name */
    protected static final int f4178c = com.fasterxml.jackson.core.c.a.a();

    /* renamed from: d reason: collision with root package name */
    private static final j f4179d = d.f4372a;

    /* renamed from: e reason: collision with root package name */
    protected static final ThreadLocal<SoftReference<com.fasterxml.jackson.core.e.a>> f4180e = new ThreadLocal<>();
    private static final long serialVersionUID = 3306684576057132431L;
    protected com.fasterxml.jackson.core.b.b _characterEscapes;
    protected int _factoryFeatures;
    protected int _generatorFeatures;
    protected com.fasterxml.jackson.core.b.d _inputDecorator;
    protected h _objectCodec;
    protected i _outputDecorator;
    protected int _parserFeatures;
    protected j _rootValueSeparator;

    /* renamed from: f reason: collision with root package name */
    protected final transient com.fasterxml.jackson.core.d.b f4181f;

    /* renamed from: g reason: collision with root package name */
    protected final transient com.fasterxml.jackson.core.d.a f4182g;

    /* compiled from: JsonFactory */
    public enum a {
        INTERN_FIELD_NAMES(true),
        CANONICALIZE_FIELD_NAMES(true),
        FAIL_ON_SYMBOL_HASH_OVERFLOW(true);
        
        private final boolean _defaultState;

        private a(boolean z) {
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
            return 1 << ordinal();
        }

        public boolean b(int i2) {
            return (i2 & c()) != 0;
        }
    }

    public b() {
        this(null);
    }

    public e a(InputStream inputStream) throws IOException, JsonParseException {
        c a2 = a((Object) inputStream, false);
        return a(b(inputStream, a2), a2);
    }

    /* access modifiers changed from: protected */
    public final InputStream b(InputStream inputStream, c cVar) throws IOException {
        com.fasterxml.jackson.core.b.d dVar = this._inputDecorator;
        if (dVar != null) {
            InputStream a2 = dVar.a(cVar, inputStream);
            if (a2 != null) {
                return a2;
            }
        }
        return inputStream;
    }

    public boolean b() {
        return true;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() {
        return new b(this, this._objectCodec);
    }

    public b(h hVar) {
        this.f4181f = com.fasterxml.jackson.core.d.b.a();
        this.f4182g = com.fasterxml.jackson.core.d.a.a();
        this._factoryFeatures = f4176a;
        this._parserFeatures = f4177b;
        this._generatorFeatures = f4178c;
        this._rootValueSeparator = f4179d;
        this._objectCodec = hVar;
    }

    public e a(Reader reader) throws IOException, JsonParseException {
        c a2 = a((Object) reader, false);
        return a(b(reader, a2), a2);
    }

    /* access modifiers changed from: protected */
    public final Reader b(Reader reader, c cVar) throws IOException {
        com.fasterxml.jackson.core.b.d dVar = this._inputDecorator;
        if (dVar != null) {
            Reader a2 = dVar.a(cVar, reader);
            if (a2 != null) {
                return a2;
            }
        }
        return reader;
    }

    public e a(byte[] bArr) throws IOException, JsonParseException {
        c a2 = a((Object) bArr, true);
        com.fasterxml.jackson.core.b.d dVar = this._inputDecorator;
        if (dVar != null) {
            InputStream a3 = dVar.a(a2, bArr, 0, bArr.length);
            if (a3 != null) {
                return a(a3, a2);
            }
        }
        return a(bArr, 0, bArr.length, a2);
    }

    /* access modifiers changed from: protected */
    public final OutputStream b(OutputStream outputStream, c cVar) throws IOException {
        i iVar = this._outputDecorator;
        if (iVar != null) {
            OutputStream a2 = iVar.a(cVar, outputStream);
            if (a2 != null) {
                return a2;
            }
        }
        return outputStream;
    }

    /* access modifiers changed from: protected */
    public final Writer b(Writer writer, c cVar) throws IOException {
        i iVar = this._outputDecorator;
        if (iVar != null) {
            Writer a2 = iVar.a(cVar, writer);
            if (a2 != null) {
                return a2;
            }
        }
        return writer;
    }

    protected b(b bVar, h hVar) {
        this.f4181f = com.fasterxml.jackson.core.d.b.a();
        this.f4182g = com.fasterxml.jackson.core.d.a.a();
        this._factoryFeatures = f4176a;
        this._parserFeatures = f4177b;
        this._generatorFeatures = f4178c;
        this._rootValueSeparator = f4179d;
        this._objectCodec = null;
        this._factoryFeatures = bVar._factoryFeatures;
        this._parserFeatures = bVar._parserFeatures;
        this._generatorFeatures = bVar._generatorFeatures;
        this._characterEscapes = bVar._characterEscapes;
        this._inputDecorator = bVar._inputDecorator;
        this._outputDecorator = bVar._outputDecorator;
        this._rootValueSeparator = bVar._rootValueSeparator;
    }

    public e a(String str) throws IOException, JsonParseException {
        int length = str.length();
        if (this._inputDecorator != null || length > 32768 || !b()) {
            return a((Reader) new StringReader(str));
        }
        c a2 = a((Object) str, true);
        char[] a3 = a2.a(length);
        str.getChars(0, length, a3, 0);
        return a(a3, 0, length, a2, true);
    }

    public e a(char[] cArr) throws IOException {
        return a(cArr, 0, cArr.length);
    }

    public e a(char[] cArr, int i2, int i3) throws IOException {
        if (this._inputDecorator != null) {
            return a((Reader) new CharArrayReader(cArr, i2, i3));
        }
        return a(cArr, i2, i3, a((Object) cArr, true), false);
    }

    public c a(OutputStream outputStream, a aVar) throws IOException {
        c a2 = a((Object) outputStream, false);
        a2.a(aVar);
        if (aVar == a.UTF8) {
            return a(b(outputStream, a2), a2);
        }
        return a(b(a(outputStream, aVar, a2), a2), a2);
    }

    public c a(OutputStream outputStream) throws IOException {
        return a(outputStream, a.UTF8);
    }

    public c a(Writer writer) throws IOException {
        c a2 = a((Object) writer, false);
        return a(b(writer, a2), a2);
    }

    /* access modifiers changed from: protected */
    public e a(InputStream inputStream, c cVar) throws IOException {
        return new com.fasterxml.jackson.core.c.a(cVar, inputStream).a(this._parserFeatures, this._objectCodec, this.f4182g, this.f4181f, this._factoryFeatures);
    }

    /* access modifiers changed from: protected */
    public e a(Reader reader, c cVar) throws IOException {
        f fVar = new f(cVar, this._parserFeatures, reader, this._objectCodec, this.f4181f.c(this._factoryFeatures));
        return fVar;
    }

    /* access modifiers changed from: protected */
    public e a(char[] cArr, int i2, int i3, c cVar, boolean z) throws IOException {
        f fVar = new f(cVar, this._parserFeatures, null, this._objectCodec, this.f4181f.c(this._factoryFeatures), cArr, i2, i2 + i3, z);
        return fVar;
    }

    /* access modifiers changed from: protected */
    public e a(byte[] bArr, int i2, int i3, c cVar) throws IOException {
        return new com.fasterxml.jackson.core.c.a(cVar, bArr, i2, i3).a(this._parserFeatures, this._objectCodec, this.f4182g, this.f4181f, this._factoryFeatures);
    }

    /* access modifiers changed from: protected */
    public c a(Writer writer, c cVar) throws IOException {
        com.fasterxml.jackson.core.c.i iVar = new com.fasterxml.jackson.core.c.i(cVar, this._generatorFeatures, this._objectCodec, writer);
        com.fasterxml.jackson.core.b.b bVar = this._characterEscapes;
        if (bVar != null) {
            iVar.a(bVar);
        }
        j jVar = this._rootValueSeparator;
        if (jVar != f4179d) {
            iVar.b(jVar);
        }
        return iVar;
    }

    /* access modifiers changed from: protected */
    public c a(OutputStream outputStream, c cVar) throws IOException {
        g gVar = new g(cVar, this._generatorFeatures, this._objectCodec, outputStream);
        com.fasterxml.jackson.core.b.b bVar = this._characterEscapes;
        if (bVar != null) {
            gVar.a(bVar);
        }
        j jVar = this._rootValueSeparator;
        if (jVar != f4179d) {
            gVar.b(jVar);
        }
        return gVar;
    }

    /* access modifiers changed from: protected */
    public Writer a(OutputStream outputStream, a aVar, c cVar) throws IOException {
        if (aVar == a.UTF8) {
            return new l(cVar, outputStream);
        }
        return new OutputStreamWriter(outputStream, aVar.b());
    }

    public com.fasterxml.jackson.core.e.a a() {
        com.fasterxml.jackson.core.e.a aVar;
        SoftReference softReference = (SoftReference) f4180e.get();
        if (softReference == null) {
            aVar = null;
        } else {
            aVar = (com.fasterxml.jackson.core.e.a) softReference.get();
        }
        if (aVar != null) {
            return aVar;
        }
        com.fasterxml.jackson.core.e.a aVar2 = new com.fasterxml.jackson.core.e.a();
        f4180e.set(new SoftReference(aVar2));
        return aVar2;
    }

    /* access modifiers changed from: protected */
    public c a(Object obj, boolean z) {
        return new c(a(), obj, z);
    }
}
