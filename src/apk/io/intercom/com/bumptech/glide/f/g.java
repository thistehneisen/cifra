package io.intercom.com.bumptech.glide.f;

import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import io.intercom.com.bumptech.glide.g.a;
import io.intercom.com.bumptech.glide.h;
import io.intercom.com.bumptech.glide.load.b;
import io.intercom.com.bumptech.glide.load.c.a.l;
import io.intercom.com.bumptech.glide.load.c.a.o;
import io.intercom.com.bumptech.glide.load.c.a.p;
import io.intercom.com.bumptech.glide.load.c.e.c;
import io.intercom.com.bumptech.glide.load.c.e.f;
import io.intercom.com.bumptech.glide.load.c.e.i;
import io.intercom.com.bumptech.glide.load.engine.q;
import io.intercom.com.bumptech.glide.load.j;
import io.intercom.com.bumptech.glide.load.m;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestOptions */
public class g implements Cloneable {

    /* renamed from: a reason: collision with root package name */
    private int f9336a;

    /* renamed from: b reason: collision with root package name */
    private float f9337b = 1.0f;

    /* renamed from: c reason: collision with root package name */
    private q f9338c = q.f9936e;

    /* renamed from: d reason: collision with root package name */
    private h f9339d = h.NORMAL;

    /* renamed from: e reason: collision with root package name */
    private Drawable f9340e;

    /* renamed from: f reason: collision with root package name */
    private int f9341f;

    /* renamed from: g reason: collision with root package name */
    private Drawable f9342g;

    /* renamed from: h reason: collision with root package name */
    private int f9343h;

    /* renamed from: i reason: collision with root package name */
    private boolean f9344i = true;

    /* renamed from: j reason: collision with root package name */
    private int f9345j = -1;

    /* renamed from: k reason: collision with root package name */
    private int f9346k = -1;

    /* renamed from: l reason: collision with root package name */
    private io.intercom.com.bumptech.glide.load.g f9347l = a.a();
    private boolean m;
    private boolean n = true;
    private Drawable o;
    private int p;
    private j q = new j();
    private Map<Class<?>, m<?>> r = new HashMap();
    private Class<?> s = Object.class;
    private boolean t;
    private Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y = true;
    private boolean z;

    private g J() {
        if (!this.t) {
            return this;
        }
        throw new IllegalStateException("You cannot modify locked RequestOptions, consider clone()");
    }

    public static g b(q qVar) {
        return new g().a(qVar);
    }

    private static boolean b(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    private g c(io.intercom.com.bumptech.glide.load.c.a.j jVar, m<Bitmap> mVar) {
        return a(jVar, mVar, false);
    }

    public final boolean B() {
        return this.n;
    }

    public final boolean C() {
        return this.m;
    }

    public final boolean D() {
        return c(2048);
    }

    public final boolean E() {
        return io.intercom.com.bumptech.glide.h.j.b(this.f9346k, this.f9345j);
    }

    public g F() {
        this.t = true;
        return this;
    }

    public g G() {
        return a(io.intercom.com.bumptech.glide.load.c.a.j.f9594b, (m<Bitmap>) new io.intercom.com.bumptech.glide.load.c.a.g<Bitmap>());
    }

    public g H() {
        return c(io.intercom.com.bumptech.glide.load.c.a.j.f9597e, new io.intercom.com.bumptech.glide.load.c.a.h());
    }

    public g I() {
        return c(io.intercom.com.bumptech.glide.load.c.a.j.f9593a, new p());
    }

    public g a(float f2) {
        if (this.v) {
            return clone().a(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.f9337b = f2;
        this.f9336a |= 2;
        J();
        return this;
    }

    public final int d() {
        return this.f9341f;
    }

    public final Drawable e() {
        return this.f9340e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (Float.compare(gVar.f9337b, this.f9337b) == 0 && this.f9341f == gVar.f9341f && io.intercom.com.bumptech.glide.h.j.b((Object) this.f9340e, (Object) gVar.f9340e) && this.f9343h == gVar.f9343h && io.intercom.com.bumptech.glide.h.j.b((Object) this.f9342g, (Object) gVar.f9342g) && this.p == gVar.p && io.intercom.com.bumptech.glide.h.j.b((Object) this.o, (Object) gVar.o) && this.f9344i == gVar.f9344i && this.f9345j == gVar.f9345j && this.f9346k == gVar.f9346k && this.m == gVar.m && this.n == gVar.n && this.w == gVar.w && this.x == gVar.x && this.f9338c.equals(gVar.f9338c) && this.f9339d == gVar.f9339d && this.q.equals(gVar.q) && this.r.equals(gVar.r) && this.s.equals(gVar.s) && io.intercom.com.bumptech.glide.h.j.b((Object) this.f9347l, (Object) gVar.f9347l) && io.intercom.com.bumptech.glide.h.j.b((Object) this.u, (Object) gVar.u)) {
            return true;
        }
        return false;
    }

    public final Drawable f() {
        return this.o;
    }

    public final int g() {
        return this.p;
    }

    public final boolean h() {
        return this.x;
    }

    public int hashCode() {
        return io.intercom.com.bumptech.glide.h.j.a((Object) this.u, io.intercom.com.bumptech.glide.h.j.a((Object) this.f9347l, io.intercom.com.bumptech.glide.h.j.a((Object) this.s, io.intercom.com.bumptech.glide.h.j.a((Object) this.r, io.intercom.com.bumptech.glide.h.j.a((Object) this.q, io.intercom.com.bumptech.glide.h.j.a((Object) this.f9339d, io.intercom.com.bumptech.glide.h.j.a((Object) this.f9338c, io.intercom.com.bumptech.glide.h.j.a(this.x, io.intercom.com.bumptech.glide.h.j.a(this.w, io.intercom.com.bumptech.glide.h.j.a(this.n, io.intercom.com.bumptech.glide.h.j.a(this.m, io.intercom.com.bumptech.glide.h.j.a(this.f9346k, io.intercom.com.bumptech.glide.h.j.a(this.f9345j, io.intercom.com.bumptech.glide.h.j.a(this.f9344i, io.intercom.com.bumptech.glide.h.j.a((Object) this.o, io.intercom.com.bumptech.glide.h.j.a(this.p, io.intercom.com.bumptech.glide.h.j.a((Object) this.f9342g, io.intercom.com.bumptech.glide.h.j.a(this.f9343h, io.intercom.com.bumptech.glide.h.j.a((Object) this.f9340e, io.intercom.com.bumptech.glide.h.j.a(this.f9341f, io.intercom.com.bumptech.glide.h.j.a(this.f9337b)))))))))))))))))))));
    }

    public final j i() {
        return this.q;
    }

    public final int j() {
        return this.f9345j;
    }

    public final int k() {
        return this.f9346k;
    }

    public final Drawable l() {
        return this.f9342g;
    }

    public final int m() {
        return this.f9343h;
    }

    public final h n() {
        return this.f9339d;
    }

    public final Class<?> o() {
        return this.s;
    }

    public final io.intercom.com.bumptech.glide.load.g p() {
        return this.f9347l;
    }

    public final float q() {
        return this.f9337b;
    }

    public final Theme r() {
        return this.u;
    }

    public final Map<Class<?>, m<?>> s() {
        return this.r;
    }

    public final boolean t() {
        return this.z;
    }

    public final boolean u() {
        return this.w;
    }

    public final boolean v() {
        return this.f9344i;
    }

    public final boolean w() {
        return c(8);
    }

    /* access modifiers changed from: 0000 */
    public boolean x() {
        return this.y;
    }

    public static g b(io.intercom.com.bumptech.glide.load.g gVar) {
        return new g().a(gVar);
    }

    public final q c() {
        return this.f9338c;
    }

    public g clone() {
        try {
            g gVar = (g) super.clone();
            gVar.q = new j();
            gVar.q.a(this.q);
            gVar.r = new HashMap();
            gVar.r.putAll(this.r);
            gVar.t = false;
            gVar.v = false;
            return gVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static g b(Class<?> cls) {
        return new g().a(cls);
    }

    private boolean c(int i2) {
        return b(this.f9336a, i2);
    }

    public g b(boolean z2) {
        if (this.v) {
            return clone().b(z2);
        }
        this.z = z2;
        this.f9336a |= 1048576;
        J();
        return this;
    }

    public g a(q qVar) {
        if (this.v) {
            return clone().a(qVar);
        }
        io.intercom.com.bumptech.glide.h.h.a(qVar);
        this.f9338c = qVar;
        this.f9336a |= 4;
        J();
        return this;
    }

    public g b(Drawable drawable) {
        if (this.v) {
            return clone().b(drawable);
        }
        this.f9342g = drawable;
        this.f9336a |= 64;
        J();
        return this;
    }

    public g a(h hVar) {
        if (this.v) {
            return clone().a(hVar);
        }
        io.intercom.com.bumptech.glide.h.h.a(hVar);
        this.f9339d = hVar;
        this.f9336a |= 8;
        J();
        return this;
    }

    public g b(int i2) {
        if (this.v) {
            return clone().b(i2);
        }
        this.f9343h = i2;
        this.f9336a |= 128;
        J();
        return this;
    }

    public g a(Drawable drawable) {
        if (this.v) {
            return clone().a(drawable);
        }
        this.f9340e = drawable;
        this.f9336a |= 16;
        J();
        return this;
    }

    /* access modifiers changed from: 0000 */
    public final g b(io.intercom.com.bumptech.glide.load.c.a.j jVar, m<Bitmap> mVar) {
        if (this.v) {
            return clone().b(jVar, mVar);
        }
        a(jVar);
        return a(mVar);
    }

    public g a(int i2) {
        if (this.v) {
            return clone().a(i2);
        }
        this.f9341f = i2;
        this.f9336a |= 32;
        J();
        return this;
    }

    public g b() {
        return a(i.f9697b, (T) Boolean.valueOf(true));
    }

    public g a(boolean z2) {
        if (this.v) {
            return clone().a(true);
        }
        this.f9344i = !z2;
        this.f9336a |= 256;
        J();
        return this;
    }

    public g a(int i2, int i3) {
        if (this.v) {
            return clone().a(i2, i3);
        }
        this.f9346k = i2;
        this.f9345j = i3;
        this.f9336a |= 512;
        J();
        return this;
    }

    public g a(io.intercom.com.bumptech.glide.load.g gVar) {
        if (this.v) {
            return clone().a(gVar);
        }
        io.intercom.com.bumptech.glide.h.h.a(gVar);
        this.f9347l = gVar;
        this.f9336a |= 1024;
        J();
        return this;
    }

    public <T> g a(io.intercom.com.bumptech.glide.load.i<T> iVar, T t2) {
        if (this.v) {
            return clone().a(iVar, t2);
        }
        io.intercom.com.bumptech.glide.h.h.a(iVar);
        io.intercom.com.bumptech.glide.h.h.a(t2);
        this.q.a(iVar, t2);
        J();
        return this;
    }

    public g a(Class<?> cls) {
        if (this.v) {
            return clone().a(cls);
        }
        io.intercom.com.bumptech.glide.h.h.a(cls);
        this.s = cls;
        this.f9336a |= CodedOutputStream.DEFAULT_BUFFER_SIZE;
        J();
        return this;
    }

    public g a(b bVar) {
        io.intercom.com.bumptech.glide.h.h.a(bVar);
        return a(l.f9603a, (T) bVar).a(i.f9696a, (T) bVar);
    }

    public g a(io.intercom.com.bumptech.glide.load.c.a.j jVar) {
        io.intercom.com.bumptech.glide.load.i<io.intercom.com.bumptech.glide.load.c.a.j> iVar = l.f9604b;
        io.intercom.com.bumptech.glide.h.h.a(jVar);
        return a(iVar, (T) jVar);
    }

    /* access modifiers changed from: 0000 */
    public final g a(io.intercom.com.bumptech.glide.load.c.a.j jVar, m<Bitmap> mVar) {
        if (this.v) {
            return clone().a(jVar, mVar);
        }
        a(jVar);
        return a(mVar, false);
    }

    private g a(io.intercom.com.bumptech.glide.load.c.a.j jVar, m<Bitmap> mVar, boolean z2) {
        g b2 = z2 ? b(jVar, mVar) : a(jVar, mVar);
        b2.y = true;
        return b2;
    }

    public g a(m<Bitmap> mVar) {
        return a(mVar, true);
    }

    private g a(m<Bitmap> mVar, boolean z2) {
        if (this.v) {
            return clone().a(mVar, z2);
        }
        o oVar = new o(mVar, z2);
        a(Bitmap.class, mVar, z2);
        a(Drawable.class, (m<T>) oVar, z2);
        oVar.a();
        a(BitmapDrawable.class, (m<T>) oVar, z2);
        a(c.class, (m<T>) new f<T>(mVar), z2);
        J();
        return this;
    }

    private <T> g a(Class<T> cls, m<T> mVar, boolean z2) {
        if (this.v) {
            return clone().a(cls, mVar, z2);
        }
        io.intercom.com.bumptech.glide.h.h.a(cls);
        io.intercom.com.bumptech.glide.h.h.a(mVar);
        this.r.put(cls, mVar);
        this.f9336a |= 2048;
        this.n = true;
        this.f9336a |= 65536;
        this.y = false;
        if (z2) {
            this.f9336a |= 131072;
            this.m = true;
        }
        J();
        return this;
    }

    public g a(g gVar) {
        if (this.v) {
            return clone().a(gVar);
        }
        if (b(gVar.f9336a, 2)) {
            this.f9337b = gVar.f9337b;
        }
        if (b(gVar.f9336a, 262144)) {
            this.w = gVar.w;
        }
        if (b(gVar.f9336a, 1048576)) {
            this.z = gVar.z;
        }
        if (b(gVar.f9336a, 4)) {
            this.f9338c = gVar.f9338c;
        }
        if (b(gVar.f9336a, 8)) {
            this.f9339d = gVar.f9339d;
        }
        if (b(gVar.f9336a, 16)) {
            this.f9340e = gVar.f9340e;
        }
        if (b(gVar.f9336a, 32)) {
            this.f9341f = gVar.f9341f;
        }
        if (b(gVar.f9336a, 64)) {
            this.f9342g = gVar.f9342g;
        }
        if (b(gVar.f9336a, 128)) {
            this.f9343h = gVar.f9343h;
        }
        if (b(gVar.f9336a, 256)) {
            this.f9344i = gVar.f9344i;
        }
        if (b(gVar.f9336a, 512)) {
            this.f9346k = gVar.f9346k;
            this.f9345j = gVar.f9345j;
        }
        if (b(gVar.f9336a, 1024)) {
            this.f9347l = gVar.f9347l;
        }
        if (b(gVar.f9336a, (int) CodedOutputStream.DEFAULT_BUFFER_SIZE)) {
            this.s = gVar.s;
        }
        if (b(gVar.f9336a, 8192)) {
            this.o = gVar.o;
        }
        if (b(gVar.f9336a, 16384)) {
            this.p = gVar.p;
        }
        if (b(gVar.f9336a, 32768)) {
            this.u = gVar.u;
        }
        if (b(gVar.f9336a, 65536)) {
            this.n = gVar.n;
        }
        if (b(gVar.f9336a, 131072)) {
            this.m = gVar.m;
        }
        if (b(gVar.f9336a, 2048)) {
            this.r.putAll(gVar.r);
            this.y = gVar.y;
        }
        if (b(gVar.f9336a, 524288)) {
            this.x = gVar.x;
        }
        if (!this.n) {
            this.r.clear();
            this.f9336a &= -2049;
            this.m = false;
            this.f9336a &= -131073;
            this.y = true;
        }
        this.f9336a |= gVar.f9336a;
        this.q.a(gVar.q);
        J();
        return this;
    }

    public g a() {
        if (!this.t || this.v) {
            this.v = true;
            F();
            return this;
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }
}
