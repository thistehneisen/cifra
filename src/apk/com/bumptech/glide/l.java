package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.f.a;
import com.bumptech.glide.f.a.h;
import com.bumptech.glide.f.a.i;
import com.bumptech.glide.f.b;
import com.bumptech.glide.f.c;
import com.bumptech.glide.f.d;
import com.bumptech.glide.f.e;
import com.bumptech.glide.f.f;
import com.bumptech.glide.f.j;
import com.bumptech.glide.h.g;
import com.bumptech.glide.h.n;
import com.bumptech.glide.load.engine.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: RequestBuilder */
public class l<TranscodeType> extends a<l<TranscodeType>> implements Cloneable, i<l<TranscodeType>> {
    protected static final f A = ((f) ((f) ((f) new f().a(s.f4074c)).a(j.LOW)).a(true));
    private final Context B;
    private final n C;
    private final Class<TranscodeType> D;
    private final e E;
    private final g F;
    private o<?, ? super TranscodeType> G;
    private Object H;
    private List<e<TranscodeType>> I;
    private l<TranscodeType> J;
    private l<TranscodeType> K;
    private Float L;
    private boolean M = true;
    private boolean N;
    private boolean O;

    @SuppressLint({"CheckResult"})
    protected l(e eVar, n nVar, Class<TranscodeType> cls, Context context) {
        this.E = eVar;
        this.C = nVar;
        this.D = cls;
        this.B = context;
        this.G = nVar.b(cls);
        this.F = eVar.f();
        a(nVar.c());
        a((a) nVar.d());
    }

    private l<TranscodeType> b(Object obj) {
        this.H = obj;
        this.N = true;
        return this;
    }

    @SuppressLint({"CheckResult"})
    private void a(List<e<Object>> list) {
        for (e a2 : list) {
            a(a2);
        }
    }

    private <Y extends h<TranscodeType>> Y b(Y y, e<TranscodeType> eVar, a<?> aVar, Executor executor) {
        com.bumptech.glide.h.l.a(y);
        if (this.N) {
            c a2 = a(y, eVar, aVar, executor);
            c request = y.getRequest();
            if (!a2.a(request) || a(aVar, request)) {
                this.C.a((h<?>) y);
                y.a(a2);
                this.C.a(y, a2);
                return y;
            }
            a2.a();
            com.bumptech.glide.h.l.a(request);
            if (!request.isRunning()) {
                request.e();
            }
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public l<TranscodeType> clone() {
        l<TranscodeType> lVar = (l) super.clone();
        lVar.G = lVar.G.clone();
        return lVar;
    }

    public l<TranscodeType> a(a<?> aVar) {
        com.bumptech.glide.h.l.a(aVar);
        return (l) super.a(aVar);
    }

    public l<TranscodeType> a(e<TranscodeType> eVar) {
        if (eVar != null) {
            if (this.I == null) {
                this.I = new ArrayList();
            }
            this.I.add(eVar);
        }
        return this;
    }

    public l<TranscodeType> a(Object obj) {
        b(obj);
        return this;
    }

    public l<TranscodeType> a(String str) {
        b((Object) str);
        return this;
    }

    public <Y extends h<TranscodeType>> Y a(Y y) {
        a(y, null, g.b());
        return y;
    }

    /* access modifiers changed from: 0000 */
    public <Y extends h<TranscodeType>> Y a(Y y, e<TranscodeType> eVar, Executor executor) {
        b(y, eVar, this, executor);
        return y;
    }

    private boolean a(a<?> aVar, c cVar) {
        return !aVar.u() && cVar.isComplete();
    }

    public i<ImageView, TranscodeType> a(ImageView imageView) {
        a aVar;
        n.a();
        com.bumptech.glide.h.l.a(imageView);
        if (!C() && x() && imageView.getScaleType() != null) {
            switch (k.f3549a[imageView.getScaleType().ordinal()]) {
                case 1:
                    aVar = clone().F();
                    break;
                case 2:
                    aVar = clone().G();
                    break;
                case 3:
                case 4:
                case 5:
                    aVar = clone().H();
                    break;
                case 6:
                    aVar = clone().G();
                    break;
            }
        }
        aVar = this;
        i<ImageView, TranscodeType> a2 = this.F.a(imageView, this.D);
        b(a2, null, aVar, g.b());
        return a2;
    }

    private j b(j jVar) {
        int i2 = k.f3550b[jVar.ordinal()];
        if (i2 == 1) {
            return j.NORMAL;
        }
        if (i2 == 2) {
            return j.HIGH;
        }
        if (i2 == 3 || i2 == 4) {
            return j.IMMEDIATE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("unknown priority: ");
        sb.append(m());
        throw new IllegalArgumentException(sb.toString());
    }

    private c b(h<TranscodeType> hVar, e<TranscodeType> eVar, d dVar, o<?, ? super TranscodeType> oVar, j jVar, int i2, int i3, a<?> aVar, Executor executor) {
        d dVar2 = dVar;
        j jVar2 = jVar;
        l<TranscodeType> lVar = this.J;
        if (lVar != null) {
            if (!this.O) {
                o<?, ? super TranscodeType> oVar2 = lVar.M ? oVar : lVar.G;
                j m = this.J.v() ? this.J.m() : b(jVar2);
                int j2 = this.J.j();
                int i4 = this.J.i();
                if (n.b(i2, i3) && !this.J.D()) {
                    j2 = aVar.j();
                    i4 = aVar.i();
                }
                int i5 = j2;
                int i6 = i4;
                j jVar3 = new j(dVar2);
                c a2 = a(hVar, eVar, aVar, (d) jVar3, oVar, jVar, i2, i3, executor);
                this.O = true;
                l<TranscodeType> lVar2 = this.J;
                j jVar4 = jVar3;
                c a3 = lVar2.a(hVar, eVar, (d) jVar3, oVar2, m, i5, i6, (a<?>) lVar2, executor);
                this.O = false;
                jVar4.a(a2, a3);
                return jVar4;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        } else if (this.L == null) {
            return a(hVar, eVar, aVar, dVar, oVar, jVar, i2, i3, executor);
        } else {
            j jVar5 = new j(dVar2);
            e<TranscodeType> eVar2 = eVar;
            j jVar6 = jVar5;
            o<?, ? super TranscodeType> oVar3 = oVar;
            int i7 = i2;
            int i8 = i3;
            Executor executor2 = executor;
            jVar5.a(a(hVar, eVar2, aVar, (d) jVar6, oVar3, jVar, i7, i8, executor2), a(hVar, eVar2, aVar.clone().a(this.L.floatValue()), (d) jVar6, oVar3, b(jVar2), i7, i8, executor2));
            return jVar5;
        }
    }

    private c a(h<TranscodeType> hVar, e<TranscodeType> eVar, a<?> aVar, Executor executor) {
        return a(hVar, eVar, (d) null, this.G, aVar.m(), aVar.j(), aVar.i(), aVar, executor);
    }

    /* JADX WARNING: type inference failed for: r15v0 */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.f.d] */
    /* JADX WARNING: type inference failed for: r14v0, types: [com.bumptech.glide.f.d] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r15v2 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r0v4, types: [com.bumptech.glide.f.b] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r15v3 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 6 */
    private c a(h<TranscodeType> hVar, e<TranscodeType> eVar, d dVar, o<?, ? super TranscodeType> oVar, j jVar, int i2, int i3, a<?> aVar, Executor executor) {
        ? r15;
        ? r3;
        if (this.K != null) {
            ? bVar = new b(dVar);
            r15 = bVar;
            r3 = bVar;
        } else {
            r15 = 0;
            r3 = dVar;
        }
        c b2 = b(hVar, eVar, r3, oVar, jVar, i2, i3, aVar, executor);
        if (r15 == 0) {
            return b2;
        }
        int j2 = this.K.j();
        int i4 = this.K.i();
        if (n.b(i2, i3) && !this.K.D()) {
            j2 = aVar.j();
            i4 = aVar.i();
        }
        int i5 = j2;
        int i6 = i4;
        l<TranscodeType> lVar = this.K;
        b bVar2 = r15;
        bVar2.a(b2, lVar.a(hVar, eVar, (d) r15, lVar.G, lVar.m(), i5, i6, (a<?>) this.K, executor));
        return bVar2;
    }

    private c a(h<TranscodeType> hVar, e<TranscodeType> eVar, a<?> aVar, d dVar, o<?, ? super TranscodeType> oVar, j jVar, int i2, int i3, Executor executor) {
        Context context = this.B;
        g gVar = this.F;
        return com.bumptech.glide.f.i.a(context, gVar, this.H, this.D, aVar, i2, i3, jVar, hVar, eVar, this.I, dVar, gVar.d(), oVar.a(), executor);
    }
}
