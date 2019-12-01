package b.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

/* compiled from: TransitionUtils */
class L {

    /* renamed from: a reason: collision with root package name */
    private static final boolean f2836a = (VERSION.SDK_INT >= 19);

    /* renamed from: b reason: collision with root package name */
    private static final boolean f2837b = (VERSION.SDK_INT >= 18);

    /* renamed from: c reason: collision with root package name */
    private static final boolean f2838c;

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 28) {
            z = false;
        }
        f2838c = z;
    }

    static View a(ViewGroup viewGroup, View view, View view2) {
        Matrix matrix = new Matrix();
        matrix.setTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        ba.a(view, matrix);
        ba.b(viewGroup, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.left);
        int round2 = Math.round(rectF.top);
        int round3 = Math.round(rectF.right);
        int round4 = Math.round(rectF.bottom);
        ImageView imageView = new ImageView(view.getContext());
        imageView.setScaleType(ScaleType.CENTER_CROP);
        Bitmap a2 = a(view, matrix, rectF, viewGroup);
        if (a2 != null) {
            imageView.setImageBitmap(a2);
        }
        imageView.measure(MeasureSpec.makeMeasureSpec(round3 - round, 1073741824), MeasureSpec.makeMeasureSpec(round4 - round2, 1073741824));
        imageView.layout(round, round2, round3, round4);
        return imageView;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008a  */
    private static Bitmap a(View view, Matrix matrix, RectF rectF, ViewGroup viewGroup) {
        boolean z;
        boolean z2;
        ViewGroup viewGroup2;
        int round;
        int round2;
        int i2 = 0;
        if (f2836a) {
            z2 = !view.isAttachedToWindow();
            if (viewGroup != null) {
                z = viewGroup.isAttachedToWindow();
                Bitmap bitmap = null;
                if (f2837b || !z2) {
                    viewGroup2 = null;
                } else if (!z) {
                    return null;
                } else {
                    ViewGroup viewGroup3 = (ViewGroup) view.getParent();
                    int indexOfChild = viewGroup3.indexOfChild(view);
                    viewGroup.getOverlay().add(view);
                    int i3 = indexOfChild;
                    viewGroup2 = viewGroup3;
                    i2 = i3;
                }
                round = Math.round(rectF.width());
                round2 = Math.round(rectF.height());
                if (round > 0 && round2 > 0) {
                    float min = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
                    int round3 = Math.round(((float) round) * min);
                    int round4 = Math.round(((float) round2) * min);
                    matrix.postTranslate(-rectF.left, -rectF.top);
                    matrix.postScale(min, min);
                    if (!f2838c) {
                        Picture picture = new Picture();
                        Canvas beginRecording = picture.beginRecording(round3, round4);
                        beginRecording.concat(matrix);
                        view.draw(beginRecording);
                        picture.endRecording();
                        bitmap = Bitmap.createBitmap(picture);
                    } else {
                        bitmap = Bitmap.createBitmap(round3, round4, Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmap);
                        canvas.concat(matrix);
                        view.draw(canvas);
                    }
                }
                if (f2837b && z2) {
                    viewGroup.getOverlay().remove(view);
                    viewGroup2.addView(view, i2);
                }
                return bitmap;
            }
        } else {
            z2 = false;
        }
        z = false;
        Bitmap bitmap2 = null;
        if (f2837b) {
        }
        viewGroup2 = null;
        round = Math.round(rectF.width());
        round2 = Math.round(rectF.height());
        float min2 = Math.min(1.0f, 1048576.0f / ((float) (round * round2)));
        int round32 = Math.round(((float) round) * min2);
        int round42 = Math.round(((float) round2) * min2);
        matrix.postTranslate(-rectF.left, -rectF.top);
        matrix.postScale(min2, min2);
        if (!f2838c) {
        }
        viewGroup.getOverlay().remove(view);
        viewGroup2.addView(view, i2);
        return bitmap2;
    }

    static Animator a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
