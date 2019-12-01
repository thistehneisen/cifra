package c.b.a.c.h;

import android.graphics.Typeface;
import android.text.TextPaint;
import b.g.a.a.h.a;

/* compiled from: TextAppearance */
class b extends a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ TextPaint f3147a;

    /* renamed from: b reason: collision with root package name */
    final /* synthetic */ a f3148b;

    /* renamed from: c reason: collision with root package name */
    final /* synthetic */ c f3149c;

    b(c cVar, TextPaint textPaint, a aVar) {
        this.f3149c = cVar;
        this.f3147a = textPaint;
        this.f3148b = aVar;
    }

    public void a(Typeface typeface) {
        c cVar = this.f3149c;
        cVar.o = Typeface.create(typeface, cVar.f3154e);
        this.f3149c.a(this.f3147a, typeface);
        this.f3149c.n = true;
        this.f3148b.a(typeface);
    }

    public void a(int i2) {
        this.f3149c.a();
        this.f3149c.n = true;
        this.f3148b.a(i2);
    }
}
