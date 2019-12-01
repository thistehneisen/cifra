package b.e.b.a;

/* compiled from: ResolutionDimension */
public class r extends s {

    /* renamed from: c reason: collision with root package name */
    float f2410c = 0.0f;

    public void a(int i2) {
        if (this.f2412b == 0 || this.f2410c != ((float) i2)) {
            this.f2410c = (float) i2;
            if (this.f2412b == 1) {
                b();
            }
            a();
        }
    }

    public void d() {
        super.d();
        this.f2410c = 0.0f;
    }

    public void f() {
        this.f2412b = 2;
    }
}
