package b.j.a.a;

import android.view.animation.Interpolator;

/* compiled from: LookupTableInterpolator */
abstract class d implements Interpolator {

    /* renamed from: a reason: collision with root package name */
    private final float[] f2774a;

    /* renamed from: b reason: collision with root package name */
    private final float f2775b = (1.0f / ((float) (this.f2774a.length - 1)));

    protected d(float[] fArr) {
        this.f2774a = fArr;
    }

    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f2774a;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f2), fArr.length - 2);
        float f3 = (float) min;
        float f4 = this.f2775b;
        float f5 = (f2 - (f3 * f4)) / f4;
        float[] fArr2 = this.f2774a;
        return fArr2[min] + (f5 * (fArr2[min + 1] - fArr2[min]));
    }
}
