package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* compiled from: CardViewBaseImpl */
class e implements a {

    /* renamed from: a reason: collision with root package name */
    final /* synthetic */ f f1094a;

    e(f fVar) {
        this.f1094a = fVar;
    }

    public void a(Canvas canvas, RectF rectF, float f2, Paint paint) {
        Canvas canvas2 = canvas;
        RectF rectF2 = rectF;
        float f3 = 2.0f * f2;
        float width = (rectF.width() - f3) - 1.0f;
        float height = (rectF.height() - f3) - 1.0f;
        if (f2 >= 1.0f) {
            float f4 = f2 + 0.5f;
            float f5 = -f4;
            this.f1094a.f1095a.set(f5, f5, f4, f4);
            int save = canvas.save();
            canvas2.translate(rectF2.left + f4, rectF2.top + f4);
            Paint paint2 = paint;
            canvas.drawArc(this.f1094a.f1095a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.f1094a.f1095a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(height, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.f1094a.f1095a, 180.0f, 90.0f, true, paint2);
            canvas2.translate(width, 0.0f);
            canvas2.rotate(90.0f);
            canvas.drawArc(this.f1094a.f1095a, 180.0f, 90.0f, true, paint2);
            canvas2.restoreToCount(save);
            float f6 = (rectF2.left + f4) - 1.0f;
            float f7 = rectF2.top;
            canvas.drawRect(f6, f7, (rectF2.right - f4) + 1.0f, f7 + f4, paint2);
            float f8 = (rectF2.left + f4) - 1.0f;
            float f9 = rectF2.bottom;
            canvas.drawRect(f8, f9 - f4, (rectF2.right - f4) + 1.0f, f9, paint2);
        }
        canvas.drawRect(rectF2.left, rectF2.top + f2, rectF2.right, rectF2.bottom - f2, paint);
    }
}
