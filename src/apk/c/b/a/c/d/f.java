package c.b.a.c.d;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;

/* compiled from: CircularRevealWidget */
public interface f extends a {

    /* compiled from: CircularRevealWidget */
    public static class a implements TypeEvaluator<d> {

        /* renamed from: a reason: collision with root package name */
        public static final TypeEvaluator<d> f3137a = new a();

        /* renamed from: b reason: collision with root package name */
        private final d f3138b = new d();

        /* renamed from: a */
        public d evaluate(float f2, d dVar, d dVar2) {
            this.f3138b.a(c.b.a.c.g.a.a(dVar.f3141a, dVar2.f3141a, f2), c.b.a.c.g.a.a(dVar.f3142b, dVar2.f3142b, f2), c.b.a.c.g.a.a(dVar.f3143c, dVar2.f3143c, f2));
            return this.f3138b;
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class b extends Property<f, d> {

        /* renamed from: a reason: collision with root package name */
        public static final Property<f, d> f3139a = new b("circularReveal");

        private b(String str) {
            super(d.class, str);
        }

        /* renamed from: a */
        public d get(f fVar) {
            return fVar.getRevealInfo();
        }

        /* renamed from: a */
        public void set(f fVar, d dVar) {
            fVar.setRevealInfo(dVar);
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class c extends Property<f, Integer> {

        /* renamed from: a reason: collision with root package name */
        public static final Property<f, Integer> f3140a = new c("circularRevealScrimColor");

        private c(String str) {
            super(Integer.class, str);
        }

        /* renamed from: a */
        public Integer get(f fVar) {
            return Integer.valueOf(fVar.getCircularRevealScrimColor());
        }

        /* renamed from: a */
        public void set(f fVar, Integer num) {
            fVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget */
    public static class d {

        /* renamed from: a reason: collision with root package name */
        public float f3141a;

        /* renamed from: b reason: collision with root package name */
        public float f3142b;

        /* renamed from: c reason: collision with root package name */
        public float f3143c;

        public void a(float f2, float f3, float f4) {
            this.f3141a = f2;
            this.f3142b = f3;
            this.f3143c = f4;
        }

        private d() {
        }

        public d(float f2, float f3, float f4) {
            this.f3141a = f2;
            this.f3142b = f3;
            this.f3143c = f4;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    d getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i2);

    void setRevealInfo(d dVar);
}
