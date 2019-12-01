package b.p;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: b.p.w reason: case insensitive filesystem */
/* compiled from: PathProperty */
class C0276w<T> extends Property<T, Float> {

    /* renamed from: a reason: collision with root package name */
    private final Property<T, PointF> f2937a;

    /* renamed from: b reason: collision with root package name */
    private final PathMeasure f2938b;

    /* renamed from: c reason: collision with root package name */
    private final float f2939c;

    /* renamed from: d reason: collision with root package name */
    private final float[] f2940d = new float[2];

    /* renamed from: e reason: collision with root package name */
    private final PointF f2941e = new PointF();

    /* renamed from: f reason: collision with root package name */
    private float f2942f;

    C0276w(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f2937a = property;
        this.f2938b = new PathMeasure(path, false);
        this.f2939c = this.f2938b.getLength();
    }

    /* renamed from: a */
    public void set(T t, Float f2) {
        this.f2942f = f2.floatValue();
        this.f2938b.getPosTan(this.f2939c * f2.floatValue(), this.f2940d, null);
        PointF pointF = this.f2941e;
        float[] fArr = this.f2940d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f2937a.set(t, pointF);
    }

    public Float get(T t) {
        return Float.valueOf(this.f2942f);
    }
}
