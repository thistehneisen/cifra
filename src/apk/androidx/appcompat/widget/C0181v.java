package androidx.appcompat.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.c;
import io.fabric.sdk.android.a.b.C0730a;

/* renamed from: androidx.appcompat.widget.v reason: case insensitive filesystem */
/* compiled from: AppCompatProgressBarHelper */
class C0181v {

    /* renamed from: a reason: collision with root package name */
    private static final int[] f1051a = {16843067, 16843068};

    /* renamed from: b reason: collision with root package name */
    private final ProgressBar f1052b;

    /* renamed from: c reason: collision with root package name */
    private Bitmap f1053c;

    C0181v(ProgressBar progressBar) {
        this.f1052b = progressBar;
    }

    private Shape b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* access modifiers changed from: 0000 */
    public void a(AttributeSet attributeSet, int i2) {
        sa a2 = sa.a(this.f1052b.getContext(), attributeSet, f1051a, i2, 0);
        Drawable c2 = a2.c(0);
        if (c2 != null) {
            this.f1052b.setIndeterminateDrawable(a(c2));
        }
        Drawable c3 = a2.c(1);
        if (c3 != null) {
            this.f1052b.setProgressDrawable(a(c3, false));
        }
        a2.a();
    }

    private Drawable a(Drawable drawable, boolean z) {
        if (drawable instanceof c) {
            c cVar = (c) drawable;
            Drawable a2 = cVar.a();
            if (a2 != null) {
                cVar.a(a(a2, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                int id = layerDrawable.getId(i2);
                drawableArr[i2] = a(layerDrawable.getDrawable(i2), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i3 = 0; i3 < numberOfLayers; i3++) {
                layerDrawable2.setId(i3, layerDrawable.getId(i3));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1053c == null) {
                this.f1053c = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, TileMode.REPEAT, TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            drawable = z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }

    private Drawable a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i2 = 0; i2 < numberOfFrames; i2++) {
            Drawable a2 = a(animationDrawable.getFrame(i2), true);
            a2.setLevel(C0730a.DEFAULT_TIMEOUT);
            animationDrawable2.addFrame(a2, animationDrawable.getDuration(i2));
        }
        animationDrawable2.setLevel(C0730a.DEFAULT_TIMEOUT);
        return animationDrawable2;
    }

    /* access modifiers changed from: 0000 */
    public Bitmap a() {
        return this.f1053c;
    }
}
