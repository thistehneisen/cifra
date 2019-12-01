package b.p;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* renamed from: b.p.d reason: case insensitive filesystem */
/* compiled from: ChangeBounds */
class C0258d extends Property<Drawable, PointF> {

    /* renamed from: a reason: collision with root package name */
    private Rect f2875a = new Rect();

    C0258d(Class cls, String str) {
        super(cls, str);
    }

    /* renamed from: a */
    public void set(Drawable drawable, PointF pointF) {
        drawable.copyBounds(this.f2875a);
        this.f2875a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
        drawable.setBounds(this.f2875a);
    }

    /* renamed from: a */
    public PointF get(Drawable drawable) {
        drawable.copyBounds(this.f2875a);
        Rect rect = this.f2875a;
        return new PointF((float) rect.left, (float) rect.top);
    }
}
