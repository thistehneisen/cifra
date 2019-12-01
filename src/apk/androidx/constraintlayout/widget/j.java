package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout.a;

/* compiled from: Placeholder */
public class j extends View {

    /* renamed from: a reason: collision with root package name */
    private int f1205a;

    /* renamed from: b reason: collision with root package name */
    private View f1206b;

    /* renamed from: c reason: collision with root package name */
    private int f1207c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f1206b != null) {
            a aVar = (a) getLayoutParams();
            a aVar2 = (a) this.f1206b.getLayoutParams();
            aVar2.ma.j(0);
            aVar.ma.k(aVar2.ma.u());
            aVar.ma.c(aVar2.ma.j());
            aVar2.ma.j(8);
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f1205a == -1 && !isInEditMode()) {
            setVisibility(this.f1207c);
        }
        this.f1206b = constraintLayout.findViewById(this.f1205a);
        View view = this.f1206b;
        if (view != null) {
            ((a) view.getLayoutParams()).aa = true;
            this.f1206b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f1206b;
    }

    public int getEmptyVisibility() {
        return this.f1207c;
    }

    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize((float) rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Align.LEFT);
            String str = "?";
            paint.getTextBounds(str, 0, 1, rect);
            canvas.drawText(str, ((((float) width) / 2.0f) - (((float) rect.width()) / 2.0f)) - ((float) rect.left), ((((float) height) / 2.0f) + (((float) rect.height()) / 2.0f)) - ((float) rect.bottom), paint);
        }
    }

    public void setContentId(int i2) {
        if (this.f1205a != i2) {
            View view = this.f1206b;
            if (view != null) {
                view.setVisibility(0);
                ((a) this.f1206b.getLayoutParams()).aa = false;
                this.f1206b = null;
            }
            this.f1205a = i2;
            if (i2 != -1) {
                View findViewById = ((View) getParent()).findViewById(i2);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
            }
        }
    }

    public void setEmptyVisibility(int i2) {
        this.f1207c = i2;
    }
}
