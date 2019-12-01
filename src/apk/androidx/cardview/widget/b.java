package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* compiled from: CardViewApi17Impl */
class b implements a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ c f1093a;

    b(c cVar) {
        this.f1093a = cVar;
    }

    public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
        canvas.drawRoundRect(rectF, f2, f2, paint);
    }
}
