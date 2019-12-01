package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.c.d;
import com.bumptech.glide.c.i;
import com.bumptech.glide.c.j;
import com.bumptech.glide.c.o;
import com.bumptech.glide.c.p;
import com.bumptech.glide.c.r;
import com.bumptech.glide.f.a.h;
import com.bumptech.glide.f.e;
import com.bumptech.glide.f.f;
import com.bumptech.glide.load.c.e.c;
import com.bumptech.glide.load.engine.s;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: RequestManager */
public class n implements j, i<l<Drawable>> {

    /* renamed from: a reason: collision with root package name */
    private static final f f4138a = ((f) f.b(Bitmap.class).E());

    /* renamed from: b reason: collision with root package name */
    private static final f f4139b = ((f) f.b(c.class).E());

    /* renamed from: c reason: collision with root package name */
    private static final f f4140c = ((f) ((f) f.b(s.f4074c).a(j.LOW)).a(true));

    /* renamed from: d reason: collision with root package name */
    protected final e f4141d;

    /* renamed from: e reason: collision with root package name */
    protected final Context f4142e;

    /* renamed from: f reason: collision with root package name */
    final i f4143f;

    /* renamed from: g reason: collision with root package name */
    private final p f4144g;

    /* renamed from: h reason: collision with root package name */
    private final o f4145h;

    /* renamed from: i reason: collision with root package name */
    private final r f4146i;

    /* renamed from: j reason: collision with root package name */
    private final Runnable f4147j;

    /* renamed from: k reason: collision with root package name */
    private final Handler f4148k;

    /* renamed from: l reason: collision with root package name */
    private final com.bumptech.glide.c.c f4149l;
    private final CopyOnWriteArrayList<e<Object>> m;
    private f n;

    /* compiled from: RequestManager */
    private class a implements com.bumptech.glide.c.c.a {

        /* renamed from: a reason: collision with root package name */
        private final p f4150a;

        a(p pVar) {
            this.f4150a = pVar;
        }

        public void a(boolean z) {
            if (z) {
                synchronized (n.this) {
                    this.f4150a.c();
                }
            }
        }
    }

    public n(e eVar, i iVar, o oVar, Context context) {
        this(eVar, iVar, oVar, new p(), eVar.d(), context);
    }

    private void c(h<?> hVar) {
        if (!b(hVar) && !this.f4141d.a(hVar) && hVar.getRequest() != null) {
            com.bumptech.glide.f.c request = hVar.getRequest();
            hVar.a((com.bumptech.glide.f.c) null);
            request.clear();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void a(f fVar) {
        this.n = (f) ((f) fVar.clone()).a();
    }

    public l<Drawable> b() {
        return a(Drawable.class);
    }

    /* access modifiers changed from: 0000 */
    public synchronized f d() {
        return this.n;
    }

    public synchronized void e() {
        this.f4144g.b();
    }

    public synchronized void f() {
        this.f4144g.d();
    }

    public synchronized void onDestroy() {
        this.f4146i.onDestroy();
        for (h a2 : this.f4146i.b()) {
            a(a2);
        }
        this.f4146i.a();
        this.f4144g.a();
        this.f4143f.b(this);
        this.f4143f.b(this.f4149l);
        this.f4148k.removeCallbacks(this.f4147j);
        this.f4141d.b(this);
    }

    public synchronized void onStart() {
        f();
        this.f4146i.onStart();
    }

    public synchronized void onStop() {
        e();
        this.f4146i.onStop();
    }

    public synchronized String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{tracker=");
        sb.append(this.f4144g);
        sb.append(", treeNode=");
        sb.append(this.f4145h);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean b(h<?> hVar) {
        com.bumptech.glide.f.c request = hVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f4144g.a(request)) {
            return false;
        }
        this.f4146i.b(hVar);
        hVar.a((com.bumptech.glide.f.c) null);
        return true;
    }

    public l<Bitmap> a() {
        return a(Bitmap.class).a((com.bumptech.glide.f.a) f4138a);
    }

    n(e eVar, i iVar, o oVar, p pVar, d dVar, Context context) {
        this.f4146i = new r();
        this.f4147j = new m(this);
        this.f4148k = new Handler(Looper.getMainLooper());
        this.f4141d = eVar;
        this.f4143f = iVar;
        this.f4145h = oVar;
        this.f4144g = pVar;
        this.f4142e = context;
        this.f4149l = dVar.a(context.getApplicationContext(), new a(pVar));
        if (com.bumptech.glide.h.n.b()) {
            this.f4148k.post(this.f4147j);
        } else {
            iVar.a(this);
        }
        iVar.a(this.f4149l);
        this.m = new CopyOnWriteArrayList<>(eVar.f().b());
        a(eVar.f().c());
        eVar.a(this);
    }

    public l<Drawable> a(String str) {
        return b().a(str);
    }

    public <ResourceType> l<ResourceType> a(Class<ResourceType> cls) {
        return new l<>(this.f4141d, this, cls, this.f4142e);
    }

    public synchronized void a(h<?> hVar) {
        if (hVar != null) {
            c(hVar);
        }
    }

    /* access modifiers changed from: 0000 */
    public List<e<Object>> c() {
        return this.m;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void a(h<?> hVar, com.bumptech.glide.f.c cVar) {
        this.f4146i.a(hVar);
        this.f4144g.b(cVar);
    }

    /* access modifiers changed from: 0000 */
    public <T> o<?, T> b(Class<T> cls) {
        return this.f4141d.f().a(cls);
    }
}
