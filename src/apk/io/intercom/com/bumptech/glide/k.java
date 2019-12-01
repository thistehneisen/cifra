package io.intercom.com.bumptech.glide;

import android.content.Context;
import android.widget.ImageView;
import io.intercom.com.bumptech.glide.f.a;
import io.intercom.com.bumptech.glide.f.a.i;
import io.intercom.com.bumptech.glide.f.b;
import io.intercom.com.bumptech.glide.f.c;
import io.intercom.com.bumptech.glide.f.d;
import io.intercom.com.bumptech.glide.f.e;
import io.intercom.com.bumptech.glide.f.f;
import io.intercom.com.bumptech.glide.f.g;
import io.intercom.com.bumptech.glide.h.h;
import io.intercom.com.bumptech.glide.h.j;
import io.intercom.com.bumptech.glide.load.engine.q;
import java.io.File;

/* compiled from: RequestBuilder */
public class k<TranscodeType> implements Cloneable, g<k<TranscodeType>> {

    /* renamed from: a reason: collision with root package name */
    protected static final g f9412a = new g().a(q.f9934c).a(h.LOW).a(true);

    /* renamed from: b reason: collision with root package name */
    private final Context f9413b;

    /* renamed from: c reason: collision with root package name */
    private final n f9414c;

    /* renamed from: d reason: collision with root package name */
    private final Class<TranscodeType> f9415d;

    /* renamed from: e reason: collision with root package name */
    private final g f9416e;

    /* renamed from: f reason: collision with root package name */
    private final c f9417f;

    /* renamed from: g reason: collision with root package name */
    private final e f9418g;

    /* renamed from: h reason: collision with root package name */
    protected g f9419h;

    /* renamed from: i reason: collision with root package name */
    private o<?, ? super TranscodeType> f9420i;

    /* renamed from: j reason: collision with root package name */
    private Object f9421j;

    /* renamed from: k reason: collision with root package name */
    private f<TranscodeType> f9422k;

    /* renamed from: l reason: collision with root package name */
    private k<TranscodeType> f9423l;
    private k<TranscodeType> m;
    private Float n;
    private boolean o = true;
    private boolean p;
    private boolean q;

    protected k(c cVar, n nVar, Class<TranscodeType> cls, Context context) {
        this.f9417f = cVar;
        this.f9414c = nVar;
        this.f9415d = cls;
        this.f9416e = nVar.d();
        this.f9413b = context;
        this.f9420i = nVar.b(cls);
        this.f9419h = this.f9416e;
        this.f9418g = cVar.f();
    }

    private k<TranscodeType> b(Object obj) {
        this.f9421j = obj;
        this.p = true;
        return this;
    }

    public k<TranscodeType> a(g gVar) {
        h.a(gVar);
        this.f9419h = a().a(gVar);
        return this;
    }

    public k<TranscodeType> clone() {
        try {
            k<TranscodeType> kVar = (k) super.clone();
            kVar.f9419h = kVar.f9419h.clone();
            kVar.f9420i = kVar.f9420i.clone();
            return kVar;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    private <Y extends io.intercom.com.bumptech.glide.f.a.h<TranscodeType>> Y b(Y y, f<TranscodeType> fVar, g gVar) {
        j.b();
        h.a(y);
        if (this.p) {
            gVar.a();
            c a2 = a((io.intercom.com.bumptech.glide.f.a.h<TranscodeType>) y, fVar, gVar);
            c request = y.getRequest();
            if (a2.a(request)) {
                a2.a();
                h.a(request);
                if (!request.isRunning()) {
                    request.e();
                }
                return y;
            }
            this.f9414c.a((io.intercom.com.bumptech.glide.f.a.h<?>) y);
            y.setRequest(a2);
            this.f9414c.a(y, a2);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    /* access modifiers changed from: protected */
    public g a() {
        g gVar = this.f9416e;
        g gVar2 = this.f9419h;
        return gVar == gVar2 ? gVar2.clone() : gVar2;
    }

    public k<TranscodeType> a(o<?, ? super TranscodeType> oVar) {
        h.a(oVar);
        this.f9420i = oVar;
        this.o = false;
        return this;
    }

    public k<TranscodeType> a(f<TranscodeType> fVar) {
        this.f9422k = fVar;
        return this;
    }

    public k<TranscodeType> a(Object obj) {
        b(obj);
        return this;
    }

    public k<TranscodeType> a(String str) {
        b(str);
        return this;
    }

    public k<TranscodeType> a(File file) {
        b(file);
        return this;
    }

    public <Y extends io.intercom.com.bumptech.glide.f.a.h<TranscodeType>> Y a(Y y) {
        a(y, null);
        return y;
    }

    /* access modifiers changed from: private */
    public <Y extends io.intercom.com.bumptech.glide.f.a.h<TranscodeType>> Y a(Y y, f<TranscodeType> fVar) {
        b(y, fVar, a());
        return y;
    }

    public i<ImageView, TranscodeType> a(ImageView imageView) {
        j.b();
        h.a(imageView);
        g gVar = this.f9419h;
        if (!gVar.D() && gVar.B() && imageView.getScaleType() != null) {
            switch (j.f9410a[imageView.getScaleType().ordinal()]) {
                case 1:
                    gVar = gVar.clone().G();
                    break;
                case 2:
                    gVar = gVar.clone().H();
                    break;
                case 3:
                case 4:
                case 5:
                    gVar = gVar.clone().I();
                    break;
                case 6:
                    gVar = gVar.clone().H();
                    break;
            }
        }
        i<ImageView, TranscodeType> a2 = this.f9418g.a(imageView, this.f9415d);
        b(a2, null, gVar);
        return a2;
    }

    private c b(io.intercom.com.bumptech.glide.f.a.h<TranscodeType> hVar, f<TranscodeType> fVar, d dVar, o<?, ? super TranscodeType> oVar, h hVar2, int i2, int i3, g gVar) {
        d dVar2 = dVar;
        h hVar3 = hVar2;
        k<TranscodeType> kVar = this.f9423l;
        if (kVar != null) {
            if (!this.q) {
                o<?, ? super TranscodeType> oVar2 = kVar.o ? oVar : kVar.f9420i;
                h n2 = this.f9423l.f9419h.w() ? this.f9423l.f9419h.n() : a(hVar3);
                int k2 = this.f9423l.f9419h.k();
                int j2 = this.f9423l.f9419h.j();
                if (j.b(i2, i3) && !this.f9423l.f9419h.E()) {
                    k2 = gVar.k();
                    j2 = gVar.j();
                }
                int i4 = k2;
                int i5 = j2;
                io.intercom.com.bumptech.glide.f.k kVar2 = new io.intercom.com.bumptech.glide.f.k(dVar2);
                c a2 = a(hVar, fVar, gVar, (d) kVar2, oVar, hVar2, i2, i3);
                this.q = true;
                k<TranscodeType> kVar3 = this.f9423l;
                io.intercom.com.bumptech.glide.f.k kVar4 = kVar2;
                c a3 = kVar3.a(hVar, fVar, (d) kVar2, oVar2, n2, i4, i5, kVar3.f9419h);
                this.q = false;
                kVar4.a(a2, a3);
                return kVar4;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.n == null) {
            return a(hVar, fVar, gVar, dVar, oVar, hVar2, i2, i3);
        } else {
            io.intercom.com.bumptech.glide.f.k kVar5 = new io.intercom.com.bumptech.glide.f.k(dVar2);
            f<TranscodeType> fVar2 = fVar;
            io.intercom.com.bumptech.glide.f.k kVar6 = kVar5;
            o<?, ? super TranscodeType> oVar3 = oVar;
            int i6 = i2;
            int i7 = i3;
            kVar5.a(a(hVar, fVar2, gVar, (d) kVar6, oVar3, hVar2, i6, i7), a(hVar, fVar2, gVar.clone().a(this.n.floatValue()), (d) kVar6, oVar3, a(hVar3), i6, i7));
            return kVar5;
        }
    }

    public b<TranscodeType> a(int i2, int i3) {
        e eVar = new e(this.f9418g.e(), i2, i3);
        if (j.c()) {
            this.f9418g.e().post(new i(this, eVar));
        } else {
            a((Y) eVar, (f<TranscodeType>) eVar);
        }
        return eVar;
    }

    private h a(h hVar) {
        int i2 = j.f9411b[hVar.ordinal()];
        if (i2 == 1) {
            return h.NORMAL;
        }
        if (i2 == 2) {
            return h.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return h.IMMEDIATE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unknown priority: ");
        sb.append(this.f9419h.n());
        throw new IllegalArgumentException(sb.toString());
    }

    private c a(io.intercom.com.bumptech.glide.f.a.h<TranscodeType> hVar, f<TranscodeType> fVar, g gVar) {
        return a(hVar, fVar, (d) null, this.f9420i, gVar.n(), gVar.k(), gVar.j(), gVar);
    }

    /* JADX WARNING: type inference failed for: r15v0 */
    /* JADX WARNING: type inference failed for: r3v0, types: [io.intercom.com.bumptech.glide.f.d] */
    /* JADX WARNING: type inference failed for: r13v0, types: [io.intercom.com.bumptech.glide.f.d] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r0v4, types: [io.intercom.com.bumptech.glide.f.a] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    private c a(io.intercom.com.bumptech.glide.f.a.h<TranscodeType> hVar, f<TranscodeType> fVar, d dVar, o<?, ? super TranscodeType> oVar, h hVar2, int i2, int i3, g gVar) {
        ? r15;
        ? r3;
        if (this.m != null) {
            ? aVar = new a(dVar);
            r15 = aVar;
            r3 = aVar;
        } else {
            r15 = 0;
            r3 = dVar;
        }
        c b2 = b(hVar, fVar, r3, oVar, hVar2, i2, i3, gVar);
        if (r15 == 0) {
            return b2;
        }
        int k2 = this.m.f9419h.k();
        int j2 = this.m.f9419h.j();
        if (j.b(i2, i3) && !this.m.f9419h.E()) {
            k2 = gVar.k();
            j2 = gVar.j();
        }
        int i4 = k2;
        int i5 = j2;
        k<TranscodeType> kVar = this.m;
        a aVar2 = r15;
        aVar2.a(b2, kVar.a(hVar, fVar, (d) r15, kVar.f9420i, kVar.f9419h.n(), i4, i5, this.m.f9419h));
        return aVar2;
    }

    private c a(io.intercom.com.bumptech.glide.f.a.h<TranscodeType> hVar, f<TranscodeType> fVar, g gVar, d dVar, o<?, ? super TranscodeType> oVar, h hVar2, int i2, int i3) {
        Context context = this.f9413b;
        e eVar = this.f9418g;
        return io.intercom.com.bumptech.glide.f.j.a(context, eVar, this.f9421j, this.f9415d, gVar, i2, i3, hVar2, hVar, fVar, this.f9422k, dVar, eVar.c(), oVar.a());
    }
}
