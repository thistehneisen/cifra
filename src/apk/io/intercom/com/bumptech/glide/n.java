package io.intercom.com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import io.intercom.com.bumptech.glide.c.c;
import io.intercom.com.bumptech.glide.c.i;
import io.intercom.com.bumptech.glide.c.j;
import io.intercom.com.bumptech.glide.c.o;
import io.intercom.com.bumptech.glide.c.p;
import io.intercom.com.bumptech.glide.c.r;
import io.intercom.com.bumptech.glide.f.a.h;
import io.intercom.com.bumptech.glide.f.b.d;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.load.engine.q;
import java.io.File;

/* compiled from: RequestManager */
public class n implements j, g<k<Drawable>> {

    /* renamed from: a reason: collision with root package name */
    private static final g f9997a;

    /* renamed from: b reason: collision with root package name */
    private static final g f9998b;

    /* renamed from: c reason: collision with root package name */
    private static final g f9999c = g.b(q.f9934c).a(h.LOW).a(true);

    /* renamed from: d reason: collision with root package name */
    protected final c f10000d;

    /* renamed from: e reason: collision with root package name */
    protected final Context f10001e;

    /* renamed from: f reason: collision with root package name */
    final i f10002f;

    /* renamed from: g reason: collision with root package name */
    private final p f10003g;

    /* renamed from: h reason: collision with root package name */
    private final o f10004h;

    /* renamed from: i reason: collision with root package name */
    private final r f10005i;

    /* renamed from: j reason: collision with root package name */
    private final Runnable f10006j;

    /* renamed from: k reason: collision with root package name */
    private final Handler f10007k;

    /* renamed from: l reason: collision with root package name */
    private final c f10008l;
    private g m;

    /* compiled from: RequestManager */
    private static class a extends io.intercom.com.bumptech.glide.f.a.i<View, Object> {
        a(View view) {
            super(view);
        }

        public void onResourceReady(Object obj, d<? super Object> dVar) {
        }
    }

    /* compiled from: RequestManager */
    private static class b implements io.intercom.com.bumptech.glide.c.c.a {

        /* renamed from: a reason: collision with root package name */
        private final p f10009a;

        b(p pVar) {
            this.f10009a = pVar;
        }

        public void a(boolean z) {
            if (z) {
                this.f10009a.c();
            }
        }
    }

    static {
        g b2 = g.b(Bitmap.class);
        b2.F();
        f9997a = b2;
        g b3 = g.b(io.intercom.com.bumptech.glide.load.c.e.c.class);
        b3.F();
        f9998b = b3;
    }

    public n(c cVar, i iVar, o oVar, Context context) {
        this(cVar, iVar, oVar, new p(), cVar.d(), context);
    }

    /* access modifiers changed from: protected */
    public void a(g gVar) {
        g clone = gVar.clone();
        clone.a();
        this.m = clone;
    }

    public k<Drawable> b() {
        return a(Drawable.class);
    }

    public k<File> c() {
        k<File> a2 = a(File.class);
        a2.a(f9999c);
        return a2;
    }

    /* access modifiers changed from: 0000 */
    public g d() {
        return this.m;
    }

    public void e() {
        io.intercom.com.bumptech.glide.h.j.b();
        this.f10003g.b();
    }

    public void f() {
        io.intercom.com.bumptech.glide.h.j.b();
        this.f10003g.d();
    }

    public void onDestroy() {
        this.f10005i.onDestroy();
        for (h a2 : this.f10005i.b()) {
            a(a2);
        }
        this.f10005i.a();
        this.f10003g.a();
        this.f10002f.a(this);
        this.f10002f.a(this.f10008l);
        this.f10007k.removeCallbacks(this.f10006j);
        this.f10000d.b(this);
    }

    public void onStart() {
        f();
        this.f10005i.onStart();
    }

    public void onStop() {
        e();
        this.f10005i.onStop();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{tracker=");
        sb.append(this.f10003g);
        sb.append(", treeNode=");
        sb.append(this.f10004h);
        sb.append("}");
        return sb.toString();
    }

    private void c(h<?> hVar) {
        if (!b(hVar) && !this.f10000d.a(hVar) && hVar.getRequest() != null) {
            io.intercom.com.bumptech.glide.f.c request = hVar.getRequest();
            hVar.setRequest(null);
            request.clear();
        }
    }

    public k<Bitmap> a() {
        k<Bitmap> a2 = a(Bitmap.class);
        a2.a(f9997a);
        return a2;
    }

    /* access modifiers changed from: 0000 */
    public boolean b(h<?> hVar) {
        io.intercom.com.bumptech.glide.f.c request = hVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f10003g.a(request)) {
            return false;
        }
        this.f10005i.b(hVar);
        hVar.setRequest(null);
        return true;
    }

    public k<Drawable> a(String str) {
        k<Drawable> b2 = b();
        b2.a(str);
        return b2;
    }

    n(c cVar, i iVar, o oVar, p pVar, io.intercom.com.bumptech.glide.c.d dVar, Context context) {
        this.f10005i = new r();
        this.f10006j = new l(this);
        this.f10007k = new Handler(Looper.getMainLooper());
        this.f10000d = cVar;
        this.f10002f = iVar;
        this.f10004h = oVar;
        this.f10003g = pVar;
        this.f10001e = context;
        this.f10008l = dVar.a(context.getApplicationContext(), new b(pVar));
        if (io.intercom.com.bumptech.glide.h.j.c()) {
            this.f10007k.post(this.f10006j);
        } else {
            iVar.b(this);
        }
        iVar.b(this.f10008l);
        a(cVar.f().b());
        cVar.a(this);
    }

    public <ResourceType> k<ResourceType> a(Class<ResourceType> cls) {
        return new k<>(this.f10000d, this, cls, this.f10001e);
    }

    public void a(View view) {
        a((h<?>) new a<Object>(view));
    }

    public void a(h<?> hVar) {
        if (hVar != null) {
            if (io.intercom.com.bumptech.glide.h.j.d()) {
                c(hVar);
            } else {
                this.f10007k.post(new m(this, hVar));
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public <T> o<?, T> b(Class<T> cls) {
        return this.f10000d.f().a(cls);
    }

    /* access modifiers changed from: 0000 */
    public void a(h<?> hVar, io.intercom.com.bumptech.glide.f.c cVar) {
        this.f10005i.a(hVar);
        this.f10003g.b(cVar);
    }
}
