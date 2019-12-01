package c.b.a.c.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* compiled from: MatrixEvaluator */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a reason: collision with root package name */
    private final float[] f3101a = new float[9];

    /* renamed from: b reason: collision with root package name */
    private final float[] f3102b = new float[9];

    /* renamed from: c reason: collision with root package name */
    private final Matrix f3103c = new Matrix();

    /* renamed from: a */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f3101a);
        matrix2.getValues(this.f3102b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f3102b;
            float f3 = fArr[i2];
            float[] fArr2 = this.f3101a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f3103c.setValues(this.f3102b);
        return this.f3103c;
    }
}
