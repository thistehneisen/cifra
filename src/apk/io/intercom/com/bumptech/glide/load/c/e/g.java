package io.intercom.com.bumptech.glide.load.c.e;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import io.intercom.com.bumptech.glide.f.a.f;
import io.intercom.com.bumptech.glide.f.a.h;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.k;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import io.intercom.com.bumptech.glide.load.engine.q;
import io.intercom.com.bumptech.glide.load.m;
import io.intercom.com.bumptech.glide.n;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GifFrameLoader */
class g {

    /* renamed from: a reason: collision with root package name */
    private final io.intercom.com.bumptech.glide.b.a f9678a;

    /* renamed from: b reason: collision with root package name */
    private final Handler f9679b;

    /* renamed from: c reason: collision with root package name */
    private final List<b> f9680c;

    /* renamed from: d reason: collision with root package name */
    final n f9681d;

    /* renamed from: e reason: collision with root package name */
    private final e f9682e;

    /* renamed from: f reason: collision with root package name */
    private boolean f9683f;

    /* renamed from: g reason: collision with root package name */
    private boolean f9684g;

    /* renamed from: h reason: collision with root package name */
    private boolean f9685h;

    /* renamed from: i reason: collision with root package name */
    private k<Bitmap> f9686i;

    /* renamed from: j reason: collision with root package name */
    private a f9687j;

    /* renamed from: k reason: collision with root package name */
    private boolean f9688k;

    /* renamed from: l reason: collision with root package name */
    private a f9689l;
    private Bitmap m;
    private m<Bitmap> n;
    private a o;
    private d p;

    /* compiled from: GifFrameLoader */
    static class a extends f<Bitmap> {

        /* renamed from: a reason: collision with root package name */
        private final Handler f9690a;

        /* renamed from: b reason: collision with root package name */
        final int f9691b;

        /* renamed from: c reason: collision with root package name */
        private final long f9692c;

        /* renamed from: d reason: collision with root package name */
        private Bitmap f9693d;

        a(Handler handler, int i2, long j2) {
            this.f9690a = handler;
            this.f9691b = i2;
            this.f9692c = j2;
        }

        /* access modifiers changed from: 0000 */
        public Bitmap b() {
            return this.f9693d;
        }

        public void onResourceReady(Bitmap bitmap, io.intercom.com.bumptech.glide.f.b.d<? super Bitmap> dVar) {
            this.f9693d = bitmap;
            this.f9690a.sendMessageAtTime(this.f9690a.obtainMessage(1, this), this.f9692c);
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
                g.this.f9681d.a((h<?>) (a) message.obj);
            }
            return false;
        }
    }

    /* compiled from: GifFrameLoader */
    interface d {
        void a();
    }

    g(io.intercom.com.bumptech.glide.c cVar, io.intercom.com.bumptech.glide.b.a aVar, int i2, int i3, m<Bitmap> mVar, Bitmap bitmap) {
        this(cVar.c(), io.intercom.com.bumptech.glide.c.b(cVar.e()), aVar, null, a(io.intercom.com.bumptech.glide.c.b(cVar.e()), i2, i3), mVar, bitmap);
    }

    private static io.intercom.com.bumptech.glide.load.g j() {
        return new io.intercom.com.bumptech.glide.g.b(Double.valueOf(Math.random()));
    }

    private int k() {
        return j.a(c().getWidth(), c().getHeight(), c().getConfig());
    }

    private void l() {
        if (this.f9683f && !this.f9684g) {
            if (this.f9685h) {
                io.intercom.com.bumptech.glide.h.h.a(this.o == null, "Pending target must be null when starting from the first frame");
                this.f9678a.d();
                this.f9685h = false;
            }
            a aVar = this.o;
            if (aVar != null) {
                this.o = null;
                a(aVar);
                return;
            }
            this.f9684g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f9678a.c());
            this.f9678a.advance();
            this.f9689l = new a(this.f9679b, this.f9678a.e(), uptimeMillis);
            k<Bitmap> kVar = this.f9686i;
            kVar.a(io.intercom.com.bumptech.glide.f.g.b(j()));
            kVar.a((Object) this.f9678a);
            kVar.a(this.f9689l);
        }
    }

    private void m() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.f9682e.a(bitmap);
            this.m = null;
        }
    }

    private void n() {
        if (!this.f9683f) {
            this.f9683f = true;
            this.f9688k = false;
            l();
        }
    }

    private void o() {
        this.f9683f = false;
    }

    /* access modifiers changed from: 0000 */
    public void a(m<Bitmap> mVar, Bitmap bitmap) {
        io.intercom.com.bumptech.glide.h.h.a(mVar);
        this.n = mVar;
        io.intercom.com.bumptech.glide.h.h.a(bitmap);
        this.m = bitmap;
        k<Bitmap> kVar = this.f9686i;
        kVar.a(new io.intercom.com.bumptech.glide.f.g().a(mVar));
        this.f9686i = kVar;
    }

    /* access modifiers changed from: 0000 */
    public void b(b bVar) {
        this.f9680c.remove(bVar);
        if (this.f9680c.isEmpty()) {
            o();
        }
    }

    /* access modifiers changed from: 0000 */
    public Bitmap c() {
        a aVar = this.f9687j;
        return aVar != null ? aVar.b() : this.m;
    }

    /* access modifiers changed from: 0000 */
    public int d() {
        a aVar = this.f9687j;
        if (aVar != null) {
            return aVar.f9691b;
        }
        return -1;
    }

    /* access modifiers changed from: 0000 */
    public Bitmap e() {
        return this.m;
    }

    /* access modifiers changed from: 0000 */
    public int f() {
        return this.f9678a.b();
    }

    /* access modifiers changed from: 0000 */
    public int g() {
        return c().getHeight();
    }

    /* access modifiers changed from: 0000 */
    public int h() {
        return this.f9678a.f() + k();
    }

    /* access modifiers changed from: 0000 */
    public int i() {
        return c().getWidth();
    }

    /* access modifiers changed from: 0000 */
    public void a(b bVar) {
        if (!this.f9688k) {
            boolean isEmpty = this.f9680c.isEmpty();
            if (!this.f9680c.contains(bVar)) {
                this.f9680c.add(bVar);
                if (isEmpty) {
                    n();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
    }

    /* access modifiers changed from: 0000 */
    public ByteBuffer b() {
        return this.f9678a.getData().asReadOnlyBuffer();
    }

    g(e eVar, n nVar, io.intercom.com.bumptech.glide.b.a aVar, Handler handler, k<Bitmap> kVar, m<Bitmap> mVar, Bitmap bitmap) {
        this.f9680c = new ArrayList();
        this.f9683f = false;
        this.f9684g = false;
        this.f9685h = false;
        this.f9681d = nVar;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new c());
        }
        this.f9682e = eVar;
        this.f9679b = handler;
        this.f9686i = kVar;
        this.f9678a = aVar;
        a(mVar, bitmap);
    }

    /* access modifiers changed from: 0000 */
    public void a() {
        this.f9680c.clear();
        m();
        o();
        a aVar = this.f9687j;
        if (aVar != null) {
            this.f9681d.a((h<?>) aVar);
            this.f9687j = null;
        }
        a aVar2 = this.f9689l;
        if (aVar2 != null) {
            this.f9681d.a((h<?>) aVar2);
            this.f9689l = null;
        }
        a aVar3 = this.o;
        if (aVar3 != null) {
            this.f9681d.a((h<?>) aVar3);
            this.o = null;
        }
        this.f9678a.clear();
        this.f9688k = true;
    }

    /* access modifiers changed from: 0000 */
    public void a(a aVar) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.a();
        }
        this.f9684g = false;
        if (this.f9688k) {
            this.f9679b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f9683f) {
            this.o = aVar;
        } else {
            if (aVar.b() != null) {
                m();
                a aVar2 = this.f9687j;
                this.f9687j = aVar;
                for (int size = this.f9680c.size() - 1; size >= 0; size--) {
                    ((b) this.f9680c.get(size)).a();
                }
                if (aVar2 != null) {
                    this.f9679b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            l();
        }
    }

    private static k<Bitmap> a(n nVar, int i2, int i3) {
        k<Bitmap> a2 = nVar.a();
        a2.a(io.intercom.com.bumptech.glide.f.g.b(q.f9933b).b(true).a(true).a(i2, i3));
        return a2;
    }
}
