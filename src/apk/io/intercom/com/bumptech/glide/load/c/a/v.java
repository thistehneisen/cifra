package io.intercom.com.bumptech.glide.load.c.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import io.intercom.com.bumptech.glide.load.engine.a.e;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: TransformationUtils */
public final class v {

    /* renamed from: a reason: collision with root package name */
    private static final Paint f9637a = new Paint(6);

    /* renamed from: b reason: collision with root package name */
    private static final Paint f9638b = new Paint(7);

    /* renamed from: c reason: collision with root package name */
    private static final Paint f9639c = new Paint(7);

    /* renamed from: d reason: collision with root package name */
    private static final List<String> f9640d = Arrays.asList(new String[]{"XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098"});

    /* renamed from: e reason: collision with root package name */
    private static final Lock f9641e = ((!f9640d.contains(Build.MODEL) || VERSION.SDK_INT != 22) ? new a() : new ReentrantLock());

    /* compiled from: TransformationUtils */
    private static final class a implements Lock {
        a() {
        }

        public void lock() {
        }

        public void lockInterruptibly() throws InterruptedException {
        }

        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        public boolean tryLock() {
            return true;
        }

        public boolean tryLock(long j2, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        public void unlock() {
        }
    }

    static {
        f9639c.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
    }

    public static int a(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Lock a() {
        return f9641e;
    }

    public static Bitmap b(e eVar, Bitmap bitmap, int i2, int i3) {
        String str = "TransformationUtils";
        if (bitmap.getWidth() > i2 || bitmap.getHeight() > i3) {
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "requested target size too big for input, fit centering instead");
            }
            return c(eVar, bitmap, i2, i3);
        }
        if (Log.isLoggable(str, 2)) {
            Log.v(str, "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static boolean b(int i2) {
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap c(e eVar, Bitmap bitmap, int i2, int i3) {
        String str = "TransformationUtils";
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float min = Math.min(((float) i2) / ((float) bitmap.getWidth()), ((float) i3) / ((float) bitmap.getHeight()));
        int round = Math.round(((float) bitmap.getWidth()) * min);
        int round2 = Math.round(((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == round && bitmap.getHeight() == round2) {
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap bitmap2 = eVar.get((int) (((float) bitmap.getWidth()) * min), (int) (((float) bitmap.getHeight()) * min), a(bitmap));
        a(bitmap, bitmap2);
        if (Log.isLoggable(str, 2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("request: ");
            sb.append(i2);
            String str2 = "x";
            sb.append(str2);
            sb.append(i3);
            Log.v(str, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("toFit:   ");
            sb2.append(bitmap.getWidth());
            sb2.append(str2);
            sb2.append(bitmap.getHeight());
            Log.v(str, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("toReuse: ");
            sb3.append(bitmap2.getWidth());
            sb3.append(str2);
            sb3.append(bitmap2.getHeight());
            Log.v(str, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("minPct:   ");
            sb4.append(min);
            Log.v(str, sb4.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(min, min);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static Bitmap a(e eVar, Bitmap bitmap, int i2, int i3) {
        float f2;
        float f3;
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f4 = 0.0f;
        if (bitmap.getWidth() * i3 > bitmap.getHeight() * i2) {
            f3 = ((float) i3) / ((float) bitmap.getHeight());
            f2 = (((float) i2) - (((float) bitmap.getWidth()) * f3)) * 0.5f;
        } else {
            f3 = ((float) i2) / ((float) bitmap.getWidth());
            f4 = (((float) i3) - (((float) bitmap.getHeight()) * f3)) * 0.5f;
            f2 = 0.0f;
        }
        matrix.setScale(f3, f3);
        matrix.postTranslate((float) ((int) (f2 + 0.5f)), (float) ((int) (f4 + 0.5f)));
        Bitmap bitmap2 = eVar.get(i2, i3, a(bitmap));
        a(bitmap, bitmap2);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap a(e eVar, Bitmap bitmap, int i2) {
        if (!b(i2)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        a(i2, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmap2 = eVar.get(Math.round(rectF.width()), Math.round(rectF.height()), a(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        a(bitmap, bitmap2, matrix);
        return bitmap2;
    }

    private static void a(Canvas canvas) {
        canvas.setBitmap(null);
    }

    private static Config a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        f9641e.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f9637a);
            a(canvas);
        } finally {
            f9641e.unlock();
        }
    }

    static void a(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                return;
            default:
                return;
        }
    }
}
