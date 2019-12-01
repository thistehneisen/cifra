package c.b.a.c.d;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import c.b.a.c.d.f.d;

/* compiled from: CircularRevealFrameLayout */
public class c extends FrameLayout implements f {

    /* renamed from: a reason: collision with root package name */
    private final d f3135a;

    public void a() {
        this.f3135a.a();
        throw null;
    }

    public void b() {
        this.f3135a.b();
        throw null;
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
        d dVar = this.f3135a;
        if (dVar == null) {
            super.draw(canvas);
        } else {
            dVar.a(canvas);
            throw null;
        }
    }

    public Drawable getCircularRevealOverlayDrawable() {
        this.f3135a.c();
        throw null;
    }

    public int getCircularRevealScrimColor() {
        this.f3135a.d();
        throw null;
    }

    public d getRevealInfo() {
        this.f3135a.e();
        throw null;
    }

    public boolean isOpaque() {
        d dVar = this.f3135a;
        if (dVar == null) {
            return super.isOpaque();
        }
        dVar.f();
        throw null;
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f3135a.a(drawable);
        throw null;
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f3135a.a(i2);
        throw null;
    }

    public void setRevealInfo(d dVar) {
        this.f3135a.a(dVar);
        throw null;
    }
}
