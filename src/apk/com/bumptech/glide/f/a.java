package com.bumptech.glide.f;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.f.a;
import com.bumptech.glide.h.b;
import com.bumptech.glide.h.n;
import com.bumptech.glide.j;
import com.bumptech.glide.load.c.a.g;
import com.bumptech.glide.load.c.a.h;
import com.bumptech.glide.load.c.a.o;
import com.bumptech.glide.load.c.a.q;
import com.bumptech.glide.load.c.e.c;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import java.util.Map;

/* compiled from: BaseRequestOptions */
public abstract class a<T extends a<T>> implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    private int f3430a;

    /* renamed from: b reason: collision with root package name */
    private float f3431b = 1.0f;

    /* renamed from: c reason: collision with root package name */
    private s f3432c = s.f4076e;

    /* renamed from: d reason: collision with root package name */
    private j f3433d = j.NORMAL;

    /* renamed from: e reason: collision with root package name */
    private Drawable f3434e;

    /* renamed from: f reason: collision with root package name */
    private int f3435f;

    /* renamed from: g reason: collision with root package name */
    private Drawable f3436g;

    /* renamed from: h reason: collision with root package name */
    private int f3437h;

    /* renamed from: i reason: collision with root package name */
    private boolean f3438i = true;

    /* renamed from: j reason: collision with root package name */
    private int f3439j = -1;

    /* renamed from: k reason: collision with root package name */
    private int f3440k = -1;

    /* renamed from: l reason: collision with root package name */
    private f f3441l = com.bumptech.glide.g.a.a();
    private boolean m;
    private boolean n = true;
    private Drawable o;
    private int p;
    private i q = new i();
    private Map<Class<?>, l<?>> r = new b();
    private Class<?> s = Object.class;
    private boolean t;
    private Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y = true;
    private boolean z;

    private T I() {
        return this;
    }

    private T J() {
        if (!this.t) {
            I();
            return this;
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    private static boolean b(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    private T c(com.bumptech.glide.load.c.a.j jVar, l<Bitmap> lVar) {
        return a(jVar, lVar, false);
    }

    public final boolean B() {
        return this.m;
    }

    public final boolean C() {
        return b(2048);
    }

    public final boolean D() {
        return n.b(this.f3440k, this.f3439j);
    }

    public T E() {
        this.t = true;
        I();
        return this;
    }

    public T F() {
        return a(com.bumptech.glide.load.c.a.j.f3734b, (l<Bitmap>) new g<Bitmap>());
    }

    public T G() {
        return c(com.bumptech.glide.load.c.a.j.f3737e, new h());
    }

    public T H() {
        return c(com.bumptech.glide.load.c.a.j.f3733a, new q());
    }

    public T a(float f2) {
        if (this.v) {
            return clone().a(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f3431b = f2;
        this.f3430a |= 2;
        J();
        return this;
    }

    public T b(boolean z2) {
        if (this.v) {
            return clone().b(z2);
        }
        this.z = z2;
        this.f3430a |= 1048576;
        J();
        return this;
    }

    public final Drawable d() {
        return this.f3434e;
    }

    public final Drawable e() {
        return this.o;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Float.compare(aVar.f3431b, this.f3431b) == 0 && this.f3435f == aVar.f3435f && n.b((Object) this.f3434e, (Object) aVar.f3434e) && this.f3437h == aVar.f3437h && n.b((Object) this.f3436g, (Object) aVar.f3436g) && this.p == aVar.p && n.b((Object) this.o, (Object) aVar.o) && this.f3438i == aVar.f3438i && this.f3439j == aVar.f3439j && this.f3440k == aVar.f3440k && this.m == aVar.m && this.n == aVar.n && this.w == aVar.w && this.x == aVar.x && this.f3432c.equals(aVar.f3432c) && this.f3433d == aVar.f3433d && this.q.equals(aVar.q) && this.r.equals(aVar.r) && this.s.equals(aVar.s) && n.b((Object) this.f3441l, (Object) aVar.f3441l) && n.b((Object) this.u, (Object) aVar.u)) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.p;
    }

    public final boolean g() {
        return this.x;
    }

    public final i h() {
        return this.q;
    }

    public int hashCode() {
        return n.a((Object) this.u, n.a((Object) this.f3441l, n.a((Object) this.s, n.a((Object) this.r, n.a((Object) this.q, n.a((Object) this.f3433d, n.a((Object) this.f3432c, n.a(this.x, n.a(this.w, n.a(this.n, n.a(this.m, n.a(this.f3440k, n.a(this.f3439j, n.a(this.f3438i, n.a((Object) this.o, n.a(this.p, n.a((Object) this.f3436g, n.a(this.f3437h, n.a((Object) this.f3434e, n.a(this.f3435f, n.a(this.f3431b)))))))))))))))))))));
    }

    public final int i() {
        return this.f3439j;
    }

    public final int j() {
        return this.f3440k;
    }

    public final Drawable k() {
        return this.f3436g;
    }

    public final int l() {
        return this.f3437h;
    }

    public final j m() {
        return this.f3433d;
    }

    public final Class<?> n() {
        return this.s;
    }

    public final f o() {
        return this.f3441l;
    }

    public final float p() {
        return this.f3431b;
    }

    public final Theme q() {
        return this.u;
    }

    public final Map<Class<?>, l<?>> r() {
        return this.r;
    }

    public final boolean s() {
        return this.z;
    }

    public final boolean t() {
        return this.w;
    }

    public final boolean u() {
        return this.f3438i;
    }

    public final boolean v() {
        return b(8);
    }

    /* access modifiers changed from: 0000 */
    public boolean w() {
        return this.y;
    }

    public final boolean x() {
        return this.n;
    }

    public final int c() {
        return this.f3435f;
    }

    public T clone() {
        try {
            T t2 = (a) super.clone();
            t2.q = new i();
            t2.q.a(this.q);
            t2.r = new b();
            t2.r.putAll(this.r);
            t2.t = false;
            t2.v = false;
            return t2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: 0000 */
    public final T b(com.bumptech.glide.load.c.a.j jVar, l<Bitmap> lVar) {
        if (this.v) {
            return clone().b(jVar, lVar);
        }
        a(jVar);
        return a(lVar);
    }

    public T a(s sVar) {
        if (this.v) {
            return clone().a(sVar);
        }
        com.bumptech.glide.h.l.a(sVar);
        this.f3432c = sVar;
        this.f3430a |= 4;
        J();
        return this;
    }

    public final s b() {
        return this.f3432c;
    }

    private boolean b(int i2) {
        return b(this.f3430a, i2);
    }

    public T a(j jVar) {
        if (this.v) {
            return clone().a(jVar);
        }
        com.bumptech.glide.h.l.a(jVar);
        this.f3433d = jVar;
        this.f3430a |= 8;
        J();
        return this;
    }

    public T a(int i2) {
        if (this.v) {
            return clone().a(i2);
        }
        this.f3437h = i2;
        this.f3430a |= 128;
        this.f3436g = null;
        this.f3430a &= -65;
        J();
        return this;
    }

    public T a(boolean z2) {
        if (this.v) {
            return clone().a(true);
        }
        this.f3438i = !z2;
        this.f3430a |= 256;
        J();
        return this;
    }

    public T a(int i2, int i3) {
        if (this.v) {
            return clone().a(i2, i3);
        }
        this.f3440k = i2;
        this.f3439j = i3;
        this.f3430a |= 512;
        J();
        return this;
    }

    public T a(f fVar) {
        if (this.v) {
            return clone().a(fVar);
        }
        com.bumptech.glide.h.l.a(fVar);
        this.f3441l = fVar;
        this.f3430a |= 1024;
        J();
        return this;
    }

    public <Y> T a(com.bumptech.glide.load.h<Y> hVar, Y y2) {
        if (this.v) {
            return clone().a(hVar, y2);
        }
        com.bumptech.glide.h.l.a(hVar);
        com.bumptech.glide.h.l.a(y2);
        this.q.a(hVar, y2);
        J();
        return this;
    }

    public T a(Class<?> cls) {
        if (this.v) {
            return clone().a(cls);
        }
        com.bumptech.glide.h.l.a(cls);
        this.s = cls;
        this.f3430a |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        J();
        return this;
    }

    public T a(com.bumptech.glide.load.c.a.j jVar) {
        com.bumptech.glide.load.h<com.bumptech.glide.load.c.a.j> hVar = com.bumptech.glide.load.c.a.j.f3740h;
        com.bumptech.glide.h.l.a(jVar);
        return a(hVar, (Y) jVar);
    }

    /* access modifiers changed from: 0000 */
    public final T a(com.bumptech.glide.load.c.a.j jVar, l<Bitmap> lVar) {
        if (this.v) {
            return clone().a(jVar, lVar);
        }
        a(jVar);
        return a(lVar, false);
    }

    private T a(com.bumptech.glide.load.c.a.j jVar, l<Bitmap> lVar, boolean z2) {
        T b2 = z2 ? b(jVar, lVar) : a(jVar, lVar);
        b2.y = true;
        return b2;
    }

    public T a(l<Bitmap> lVar) {
        return a(lVar, true);
    }

    /* access modifiers changed from: 0000 */
    public T a(l<Bitmap> lVar, boolean z2) {
        if (this.v) {
            return clone().a(lVar, z2);
        }
        o oVar = new o(lVar, z2);
        a(Bitmap.class, lVar, z2);
        a(Drawable.class, (l<Y>) oVar, z2);
        oVar.a();
        a(BitmapDrawable.class, (l<Y>) oVar, z2);
        a(c.class, (l<Y>) new com.bumptech.glide.load.c.e.f<Y>(lVar), z2);
        J();
        return this;
    }

    /* access modifiers changed from: 0000 */
    public <Y> T a(Class<Y> cls, l<Y> lVar, boolean z2) {
        if (this.v) {
            return clone().a(cls, lVar, z2);
        }
        com.bumptech.glide.h.l.a(cls);
        com.bumptech.glide.h.l.a(lVar);
        this.r.put(cls, lVar);
        this.f3430a |= 2048;
        this.n = true;
        this.f3430a |= 65536;
        this.y = false;
        if (z2) {
            this.f3430a |= 131072;
            this.m = true;
        }
        J();
        return this;
    }

    public T a(a<?> aVar) {
        if (this.v) {
            return clone().a(aVar);
        }
        if (b(aVar.f3430a, 2)) {
            this.f3431b = aVar.f3431b;
        }
        if (b(aVar.f3430a, 262144)) {
            this.w = aVar.w;
        }
        if (b(aVar.f3430a, 1048576)) {
            this.z = aVar.z;
        }
        if (b(aVar.f3430a, 4)) {
            this.f3432c = aVar.f3432c;
        }
        if (b(aVar.f3430a, 8)) {
            this.f3433d = aVar.f3433d;
        }
        if (b(aVar.f3430a, 16)) {
            this.f3434e = aVar.f3434e;
            this.f3435f = 0;
            this.f3430a &= -33;
        }
        if (b(aVar.f3430a, 32)) {
            this.f3435f = aVar.f3435f;
            this.f3434e = null;
            this.f3430a &= -17;
        }
        if (b(aVar.f3430a, 64)) {
            this.f3436g = aVar.f3436g;
            this.f3437h = 0;
            this.f3430a &= -129;
        }
        if (b(aVar.f3430a, 128)) {
            this.f3437h = aVar.f3437h;
            this.f3436g = null;
            this.f3430a &= -65;
        }
        if (b(aVar.f3430a, 256)) {
            this.f3438i = aVar.f3438i;
        }
        if (b(aVar.f3430a, 512)) {
            this.f3440k = aVar.f3440k;
            this.f3439j = aVar.f3439j;
        }
        if (b(aVar.f3430a, 1024)) {
            this.f3441l = aVar.f3441l;
        }
        if (b(aVar.f3430a, (int) CodedOutputStream.DEFAULT_BUFFER_SIZE)) {
            this.s = aVar.s;
        }
        if (b(aVar.f3430a, 8192)) {
            this.o = aVar.o;
            this.p = 0;
            this.f3430a &= -16385;
        }
        if (b(aVar.f3430a, 16384)) {
            this.p = aVar.p;
            this.o = null;
            this.f3430a &= -8193;
        }
        if (b(aVar.f3430a, 32768)) {
            this.u = aVar.u;
        }
        if (b(aVar.f3430a, 65536)) {
            this.n = aVar.n;
        }
        if (b(aVar.f3430a, 131072)) {
            this.m = aVar.m;
        }
        if (b(aVar.f3430a, 2048)) {
            this.r.putAll(aVar.r);
            this.y = aVar.y;
        }
        if (b(aVar.f3430a, 524288)) {
            this.x = aVar.x;
        }
        if (!this.n) {
            this.r.clear();
            this.f3430a &= -2049;
            this.m = false;
            this.f3430a &= -131073;
            this.y = true;
        }
        this.f3430a |= aVar.f3430a;
        this.q.a(aVar.q);
        J();
        return this;
    }

    public T a() {
        if (!this.t || this.v) {
            this.v = true;
            return E();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }
}
