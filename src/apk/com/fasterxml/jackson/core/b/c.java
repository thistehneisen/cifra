package com.fasterxml.jackson.core.b;

import com.fasterxml.jackson.core.a;
import com.fasterxml.jackson.core.e.g;

/* compiled from: IOContext */
public class c {

    /* renamed from: a reason: collision with root package name */
    protected final Object f4197a;

    /* renamed from: b reason: collision with root package name */
    protected a f4198b;

    /* renamed from: c reason: collision with root package name */
    protected final boolean f4199c;

    /* renamed from: d reason: collision with root package name */
    protected final com.fasterxml.jackson.core.e.a f4200d;

    /* renamed from: e reason: collision with root package name */
    protected byte[] f4201e = null;

    /* renamed from: f reason: collision with root package name */
    protected byte[] f4202f = null;

    /* renamed from: g reason: collision with root package name */
    protected byte[] f4203g = null;

    /* renamed from: h reason: collision with root package name */
    protected char[] f4204h = null;

    /* renamed from: i reason: collision with root package name */
    protected char[] f4205i = null;

    /* renamed from: j reason: collision with root package name */
    protected char[] f4206j = null;

    public c(com.fasterxml.jackson.core.e.a aVar, Object obj, boolean z) {
        this.f4200d = aVar;
        this.f4197a = obj;
        this.f4199c = z;
    }

    private IllegalArgumentException i() {
        return new IllegalArgumentException("Trying to release buffer not owned by the context");
    }

    public void a(a aVar) {
        this.f4198b = aVar;
    }

    public byte[] b() {
        a((Object) this.f4201e);
        byte[] a2 = this.f4200d.a(0);
        this.f4201e = a2;
        return a2;
    }

    public char[] c() {
        a((Object) this.f4204h);
        char[] b2 = this.f4200d.b(0);
        this.f4204h = b2;
        return b2;
    }

    public byte[] d() {
        a((Object) this.f4202f);
        byte[] a2 = this.f4200d.a(1);
        this.f4202f = a2;
        return a2;
    }

    public g e() {
        return new g(this.f4200d);
    }

    public a f() {
        return this.f4198b;
    }

    public Object g() {
        return this.f4197a;
    }

    public boolean h() {
        return this.f4199c;
    }

    public char[] a(int i2) {
        a((Object) this.f4204h);
        char[] b2 = this.f4200d.b(0, i2);
        this.f4204h = b2;
        return b2;
    }

    public void b(byte[] bArr) {
        if (bArr != null) {
            a(bArr, this.f4202f);
            this.f4202f = null;
            this.f4200d.a(1, bArr);
        }
    }

    public void c(char[] cArr) {
        if (cArr != null) {
            a(cArr, this.f4204h);
            this.f4204h = null;
            this.f4200d.a(0, cArr);
        }
    }

    public char[] a() {
        a((Object) this.f4205i);
        char[] b2 = this.f4200d.b(1);
        this.f4205i = b2;
        return b2;
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            a(bArr, this.f4201e);
            this.f4201e = null;
            this.f4200d.a(0, bArr);
        }
    }

    public void b(char[] cArr) {
        if (cArr != null) {
            a(cArr, this.f4206j);
            this.f4206j = null;
            this.f4200d.a(3, cArr);
        }
    }

    public void a(char[] cArr) {
        if (cArr != null) {
            a(cArr, this.f4205i);
            this.f4205i = null;
            this.f4200d.a(1, cArr);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    /* access modifiers changed from: protected */
    public final void a(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && bArr.length <= bArr2.length) {
            throw i();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(char[] cArr, char[] cArr2) {
        if (cArr != cArr2 && cArr.length <= cArr2.length) {
            throw i();
        }
    }
}
