package com.bumptech.glide.load.c.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.f.a.f;
import com.bumptech.glide.f.a.h;
import com.bumptech.glide.l;
import com.bumptech.glide.load.engine.a.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.n;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GifFrameLoader */
class g {

    /* renamed from: a reason: collision with root package name */
    private final com.bumptech.glide.b.a f3815a;

    /* renamed from: b reason: collision with root package name */
    private final Handler f3816b;

    /* renamed from: c reason: collision with root package name */
    private final List<b> f3817c;

    /* renamed from: d reason: collision with root package name */
    final n f3818d;

    /* renamed from: e reason: collision with root package name */
    private final e f3819e;

    /* renamed from: f reason: collision with root package name */
    private boolean f3820f;

    /* renamed from: g reason: collision with root package name */
    private boolean f3821g;

    /* renamed from: h reason: collision with root package name */
    private boolean f3822h;

    /* renamed from: i reason: collision with root package name */
    private l<Bitmap> f3823i;

    /* renamed from: j reason: collision with root package name */
    private a f3824j;

    /* renamed from: k reason: collision with root package name */
    private boolean f3825k;

    /* renamed from: l reason: collision with root package name */
    private a f3826l;
    private Bitmap m;
    private com.bumptech.glide.load.l<Bitmap> n;
    private a o;
    private d p;

    /* compiled from: GifFrameLoader */
    static class a extends f<Bitmap> {

        /* renamed from: d reason: collision with root package name */
        private final Handler f3827d;

        /* renamed from: e reason: collision with root package name */
        final int f3828e;

        /* renamed from: f reason: collision with root package name */
        private final long f3829f;

        /* renamed from: g reason: collision with root package name */
        private Bitmap f3830g;

        a(Handler handler, int i2, long j2) {
            this.f3827d = handler;
            this.f3828e = i2;
            this.f3829f = j2;
        }

        /* access modifiers changed from: 0000 */
        public Bitmap a() {
            return this.f3830g;
        }

        public void a(Bitmap bitmap, com.bumptech.glide.f.b.b<? super Bitmap> bVar) {
            this.f3830g = bitmap;
            this.f3827d.sendMessageAtTime(this.f3827d.obtainMessage(1, this), this.f3829f);
        }
    }

    /* compiled from: GifFrameLoader */
    public interface b {
        void a();
    }

    /* compiled from: GifFrameLoader */
    private class c implements Callback {
        c() {
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                g.this.a((a) message.obj);
                return true;
            }
            if (i2 == 2) {
                g.this.f3818d.a((h<?>) (a) message.obj);
            }
            return false;
        }
    }

    /* compiled from: GifFrameLoader */
    interface d {
        void a();
    }

    g(com.bumptech.glide.e eVar, com.bumptech.glide.b.a aVar, int i2, int i3, com.bumptech.glide.load.l<Bitmap> lVar, Bitmap bitmap) {
        this(eVar.c(), com.bumptech.glide.e.b(eVar.e()), aVar, null, a(com.bumptech.glide.e.b(eVar.e()), i2, i3), lVar, bitmap);
    }

    private static com.bumptech.glide.load.f j() {
        return new com.bumptech.glide.g.b(Double.valueOf(Math.random()));
    }

    private int k() {
        return com.bumptech.glide.h.n.a(c().getWidth(), c().getHeight(), c().getConfig());
    }

    private void l() {
        if (this.f3820f && !this.f3821g) {
            if (this.f3822h) {
                com.bumptech.glide.h.l.a(this.o == null, "Pending target must be null when starting from the first frame");
                this.f3815a.d();
                this.f3822h = false;
            }
            a aVar = this.o;
            if (aVar != null) {
                this.o = null;
                a(aVar);
                return;
            }
            this.f3821g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f3815a.c());
            this.f3815a.advance();
            this.f3826l = new a(this.f3816b, this.f3815a.e(), uptimeMillis);
            this.f3823i.a((com.bumptech.glide.f.a) com.bumptech.glide.f.f.b(j())).a((Object) this.f3815a).a(this.f3826l);
        }
    }

    private void m() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f3819e.a(bitmap);
            this.m = null;
        }
    }

    private void n() {
        if (!this.f3820f) {
            this.f3820f = true;
            this.f3825k = false;
            l();
        }
    }

    private void o() {
        this.f3820f = false;
    }

    /* access modifiers changed from: 0000 */
    public void a(com.bumptech.glide.load.l<Bitmap> lVar, Bitmap bitmap) {
        com.bumptech.glide.h.l.a(lVar);
        this.n = lVar;
        com.bumptech.glide.h.l.a(bitmap);
        this.m = bitmap;
        this.f3823i = this.f3823i.a(new com.bumptech.glide.f.f().a(lVar));
    }

    /* access modifiers changed from: 0000 */
    public void b(b bVar) {
        this.f3817c.remove(bVar);
        if (this.f3817c.isEmpty()) {
            o();
        }
    }

    /* access modifiers changed from: 0000 */
    public Bitmap c() {
        a aVar = this.f3824j;
        return aVar != null ? aVar.a() : this.m;
    }

    /* access modifiers changed from: 0000 */
    public int d() {
        a aVar = this.f3824j;
        if (aVar != null) {
            return aVar.f3828e;
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public Bitmap e() {
        return this.m;
    }

    /* access modifiers changed from: 0000 */
    public int f() {
        return this.f3815a.b();
    }

    /* access modifiers changed from: 0000 */
    public int g() {
        return c().getHeight();
    }

    /* access modifiers changed from: 0000 */
    public int h() {
        return this.f3815a.f() + k();
    }

    /* access modifiers changed from: 0000 */
    public int i() {
        return c().getWidth();
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar) {
        if (this.f3825k) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        } else if (!this.f3817c.contains(bVar)) {
            boolean isEmpty = this.f3817c.isEmpty();
            this.f3817c.add(bVar);
            if (isEmpty) {
                n();
            }
        } else {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
    }

    /* access modifiers changed from: 0000 */
    public ByteBuffer b() {
        return this.f3815a.getData().asReadOnlyBuffer();
    }

    g(e eVar, n nVar, com.bumptech.glide.b.a aVar, Handler handler, l<Bitmap> lVar, com.bumptech.glide.load.l<Bitmap> lVar2, Bitmap bitmap) {
        this.f3817c = new ArrayList();
        this.f3818d = nVar;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new c());
        }
        this.f3819e = eVar;
        this.f3816b = handler;
        this.f3823i = lVar;
        this.f3815a = aVar;
        a(lVar2, bitmap);
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f3817c.clear();
        m();
        o();
        a aVar = this.f3824j;
        if (aVar != null) {
            this.f3818d.a((h<?>) aVar);
            this.f3824j = null;
        }
        a aVar2 = this.f3826l;
        if (aVar2 != null) {
            this.f3818d.a((h<?>) aVar2);
            this.f3826l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f3818d.a((h<?>) aVar3);
            this.o = null;
        }
        this.f3815a.clear();
        this.f3825k = true;
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f3821g = false;
        if (this.f3825k) {
            this.f3816b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f3820f) {
            this.o = aVar;
        } else {
            if (aVar.a() != null) {
                m();
                a aVar2 = this.f3824j;
                this.f3824j = aVar;
                for (int size = this.f3817c.size() - 1; size >= 0; size--) {
                    ((b) this.f3817c.get(size)).a();
                }
                if (aVar2 != null) {
                    this.f3816b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        }
    }

    private static l<Bitmap> a(n nVar, int i2, int i3) {
        return nVar.a().a(((com.bumptech.glide.f.f) ((com.bumptech.glide.f.f) com.bumptech.glide.f.f.b(s.f4073b).b(true)).a(true)).a(i2, i3));
    }
}
