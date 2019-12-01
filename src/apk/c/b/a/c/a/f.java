package c.b.a.c.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* compiled from: ImageMatrixProperty */
public class f extends Property<ImageView, Matrix> {

    /* renamed from: a reason: collision with root package name */
    private final Matrix f3100a = new Matrix();

    public f() {
        super(Matrix.class, "imageMatrixProperty");
    }

    /* renamed from: a */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    /* renamed from: a */
    public Matrix get(ImageView imageView) {
        this.f3100a.set(imageView.getImageMatrix());
        return this.f3100a;
    }
}
