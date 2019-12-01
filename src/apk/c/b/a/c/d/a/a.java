package c.b.a.c.d.a;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.CardView;
import c.b.a.c.d.d;
import c.b.a.c.d.f;

/* compiled from: CircularRevealCardView */
public class a extends CardView implements f {

    /* renamed from: j reason: collision with root package name */
    private final d f3134j;

    public void a() {
        this.f3134j.a();
        throw null;
    }

    public void b() {
        this.f3134j.b();
        throw null;
    }

    public void draw(Canvas canvas) {
        d dVar = this.f3134j;
        if (dVar == null) {
            super.draw(canvas);
        } else {
            dVar.a(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.f3134j.c();
        throw null;
    }

    public int getCircularRevealScrimColor() {
        this.f3134j.d();
        throw null;
    }

    public f.d getRevealInfo() {
        this.f3134j.e();
        throw null;
    }

    public boolean isOpaque() {
        d dVar = this.f3134j;
        if (dVar == null) {
            return super.isOpaque();
        }
        dVar.f();
        throw null;
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f3134j.a(drawable);
        throw null;
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f3134j.a(i2);
        throw null;
    }

    public void setRevealInfo(f.d dVar) {
        this.f3134j.a(dVar);
        throw null;
    }
}
