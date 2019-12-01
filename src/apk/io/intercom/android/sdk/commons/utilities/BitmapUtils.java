package io.intercom.android.sdk.commons.utilities;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;

public class BitmapUtils {

    public interface BitmapCache {
        Bitmap get(int i2, int i3, Config config);
    }

    public static Bitmap transformRound(Bitmap bitmap, BitmapCache bitmapCache) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int width = (bitmap.getWidth() - min) / 2;
        int height = (bitmap.getHeight() - min) / 2;
        Bitmap bitmap2 = bitmapCache.get(min, min, Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        TileMode tileMode = TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        if (!(width == 0 && height == 0)) {
            Matrix matrix = new Matrix();
            matrix.setTranslate((float) (-width), (float) (-height));
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        float f2 = ((float) min) / 2.0f;
        canvas.drawCircle(f2, f2, f2, paint);
        return bitmap2;
    }

    public static Bitmap transformRoundCorners(Bitmap bitmap, BitmapCache bitmapCache, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmap2 = bitmapCache.get(width, height, Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        TileMode tileMode = TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        float f2 = (float) i2;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), f2, f2, paint);
        return bitmap2;
    }

    public static Bitmap transformRoundCorners(Bitmap bitmap, BitmapCache bitmapCache, int i2, int i3, int i4, int i5, int i6) {
        Bitmap bitmap2 = bitmapCache.get(i2, i3, Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(i2, i3, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, false);
        TileMode tileMode = TileMode.CLAMP;
        paint.setShader(new BitmapShader(createScaledBitmap, tileMode, tileMode));
        float f2 = (float) i6;
        RectF rectF = new RectF(f2, f2, (float) (i2 - i6), (float) (i3 - i6));
        float f3 = (float) i4;
        canvas.drawRoundRect(rectF, f3, f3, paint);
        Paint paint2 = new Paint();
        paint2.setColor(i5);
        paint2.setStyle(Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(f2);
        canvas.drawRoundRect(rectF, f3, f3, paint2);
        return bitmap2;
    }

    public static Bitmap transformRound(Bitmap bitmap, BitmapCache bitmapCache, int i2, int i3) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        float f2 = ((float) min) / 2.0f;
        Bitmap bitmap2 = bitmapCache.get(min, min, Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, Config.ARGB_8888);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        TileMode tileMode = TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        Canvas canvas = new Canvas(bitmap2);
        int i4 = i3 / 2;
        float width = (float) (((bitmap.getWidth() - i3) / 2) + i4);
        float height = (float) (((bitmap.getHeight() - i3) / 2) + i4);
        float f3 = f2 - ((float) i3);
        canvas.drawCircle(width, height, f3, paint);
        Paint paint2 = new Paint();
        paint2.setColor(i2);
        paint2.setStyle(Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(2.0f);
        canvas.drawCircle(width, height, f3, paint2);
        return bitmap2;
    }
}
